package flowapowa.application;

import java.util.Locale;
import java.util.Objects;

final class Total implements ReceiptLine {
    private final String element;
    private final float amount;

    Total(String element, float amount) {
        this.element = element;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%-20s %8.2f\n", element, amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Total) obj;
        return Objects.equals(this.element, that.element) &&
                Float.floatToIntBits(this.amount) == Float.floatToIntBits(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, amount);
    }

}
