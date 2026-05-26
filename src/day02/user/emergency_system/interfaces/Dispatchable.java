package day02.user.emergency_system.interfaces;


import day02.user.emergency_system.reports.EmergencyReport;

public interface Dispatchable {
    void dispatchTo(EmergencyReport report);
}
