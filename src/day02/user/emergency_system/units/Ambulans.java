package day02.user.emergency_system.units;

import day02.user.emergency_system.enums.UnitStatus;
import day02.user.emergency_system.reports.EmergencyReport;

public class Ambulans extends EmergencyUnit {

    public Ambulans(String id, String location) {
        super(id, location);
    }

    @Override
    public String getUnitType() {
        return "Ambulans";
    }

    @Override
    public void dispatchTo(EmergencyReport report) {
        setStatus(UnitStatus.BUSY);

        report.setAssignedUnit(this);

        System.out.println("Ambulans " + getId() + " wysłany do zgłoszenia #" + report.getId());
    }
}
