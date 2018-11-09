package utils;

import data.*;

import java.util.*;

public class LibraryUtils {


    public static void printBooks(Library library) {
        List<Publication> publications = new ArrayList<>();
        publications.addAll(library.getPublications().values());
        Collections.sort(publications, new Library.AlphabeticalComparator());
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
        List<Publication> publications = new ArrayList<>();
        publications.addAll(library.getPublications().values());
        Collections.sort(publications, new Library.AlphabeticalComparator());
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

    public static void printUsers(Library library){
        List<LibraryUser> users = new ArrayList<>();
        users.addAll(library.getUsers().values());
        Collections.sort(users, new Comparator<LibraryUser>(){
            public int compare(LibraryUser o1, LibraryUser o2){
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        for(LibraryUser u : users){
            System.out.println(u);
        }
    }
}
