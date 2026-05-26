package day02.user.emergency_system.reports;

import day02.user.emergency_system.enums.Priority;

public class AccidentReport extends EmergencyReport{

    public AccidentReport(String location, String description, Priority priority) {
        super(location, description, priority);
    }

    @Override
    public String getRequiredUnitType() {
        return "Radiowóz";
    }

    @Override
    public String getReportType() {
        return "Wypadek";
    }
}
