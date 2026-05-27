package day03.messaging;

import day03.messaging.dao.NoteDao;
import day03.messaging.i18n.Messages;
import day03.messaging.model.Note;
import day03.messaging.repository.CrudRepository;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class NotesApp {

    private final Scanner scanner = new Scanner(System.in);

    private final NoteDao noteDao = new NoteDao();

    private final CrudRepository<Note, Integer> noteRepository = noteDao;

    private final Messages messages;

    public NotesApp(Locale locale) {
        this.messages = new Messages(locale);
    }

    public void start() {
        try {
            noteDao.createTable();
        } catch (Exception e) {
            System.out.println(messages.get("msg.error") + e.getMessage());
        }

        boolean running = true;

        while (running) {
            showMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addNote();
                    case 2 -> showAllNotes();
                    case 3 -> showNoteById();
                    case 4 -> updateNote();
                    case 5 -> deleteNote();
                    case  0 -> running = false;
                    default -> System.out.println(messages.get("msg.unknown"));
                }
            } catch (NumberFormatException e) {
                System.out.println(messages.get("msg.number"));
            } catch (Exception e) {
                System.out.println(messages.get("msg.error") + e.getMessage());
            }
        }

        System.out.println(messages.get("msg.end"));
    }

    private void showMenu() {
        System.out.println();
        System.out.println(messages.get("app.title"));
        System.out.println(messages.get("menu.add"));
        System.out.println(messages.get("menu.showAll"));
        System.out.println(messages.get("menu.showById"));
        System.out.println(messages.get("menu.update"));
        System.out.println(messages.get("menu.delete"));
        System.out.println(messages.get("menu.exit"));
        System.out.print(messages.get("menu.choice"));
    }

    private void addNote() throws Exception {
        System.out.println(messages.get("note.title"));
        String title = scanner.nextLine();

        System.out.println(messages.get("note.content"));
        String content = scanner.nextLine();

        Note note = new Note(title, content);

        noteRepository.add(note);
        System.out.println(messages.get("msg.added"));
    }

    private void showAllNotes() throws Exception {
        List<Note> notes = noteRepository.findAll();

        if (notes.isEmpty()) {
            System.out.println(messages.get("msg.empty"));
            return;
        }

        for (Note n : notes) {
            System.out.println("-----------");
            System.out.println(n);
        }
    }

    private void showNoteById() throws Exception {
        int id = readInt(messages.get("note.id"));

        Note note = noteRepository.findById(id);

        System.out.println(note);
    }

    private void updateNote() throws Exception {

        int id = readInt(messages.get("note.id"));

        System.out.println(messages.get("note.newTitle"));
        String title = scanner.nextLine();

        System.out.println(messages.get("note.newContent"));
        String content = scanner.nextLine();

        Note updatedNote = new Note(title, content);

        noteRepository.update(id, updatedNote);

        System.out.println(messages.get("msg.updated"));

    }

    private void deleteNote() throws Exception {

        int id = readInt(messages.get("note.id"));

        noteRepository.delete(id);

        System.out.println(messages.get("msg.deleted"));
    }

    private int readInt(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}
