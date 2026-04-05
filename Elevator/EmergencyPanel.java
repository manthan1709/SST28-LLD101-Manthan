public class EmergencyPanel extends Panel {
    Elevator elevator;

    public EmergencyPanel(Elevator elevator) {
        this.elevator = elevator;
    }

    public void triggerAlarm() {
        press(); 
    }

    @Override
    public void press() {
        elevator.emergencyStop();
    }
}
