public class TripleRoomMonthlyRule implements PricingRule {
    @Override
    public Money monthlyCharge(BookingRequest req) {
        return (req.roomType == LegacyRoomTypes.TRIPLE) ? new Money(12000.0) : new Money(0.0);
    }
}