package kuis2_24;
import java.util.Scanner;
/**
 *
 * @author sabil
 */
public class DoubleLinkedListsMain_24 {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        
        DoubleLinkedLists_24 dll = new DoubleLinkedLists_24();
        int menu = 0;
        String nama,noHp;
        String namaPesanan;
        int kodePesanan,harga;
        System.out.println("===QUIS 2 PRAKTIKUM ALGORITMA STRUKTUR DATA===");
        System.out.println("Nama\t : Sabilla Luthfi Rahmadhan");
        System.out.println("NIM\t : 2141720122");
        System.out.println("Absen\t : 24");
        System.out.println("==============================================");
        System.out.println("System Antrian Resto Royal Delish");
        do {
            System.out.println("===============================");
            System.out.println("Menu");
            System.out.println("===============================");
            System.out.println("1. Tambah Data Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian");
            System.out.println("4. Pengurutan Pesanan by nama");
            System.out.println("5. Hitung Total Pendapatan");
            System.out.println("6. Keluar");
            System.out.println("===============================");
            System.out.print("Pilih menu : ");
            menu = sc.nextInt();
            sc.nextLine();
            
            switch (menu) {
                case 1:
                    System.out.println("Masukkan data antrian : ");
                    System.out.print("Nama : ");
                    nama = sc.nextLine();
                    System.out.print("No. HP : ");
                    noHp = sc.nextLine();
                    System.out.print("Kode Pesanan : ");
                    kodePesanan = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nama Pesanan : ");
                    namaPesanan = sc.nextLine();
                    System.out.print("Harga : ");
                    harga = sc.nextInt();
                    
                    dll.addLast(new Pembeli_24 (nama, noHp),new Pesanan_24 (kodePesanan, namaPesanan, harga));
                    break;
                case 2:
                    dll.print();
                    break;
                case 3:
                    System.out.print("Masukkan index yang ingin dihapus : ");
                    int idx = sc.nextInt();
                    dll.remove(idx);
                    break;
                case 4:
                    dll.asc();
                    dll.printAsc();
                    break;
                case 5:
                    dll.total();
                    break;
                case 6:
                    System.out.println("Program sudah dijalankan, terimakasih");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }
        } while (menu != 0 && menu <= 6);
            sc.close();
    }
}
