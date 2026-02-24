public class DoubleRoomMonthlyRule implements PricingRule {
    @Override
    public Money monthlyCharge(BookingRequest req) {
        return (req.roomType == LegacyRoomTypes.DOUBLE) ? new Money(15000.0) : new Money(0.0);
    }
}