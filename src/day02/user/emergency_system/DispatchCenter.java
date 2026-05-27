package day02.user.emergency_system;

import day02.user.emergency_system.enums.Priority;
import day02.user.emergency_system.reports.EmergencyReport;
import day02.user.emergency_system.units.EmergencyUnit;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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

            System.out.println("Brak zgłoszeń.");

            return;
        }

        reports.sort(
                Comparator.comparing(EmergencyReport::getPriority)
                        .reversed()
        );

        for (EmergencyReport report : reports) {

            if (report.getAssignedUnit() != null) {
                continue;
            }

            Optional<EmergencyUnit> foundUnit = units.stream()

                    .filter(EmergencyUnit::isAvailable)

                    .filter(unit ->
                            unit.getUnitType()
                                    .equals(report.getRequiredUnitType())
                    )

                    .findFirst();

            if (foundUnit.isPresent()) {

                foundUnit.get().dispatchTo(report);
            }
            else {

                System.out.println(
                        "Brak wolnej jednostki dla zgłoszenia #"
                                + report.getId()
                );
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
                        foundedReport.getCreatedAt(),
                        LocalDateTime.now(),
                        foundedReport.generateSummary()
                )
        );
        System.out.println("Zgloszenie #" + id + " zostalo zakończone");
    }

    public void showReportsByPriority(Priority priority) {

        boolean found = false;

        System.out.println("\nZgłoszenia o priorytecie: " + priority);

        for (EmergencyReport report : reports) {
            if (report.getPriority() == priority) {
                System.out.println(report.generateSummary());
                found = true;
            }
        }
        if(!found) {
            System.out.println("Brak zgłoszeń o takim priorytecie");
        }
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Historia jest pusta");
            return;
        }

        System.out.println("\nHistoria:");

        for (HistoryEntry entry : history) {
            entry.print();

            System.out.println("----------");
        }
    }

    public void showTodayReports() {
        LocalDateTime now = LocalDateTime.now();

        boolean founded = false;

        System.out.println("\nDzisiejsze aktywne zgłoszenia");

        for (EmergencyReport report : reports) {
            if (report.getCreatedAt().toLocalDate().equals(now.toLocalDate())) {
                System.out.println(report.generateSummary());
                founded = true;
            }
        }
        if (!founded) {
            System.out.println("Brak dzisejszych aktywnych zgłoszeń");
        }
    }

    public void saveHistoryToCsvFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("historia_zgłoszeń.csv"));

            writer.println("id;typ;priorytet;data_zgłoszenia;data_zakończenia;czas_obsługi_zgłoszenia_minuty;podsumowanie");

            for (HistoryEntry entry : history) {
                writer.println(entry.toCsvFormat());
            }


        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu pliku csv: " + e.getMessage());
        }
    }
}
