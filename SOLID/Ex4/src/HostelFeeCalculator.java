import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<PricingRule> rules;

    public HostelFeeCalculator(FakeBookingRepo repo, List<PricingRule> rules) {
        this.repo = repo;
        this.rules = rules;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        Money total = new Money(0.0);

        for (int i = 0; i < rules.size(); i++) {
            PricingRule rule = rules.get(i);
            total = total.plus(rule.monthlyCharge(req));
        }

        return total;
    }
}
