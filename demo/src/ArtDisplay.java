import java.util.ArrayList;
import java.util.Scanner;

public class ArtDisplay {
    private final ArrayList<MenuItem> arts = new ArrayList<>();
    private final ArrayList<MenuItem> cart = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public ArtDisplay() {
        arts.add(new MenuItem("Starry Night", "Vincent van Gogh",
                "Lukisan malam berbintang yang penuh emosi dan warna biru pekat.", 5000000));
        arts.add(new MenuItem("Mona Lisa", "Leonardo da Vinci",
                "Potret wanita misterius dengan senyum yang menenangkan.", 10000000));
        arts.add(new MenuItem("Water Lilies", "Claude Monet",
                "Seri lukisan bunga teratai dengan pantulan air yang memukau.", 3500000));
        arts.add(new MenuItem("The Scream", "Edvard Munch",
                "Ekspresi kegelisahan dan kesedihan manusia modern.", 4500000));
    }

    public void displayArtMenu() {
        System.out.println("\n=== Mahakarya Maharupa Makmur ===");
        System.out.println("1. Lihat daftar karya seni");
        System.out.println("2. Pesan karya seni");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
    }

    public void listArts() {
        System.out.println("\n=== Daftar Karya Seni ===");
        for (int i = 0; i < arts.size(); i++) {
            arts.get(i).displayDetail(i + 1);
        }
        System.out.println("=========================");
    }

    public void placeOrder() {
        cart.clear();
        listArts();
        System.out.println("Ketik 0 jika sudah selesai memilih.\n");

        while (true) {
            System.out.print("Masukkan nomor karya yang ingin dibeli: ");
            if (!sc.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan nomor.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 0) {
                sc.nextLine();
                break;
            }

            if (choice < 1 || choice > arts.size()) {
                System.out.println("Nomor tidak valid.");
                sc.nextLine();
                continue;
            }

            MenuItem art = arts.get(choice - 1);

            if (!art.isAvailable()) {
                System.out.println("❌ Karya ini sudah terjual dan tidak dapat dibeli lagi.");
                sc.nextLine();
                continue;
            }

            MenuItem item = new MenuItem(art.getName(), art.getPainter(), art.getDescription(), art.getPrice());
            item.setQuantity(1);
            cart.add(item);

            art.markAsSold();

            sc.nextLine();
            System.out.println("✅ Ditambahkan ke keranjang: " + art.getName());
        }

        confirmOrder();
    }

    public void confirmOrder() {
        if (cart.isEmpty()) {
            System.out.println("Keranjang kosong. Tidak ada pesanan.");
            return;
        }

        System.out.println("\n=== Konfirmasi Pesanan ===");
        for (MenuItem item : cart) {
            item.displayItem();
        }

        System.out.print("\nLanjutkan ke checkout? (y/n): ");
        String confirm = sc.nextLine().trim();
        if (confirm.equalsIgnoreCase("y")) {
            printReceipt();
        } else {
            for (MenuItem item : cart) {
                for (MenuItem art : arts) {
                    if (art.getName().equals(item.getName())) {
                        art.markAsSold();
                        new MenuItem(art.getName(), art.getPainter(), art.getDescription(), art.getPrice());
                    }
                }
            }
            System.out.println("Pesanan dibatalkan, stok dikembalikan.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : cart) {
            total += item.getSubtotal();
        }
        double TAX_RATE = 0.2;
        return total + (total * TAX_RATE);
    }

    public void printReceipt() {
        System.out.println("\n=== NOTA PEMESANAN ===");
        for (MenuItem item : cart) {
            item.displayItem();
        }
        double total = calculateTotal();
        System.out.printf("\nTotal (termasuk pajak 20%%): Rp%.2f\n", total);
        System.out.println("=======================");
    }

    public static void main(String[] args) {
        ArtDisplay shop = new ArtDisplay();

        while (true) {
            shop.displayArtMenu();

            if (!shop.sc.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan angka menu.");
                shop.sc.nextLine();
                continue;
            }

            int choice = shop.sc.nextInt();
            shop.sc.nextLine();

            switch (choice) {
                case 1 -> shop.listArts();
                case 2 -> shop.placeOrder();
                case 3 -> {
                    System.out.println("Terima kasih telah mengunjungi Mahakarya Maharupa Makmur!");
                    shop.sc.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
