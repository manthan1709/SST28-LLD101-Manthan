public class GymAddOnMonthlyRule implements PricingRule {
    @Override
    public Money monthlyCharge(BookingRequest req) {
        return req.addOns.contains(AddOn.GYM) ? new Money(300.0) : new Money(0.0);
    }
}
