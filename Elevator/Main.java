import java.util.*;

public class Main {
    public static void main(String[] args) {
        Elevator e1 = new Elevator(1);
        Elevator e2 = new Elevator(2);

        ArrayList<Elevator> elevators = new ArrayList<>();
        elevators.add(e1);
        elevators.add(e2);
        ElevatorManager manager = new ElevatorManager(elevators);

        Floor f0 = new Floor(0, manager);
        Floor f5 = new Floor(5, manager);

        f0.panel.press(Direction.UP);

        e1.processRequests();
        e2.processRequests();

        InnerPanel inner = new InnerPanel(e1);
        inner.press(10);

        e1.processRequests();
        EmergencyPanel ep = new EmergencyPanel(e1);
        ep.triggerAlarm();
    }
}