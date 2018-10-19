package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;
import utils.LibraryUtils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LibraryControl {

    // zmienna do komunikacji z użytkownikiem
    private DataReader dataReader;

    // "biblioteka" przechowująca dane
    private Library library;
    private LibraryUtils libraryUtils;

    public LibraryControl() {
        dataReader = new DataReader();
        library = new Library();
        libraryUtils = new LibraryUtils();
    }

    /*
     * Główna pętla programu, która pozwala na wybór opcji i interakcję
     */
    public void controlLoop() {
        Option option = null;
        while (option != Option.EXIT) {
            try {
                printOptions();
                option = Option.createOptionFromInt(dataReader.getInt());
                switch (option) {
                    case ADD_BOOK:
                        addBook();
                        break;
                    case ADD_MAGAZINE:
                        addMagazine();
                        break;
                    case PRINT_BOOKS:
                        printBooks();
                        break;
                    case PRINT_MAGAZINES:
                        printMagazines();
                        break;
                    case EXIT: //nigdy nie zostanie wykonany
                }
            } catch(InputMismatchException e){
                System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodano");
            } catch(NumberFormatException | NoSuchElementException e){
                System.out.println("Wybrana opcja nie istnieje wybierz ponownie");
            }
        }
        dataReader.close();
    }

    private void printOptions() {
        for (Option o : Option.values()) {
            System.out.println(o);
        }
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printBooks() {
        libraryUtils.printBooks(library);
    }

    private void printMagazines() {
        libraryUtils.printMagazines(library);
    }
}
