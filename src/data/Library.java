package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

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

    public static class AlphabeticalComparator implements Comparator<Publication> {

        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class DateComparator implements Comparator<Publication> {
        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            Integer i1 = o1.getYear();
            Integer i2 = o2.getYear();
            // - (minus) change sort from the biggest to the smallest number
            return -i1.compareTo(i2);
        }
    }
}
