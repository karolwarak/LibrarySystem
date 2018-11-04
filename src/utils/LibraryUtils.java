package utils;

import data.*;

import java.util.Collection;

public class LibraryUtils {


    public static void printBooks(Library library) {
        Collection<Publication> publications = library.getPublications().values();
        int countBooks = 0;
        for (Publication p : publications) {
            if(p instanceof Book){
                System.out.println(p);
                countBooks++;
            }
        }

        if (countBooks == 0) {
            System.out.println("Brak ksiazek w bibliotece");
        }
    }

    public static void printMagazines(Library library) {
        Collection<Publication> publications = library.getPublications().values();
        int countMagazines = 0;
        for (Publication p : publications) {
            if (p instanceof Magazine) {
                System.out.println(p);
                countMagazines++;
            }
        }
        if (countMagazines == 0) {
            System.out.println("Brak magazynow w bibliotece");
        }
    }

    public static void printUsers(Library lib){
        Collection<LibraryUser> users = lib.getUsers().values();
        for(LibraryUser u : users){
            System.out.println(u);
        }
    }
}
