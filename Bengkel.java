import java.util.ArrayList;
import java.util.List;

public class Bengkel {
    private List<Kendaraan> daftarKendaraan = new ArrayList<Kendaraan>();
    private List<Mekanik> daftarMekanik = new ArrayList<Mekanik>();

    public Bengkel() {}

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
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

    public void tambahMekanik(Mekanik m) {
        daftarMekanik.add(m);
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
