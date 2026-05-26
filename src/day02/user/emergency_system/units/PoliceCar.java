package day02.user.emergency_system.units;

import day02.user.emergency_system.enums.UnitStatus;
import day02.user.emergency_system.reports.EmergencyReport;

public class PoliceCar extends EmergencyUnit {

    public PoliceCar(String id, String location) {
        super(id, location);
    }

    @Override
    public String getUnitType() {
        return "Radiowóz";
    }

    @Override
    public void dispatchTo(EmergencyReport report) {

        setStatus(UnitStatus.BUSY);

        report.setAssignedUnit(this);

        System.out.println("Radiowóz " + getId() + " został wysłany do zgłoszenia: " + report.getId());
    }
}
