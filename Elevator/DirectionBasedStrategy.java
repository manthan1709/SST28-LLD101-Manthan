import java.util.*;

public class DirectionBasedStrategy implements MovementStrategy {
    public ArrayList<Request> optimize(ArrayList<Request> requests, int currentFloor, Direction direction) {
        ArrayList<Request> up = new ArrayList<>();
        ArrayList<Request> down = new ArrayList<>();

        for (Request r : requests) {
            if (r.sourceFloor >= currentFloor) {
                up.add(r);
            } else {
                down.add(r);
            }
        }

        up.sort(Comparator.comparingInt(r -> r.sourceFloor));
        down.sort((a, b) -> b.sourceFloor - a.sourceFloor);

        ArrayList<Request> result = new ArrayList<>();
        result.addAll(up);
        result.addAll(down);

        return result;
    }
}