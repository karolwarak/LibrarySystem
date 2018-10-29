package utils;

import data.Book;
import data.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {

    private Scanner sc;

    public DataReader() {
        sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    public int getInt() throws NumberFormatException {
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException ex) {
            throw new NumberFormatException("Liczba wprowadzona w nieprawidlowej formie");
        } finally {
            sc.nextLine();
        }
        return number;
    }

    public Book readAndCreateBook() throws InputMismatchException {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("Autor: ");
        String author = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();

        System.out.println("Ilość stron: ");
        int pages = 0;
        int releaseDate = 0;
        try {
            pages = sc.nextInt();
            sc.nextLine();
            System.out.println("Rok wydania: ");
            releaseDate = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            throw ex;
        }

        return new Book(title, publisher, releaseDate, author, pages, isbn);
    }

    public Magazine readAndCreateMagazine() throws InputMismatchException {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("Język: ");
        String language = sc.nextLine();
        int year = 0;
        int month = 0;
        int day = 0;
        try{
            System.out.println("Rok wydania: ");
            year = sc.nextInt();
            sc.nextLine();
            System.out.println("Miesiąc: ");
            month = sc.nextInt();
            sc.nextLine();
            System.out.println("Dzień: ");
            day = sc.nextInt();
            sc.nextLine();
        } catch(InputMismatchException ex) {
            sc.nextLine();
            throw ex;
        }

        return new Magazine(title, publisher, year, month, day, language);
    }

    public String readAndDeletePublication(){
        System.out.println("Podaj tytul ktory chcesz usunac z biblioteki: ");
        String title = sc.nextLine();
        return title;
    }

}


