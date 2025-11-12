package week10.milano.id.ac.umn.Assignment.model;

public class Voucher extends Barang {
    private double pajak;
    public static int total;

    public Voucher(String id, String nama, double harga, int stok, double pajak) {
        super(id, nama, harga, stok);
        this.pajak = pajak;
        total++;
    }

    public double getPajak() { return pajak; }

    public double getHargaJual() {
        return harga + (harga * pajak);
    }

    @Override
    public String toString() {
        return "Voucher - " + super.toString() + ", Pajak: " + pajak + ", Harga Jual: " + getHargaJual();
    }
}
