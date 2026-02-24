import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));

        List<PricingRule> rules = List.of(
                new SingleRoomMonthlyRule(),
                new DoubleRoomMonthlyRule(),
                new TripleRoomMonthlyRule(),
                new DeluxeRoomMonthlyRule(),
                new MessAddOnMonthlyRule(),
                new LaundryAddOnMonthlyRule(),
                new GymAddOnMonthlyRule()
        );

        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), rules);
        calc.process(req);
    }
}