package src;
public class Mekanik {
    private String idMekanik;
    private String namaMekanik;
    private String spesialisasi;
    private String nomorTelepon;
    private boolean statusTersedia;

    public Mekanik() {
        this.statusTersedia = true;
    }

    public Mekanik(String idMekanik, String namaMekanik, String spesialisasi, String nomorTelepon) {
        this.idMekanik = idMekanik;
        this.namaMekanik = namaMekanik;
        this.spesialisasi = spesialisasi;
        this.nomorTelepon = nomorTelepon;
        this.statusTersedia = true;
    }

    public void tampilkanInfo() {
        System.out.println("ID Mekanik   : " + idMekanik);
        System.out.println("Nama Mekanik : " + namaMekanik);
        System.out.println("Spesialisasi : " + spesialisasi);
        System.out.println("No. Telepon  : " + nomorTelepon);
        System.out.println("Status       : " + (statusTersedia ? "Tersedia" : "Tidak Tersedia"));
    }

    public boolean cekKetersediaan() {
        return statusTersedia;
    }

    public void ubahStatus(boolean status) {
        this.statusTersedia = status;
    }

}
