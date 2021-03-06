package app;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LibraryControl {

    private DataReader dataReader;
    private Library library;
    private FileManager fileManager;

    public LibraryControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();

        try {
            library = fileManager.readLibraryFromFile();
            System.out.println("Wczytano dane z pliku");
        } catch (ClassNotFoundException | IOException e) {
            library = new Library();
            System.out.println("Utworzono nowa baze biblioteki");
        }
    }

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
                    case DELETE_PUBLICATION:
                        deletePublication();
                        break;
                    case ADD_USER:
                        addUser();
                        break;
                    case PRINT_USERS:
                        printUsers();
                        break;
                    case DELETE_USER:
                        deleteUser();
                        break;
                    case EXIT:
                        exit();
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodano");
            } catch (NumberFormatException | NoSuchElementException e) {
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
        LibraryUtils.printBooks(library);
    }

    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }

    private void deletePublication(){
        String titlePublicationToRemove = dataReader.readAndDeletePublication();
        library.removePublication(titlePublicationToRemove);
    }

    private void addUser(){
        LibraryUser libUser = dataReader.readAndCreateLibraryUser();
        library.addUser(libUser);
    }

    private void printUsers(){
        LibraryUtils.printUsers(library);
    }

    private void deleteUser(){
        String peselUserToRemove = dataReader.readAndDeleteUser();
        library.removeUser(peselUserToRemove);
    }

    private void exit() {
        fileManager.writeLibraryToFile(library);
    }

    // typu wyliczeniowy Option jest wykorzystyway tylko w tej klasie i nikt nie musi wiedziec, ze istnieje (nie potrzebny osobny plik)
    // wiec zamienilem na prywatna klasa wewnetrzna
    public enum Option {

        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2, "Dodanie magazynu/gazety"),
        PRINT_BOOKS(3, "Wyświetlenie dostępnych książek"),
        PRINT_MAGAZINES(4, "Wyświetlenie dostępnych magazynów/gazet"),
        DELETE_PUBLICATION(5, "Kasowanie publikacji na podstawie tytulu"),
        ADD_USER(6, "Dodanie nowego uzytkownika"),
        PRINT_USERS(7, "Wyswietlanie wszystkich uzytkownikow"),
        DELETE_USER(8, "Kasowanie uzytkownika na podstawie peselu");

        private int value;
        private String description;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createOptionFromInt(int option) throws NoSuchElementException {
            Option result;
            try {
                result = Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new NoSuchElementException("Brak elementu o wskazanym ID");
            }
            return result;
        }
    }
}

