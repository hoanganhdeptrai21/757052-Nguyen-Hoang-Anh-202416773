package hust.soict.dsai.aims.media.comparator;

public class MediaComparatorByTitleCost implements java.util.Comparator<hust.soict.dsai.aims.media.Media> {
    public int compare(hust.soict.dsai.aims.media.Media media1, hust.soict.dsai.aims.media.Media media2) {
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return Float.compare(media1.getCost(), media2.getCost());
        }
    }
    
}