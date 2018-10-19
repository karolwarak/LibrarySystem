package data;

public class Library {

    public static final int MAX_PUBLICATIONS = 2000;
    private Publication[] publications;
    private int publicationsNumber;

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public Publication[] getPublications() {
        return publications;
    }

    public Library() {
        publications = new Publication[MAX_PUBLICATIONS];
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    private void addPublication(Publication publication) {
        if (publicationsNumber == MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("You reach max of publication which is = " + MAX_PUBLICATIONS);
        }
            publications[publicationsNumber] = publication;
            publicationsNumber++;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<publicationsNumber; i++){
            builder.append(publications[i]);
            builder.append("\n");
        }
        return builder.toString();
    }
}
