package day02.user.emergency_system.units;

import day02.user.emergency_system.enums.UnitStatus;
import day02.user.emergency_system.reports.EmergencyReport;

public class FireTruck extends EmergencyUnit{

    public FireTruck(String id, String location) {
        super(id, location);
    }

    @Override
    public String getUnitType() {
        return "Wóz strażacki";
    }

    @Override
    public void dispatchTo(EmergencyReport report) {

        setStatus(UnitStatus.BUSY);

        report.setAssignedUnit(this);

        System.out.println("Wóz strazacki o id: " + getId() + " został wyslany do zgłoszenia # " + report.getId());
    }
}
