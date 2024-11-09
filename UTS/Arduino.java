package UTS;

public class Arduino extends Alat {
    public Arduino(int id, String nama, String kategori, int jumlah, double harga) {
        super(id, nama, kategori, jumlah, harga);
    }

    @Override
    public void displayDetail() {
        System.out.println("Kategori Arduino:");
        super.displayDetail();
    }
}
