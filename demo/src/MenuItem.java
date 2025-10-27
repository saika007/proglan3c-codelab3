public class MenuItem {
    private String name;
    private String painter;
    private String description;
    private double price;
    private int quantity;
    private boolean isAvailable;

    public MenuItem(String name, String painter, String description, double price) {
        this.name = name;
        this.painter = painter;
        this.description = description;
        this.price = price;
        this.quantity = 0;
        this.isAvailable = true;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public String getPainter() {
        return painter;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsSold() {
        this.isAvailable = false;
    }

    public void displayDetail(int index) {
        String status = isAvailable ? "" : " (SOLD OUT)";
        System.out.printf("%d. %s by %s%s - Rp%.2f\n   %s\n",
                index, name, painter, status, price, description);
    }

    public void displayItem() {
        System.out.printf("%-20s x%-2d Rp%.2f\n", name, quantity, getSubtotal());
    }
}
