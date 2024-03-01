import java.util.Scanner;

public class Main {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "Admin123";
    private static final int MAHASISWA_NIM_LENGTH = 15;
    private static final String MAHASISWA_NIM = "202310370311409";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang di Sistem Login Library");

        // Meminta pengguna memilih jenis login
        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline dari buffer

        // Proses login sesuai pilihan pengguna
        switch (pilihan) {
            case 1:
                adminLogin(scanner);
                break;
            case 2:
                mahasiswaLogin(scanner);
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }

        scanner.close();
    }

    private static void adminLogin(Scanner scanner) {
        System.out.print("Masukkan username admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password admin: ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Login admin berhasil");
        } else {
            System.out.println("Username atau password admin salah");
        }
    }

    private static void mahasiswaLogin(Scanner scanner) {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();

        if (nim.length() == MAHASISWA_NIM_LENGTH && nim.equals(MAHASISWA_NIM)) {
            System.out.println("Login mahasiswa berhasil");
        } else {
            System.out.println("NIM Mahasiswa salah");
            System.out.println("Panjang NIM harus sama dengan " + MAHASISWA_NIM_LENGTH);
        }
    }
}
