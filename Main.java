import java.util.Scanner;

public class Main {
    private static Bengkel bengkel = new Bengkel();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
            case "3":
            case "6":
            case "7":
            case "8":
                System.out.println("Fitur belum tersedia.");
                break;
            case "4":
                bengkel.tampilkanDaftarKendaraan();
                break;
            case "5":
                bengkel.tampilkanDaftarMekanik();
                break;
            case "9":
                System.out.println("Terima kasih. Program selesai.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Masukkan angka 1-9.");
        }
    }
}
