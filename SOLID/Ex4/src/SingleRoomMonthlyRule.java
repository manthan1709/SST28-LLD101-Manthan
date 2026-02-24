public class SingleRoomMonthlyRule implements PricingRule {
    @Override
    public Money monthlyCharge(BookingRequest req) {
        return (req.roomType == LegacyRoomTypes.SINGLE) ? new Money(14000.0) : new Money(0.0);
    }
}