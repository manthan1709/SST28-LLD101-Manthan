public class EvaluationPipeline {
    private final PlagiarismCheck plagiarismCheck;
    private final Grader grader;
    private final ReportWriterPort reportWriter;


    public EvaluationPipeline(PlagiarismCheck plagiarismCheck, Grader grader, ReportWriterPort reportWriter) {
        this.plagiarismCheck = plagiarismCheck;
        this.grader = grader;
        this.reportWriter = reportWriter;
    }

    public void evaluate(Submission sub) {
        Rubric rubric = new Rubric();

        
        int plag = plagiarismCheck.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = reportWriter.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
