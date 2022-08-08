package flowapowa.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Receipt {
    private final List<ReceiptLine> parts = new ArrayList<>();

    public Receipt() {
    }

    public void addPart(String productName, int quantity, double price, float amount) {
        Part part = new Part(
                productName,
                quantity,
                price,
                amount
        );

        parts.add(part);
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        for (ReceiptLine part :
                parts) {
            receipt.append(part.toString());
        }

        return receipt.toString();
    }

    public void addTotal(String total, float amount) {
        parts.add(new Total(
                total,
                amount
        ));
    }

    public void addSeparator() {
        parts.add(new Separator());
    }

    public void add(Product product) {
        product.addToReceipt(this);
    }

    private static class Part implements ReceiptLine {
        protected final String productName;
        protected final float amount;
        private final double price;
        private final int quantity;

        public Part(String productName, int quantity, double price, float amount) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "%-8s %5d %6.2f %7.2f\n", productName(), quantity, price, amount());
        }

        private String productName() {
            String first = productName.substring(0, 1);
            String last = productName.substring(1);

            return first.toUpperCase() + last.toLowerCase();
        }

        private Double amount() {
            return quantity * price;
        }
    }

}
