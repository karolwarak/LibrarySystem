package utils;

import data.*;

import java.util.*;

public class LibraryUtils {


    public static void printBooks(Library library) {
        long countBooks = library.getPublications().values().stream()
                .filter(Book.class::isInstance)
                .sorted(new Library.AlphabeticalComparator())
                .peek(System.out::println)
                .count();

        if (countBooks == 0) {
            System.out.println("Brak ksiazek w bibliotece");
        }
    }

    public static void printMagazines(Library library) {
        long countMagazines = library.getPublications().values().stream()
                .filter(Magazine.class::isInstance)
                .sorted(new Library.AlphabeticalComparator())
                .peek(System.out::println)
                .count();

        if (countMagazines == 0) {
            System.out.println("Brak magazynow w bibliotece");
        }
    }

    public static void printUsers(Library library){
       library.getUsers().values().stream()
               .sorted((a, b) -> a.getLastName().compareTo(b.getLastName()))
               .forEach(System.out::println);
    }
}
