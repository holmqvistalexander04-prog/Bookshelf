import java.util.Scanner;

/**
 * Starta den här filen i IntelliJ (gröna triangeln vid main).
 * Programmet använder en enkel textmeny.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bookshelf bookshelf = new Bookshelf();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Välkommen till Bokhyllan!");

        while (running) {
            printMenu();

            int choice = readInteger("Ditt val: ");

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    bookshelf.printContents();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    running = false;
                    System.out.println("Hej då!");
                    break;

                default:
                    System.out.println("Välj en siffra mellan 1 och 5.");
            }
        }

        scanner.close();
    }

    /** Läser ett heltal utan att krascha om användaren skriver text. */
    private static int readInteger(String question) {
        System.out.print(question);
        String input = Main.scanner.nextLine();
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /** Kräver ett svar som inte bara är tom text. */
    private static String readNonEmpty(String question) {
        while (true) {
            System.out.print(question);
            String answer = Main.scanner.nextLine().trim();
            if (!answer.isEmpty()) {
                return answer;
            }
            System.out.println("Du måste skriva något. Försök igen.");
        }
    }

    private static void printMenu(){
        System.out.println("\n=== MENY ===");
        System.out.println("1. Sätt in en bok");
        System.out.println("2. Ta ut en bok");
        System.out.println("3. Visa bokhyllan");
        System.out.println("4. Sök bok med ISBN");
        System.out.println("5. Avsluta");
    }

    private static void addBook(){
        if (bookshelf.countBooks() == bookshelf.getCapacity()) {
            System.out.println("Bokhyllan är full! Du kan inte lägga till fler böcker.");
            return;
        }
        String isbn = readNonEmpty("ISBN: ");
        String title = readNonEmpty("Titel: ");
        String author = readNonEmpty("Författare: ");
        Book newBook = new Book(isbn, title, author);

        if (bookshelf.addBook(newBook)) {
            System.out.println("Boken har lagts i bokhyllan!");
        } else {
            System.out.println("Bokhyllan är full!");
        }

    }

    private static void removeBook(){
        bookshelf.printContents();
        int place = readInteger("Vilken plats (1-10) vill du tömma? ");
        if (place < 1 || place > bookshelf.getCapacity()) {
            System.out.println("Ogiltig plats. Välj mellan 1 och 10.");
            return;
        }

        Book removedBook = bookshelf.removeBook(place);
        if (removedBook == null) {
            System.out.println("Den platsen är redan tom.");
        } else {
            System.out.println("Du tog ut: " + removedBook);
            System.out.println("Plats " + place + " är nu ledig (null).");
        }
    }

    private static void searchBook(){
        String searchIsbn = readNonEmpty("Vilket ISBN söker du? ");
        Book foundBook = bookshelf.findBookByIsbn(searchIsbn);
        if (foundBook == null) {
            System.out.println("Ingen bok med det ISBN-numret finns på hyllan.");
        } else {
            // Exempel på hur man läser data genom getters.
            System.out.println("Hittad bok!");
            System.out.println("ISBN: " + foundBook.getIsbn());
            System.out.println("Titel: " + foundBook.getTitle());
            System.out.println("Författare: " + foundBook.getAuthor());
        }
    }
}
