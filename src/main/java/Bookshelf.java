/**
 * Bokhyllan innehåller en ARRAY med exakt 10 platser.
 * En ledig plats innehåller null.
 */
public class Bookshelf {
    private static final int MAX_BOOKS = 10;
    private final Book[] books = new Book[MAX_BOOKS];

    /**
     * Lägger boken på den första lediga platsen.
     * Returnerar false om hyllan är full (i stället för att krascha).
     */
    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return true;
            }
        }
        return false;
    }

    /**
     * Tar ut boken på ett platsnummer från 1 till 10.
     * Returnerar null om platsen är tom eller numret är felaktigt.
     */
    public Book removeBook(int placeNumber) {
        if (placeNumber < 1 || placeNumber > books.length) {
            return null;
        }

        int index = placeNumber - 1; // Användaren räknar 1-10, arrayen 0-9.
        Book removedBook = books[index];
        books[index] = null;         // Kravet i uppgiften: en uttagen bok lämnar null.
        return removedBook;
    }

    /** Söker efter en bok med visst ISBN. */
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book != null && book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // Hittade ingen bok.
    }

    /** Räknar antal upptagna platser. */
    public int countBooks() {
        int count = 0;
        for (Book book : books) {
            if (book != null) {
                count++;
            }
        }
        return count;
    }
    /** Returnerar hur många platser hyllan har*/
    public int getCapacity() {
        return books.length;
    }

    /** Visar ALLA tio platser, även dem som är tomma. */
    public void printContents() {
        System.out.println("\n--- Bokhyllan (" + countBooks() + "/" + books.length + " böcker) ---");
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                System.out.println((i + 1) + ". [ledig plats]");
            } else {
                System.out.println((i + 1) + ". " + books[i]);
            }
        }
    }
}
