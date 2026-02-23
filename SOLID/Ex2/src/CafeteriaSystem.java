import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store = new FileStore();
    private int invoiceSeq = 1000;

    private final BillingCalculator calculator =
            new BillingCalculator(new TaxRules(), new DiscountRules());

    private final InvoiceFormatter formatter = new InvoiceFormatter();

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }


    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        Bill bill = calculator.calculate(customerType, lines, menu);
        String printable = formatter.format(invId, lines, menu, bill);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
