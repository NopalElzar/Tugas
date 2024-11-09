package UTS;

public class Sensor extends Alat {
    public Sensor(int id, String nama, String kategori, int jumlah, double harga) {
        super(id, nama, kategori, jumlah, harga);
    }

    @Override
    public void displayDetail() {
        System.out.println("Kategori Sensor:");
        super.displayDetail();
    }
}
