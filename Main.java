import java.util.Scanner;

public class Main {
    private static Bengkel bengkel;
    private static StackServis riwayatServis;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SETUP BENGKEL ===");
        String idBengkel, namaBengkel, alamat, nomorTelepon, jamOperasional;
        boolean valid;
        do {
            System.out.print("ID Bengkel       : ");
            idBengkel = sc.nextLine().trim();
            System.out.print("Nama Bengkel     : ");
            namaBengkel = sc.nextLine().trim();
            System.out.print("Alamat           : ");
            alamat = sc.nextLine().trim();
            System.out.print("Nomor Telepon    : ");
            nomorTelepon = sc.nextLine().trim();
            System.out.print("Jam Operasional  : ");
            jamOperasional = sc.nextLine().trim();
            valid = !idBengkel.isEmpty() && !namaBengkel.isEmpty() && !alamat.isEmpty()
                    && !nomorTelepon.isEmpty() && !jamOperasional.isEmpty();
            if (!valid) {
                System.out.println("Semua data wajib diisi. Ulangi.\n");
            }
        } while (!valid);

        bengkel = new Bengkel(idBengkel, namaBengkel, alamat, nomorTelepon, jamOperasional);
        riwayatServis = new StackServis(10);

        while (true) {
            tampilkanMenu();
            prosesPilihan();
        }
    }

    public static void tampilkanMenu() {
        System.out.println("\n=== SISTEM MANAJEMEN BENGKEL ===");
        System.out.println("1. Tambah Kendaraan");
        System.out.println("2. Tambah Mekanik");
        System.out.println("3. Buat Transaksi Servis");
        System.out.println("4. Daftar Kendaraan");
        System.out.println("5. Daftar Mekanik");
        System.out.println("6. Laporan Servis");
        System.out.println("7. Lihat Riwayat Servis Terakhir");
        System.out.println("8. Keluarkan Riwayat Servis Terakhir");
        System.out.println("9. Keluar");
    }

    public static void prosesPilihan() {
        System.out.print("Pilih menu: ");
        String pilihan = sc.nextLine().trim();

        switch (pilihan) {
            case "1": {
                System.out.print("ID Kendaraan : ");
                String id = sc.nextLine().trim();
                System.out.print("Nomor Polisi : ");
                String nomorPolisi = sc.nextLine().trim();
                System.out.print("Merk         : ");
                String merk = sc.nextLine().trim();
                System.out.print("Tipe         : ");
                String tipe = sc.nextLine().trim();
                System.out.print("Tahun        : ");
                String tahunInput = sc.nextLine().trim();
                try {
                    int tahun = Integer.parseInt(tahunInput);
                    bengkel.tambahKendaraan(new Kendaraan(id, nomorPolisi, merk, tipe, tahun));
                    System.out.println("Kendaraan berhasil ditambahkan.");
                } catch (NumberFormatException e) {
                    System.out.println("Gagal: tahun harus berupa angka.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Gagal: " + e.getMessage());
                }
                break;
            }
            case "2": {
                System.out.print("ID Mekanik   : ");
                String id = sc.nextLine().trim();
                System.out.print("Nama Mekanik : ");
                String nama = sc.nextLine().trim();
                System.out.print("Spesialisasi : ");
                String spesialisasi = sc.nextLine().trim();
                System.out.print("No. Telepon  : ");
                String telepon = sc.nextLine().trim();
                if (id.isEmpty() || nama.isEmpty() || spesialisasi.isEmpty() || telepon.isEmpty()) {
                    System.out.println("Gagal: data mekanik tidak boleh kosong.");
                } else {
                    bengkel.tambahMekanik(new Mekanik(id, nama, spesialisasi, telepon));
                    System.out.println("Mekanik berhasil ditambahkan.");
                }
                break;
            }
            case "3": {
                if (bengkel.getDaftarKendaraan().isEmpty() || bengkel.getDaftarMekanik().isEmpty()) {
                    System.out.println("Gagal: butuh minimal 1 kendaraan dan 1 mekanik.");
                    break;
                }
                bengkel.tampilkanDaftarKendaraan();
                System.out.print("Pilih nomor kendaraan: ");
                String pilihKendaraan = sc.nextLine().trim();
                bengkel.tampilkanDaftarMekanik();
                System.out.print("Pilih nomor mekanik  : ");
                String pilihMekanik = sc.nextLine().trim();

                System.out.print("ID Servis            : ");
                String idServis = sc.nextLine().trim();
                System.out.print("Tanggal Servis       : ");
                String tanggal = sc.nextLine().trim();
                System.out.print("Keluhan              : ");
                String keluhan = sc.nextLine().trim();
                System.out.print("Biaya Jasa           : ");
                String biayaJasaInput = sc.nextLine().trim();
                System.out.print("Biaya Suku Cadang    : ");
                String biayaSukuCadangInput = sc.nextLine().trim();

                try {
                    int idxKendaraan = Integer.parseInt(pilihKendaraan) - 1;
                    int idxMekanik = Integer.parseInt(pilihMekanik) - 1;
                    if (idxKendaraan < 0 || idxKendaraan >= bengkel.getDaftarKendaraan().size()
                            || idxMekanik < 0 || idxMekanik >= bengkel.getDaftarMekanik().size()) {
                        System.out.println("Gagal: nomor pilihan tidak valid.");
                        break;
                    }
                    Mekanik mekanik = bengkel.getDaftarMekanik().get(idxMekanik);
                    if (!mekanik.cekKetersediaan()) {
                        System.out.println("Gagal: mekanik masih menangani servis aktif.");
                        break;
                    }
                    Servis servis = new Servis(idServis, tanggal, keluhan,
                            bengkel.getDaftarKendaraan().get(idxKendaraan), mekanik,
                            Double.parseDouble(biayaJasaInput),
                            Double.parseDouble(biayaSukuCadangInput));
                    if (bengkel.buatServis(servis)) {
                        if (!riwayatServis.push(servis)) {
                            System.out.println("Catatan: riwayat servis penuh, transaksi tetap tersimpan.");
                        }
                        System.out.println("Servis berhasil dibuat.");
                    } else {
                        System.out.println("Gagal: data servis tidak valid.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Gagal: nomor pilihan dan biaya harus berupa angka.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Gagal: " + e.getMessage());
                }
                break;
            }
            case "4":
                bengkel.tampilkanDaftarKendaraan();
                break;
            case "5":
                bengkel.tampilkanDaftarMekanik();
                break;
            case "6":
                bengkel.tampilkanLaporan();
                break;
            case "7": {
                Servis terakhir = riwayatServis.peek();
                if (terakhir == null) {
                    System.out.println("Riwayat servis kosong.");
                } else {
                    System.out.println("Riwayat servis terakhir:");
                    terakhir.tampilkanInfo();
                }
                break;
            }
            case "8": {
                Servis keluar = riwayatServis.pop();
                if (keluar == null) {
                    System.out.println("Riwayat servis kosong.");
                } else {
                    keluar.ubahStatus(false);
                    if (keluar.getMekanik() != null) {
                        keluar.getMekanik().ubahStatus(true);
                    }
                    System.out.println("Servis dikeluarkan dari riwayat:");
                    keluar.tampilkanInfo();
                }
                break;
            }
            case "9":
                System.out.println("Terima kasih. Program selesai.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Masukkan angka 1-9.");
        }
    }
}
