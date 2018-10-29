package data;

import java.util.Objects;

public class Book extends Publication {

    private static final long serialVersionUID = -5454594695218875306L;
    private String author;
    private int pages;
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String title, String publisher, int year, String author, int pages, String isbn) {
        super(title, publisher, year);
        this.setAuthor(author);
        this.setPages(pages);
        this.setIsbn(isbn);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);

        print.append(super.toString());

        print.append(getAuthor());
        print.append("; ");
        print.append(getPages());
        print.append("; ");
        print.append(getIsbn());
        print.append("; ");

        return print.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, isbn);
    }
}