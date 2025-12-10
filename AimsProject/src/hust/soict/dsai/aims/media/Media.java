package hust.soict.dsai.aims.media;

import java.util.Objects;

public abstract class Media {

    private static int nbMedia = 0;

    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media() {
        nbMedia++;
        this.id = nbMedia;
    }

    public Media(String title) {
        this();
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return Objects.equals(this.title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %.2f$",
                getClass().getSimpleName(), title, category, cost);
    }
}
