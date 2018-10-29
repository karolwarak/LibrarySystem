package data;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {

    public static final int INITIAL_CAPACITY = 1;
    private static final long serialVersionUID = 1464414436577384323L;
    private Publication[] publications;
    private int publicationsNumber;

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public Publication[] getPublications() {
        return publications;
    }

    public Library() {
        publications = new Publication[INITIAL_CAPACITY];
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    public void removePublication(String title) {
        if (title == null) {
            return;
        }

        final int NOT_FOUND = -1;
        int find = NOT_FOUND;
        int i = 0;
        while (i < publications.length && find == NOT_FOUND) {
            if (title.equals(publications[i].getTitle())) {
                find = i;
            } else {
                i++;
            }
        }
        if (find != NOT_FOUND) {
            System.arraycopy(publications, find + 1, publications, find, publications.length - find - 1);
            publicationsNumber--;
        }
    }

    private void addPublication(Publication publication) {
        if (publicationsNumber == publications.length) {
            publications = Arrays.copyOf(publications, publications.length * 2);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < publicationsNumber; i++) {
            builder.append(publications[i]);
            builder.append("\n");
        }
        return builder.toString();
    }
}
