import java.util.*;

public class Elevator {
    int id;
    int currentFloor;
    Direction direction;
    ElevatorState state;
    ArrayList<Request> requests;
    MovementStrategy movementStrategy;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.state = ElevatorState.IDLE;
        this.requests = new ArrayList<>();
        this.direction = Direction.UP;
        this.movementStrategy = new DirectionBasedStrategy();
    }

    public void addRequest(Request r) {
        requests.add(r);
    }

    public void processRequests() {
        if (requests.isEmpty()) {
            state = ElevatorState.IDLE;
            return;
        }

        requests = movementStrategy.optimize(requests, currentFloor, direction);

        while (!requests.isEmpty()) {
            Request r = requests.remove(0);

            // Update direction and state based on movement to source floor
            if (r.sourceFloor > currentFloor) {
                direction = Direction.UP;
                state = ElevatorState.MOVING_UP;
            } else if (r.sourceFloor < currentFloor) {
                direction = Direction.DOWN;
                state = ElevatorState.MOVING_DOWN;
            }

            System.out.println("Elevator " + id + " moving to floor " + r.sourceFloor);
            currentFloor = r.sourceFloor;

            if (r.destinationFloor != null) {
                // Update direction and state based on movement to destination floor
                if (r.destinationFloor > currentFloor) {
                    direction = Direction.UP;
                    state = ElevatorState.MOVING_UP;
                } else if (r.destinationFloor < currentFloor) {
                    direction = Direction.DOWN;
                    state = ElevatorState.MOVING_DOWN;
                }

                System.out.println("Going to destination " + r.destinationFloor);
                currentFloor = r.destinationFloor;
            }
        }

        // All requests done — elevator is idle
        state = ElevatorState.IDLE;
    }

    public void openDoor() {
        System.out.println("Elevator " + id + " door opened");
    }

    public void closeDoor() {
        System.out.println("Elevator " + id + " door closed");
    }

    public void emergencyStop() {
        System.out.println("Elevator " + id + " EMERGENCY STOP!");
        state = ElevatorState.IDLE;
        requests.clear();
    }

    public boolean isUnderMaintenance() {
        return state == ElevatorState.MAINTENANCE;
    }

    public void setMaintenance(boolean flag) {
        state = flag ? ElevatorState.MAINTENANCE : ElevatorState.IDLE;
    }
}