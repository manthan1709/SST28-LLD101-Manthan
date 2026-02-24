public class LaundryAddOnMonthlyRule implements PricingRule {
    @Override
    public Money monthlyCharge(BookingRequest req) {
        return req.addOns.contains(AddOn.LAUNDRY) ? new Money(500.0) : new Money(0.0);
    }
}
