package Java_Day9.LibraryManagementSystem.Modules;

public class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;
    public Book(String bookId, String title, String author, boolean isIssued) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.isIssued = isIssued;
}
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
    @Override
    public String toString() {
        return title + " by " + author + " (ID: " + bookId + ")";
    }
}

