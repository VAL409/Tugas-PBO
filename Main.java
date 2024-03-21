import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Book[] bookList = {
            new Book("001", "Sejarah", "Author 1", 10),
            new Book("002", "Matematika", "Author 2", 5),
            new Book("003", "IPS", "Author 3", 7)
    };

    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Book> borrowedBooks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    private void menu() {
        System.out.println("======= Welcome to Library =======");
        System.out.println("1. Login Admin");
        System.out.println("2. Login Mahasiswa");
        System.out.println("3. Exit");
        System.out.print("Pilih perintah yang ingin dijalankan: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                loginAsAdmin();
                break;
            case 2:
                loginAsStudent();
                break;
            case 3:
                System.out.println("Exiting program...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                menu();
        }
    }

    private void loginAsAdmin() {
        System.out.println("Welcome Admin!");
        System.out.println("1. Add Mahasiswa");
        System.out.println("2. Tampilkan daftar mahasiswa");
        System.out.println("3. Kembali ke Menu Utama");
        System.out.print("Pilih Perintah yang ingin digunakan: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                displayStudents();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                loginAsAdmin();
        }
    }

    private void addStudent() {
        System.out.println("Enter student details:");
        System.out.print("Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Program: ");
        String program = scanner.nextLine();

        studentList.add(new Student(name, nim, faculty, program));

        System.out.println("Student added successfully!");
        loginAsAdmin();
    }

    private void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            System.out.println("Registered Students:");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
        loginAsAdmin();
    }

    private void loginAsStudent() {
        System.out.println("Welcome Student!");
        System.out.print("Enter your NIM: ");
        String nim = scanner.next();

        boolean isRegistered = false;
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                isRegistered = true;
                break;
            }
        }

        if (isRegistered) {
            studentMenu();
        } else {
            System.out.println("Student with NIM " + nim + " is not registered.");
            menu();
        }
    }

    private void studentMenu() {
        System.out.println("1. Melihat Pilihan Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Melihat Buku yang dipinjam");
        System.out.println("4. Return to Main Menu");
        System.out.print("Pilih Perintah yang ingin dijalankan: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                displayBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                viewBorrowedBooks();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                studentMenu();
        }
    }

    private void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : bookList) {
            System.out.println(book);
        }
        studentMenu();
    }

    private void borrowBook() {
        System.out.println("Masukkan ID buku yang ingin dipinjam:");
        String bookId = scanner.next();
        Book foundBook = null;

        for (Book book : bookList) {
            if (book.getId().equals(bookId)) {
                foundBook = book;
                break;
            }
        }

        if (foundBook != null && foundBook.getStock() > 0) {
            borrowedBooks.add(foundBook);
            foundBook.decrementStock();
            System.out.println("Peminjaman buku berhasil!");
        } else {
            System.out.println("Buku tidak tersedia untuk dipinjam.");
        }

        studentMenu();
    }

    private void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Anda belum meminjam buku apapun.");
        } else {
            System.out.println("Buku yang dipinjam:");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
        studentMenu();
    }

    static class Book {
        private String id;
        private String title;
        private String author;
        private int stock;

        public Book(String id, String title, String author, int stock) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.stock = stock;
        }

        public String getId() {
            return id;
        }

        public int getStock() {
            return stock;
        }

        public void decrementStock() {
            stock--;
        }

        public String toString() {
            return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Stock: " + stock;
        }
    }

    static class Student {
        private String name;
        private String nim;
        private String faculty;
        private String program;

        public Student(String name, String nim, String faculty, String program) {
            this.name = name;
            this.nim = nim;
            this.faculty = faculty;
            this.program = program;
        }

        public String getNim() {
            return nim;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", NIM: " + nim + ", Faculty: " + faculty + ", Program: " + program;
        }
    }
}
