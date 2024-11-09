package UTS;

public class MiniPC extends Alat {
    private int ram;
    private int sdCardSize;

    public MiniPC(int id, String nama, String kategori, int jumlah, double harga, int ram) {
        super(id, nama, kategori, jumlah, harga);
        this.ram = ram;
        this.sdCardSize = 0;
    }

    public MiniPC(int id, String nama, String kategori, int jumlah, double harga, int ram, int sdCardSize) {
        super(id, nama, kategori, jumlah, harga);
        this.ram = ram;
        this.sdCardSize = sdCardSize;
    }

    public int getRam() { return ram; }
    public int getSdCardSize() { return sdCardSize; }

    @Override
    public void displayDetail() {
        System.out.println("Kategori MiniPC:");
        super.displayDetail();
        System.out.println("RAM: " + ram + " GB");
        if (sdCardSize > 0) {
            System.out.println("SD Card Size: " + sdCardSize + " GB");
        }
    }
}
