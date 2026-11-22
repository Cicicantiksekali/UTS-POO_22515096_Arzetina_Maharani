import java.util.ArrayList;
import java.util.List;

public class Bengkel {
    private List<Kendaraan> daftarKendaraan = new ArrayList<Kendaraan>();

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
}
