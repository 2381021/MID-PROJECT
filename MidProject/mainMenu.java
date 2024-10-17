package MidProject;

import java.util.Scanner;

public class mainMenu {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("==== MENU UTAMA ====");
            System.out.println("1. Pilih Game dan Lanjutkan");
            System.out.println("2. Keluar");
            String selectedMenu = input("Pilih");

            switch (selectedMenu) {
                case "1":
                    startFullProcess();  // Mulai proses otomatis dari game selection hingga request ke joki
                    break;
                case "2":
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    public static void startFullProcess() {
        showGameSelection();
        registerUser();
        chooseTargetRank();
        requestToJoki();
        chooseCompletionTime();

    }

    public static void showGameSelection() {
        System.out.println("==== PILIH GAME ====");
        System.out.println("1. PUBG");
        System.out.println("2. Mobile Legends");
        System.out.println("3. Free Fire");
        String gameChoice = input("Pilih game");
        System.out.println("Anda memilih game: " + gameChoice);
    }

    public static void registerUser() {
        System.out.println("==== PENDAFTARAN AKUN ====");
        String name = input("Nama Pelanggan");
        String userId = input("ID User");
        String account = input("Account");
        String phone = input("No. Telp");
        System.out.println("Akun berhasil didaftarkan atas nama: " + name);
    }

    public static void chooseTargetRank() {
        System.out.println("==== TENTUKAN TARGET RANK ====");
        System.out.println("1. +1 Rank (Rp. 15.000)");
        System.out.println("2. +2 Rank (Rp. 30.000)");
        System.out.println("3. +3 Rank (Rp. 45.000)");
        String rankChoice = input("Pilih target rank");
        System.out.println("Anda memilih: " + rankChoice);


    }

    public static void requestToJoki() {
        System.out.println("==== REQUEST KE JOKI ====");
        String request = input("Masukkan request Anda");
        System.out.println("Request Anda: \"" + request + "\" telah dikirim.");
    }

    public static void chooseCompletionTime() {
        System.out.println("==== PENJADWALAN WAKTU SELESAI ====");
        System.out.println("Berapa lama waktu yang Anda inginkan untuk menyelesaikan order?");
        System.out.println("Pilih antara 1 hingga 3 hari");

        String daysChoice = input("Masukkan jumlah hari");

        // Memeriksa apakah pilihan user berada di antara 1 hingga 3 hari
        switch (daysChoice) {
            case "1":
                System.out.println("Order Anda akan selesai dalam 1 hari.");
                break;
            case "2":
                System.out.println("Order Anda akan selesai dalam 2 hari.");
                break;
            case "3":
                System.out.println("Order Anda akan selesai dalam 3 hari.");
                break;
            default:
                System.out.println("Pilihan tidak valid, silakan pilih antara 1 hingga 3 hari.");
                chooseCompletionTime();  // Meminta input ulang jika pilihan tidak valid
        }
    }




    public static String input(String info) {
        System.out.print(info + " : ");
        return sc.nextLine();
    }

}