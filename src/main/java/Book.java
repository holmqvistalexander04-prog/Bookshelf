/**
 * Representerar EN bok.
 * Fälten är privata så att andra klasser inte kan ändra dem direkt.
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;

    public Book(String isbn, String title, String author) {
        if (isbn == null || isbn.isBlank()
                || title == null || title.isBlank()
                || author == null || author.isBlank()) {
            throw new IllegalArgumentException("ISBN, titel och författare får inte vara tomma.");
        }

        this.isbn = isbn.trim();
        this.title = title.trim();
        this.author = author.trim();
    }

    // Getters: vi kan LÄSA informationen, men inte ändra fälten direkt.
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Används automatiskt om vi skriver ut ett Book-objekt.
    @Override
    public String toString() {
        return "\"" + title + "\" av " + author + " (ISBN: " + isbn + ")";
    }
}
