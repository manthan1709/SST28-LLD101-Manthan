import java.util.*;

public interface MovementStrategy {
  ArrayList<Request> optimize(ArrayList<Request> requests, int currentFloor, Direction direction);
}
