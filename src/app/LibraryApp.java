package app;

public class LibraryApp {
    public static final String APP_NAME = "Biblioteka";


    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop();
    }

}
