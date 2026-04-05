public class OpenClosePanel extends Panel {
  Elevator elevator;
  boolean isOpenButton;

  public OpenClosePanel(Elevator elevator, boolean isOpenButton) {
    this.elevator = elevator;
    this.isOpenButton = isOpenButton;
  }

  @Override
  public void press() {
    if (isOpenButton) {
      elevator.openDoor();
    } else {
      elevator.closeDoor();
    }
  }

}
