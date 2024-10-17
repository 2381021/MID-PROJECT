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
                case "4":
                    orderHistory();
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
        paymentMethod();
        showNotification();
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

    private static String paymentMethodChoice = "";
    public static void paymentMethod() {
        System.out.println("==== METODE PEMBAYARAN ====");
        System.out.println("1. Transfer Bank");
        System.out.println("2. E-Wallet (OVO, GoPay, DANA)");
        System.out.println("3. Pulsa");

        String paymentChoice = input("Pilih metode pembayaran");

        // Menyimpan pilihan metode pembayaran
        switch (paymentChoice) {
            case "1":
                paymentMethodChoice = "Transfer Bank";
                System.out.println("Anda memilih Transfer Bank.");
                System.out.println("Silakan transfer ke rekening: 1234567890 (Bank ABC).");
                break;
            case "2":
                paymentMethodChoice = "E-Wallet";
                System.out.println("Anda memilih E-Wallet.");
                System.out.println("Silakan transfer ke nomor E-Wallet: 081234567890.");
                break;
            case "3":
                paymentMethodChoice = "Pulsa";
                System.out.println("Anda memilih pembayaran dengan Pulsa.");
                System.out.println("Silakan kirim pulsa ke nomor: 081234567890.");
                break;
            default:
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
                paymentMethod(); // Meminta input ulang jika pilihan tidak valid
                return;
        }

        // Konfirmasi total harga setelah diskon (jika ada)
        System.out.println("Total yang harus dibayar: Rp. " + totalPrice);
        System.out.println("Terima kasih telah melakukan pemesanan. Silakan lakukan pembayaran untuk menyelesaikan transaksi.");
    }

    public static void showNotification () {
        System.out.println("=========================================");
        System.out.println("✨ Terima kasih telah melakukan pemesanan joki untuk akun game online Anda! ✨");
        System.out.println("Saat ini, pesanan Anda sedang diproses. Kami akan segera menghubungi Anda dengan informasi lebih lanjut.");

        while (true) {  // Loop terus-menerus hingga pengguna memberikan input yang benar
            System.out.println("Untuk kembali ke menu utama, silakan ketik 1.");
            String backToMenu = input("Konfiramsi");

            if (backToMenu.equals("1")) {
                showMainMenu();  // Kembali ke menu utama
                break;  // Keluar dari loop setelah kembali ke menu utama
            } else {
                System.out.println("Gagal Mengkonfirmasi. Silakan coba lagi."); // Pesan jika input tidak valid
            }
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

    public static void orderHistory() {
        System.out.println("==== RIWAYAT PEMESANAN ====");
        if (gameChoice.isEmpty()) {
            System.out.println("Belum ada riwayat pemesanan.");
        } else {
            System.out.println("+----------------------+--------------------------------+");
            System.out.printf("| %-20s | %-30s |\n", "Nama Pelanggan", name);
            System.out.printf("| %-20s | %-30s |\n", "ID User", userId);
            System.out.printf("| %-20s | %-30s |\n", "Account", account);
            System.out.printf("| %-20s | %-30s |\n", "No. Telp", phone);
            System.out.printf("| %-20s | %-30s |\n", "Game yang dipilih", gameChoice);
            System.out.printf("| %-20s | %-30s |\n", "Target Rank", rankChoice);
            System.out.printf("| %-20s | %-30s |\n", "Request ke Joki", request);
            System.out.printf("| %-20s | %-30s hari |\n", "Waktu penyelesaian", daysChoice);
            System.out.printf("| %-20s | Rp. %-27.2f |\n", "Total Harga", totalPrice);
            System.out.printf("| %-20s | %-30s |\n", "Metode Pembayaran", paymentMethodChoice);
            System.out.println("+----------------------+--------------------------------+");
        }
    }





    public static String input(String info) {
        System.out.print(info + " : ");
        return sc.nextLine();
    }



}