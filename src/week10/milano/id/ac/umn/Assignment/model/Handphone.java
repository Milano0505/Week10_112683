package week10.milano.id.ac.umn.Assignment.model;

public class Handphone extends Barang {
    private String warna;
    public static int total;

    public Handphone(String id, String nama, double harga, int stok, String warna) {
        super(id, nama, harga, stok);
        this.warna = warna;
        total++;
    }

    public String getWarna() { return warna; }

    @Override
    public String toString() {
        return "Handphone - " + super.toString() + ", Warna: " + warna;
    }
}
