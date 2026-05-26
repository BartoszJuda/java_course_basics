package day02.user.emergency_system;

import day02.user.emergency_system.enums.Priority;

public record HistoryEntry(
        int reportId,
        String reportType,
        Priority priority,
        String summary
) {

    public void println() {
        System.out.println("Historia zgłoszenia #" + reportId);
        System.out.println("Typ " + reportType);
        System.out.println("Priorytet:  " + priority);

        System.out.println(summary);
    }
}
