package day02.user.emergency_system;

import day02.user.emergency_system.enums.Priority;

import java.time.Duration;
import java.time.LocalDateTime;

public record HistoryEntry(
        int reportId,
        String reportType,
        Priority priority,

        LocalDateTime createdAt,
        LocalDateTime finishedAt,
        String summary
) {

    public void print() {
        System.out.println("Historia zgłoszenia #" + reportId);
        System.out.println("Typ " + reportType);
        System.out.println("Priorytet:  " + priority);

        System.out.println("Data zgłoszenia: " + createdAt);
        System.out.println("Data zakończenia: " + finishedAt);
        System.out.println("Czas obsługi zgłoszenia: " + getDurationInMinutes() + " minut.");

        System.out.println(summary);
    }

    public long getDurationInMinutes() {
        return Duration.between(createdAt, finishedAt).toMinutes();
    }

    public String toCsvFormat() {
        return reportId + ";" +
                reportType + ";" +
                priority + ";" +
                createdAt + ";" +
                finishedAt + ";" +
                getDurationInMinutes() + ";" +
                summary.replace(";", ",");
    }
}
