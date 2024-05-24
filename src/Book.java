public class Book {
    private String title;
    private String author;
    private int year;
    private String genre;
    private String description;
    private String shelfNumber;
    private String cabinet;
    private boolean isPhysical; // Nowe pole

    public Book(String title, String author, int year, String genre, String description, String shelfNumber, String cabinet, boolean isPhysical) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.description = description;
        this.shelfNumber = shelfNumber;
        this.cabinet = cabinet;
        this.isPhysical = isPhysical; // Inicjalizacja nowego pola
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public String getCabinet() {
        return cabinet;
    }

    public boolean isPhysical() {
        return isPhysical;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ") - " + genre;
    }

    public String getDetails() {
        return "Tytuł: " + title + "\n" +
               "Autor: " + author + "\n" +
               "Rok wydania: " + year + "\n" +
               "Gatunek: " + genre + "\n" +
               "Opis: " + description + "\n" +
               "Szafa: " + cabinet + "\n" +
               "Numer półki: " + shelfNumber + "\n" +
               "Dostępność: " + (isPhysical ? "Fizyczna" : "Online");
    }
}
