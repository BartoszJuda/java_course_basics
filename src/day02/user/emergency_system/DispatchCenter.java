package day02.user.emergency_system;

import day02.user.emergency_system.reports.EmergencyReport;
import day02.user.emergency_system.units.EmergencyUnit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DispatchCenter {

    private  final List<EmergencyUnit> units = new ArrayList<>();
    private final List<EmergencyReport> reports = new ArrayList<>();

    private final List<HistoryEntry> history = new ArrayList<>();

    public void addUnit(EmergencyUnit unit) {
        units.add(unit);
    }

    public void addReport(EmergencyReport report) {
        reports.add(report);
    }

    public void dispatchUnits() {

        if (reports.isEmpty()) {
            System.out.println("brak wezwań pomocy");
            return;
        }

        reports.sort(Comparator.comparing(EmergencyReport::getPriority)
                .reversed());

        for (EmergencyReport report : reports) {

            if (report.getAssignedUnit() != null) {
                continue;
            }

            Optional<EmergencyUnit> foundedUnit = units.stream()
                    .filter(EmergencyUnit::isAvailable)

                    .filter(unit -> unit.getUnitType().equals(report.getRequiredUnitType()))
                    .findFirst();

            if (foundedUnit.isPresent()) {
                foundedUnit.get().dispatchTo(report);
            } else {
                System.out.println("Brak wolnej jednostki do przydzielenia do zgłoszenia #" + report.getId());
            }
        }
    }

    public void showActiveReports() {
        if (reports.isEmpty()) {
            System.out.println("Brak aktywnych zgłoszeń");
            return;
        }
        System.out.println("\nAKTYWNE ZGŁOSZENIA");

        for (EmergencyReport report : reports) {
            System.out.println(report.generateSummary());
        }
    }

    public void showUnits() {
        System.out.println("\nJEDNOSTKI");

        for (EmergencyUnit unit: units) {
            System.out.println(unit);
        }
    }

    public void finishReport(int id) {
        EmergencyReport foundedReport = null;

        for (EmergencyReport report : reports) {
            if (report.getId() == id) {
                foundedReport = report;
                break;
            }
        }
        if (foundedReport == null) {
            System.out.println("nie znaleziono zgłoszenia");
            return;
        }

        foundedReport.complete();

        reports.remove(foundedReport);

        history.add(
                new HistoryEntry(
                        foundedReport.getId(),
                        foundedReport.getReportType(),
                        foundedReport.getPriority(),
                        foundedReport.generateSummary()
                )
        );
        System.out.println("Zgloszenie #" + id + " zostalo zakończone");
    }
}
