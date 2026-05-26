package day02.user.emergency_system.reports;

import day02.user.emergency_system.enums.Priority;

public class MedicalReport extends EmergencyReport{

    public MedicalReport(String location, String description, Priority priority) {
        super(location, description, priority);
    }

    @Override
    public String getRequiredUnitType() {
        return "Ambulans";
    }

    @Override
    public String getReportType() {
        return "Medyczny";
    }
}
