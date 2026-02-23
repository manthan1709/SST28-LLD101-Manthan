import java.util.List;

public class MinCreditsRule implements EligibilityRule {

    @Override
    public boolean reject(StudentProfile s, List<String> reasons) {
        if (s.earnedCredits < 20) {
            reasons.add("credits below 20"); // keep output identical
            return true;
        }
        return false;
    }
}