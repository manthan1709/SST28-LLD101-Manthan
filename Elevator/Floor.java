public class Floor {
    int floorNumber;
    OuterPanel panel;
    public Floor(int floorNumber, ElevatorManager manager) {
        this.floorNumber = floorNumber;
        this.panel = new OuterPanel(floorNumber, manager);
    } 
}
