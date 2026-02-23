import java.util.List;

public class MinAttendanceRule implements EligibilityRule {

    @Override
    public boolean reject(StudentProfile s, List<String> reasons) {
        if (s.attendancePct < 75) {
            reasons.add("attendance below 75");
            return true;
        }
        return false;
    }
}