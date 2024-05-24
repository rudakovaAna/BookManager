import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main extends JFrame {
    private BookManager bookManager;
    private JTable bookTable;
    private DefaultTableModel tableModel;

    public Main() {
        bookManager = new BookManager();
        setTitle("Zarządzanie książkami");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        updateTable();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        // Tabela główna
        tableModel = new DefaultTableModel(new Object[]{"Tytuł", "Autor", "Rok", "Gatunek", "Szafa", "Numer Półki", "Dostępność"}, 0);
        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Przyciski
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        JButton addButton = new JButton("Dodaj książkę");
        JButton removeButton = new JButton("Usuń książkę");
        JButton searchButton = new JButton("Szukaj książki");
        JButton sortButton = new JButton("Sortuj książki");
        JButton detailsButton = new JButton("Wyświetl informacje");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(detailsButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Dodaj ksiązkę
        addButton.addActionListener(e -> addBook());

        // Usuń ksiązkę
        removeButton.addActionListener(e -> removeBook());

        // Szukaj 
        searchButton.addActionListener(e -> searchBooks());

        // Sortuj
        sortButton.addActionListener(e -> sortBooks());

        // Wyświetl info o ksiązce (select)
        detailsButton.addActionListener(e -> displayDetails());

        add(panel);
    }

    private void addBook() {
        String title = JOptionPane.showInputDialog(this, "Podaj tytuł książki:");
        String author = JOptionPane.showInputDialog(this, "Podaj autora książki:");
        int year = Integer.parseInt(JOptionPane.showInputDialog(this, "Podaj rok wydania książki:"));
        String genre = JOptionPane.showInputDialog(this, "Podaj gatunek książki:");
        String description = JOptionPane.showInputDialog(this, "Podaj opis książki:");
        boolean isPhysical = JOptionPane.showConfirmDialog(this, "Czy książka jest fizycznie dostępna?", "Dostępność", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        String shelfNumber = "";
        String cabinet = "";
        if (isPhysical) {
            shelfNumber = JOptionPane.showInputDialog(this, "Podaj numer półki:");
            cabinet = JOptionPane.showInputDialog(this, "Podaj szafę:");
        }

        Book book = new Book(title, author, year, genre, description, shelfNumber, cabinet, isPhysical);
        bookManager.addBook(book);
        updateTable();
    }

    private void removeBook() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow >= 0) {
            Book book = bookManager.getBooks().get(selectedRow);
            bookManager.removeBook(book);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Wybierz książkę do usunięcia.");
        }
    }

    private void searchBooks() {
        String regex = JOptionPane.showInputDialog(this, "Podaj wyrażenie regularne do wyszukiwania:");
        var result = bookManager.searchBooks(regex);
        updateTable(result);
    }

    private void sortBooks() {
        String[] options = {"Tytuł", "Autor", "Rok", "Gatunek"};
        int choice = JOptionPane.showOptionDialog(this, "Wybierz kryterium sortowania:",
                "Sortowanie książek", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        switch (choice) {
            case 0 -> bookManager.sortBooksByTitle();
            case 1 -> bookManager.sortBooksByAuthor();
            case 2 -> bookManager.sortBooksByYear();
            case 3 -> bookManager.sortBooksByGenre();
        }
        updateTable();
    }

    private void displayDetails() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow >= 0) {
            Book book = bookManager.getBooks().get(selectedRow);
            JOptionPane.showMessageDialog(this, book.getDetails(), "Szczegóły książki", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Wybierz książkę, aby wyświetlić szczegóły.");
        }
    }

    private void updateTable() {
        updateTable(bookManager.getBooks());
    }

    private void updateTable(java.util.List<Book> books) {
        tableModel.setRowCount(0);
        for (Book book : books) {
            String shelfNumber = book.isPhysical() ? book.getShelfNumber() : "";
            String cabinet = book.isPhysical() ? book.getCabinet() : "";
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre(), cabinet, shelfNumber, book.isPhysical() ? "Fizyczna" : "Online"});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}
