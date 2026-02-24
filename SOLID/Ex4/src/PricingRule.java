public interface PricingRule {
    Money monthlyCharge(BookingRequest req);
}