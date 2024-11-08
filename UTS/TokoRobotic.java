package UTS;

import java.util.ArrayList;
import java.util.Scanner;

class Barang {
    private int idBarang;
    private String namaBarang;
    private String kategoriBarang;
    private int jumlahBarang;
    private double hargaBarang;

    public Barang(int id, String nama, String kategori, int jumlah, double harga) {
        this.idBarang = id;
        this.namaBarang = nama;
        this.kategoriBarang = kategori;
        this.jumlahBarang = jumlah;
        this.hargaBarang = harga;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getKategoriBarang() {
        return kategoriBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setKategoriBarang(String kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public void setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public void displayDetail() {
        System.out.println("ID Barang: " + idBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Kategori: " + kategoriBarang);
        System.out.println("Jumlah: " + jumlahBarang);
        System.out.println("Harga: " + hargaBarang);
    }
}

class Sensor extends Barang {
    public Sensor(int id, String nama, String kategori, int jumlah, double harga) {
        super(id, nama, kategori, jumlah, harga);
    }

    @Override
    public void displayDetail() {
        System.out.println("Kategori Sensor:");
        super.displayDetail();
    }
}

class Modul extends Barang {
    public Modul(int id, String nama, String kategori, int jumlah, double harga) {
        super(id, nama, kategori, jumlah, harga);
    }

    @Override
    public void displayDetail() {
        System.out.println("Kategori Modul:");
        super.displayDetail();
    }
}

class Elektronik extends Barang {
    public Elektronik(int id, String nama, String kategori, int jumlah, double harga) {
        super(id, nama, kategori, jumlah, harga);
    }

    @Override
    public void displayDetail() {
        System.out.println("Kategori Elektronik:");
        super.displayDetail();
    }
}

public class TokoRobotic {
    private ArrayList<Barang> daftarBarang;
    private Scanner input;

    public TokoRobotic() {
        daftarBarang = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void tambahBarang() {
        System.out.print("Masukkan ID Barang: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Kategori Barang (Sensor/Modul/Elektronik): ");
        String kategori = input.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Jumlah Barang: ");
        int jumlah = input.nextInt();
        System.out.print("Masukkan Harga Barang: ");
        double harga = input.nextDouble();

        Barang item;
        if (kategori.equalsIgnoreCase("Sensor")) {
            item = new Sensor(id, nama, kategori, jumlah, harga);
        } else if (kategori.equalsIgnoreCase("Modul")) {
            item = new Modul(id, nama, kategori, jumlah, harga);
        } else if (kategori.equalsIgnoreCase("Elektronik")) {
            item = new Elektronik(id, nama, kategori, jumlah, harga);
        } else {
            System.out.println("Kategori tidak valid.");
            return;
        }

        daftarBarang.add(item);
        System.out.println("Barang berhasil ditambahkan.");
    }

    public void hapusBarang() {
        System.out.print("Masukkan ID Barang yang akan dihapus: ");
        int id = input.nextInt();
        daftarBarang.removeIf(item -> item.getIdBarang() == id);
        System.out.println("Barang berhasil dihapus.");
    }

    public void editBarang() {
        System.out.print("Masukkan ID Barang yang akan diedit: ");
        int id = input.nextInt();
        input.nextLine();
        for (Barang item : daftarBarang) {
            if (item.getIdBarang() == id) {
                System.out.print("Masukkan Nama Barang baru: ");
                item.setKategoriBarang(input.nextLine());
                System.out.print("Masukkan Jumlah Barang baru: ");
                item.setNamaBarang(input.nextLine());
                System.out.print("Masukkan Kategori Barang baru: ");
                item.setJumlahBarang(input.nextInt());
                System.out.print("Masukkan Harga Barang baru: ");
                item.setHargaBarang(input.nextDouble());
                System.out.println("Barang berhasil diedit.");
                return;
            }
        }
        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
    }

    public void ByName() {
        System.out.print("Masukkan Nama Barang yang dicari: ");
        String nama = input.nextLine();
        for (Barang item : daftarBarang) {
            if (item.getNamaBarang().equalsIgnoreCase(nama)) {
                item.displayDetail();
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void tampilkanDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang dalam inventaris.");
        } else {
            for (Barang item : daftarBarang) {
                System.out.println("ID Barang: " + item.getIdBarang() + ", Kategori: " + item.get2KategoriBarang() + ", Nama Barang: " + item.getNamaBarang());
            }
        }
    }

public void Total() {
    double total = 0;
    for (Barang item : daftarBarang) {
        total += item.getJumlahBarang() * item.getHargaBarang();
    }
    System.out.println("Total nilai inventaris: " + total);
}

public void Total(boolean showQuantityOnly) {
    if (showQuantityOnly) {
        int jumlahItem = 0;
        for (Barang item : daftarBarang) {
            jumlahItem += item.getJumlahBarang();
        }
        System.out.println("Jumlah barang yang ada: " + jumlahItem);
    }
}

public void totalInventaris() {
    System.out.println("Pilih jenis total inventaris:");
    System.out.println("1. Total nilai inventaris");
    System.out.println("2. Total jumlah barang");
    System.out.print("Input pilihan: ");
    int pilihan = input.nextInt();

    if (pilihan == 1) {
        Total();
    } else if (pilihan == 2) {
        Total(true);
    } else {
        System.out.println("Pilihan tidak valid.");
    }
}

    public void showMenu() {
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar barang");
            System.out.println("2. Tambah data barang");
            System.out.println("3. Edit data barang");
            System.out.println("4. Hapus data barang");
            System.out.println("5. Lihat detail barang by name");
            System.out.println("6. Total nilai inventaris");
            System.out.println("7. Close program");
            System.out.print("Input menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanDaftarBarang();
                    break;
                case 2:
                    tambahBarang();
                    break;
                case 3:
                    editBarang();
                    break;
                case 4:
                    hapusBarang();
                    break;
                case 5:
                    ByName();
                    break;
                case 6:
                    totalInventaris();
                    break;
                case 7:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 7);
    }

    public static void main(String[] args) {
        TokoRobotic manager = new TokoRobotic();
        manager.showMenu();
    }
}
