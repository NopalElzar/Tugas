package UTS;

public class Alat {
    private int idAlat;
    private String namaAlat;
    private String kategoriAlat;
    private int jumlahAlat;
    private double hargaAlat;

    public Alat(int id, String nama, String kategori, int jumlah, double harga) {
        this.idAlat = id;
        this.namaAlat = nama;
        this.kategoriAlat = kategori;
        this.jumlahAlat = jumlah;
        this.hargaAlat = harga;
    }

    public int getIdAlat() { return idAlat; }
    public String getNamaAlat() { return namaAlat; }
    public String getKategoriAlat() { return kategoriAlat; }
    public int getJumlahAlat() { return jumlahAlat; }
    public double getHargaAlat() { return hargaAlat; }

    public void setNamaAlat(String namaAlat) { this.namaAlat = namaAlat; }
    public void setKategoriAlat(String kategoriAlat) { this.kategoriAlat = kategoriAlat; }
    public void setJumlahAlat(int jumlahAlat) { this.jumlahAlat = jumlahAlat; }
    public void setHargaAlat(double hargaAlat) { this.hargaAlat = hargaAlat; }

    public void displayDetail() {
        System.out.println("ID Alat: " + idAlat);
        System.out.println("Nama Alat: " + namaAlat);
        System.out.println("Kategori: " + kategoriAlat);
        System.out.println("Jumlah: " + jumlahAlat);
        System.out.println("Harga: " + hargaAlat);
    }
}
