package day02.user.emergency_system.reports;

import day02.user.emergency_system.enums.Priority;

public class FireReport  extends EmergencyReport{

    public FireReport(String location, String description, Priority priority) {
        super(location, description, priority);
    }

    @Override
    public String getRequiredUnitType() {
        return "Wóz strazacki";
    }

    @Override
    public String getReportType() {
        return "Pożar";
    }
}
