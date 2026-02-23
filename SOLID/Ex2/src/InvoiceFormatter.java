import java.util.List;
import java.util.Map;

public class InvoiceFormatter {

    public String format(String invoiceId,
                         List<OrderLine> lines,
                         Map<String, MenuItem> menu,
                         Bill bill) {

        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoiceId).append("\n");

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }

        out.append(String.format("Subtotal: %.2f\n", bill.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", bill.taxPercent, bill.tax));
        out.append(String.format("Discount: -%.2f\n", bill.discount));
        out.append(String.format("TOTAL: %.2f\n", bill.total));

        return out.toString();
    }
}