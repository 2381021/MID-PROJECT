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
            System.out.println("1. Pilih Game");
            System.out.println("2. Pendaftaran Akun Pengguna");
            System.out.println("3. Tentukan Target Rank");
            System.out.println("4. Request ke Joki");
            System.out.println("5. Keluar");
            String selectedMenu = input("Pilih");

            switch (selectedMenu) {
                case "1":
                    showGameSelection();
                    break;
                case "2":
                    registerUser();
                    break;
                case "3":
                    chooseTargetRank();
                    break;
                case "4":
                    requestToJoki();
                    break;
                case "5":
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
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

    public static String input(String info) {
        System.out.print(info + " : ");
        return sc.nextLine();
    }
}
