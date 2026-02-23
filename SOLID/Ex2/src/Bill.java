public class Bill {
    double subtotal;
    double taxPercent;
    double tax;
    double discount;
    double total;

    public Bill(double subtotal, double taxPercent, double tax, double discount, double total) {
        this.subtotal = subtotal;
        this.taxPercent = taxPercent;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}