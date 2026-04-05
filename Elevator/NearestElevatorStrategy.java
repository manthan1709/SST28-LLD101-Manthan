import java.util.ArrayList;

public class NearestElevatorStrategy implements SchedulingStrategy {
  public Elevator selectElevator(Request request, ArrayList<Elevator> elevators) {
    Elevator best = null;
    int minDistance = Integer.MAX_VALUE;

    for (Elevator e : elevators) {
      if (e.isUnderMaintenance())
        continue;

      int distance = Math.abs(e.currentFloor - request.sourceFloor);
      if (distance < minDistance) {
        minDistance = distance;
        best = e;
      }
    }
    return best;
  }
}
