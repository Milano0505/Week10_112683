package week10.milano.id.ac.umn;

public class main {
    public static void main(String[] args) {
        Pekerja pekerja = new Pekerja();
        pekerja.tanyaIdentitas();

        //contoh upcasting
        pekerja = new CEO();
        pekerja.tanyaIdentitas();

        //contoh upcasting
        Karyawan karyawan = new Karyawan();
        pekerja = (Pekerja) karyawan;
        pekerja.tanyaIdentitas();
    }
}
