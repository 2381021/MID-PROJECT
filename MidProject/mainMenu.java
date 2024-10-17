package MidProject;

import java.util.Scanner;

public class mainMenu {
    public static Scanner sc = new Scanner(System.in);

    private static String gameChoice = "";
    private static String name = "";
    private static String userId = "";
    private static String account = "";
    private static String phone = "";
    private static String rankChoice = "";
    private static String request = "";
    private static String daysChoice = "";
    private static double totalPrice = 0.0;

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("==== MENU UTAMA ====");
            System.out.println("1. Buat Pemesanan");
            System.out.println("2. Edit Pemesanan");
            System.out.println("3. Batal Pemesanan");
            System.out.println("4. Riwayat Pemesanan");
            System.out.println("5. Rating (Ulasan)");
            System.out.println("6. Keluar");
            String selectedMenu = input("Pilih");

            switch (selectedMenu) {
                case "1":
                    startFullProcess();  // Mulai proses otomatis dari game selection hingga request ke joki
                    break;
                case "2":
                    editOrder();
                    break;
                case "3":
                    cancelOrder();
                    break;
                case "6":
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
        applyVoucher();

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

    public static void applyVoucher() {
        System.out.println("==== MASUKKAN KODE VOUCHER ====");
        String voucherCode = input("Masukkan kode voucher (contoh: MTJ)");

        // Memeriksa apakah kode voucher valid
        if (voucherCode.equalsIgnoreCase("MTJ")) {
            totalPrice = 0; // Diskon 100%
            System.out.println("Selamat! Anda mendapatkan diskon 100%. Total harga: Rp. " + totalPrice);
        } else {
            System.out.println("Kode voucher salah. Harga normal tetap: Rp. " + totalPrice);
        }
    }


    public static void cancelOrder() {
        System.out.println("==== BATALKAN PEMESANAN ====");
        System.out.println("Apakah Anda yakin ingin membatalkan pemesanan? Semua data akan dihapus. (ya/tidak)");
        String confirmation = input("Konfirmasi");

        if (confirmation.equalsIgnoreCase("ya")) {
            // Reset semua data yang telah diinput
            gameChoice = "";
            name = "";
            userId = "";
            account = "";
            phone = "";
            rankChoice = "";
            request = "";
            daysChoice = "";

            System.out.println("Pemesanan Anda telah dibatalkan dan semua data telah dihapus.");
        } else {
            System.out.println("Pemesanan tidak dibatalkan.");
        }
    }


    public static void editOrder() {
        System.out.println("==== EDIT PEMESANAN ====");
        System.out.println("Anda akan mengedit pemesanan Anda.");
        System.out.println("1. Edit Game");
        System.out.println("2. Edit Pendaftaran Akun");
        System.out.println("3. Edit Target Rank");
        System.out.println("4. Edit Request ke Joki");
        System.out.println("5. Edit Waktu Selesai");
        System.out.println("6. Batalkan Edit");
        String editChoice = input("Pilih yang ingin diubah");

        switch (editChoice) {
            case "1":
                showGameSelection();  // Ulangi pilihan game
                break;
            case "2":
                registerUser();       // Ulangi pendaftaran user
                break;
            case "3":
                chooseTargetRank();   // Ulangi pemilihan target rank
                break;
            case "4":
                requestToJoki();      // Ulangi request ke joki
                break;
            case "5":
                chooseCompletionTime(); // Ulangi pemilihan waktu selesai
                break;
            case "6":
                System.out.println("Batal melakukan edit.");
                break;
            default:
                System.out.println("Pilihan tidak valid, coba lagi.");
                editOrder(); // Meminta input ulang jika pilihan tidak valid
        }
    }



    public static String input(String info) {
        System.out.print(info + " : ");
        return sc.nextLine();
    }



}