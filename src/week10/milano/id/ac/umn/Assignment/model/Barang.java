package week10.milano.id.ac.umn.Assignment.model;

public class Barang {
    protected String id;
    protected String nama;
    protected double harga;
    protected int stok;

    public Barang(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void minusStok(int jml) {
        if (stok >= jml) this.stok -= jml;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Harga: " + harga + ", Stok: " + stok;
    }
}
