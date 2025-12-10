package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String author) {
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }

    public void removeAuthor(String author) {
        authors.remove(author);
    }

    @Override
    public String toString() {
        return super.toString() + " - " + authors;
    }
}
