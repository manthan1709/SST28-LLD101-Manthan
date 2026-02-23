import java.util.List;

public interface EligibilityRule {
    
    boolean reject(StudentProfile s, List<String> reasons);
}