import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
        // Ładowanie danych początkowych
        loadExampleData();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> searchBooks(String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return books.stream()
                .filter(book -> pattern.matcher(book.toString()).find())
                .collect(Collectors.toList());
    }

    public void sortBooksByTitle() {
        books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    public void sortBooksByAuthor() {
        books.sort((b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()));
    }

    public void sortBooksByYear() {
        books.sort((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear()));
    }

    public void sortBooksByGenre() {
        books.sort((b1, b2) -> b1.getGenre().compareToIgnoreCase(b2.getGenre()));
    }

    private void loadExampleData() {
        books.add(new Book("Wielki Gatsby", "F. Scott Fitzgerald", 1925, "Fikcja", "Powieść o bogactwie i nieszczęściu.", "1", "A", true));
        books.add(new Book("Zabić drozda", "Harper Lee", 1960, "Fikcja", "Historia o rasizmie i niesprawiedliwości.", "2", "B", true));
        books.add(new Book("Rok 1984", "George Orwell", 1949, "Fikcja", "Dystopijna powieść o totalitarnym reżimie.", "3", "C", false));
        books.add(new Book("Mistrz i Małgorzata", "Michaił Bułhakow", 1967, "Fikcja", "Opowieść o miłości, polityce i religii.", "4", "A", true));
        books.add(new Book("Duma i uprzedzenie", "Jane Austen", 1813, "Romans", "Klasyczna powieść o miłości i społeczeństwie.", "5", "B", true));
        books.add(new Book("Przeminęło z wiatrem", "Margaret Mitchell", 1936, "Romans", "Epicka opowieść o wojnie i miłości.", "6", "C", true));
        books.add(new Book("Hobbit", "J.R.R. Tolkien", 1937, "Fantasy", "Przygoda Bilba Bagginsa w Śródziemiu.", "7", "A", true));
        books.add(new Book("Władca Pierścieni", "J.R.R. Tolkien", 1954, "Fantasy", "Epicka saga o walce dobra ze złem.", "8", "B", false));
        books.add(new Book("Harry Potter i Kamień Filozoficzny", "J.K. Rowling", 1997, "Fantasy", "Początek przygód młodego czarodzieja.", "9", "C", true));
        books.add(new Book("Kod Leonarda da Vinci", "Dan Brown", 2003, "Thriller", "Thriller o tajemnicach Kościoła i historii sztuki.", "10", "A", true));
        books.add(new Book("Inferno", "Dan Brown", 2013, "Thriller", "Kolejna przygoda Roberta Langdona inspirowana Dantem.", "11", "B", false));
        books.add(new Book("Ojciec chrzestny", "Mario Puzo", 1969, "Kryminał", "Powieść o mafii i władzy.", "12", "C", true));
        books.add(new Book("Sherlock Holmes", "Arthur Conan Doyle", 1887, "Kryminał", "Przygody najsłynniejszego detektywa świata.", "13", "A", true));
        books.add(new Book("Zbrodnia i kara", "Fiodor Dostojewski", 1866, "Kryminał", "Powieść o moralnych dylematach.", "14", "B", true));
        books.add(new Book("Bracia Karamazow", "Fiodor Dostojewski", 1880, "Kryminał", "Głębokie rozważania o wierze i etyce.", "15", "C", true));
        books.add(new Book("Lolita", "Vladimir Nabokov", 1955, "Kontrowersja", "Kontrowersyjna powieść o obsesji.", "16", "A", false));
        books.add(new Book("Mechaniczna pomarańcza", "Anthony Burgess", 1962, "Kontrowersja", "Dystopijna opowieść o przemocy.", "17", "B", true));
        books.add(new Book("Paragraf 22", "Joseph Heller", 1961, "Fikcja", "Satyra na wojnę i biurokrację.", "18", "C", true));
        books.add(new Book("Buszujący w zbożu", "J.D. Salinger", 1951, "Fikcja", "Historia o buncie i dojrzewaniu.", "19", "A", true));
        books.add(new Book("Mały Książę", "Antoine de Saint-Exupéry", 1943, "Dziecięca", "Klasyczna opowieść filozoficzna.", "20", "B", true));
        books.add(new Book("Król Lew", "Disney", 1994, "Dziecięca", "Opowieść o dorastaniu i odpowiedzialności.", "21", "C", true));
        books.add(new Book("Opowieści z Narnii", "C.S. Lewis", 1950, "Fantasy", "Fantastyczna saga o świecie Narnii.", "22", "A", false));
        books.add(new Book("Alchemik", "Paulo Coelho", 1988, "Fikcja", "Opowieść o poszukiwaniu swojego przeznaczenia.", "23", "B", true));
        books.add(new Book("Mężczyźni, którzy nienawidzą kobiet", "Stieg Larsson", 2005, "Kryminał", "Thriller o dziennikarzu i hakerce.", "24", "C", true));
        books.add(new Book("Dziewczyna z tatuażem", "David Lagercrantz", 2015, "Kryminał", "Kontynuacja serii Millennium.", "25", "A", true));
    }
}
