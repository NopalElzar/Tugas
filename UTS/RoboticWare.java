package UTS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class RoboticWare {
    private ArrayList<Alat> daftarAlat = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void tambahAlat() {
        System.out.print("Masukkan ID Alat: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Kategori Alat (Sensor/Arduino/MiniPC): ");
        String kategori = input.nextLine();
        System.out.print("Masukkan Nama Alat: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Jumlah Alat: ");
        int jumlah = input.nextInt();
        System.out.print("Masukkan Harga Alat: ");
        double harga = input.nextDouble();

        Alat item;
        if (kategori.equalsIgnoreCase("Sensor")) {
            item = new Sensor(id, nama, kategori, jumlah, harga);
        } else if (kategori.equalsIgnoreCase("MiniPC")) {
            System.out.print("Masukkan RAM (GB): ");
            int ram = input.nextInt();
            System.out.print("Apakah ingin menambahkan SD Card Size? (y/n): ");
            input.nextLine();
            String pilihan = input.nextLine();

            if (pilihan.equalsIgnoreCase("y")) {
                System.out.print("Masukkan SD Card Size (GB): ");
                int sdCardSize = input.nextInt();
                item = new MiniPC(id, nama, kategori, jumlah, harga, ram, sdCardSize);
            } else {
                item = new MiniPC(id, nama, kategori, jumlah, harga, ram);
            }
        } else if (kategori.equalsIgnoreCase("Arduino")) {
            item = new Arduino(id, nama, kategori, jumlah, harga);
        } else {
            System.out.println("Kategori tidak valid.");
            return;
        }

        daftarAlat.add(item);
        System.out.println("Alat berhasil ditambahkan.");
    }

    public void hapusAlat() {
        System.out.print("Masukkan ID Alat yang akan dihapus: ");
        int id = input.nextInt();
        daftarAlat.removeIf(item -> item.getIdAlat() == id);
        System.out.println("Alat berhasil dihapus.");
    }

    public void editAlat() {
        System.out.print("Masukkan ID Alat yang akan diedit: ");
        int id = input.nextInt();
        input.nextLine();
        for (Alat item : daftarAlat) {
            if (item.getIdAlat() == id) {
                System.out.print("Masukkan Nama Alat baru: ");
                item.setNamaAlat(input.nextLine());
                System.out.print("Masukkan Kategori Alat baru: ");
                item.setKategoriAlat(input.nextLine());
                System.out.print("Masukkan Jumlah Alat baru: ");
                item.setJumlahAlat(input.nextInt());
                System.out.print("Masukkan Harga Alat baru: ");
                item.setHargaAlat(input.nextDouble());
                System.out.println("Alat berhasil diedit.");
                return;
            }
        }
        System.out.println("Alat dengan ID tersebut tidak ditemukan.");
    }

    public void byName() {
        System.out.print("Masukkan Nama Alat yang dicari: ");
        String nama = input.nextLine();
        for (Alat item : daftarAlat) {
            if (item.getNamaAlat().equalsIgnoreCase(nama)) {
                item.displayDetail();
                return;
            }
        }
        System.out.println("Alat tidak ditemukan.");
    }

    public void tampilkanDaftarAlat() {
        if (daftarAlat.isEmpty()) {
            System.out.println("Tidak ada alat dalam inventaris.");
        } else {
            for (Alat item : daftarAlat) {
                System.out.println("ID Alat: " + item.getIdAlat() + ", Kategori: " + item.getKategoriAlat() + ", Nama Alat: " + item.getNamaAlat());
            }
        }
    }

    public void sortir() {
        daftarAlat.sort(Comparator.comparingDouble(Alat::getHargaAlat).reversed());
        System.out.println("----------------------");
        System.out.println("Daftar alat setelah disortir:");
        for (Alat item : daftarAlat) {
            item.displayDetail();
            System.out.println("----------------------");
        }
    }

    public void showMenu() {
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar alat");
            System.out.println("2. Tambah data alat");
            System.out.println("3. Edit data alat");
            System.out.println("4. Hapus data alat");
            System.out.println("5. Lihat detail alat by name");
            System.out.println("6. Sortir alat & barang");
            System.out.println("7. Close program");
            System.out.print("Input menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanDaftarAlat();
                    break;
                case 2:
                    tambahAlat();
                    break;
                case 3:
                    editAlat();
                    break;
                case 4:
                    hapusAlat();
                    break;
                case 5:
                    byName();
                    break;
                case 6:
                    sortir();
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
        RoboticWare manager = new RoboticWare();
        manager.showMenu();
    }
}
