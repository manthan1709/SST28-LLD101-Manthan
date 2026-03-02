public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        PowerControl pjPower = (PowerControl) reg.getFirstOfType("Projector");
        pjPower.powerOn();
        InputConnectable pjInput = (InputConnectable) reg.getFirstOfType("Projector");
        pjInput.connectInput("HDMI-1");

        BrightnessControl lights = (BrightnessControl) reg.getFirstOfType("LightsPanel");
        lights.setBrightness(60);

        TemperatureControl ac = (TemperatureControl) reg.getFirstOfType("AirConditioner");
        ac.setTemperatureC(24);

        AttendanceScan scan = (AttendanceScan) reg.getFirstOfType("AttendanceScanner");
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        ((PowerControl) reg.getFirstOfType("Projector")).powerOff();
        ((PowerControl) reg.getFirstOfType("LightsPanel")).powerOff();
        ((PowerControl) reg.getFirstOfType("AirConditioner")).powerOff();
    }
}
