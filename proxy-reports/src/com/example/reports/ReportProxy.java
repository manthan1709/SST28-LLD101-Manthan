package com.example.reports;

/**
 * Proxy responsibilities:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
        
    }

    @Override
    public void display(User user) {
        System.out.println("[proxy] request: user=" + user.getName()
                + " role=" + user.getRole()
                + " -> reportId=" + reportId
                + " classification=" + classification);

        if (this.accessControl.canAccess(user, classification)) {

            if (this.realReport == null) {
                System.out.println("[proxy] access granted; lazy-loading RealReport for reportId=" + reportId);
                this.realReport = new RealReport(reportId, title, classification);
            } else {
                System.out.println("[proxy] access granted; using cached RealReport for reportId=" + reportId);
            }

            this.realReport.display(user);

        } else {
            System.out.println("[access denied] user=" + user.getName()
                    + " role=" + user.getRole()
                    + " cannot open reportId=" + reportId
                    + " classification=" + classification);
        }
    }
}
