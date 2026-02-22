import java.util.*;

public class OnboardingService {
    private final StudentRepository db;
    private final StudentRegistrationParser parser = new StudentRegistrationParser();
    private final StudentRegistrationValidator validator = new StudentRegistrationValidator();

    public OnboardingService(StudentRepository db) { this.db = db; }

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        StudentRegistrationData data = parser.parse(raw);

        List<String> errors = validator.validate(data);
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, data.name, data.email, data.phone, data.program);

        db.save(rec);

        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}