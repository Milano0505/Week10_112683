package week10.milano.id.ac.umn.Assignment.model;

public class Order {
    private String id;
    private Barang barang;
    private int jumlah;
    public static int total;

    public Order(String id, Barang barang, int jumlah) {
        this.id = id;
        this.barang = barang;
        this.jumlah = jumlah;
        total++;
    }

    public String getId() { return id; }
    public Barang getBarang() { return barang; }
    public int getJumlah() { return jumlah; }
}