package day02.user.emergency_system.units;

import day02.user.emergency_system.enums.UnitStatus;
import day02.user.emergency_system.interfaces.Dispatchable;

public abstract class EmergencyUnit implements Dispatchable {

    private final String id;
    private final String location;
    private UnitStatus status;

    public EmergencyUnit(String id, String location) {
        this.id = id;
        this.location = location;

        this.status = UnitStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public UnitStatus getStatus() {
        return status;
    }

    public void setStatus(UnitStatus status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return status == UnitStatus.AVAILABLE;
    }

    public abstract String getUnitType();

    @Override
    public String toString() {
        return "EmergencyUnit{" +
                "id='" + id + '\'' +
                ", lokalizacja='" + location + '\'' +
                ", status=" + status +
                '}';
    }
}
