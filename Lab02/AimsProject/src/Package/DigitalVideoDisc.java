package Package;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
    public DigitalVideoDisc(String title){
    super();
    this.title = title;
    nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;

    }
    public DigitalVideoDisc(String category, String title, float cost){
    this.title = title;
    this.category = category;
    this.cost = cost;
    nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;

    }
    public DigitalVideoDisc(String director,String category, String title, float cost){
    this.title = title;
    this.category = category;
    this.cost = cost;
    this.director = director;
    nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;

    }
    public DigitalVideoDisc(String title,String category, String director, int length, float cost){
    this.title = title;
    this.category = category;
    this.cost = cost;
    this.director = director;
    this.length = length;
    nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;

}
    public void setTitle(String title) {
        this.title = title;
    }
    public String toString() {
        String safeTitle = (title == null ? "" : title);
        String safeCategory = (category == null ? "" : category);
        String safeDirector = (director == null ? "" : director);
        String len = (length > 0 ? String.valueOf(length) : "");
        return String.format("DVD - %s - %s - %s - %s: %.2f $",
                safeTitle, safeCategory, safeDirector, len, cost);
    }
    public boolean isMatch(String query) {
        if (query == null || query.isBlank() || this.title == null) return false;
        String t = this.title.toLowerCase();
        for (String word : query.toLowerCase().trim().split("\\s+")) {
            if (!t.contains(word)) return false;
        }
        return true;
    }
    public String getAllInfor() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + "$" + cost;
    }
}
