package day02.user.emergency_system.reports;

import day02.user.emergency_system.units.EmergencyUnit;
import day02.user.emergency_system.interfaces.Reportable;
import day02.user.emergency_system.enums.Priority;
import day02.user.emergency_system.enums.UnitStatus;

import java.time.LocalDateTime;

public abstract class EmergencyReport implements Reportable {

    private static int counter = 1;

    private final int id;
    private final String location;
    private final String description;
    private final Priority priority;

    private final LocalDateTime createdAt;

    private boolean completed;

    private EmergencyUnit assignedUnit;


    public EmergencyReport(String location, String description, Priority priority) {
        this.id = counter++;
        this.location = location;
        this.description = description;
        this.priority = priority;

        this.createdAt = LocalDateTime.now();
        this.completed = false;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public EmergencyUnit getAssignedUnit() {
        return assignedUnit;
    }

    public void complete() {
        completed = true;

        if (assignedUnit != null) {
            assignedUnit.setStatus(UnitStatus.AVAILABLE);
        }
    }

    public void setAssignedUnit(EmergencyUnit assignedUnit) {
        this.assignedUnit = assignedUnit;
    }

    public abstract String getRequiredUnitType();

    public abstract String getReportType();

    @Override
    public String generateSummary() {

        String unitInfo;

        if (assignedUnit == null) {
            unitInfo = "Brak";
        } else
            unitInfo = assignedUnit.getUnitType()
                    + " "
                    + assignedUnit.getId();

        return "id" + id
                + " | Typ: " + getReportType()
                + " | Lokalizacja: " + location
                + " | Opis: " + description
                + " | Priorytet: " + priority
                + " | Data zgłoszenia: " + createdAt
                + " | Jednostka" + unitInfo
                + " | Status" + (completed ? "Zakończone" : "Aktywne");
    }
}
