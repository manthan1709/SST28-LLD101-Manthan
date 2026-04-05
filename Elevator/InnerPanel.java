public class InnerPanel extends Panel {
  Elevator elevator;

  public InnerPanel(Elevator elevator) {
    this.elevator = elevator;
  }

  public void press(int destination) {
    Request r = new Request(elevator.currentFloor, destination, null, RequestType.INTERNAL);
    elevator.addRequest(r);
  }

  @Override
  public void press() {
    throw new UnsupportedOperationException("Use press(int destination) to specify a floor number.");
  }
}
