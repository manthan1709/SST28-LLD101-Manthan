public class MessAddOnMonthlyRule implements PricingRule {
    @Override
    public Money monthlyCharge(BookingRequest req) {
        return req.addOns.contains(AddOn.MESS) ? new Money(1000.0) : new Money(0.0);
    }
}
