import java.util.Scanner;

public class Kendaraan {
    private String idKendaraan;
    private String nomorPolisi;
    private String merk;
    private String tipe;
    private int tahun;

    public Kendaraan(String idKendaraan, String nomorPolisi, String merk, String tipe, int tahun) {
        this.idKendaraan = idKendaraan;
        this.nomorPolisi = nomorPolisi;
        this.merk = merk;
        this.tipe = tipe;
        this.tahun = tahun;
        if (!validasiNomorPolisi()) {
            throw new IllegalArgumentException("Nomor polisi tidak boleh kosong");
        }
    }

    public void tampilkanInfo() {
        System.out.println("ID Kendaraan : " + idKendaraan);
        System.out.println("Nomor Polisi : " + nomorPolisi);
        System.out.println("Merk         : " + merk);
        System.out.println("Tipe         : " + tipe);
        System.out.println("Tahun        : " + tahun);
    }       

    public void ubahData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID Kendaraan [" + idKendaraan + "]: ");
        String id = sc.nextLine();
        if (!id.isBlank()) this.idKendaraan = id;

        System.out.print("Nomor Polisi [" + nomorPolisi + "]: ");
        String np = sc.nextLine();
        if (!np.isBlank()) this.nomorPolisi = np;

        System.out.print("Merk [" + merk + "]: ");
        String m = sc.nextLine();
        if (!m.isBlank()) this.merk = m;

        System.out.print("Tipe [" + tipe + "]: ");
        String t = sc.nextLine();
        if (!t.isBlank()) this.tipe = t;

        System.out.print("Tahun [" + tahun + "]: ");
        String th = sc.nextLine();
        if (!th.isBlank()) this.tahun = Integer.parseInt(th);


        sc.close();
    }

    public boolean validasiNomorPolisi() {
        return nomorPolisi != null && !nomorPolisi.isBlank();
    }
}
