import java.util.List;

public class MinCgrRule implements EligibilityRule {

    @Override
    public boolean reject(StudentProfile s, List<String> reasons) {
        if (s.cgr < 8.0) {
            reasons.add("CGR below 8.0");
            return true;
        }
        return false;
    }
}