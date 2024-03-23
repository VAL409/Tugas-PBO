import java.util.Scanner;

public class Balok extends BangunRuang {
    private double panjang;
    private double lebar;
    private double tinggi;
    Scanner scanner = new Scanner(System.in);
    Balok(String bangunBalok) {
        super(bangunBalok);
    }
    @Override
    public void inputNilai() {
        super.inputNilai();
        System.out.print("Input panjang balok: ");
        panjang = scanner.nextDouble();
        System.out.print("Input lebar balok: ");
        lebar = scanner.nextDouble();
        System.out.print("Input tinggi balok: ");
        tinggi = scanner.nextDouble();
    }
    @Override
    public void luasPermukaan() {
        double hasil = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan balok: " + hasil);
    }
    @Override
    public void volume() {
        double hasil = panjang * lebar * tinggi;
        super.volume();
        System.out.println("Hasil volume balok: " + hasil);
    }
}
