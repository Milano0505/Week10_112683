package week10.milano.id.ac.umn;

public class main {
    public static void main(String[] args) {
        //contoh downcasting
        CEO c = new CEO();
        Pekerja p = new CEO();
        c = (CEO)p;
        c.tanyaPendapatan();
    }
}
