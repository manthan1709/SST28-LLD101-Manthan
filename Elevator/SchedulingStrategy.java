import java.util.ArrayList;

public interface SchedulingStrategy {
  Elevator selectElevator(Request request, ArrayList<Elevator> elevators);
}
