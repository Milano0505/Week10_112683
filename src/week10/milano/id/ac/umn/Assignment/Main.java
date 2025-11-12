package week10.milano.id.ac.umn.Assignment;

import java.util.Scanner;
import week10.milano.id.ac.umn.Assignment.model.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Barang[] daftarBarang = new Barang[100];
        Order[] daftarPesanan = new Order[100];
        int jumlahBarang = 0;
        int jumlahPesanan = 0;

        int pilih;
        do {
            System.out.println("-------------Menu Toko Voucher & HP-------------");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Barang Baru");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    if (jumlahBarang == 0) {
                        System.out.println("Barang belum tersedia.\n");
                        break;
                    }

                    System.out.println("Daftar Barang Toko Voucher & HP");
                    for (int i = 0; i < jumlahBarang; i++) {
                        System.out.println(daftarBarang[i]);
                    }

                    System.out.print("Ketik 0 untuk batal\nPesan Barang (ID): ");
                    String idPesan = sc.next();
                    if (idPesan.equals("0")) break;

                    Barang brg = null;
                    for (int i = 0; i < jumlahBarang; i++) {
                        if (daftarBarang[i].getId().equalsIgnoreCase(idPesan)) {
                            brg = daftarBarang[i];
                            break;
                        }
                    }

                    if (brg == null) {
                        System.out.println("Barang tidak ditemukan\n");
                        break;
                    }

                    System.out.print("Masukkan jumlah: ");
                    int jml = sc.nextInt();
                    if (jml > brg.getStok()) {
                        System.out.println("Stok tidak mencukupi\n");
                        break;
                    }

                    double total;
                    if (brg instanceof Voucher) {
                        Voucher v = (Voucher) brg; // downcasting
                        total = v.getHargaJual() * jml;
                    } else {
                        Handphone hp = (Handphone) brg; // downcasting
                        total = hp.getHarga() * jml;
                    }

                    System.out.println(jml + " x " + brg.getNama() + " total harga: " + total);
                    System.out.print("Masukkan uang: ");
                    double uang = sc.nextDouble();

                    if (uang < total) {
                        System.out.println("Uang tidak cukup.\n");
                        break;
                    }

                    double kembalian = uang - total;
                    System.out.println("Kembalian: " + kembalian);
                    brg.minusStok(jml);

                    // Upcasting
                    daftarPesanan[jumlahPesanan++] = new Order("ORD-" + brg.getId(), brg, jml);
                    System.out.println("Pesanan berhasil disimpan!\n");
                    break;

                case 2:
                    System.out.println("========= Daftar Pesanan =========");
                    if (jumlahPesanan == 0) {
                        System.out.println("Belum ada pesanan.\n");
                    } else {
                        for (int i = 0; i < jumlahPesanan; i++) {
                            Order o = daftarPesanan[i];
                            Barang b = o.getBarang();
                            System.out.println("Order ID: " + o.getId());
                            System.out.println("Barang: " + b.getNama());
                            System.out.println("Jumlah: " + o.getJumlah());

                            // Downcasting
                            if (b instanceof Handphone) {
                                Handphone h = (Handphone) b;
                                System.out.println("Tipe: Handphone (" + h.getWarna() + ")");
                            } else if (b instanceof Voucher) {
                                Voucher v = (Voucher) b;
                                System.out.println("Tipe: Voucher (Pajak " + (v.getPajak() * 100) + "%)");
                            }
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Voucher / Handphone (V/H): ");
                    char jenis = sc.next().toLowerCase().charAt(0);
                    sc.nextLine();
                    System.out.print("ID: ");
                    String newId = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Harga: ");
                    double harga = sc.nextDouble();
                    System.out.print("Stok: ");
                    int stok = sc.nextInt();

                    if (jenis == 'v') {
                        System.out.print("Pajak (contoh 0.1 untuk 10%): ");
                        double pajak = sc.nextDouble();

                        // Upcasting
                        Barang b = new Voucher(newId, nama, harga, stok, pajak);
                        daftarBarang[jumlahBarang++] = b;

                        System.out.println("Voucher telah berhasil diinput!\n");

                    } else if (jenis == 'h') {
                        sc.nextLine();
                        System.out.print("Warna: ");
                        String warna = sc.nextLine();

                        // Upcasting
                        Barang b = new Handphone(newId, nama, harga, stok, warna);
                        daftarBarang[jumlahBarang++] = b;

                        System.out.println("Handphone telah berhasil diinput!\n");

                    } else {
                        System.out.println("Pilihan salah.\n");
                    }
                    break;

                case 0:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.\n");
            }

        } while (pilih != 0);

        sc.close();
    }
}
