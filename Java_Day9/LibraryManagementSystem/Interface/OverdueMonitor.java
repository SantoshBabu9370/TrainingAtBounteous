package Java_Day9.LibraryManagementSystem.Interface;

import Java_Day9.LibraryManagementSystem.Modules.LendingRecord;
public class OverdueMonitor extends Thread {
    private LibraryService libraryService;

    public OverdueMonitor(LibraryService service) {
        this.libraryService = service;
    }

    @Override
    public void run() {
        while (true) {
            List<LendingRecord> overdue = libraryService.getOverdueRecords();
            for (LendingRecord record : overdue) {
                System.out.println("Overdue: " + record.getBook() + " borrowed by " + record.getMember().getName());
            }
            try {
                Thread.sleep(60000); // 1 minute
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

