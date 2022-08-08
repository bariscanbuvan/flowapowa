package flowapowa.application;

class Product {
    private final String productName;
    private final int quantity;
    private final double price;

    public Product(String productName, int quantity, double price) {

        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public float amount() {
        return (float) (quantity * price);
    }

    public void addToReceipt(Receipt receipt) {
        receipt.addPart(productName, quantity, price, amount());
    }
}
