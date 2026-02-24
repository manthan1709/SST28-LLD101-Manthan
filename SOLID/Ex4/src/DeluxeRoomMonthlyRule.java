public class DeluxeRoomMonthlyRule implements PricingRule {
    @Override
    public Money monthlyCharge(BookingRequest req) {
        return (req.roomType == LegacyRoomTypes.DELUXE) ? new Money(16000.0) : new Money(0.0);
    }
}
