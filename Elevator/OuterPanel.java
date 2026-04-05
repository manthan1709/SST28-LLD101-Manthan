public class OuterPanel extends Panel {
  int floor;
  ElevatorManager manager;

  public OuterPanel(int floor, ElevatorManager manager) {
    this.floor = floor;
    this.manager = manager;
  }

  public void press(Direction dir) {
    Request r = new Request(floor, null, dir, RequestType.EXTERNAL);
    manager.handleRequest(r);
  }

  @Override
  public void press() {
    throw new UnsupportedOperationException("Use press(Direction dir) to specify UP or DOWN.");
  }

}
