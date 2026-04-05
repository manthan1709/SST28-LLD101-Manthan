import java.util.*;

public class ElevatorManager {
   ArrayList<Elevator> elevators;
    SchedulingStrategy strategy;

    public ElevatorManager(ArrayList<Elevator> elevators) {
        this.elevators = elevators;
        this.strategy = new NearestElevatorStrategy();
    }

    public void handleRequest(Request r) {
        Elevator e = strategy.selectElevator(r, elevators);
        if (e != null) {
            e.addRequest(r);
        }
    }
}
