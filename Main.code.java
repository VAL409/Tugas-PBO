import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String firstName;
        String Gender;
        LocalDate Kelahiran;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner objInput = new Scanner(System.in);

        System.out.print("Masukkan Nama Anda : ");
        firstName = objInput.nextLine();

        System.out.print("Apa Jenis kelamin Anda (L/P) : ");
        Gender = objInput.nextLine();

        System.out.print("Masukkan Tanggal Lahir (yyyy-MM-dd): ");
        String tanggalLahirString = objInput.nextLine();
        Kelahiran = LocalDate.parse(tanggalLahirString, formatter);

        System.out.println("Nama : " + firstName);
        if (Gender.equalsIgnoreCase("L")) {
            System.out.println("Jenis Kelamin: Laki-Laki");
        } else if (Gender.equalsIgnoreCase("P")) {
            System.out.println("Jenis Kelamin: Perempuan");
        } else {
            System.out.println("Input jenis kelamin tidak valid.");
            return;
        }

        System.out.println("Tanggal Lahir Anda: " + Kelahiran.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));

        LocalDate now = LocalDate.now();
        int umur = now.getYear() - Kelahiran.getYear();

        // Periksa apakah sudah melewati hari ulang tahun
        if (now.getMonthValue() < Kelahiran.getMonthValue() || (now.getMonthValue() == Kelahiran.getMonthValue() && now.getDayOfMonth() < Kelahiran.getDayOfMonth())) {
            umur--;
        }

        System.out.println("Umur Anda adalah: " + umur + " tahun");
    }
}

