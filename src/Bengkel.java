package src;

import java.util.ArrayList;

public class Bengkel {
    private String idBengkel;
    private String namaBengkel;
    private String alamat;
    private String nomorTelepon;
    private String jamOperasional;

    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<Kendaraan>();
    private ArrayList<Mekanik> daftarMekanik = new ArrayList<Mekanik>();
    private ArrayList<Servis> daftarServis = new ArrayList<Servis>();

    public Bengkel(String idBengkel, String namaBengkel, String alamat,
            String nomorTelepon, String jamOperasional) {
        this.idBengkel = idBengkel;
        this.namaBengkel = namaBengkel;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.jamOperasional = jamOperasional;
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
    }

    public void tambahMekanik(Mekanik m) {
        daftarMekanik.add(m);
    }

    public boolean buatServis(Servis s) {
        if (s == null || s.getKendaraan() == null || s.getMekanik() == null) {
            return false;
        }
        if (!daftarKendaraan.contains(s.getKendaraan())) {
            return false;
        }
        if (!daftarMekanik.contains(s.getMekanik())) {
            return false;
        }
        for (Servis aktif : daftarServis) {
            if (aktif.getMekanik() == s.getMekanik() && aktif.isStatusAktif()) {
                return false;
            }
        }
        daftarServis.add(s);
        s.getMekanik().ubahStatus(false);
        return true;
    }

    public void tampilkanLaporan() {
        System.out.println("Nama Bengkel : " + namaBengkel);
        System.out.println("Alamat       : " + alamat);
        if (daftarServis.isEmpty()) {
            System.out.println("Belum ada servis.");
            return;
        }
        double total = 0;
        for (int i = 0; i < daftarServis.size(); i++) {
            System.out.println("--- Servis #" + (i + 1) + " ---");
            daftarServis.get(i).tampilkanInfo();
            total += daftarServis.get(i).hitungTotalBiaya();
        }
        System.out.println("Total biaya seluruh servis: " + total);
    }

    public Servis cariServisById(String id) {
        for (Servis s : daftarServis) {
            if (s.getIdServis().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Kendaraan> getDaftarKendaraan() {
        return daftarKendaraan;
    }

    public ArrayList<Mekanik> getDaftarMekanik() {
        return daftarMekanik;
    }

    public String getIdBengkel() {
        return idBengkel;
    }

    public void setIdBengkel(String idBengkel) {
        this.idBengkel = idBengkel;
    }

    public String getNamaBengkel() {
        return namaBengkel;
    }

    public void setNamaBengkel(String namaBengkel) {
        this.namaBengkel = namaBengkel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getJamOperasional() {
        return jamOperasional;
    }

    public void setJamOperasional(String jamOperasional) {
        this.jamOperasional = jamOperasional;
    }

    public void tampilkanInfo() {
        System.out.println("ID Bengkel       : " + idBengkel);
        System.out.println("Nama Bengkel     : " + namaBengkel);
        System.out.println("Alamat           : " + alamat);
        System.out.println("Nomor Telepon    : " + nomorTelepon);
        System.out.println("Jam Operasional  : " + jamOperasional);
    }

    public void tampilkanDaftarKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan.");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.println("--- Kendaraan #" + (i + 1) + " ---");
            daftarKendaraan.get(i).tampilkanInfo();
        }
    }

    public void tampilkanDaftarMekanik() {
        if (daftarMekanik.isEmpty()) {
            System.out.println("Belum ada mekanik.");
            return;
        }
        for (int i = 0; i < daftarMekanik.size(); i++) {
            System.out.println("--- Mekanik #" + (i + 1) + " ---");
            daftarMekanik.get(i).tampilkanInfo();
        }
    }
}
