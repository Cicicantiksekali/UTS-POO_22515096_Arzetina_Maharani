public class Servis {
    private String idServis;
    private String tanggalServis;
    private String keluhan;
    private double biayaJasa;
    private double biayaSukuCadang;
    private boolean statusAktif;

    public Servis() {
        this.statusAktif = true;
    }

    public Servis(String idServis, String tanggalServis, String keluhan,
                  double biayaJasa, double biayaSukuCadang) {
        if (biayaJasa < 0 || biayaSukuCadang < 0) {
            throw new IllegalArgumentException("Biaya tidak boleh negatif");
        }
        this.idServis = idServis;
        this.tanggalServis = tanggalServis;
        this.keluhan = keluhan;
        this.biayaJasa = biayaJasa;
        this.biayaSukuCadang = biayaSukuCadang;
        this.statusAktif = true;
    }

    public double hitungTotalBiaya() {
        return biayaJasa + biayaSukuCadang;
    }

    public void ubahStatus(boolean aktif) {
        this.statusAktif = aktif;
    }

    public void tampilkanInfo() {
        System.out.println("ID Servis        : " + idServis);
        System.out.println("Tanggal Servis   : " + tanggalServis);
        System.out.println("Keluhan          : " + keluhan);
        System.out.println("Biaya Jasa       : " + biayaJasa);
        System.out.println("Biaya Suku Cadang: " + biayaSukuCadang);
        System.out.println("Total Biaya      : " + hitungTotalBiaya());
        System.out.println("Status           : " + (statusAktif ? "Aktif" : "Selesai"));
    }
}
