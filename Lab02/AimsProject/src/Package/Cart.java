package Package;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println( disc.getTitle() + " has been added to cart.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("Cart is full.");
            }
            else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 5) {
                System.out.println("Cart is almost full.");
            }
        } else {
            System.out.println("Cart is already full.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] discList) {
        for (DigitalVideoDisc disc : discList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered ++;
                System.out.println( disc.getTitle() + " has been added to cart.");
                if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                    System.out.println("Cart is full.");
                    break;
                }
                else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 5) {
                    System.out.println("Cart is almost full.");
                }
            } else {
                System.out.println("Cart is already full. Cannot add '" + disc.getTitle() + "'.");
                break;
            }
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    boolean found = false;
    for (int index = 0; index < count; index++) {
        if (itemsOrdered[index] != null &&
            itemsOrdered[index].getTitle().equalsIgnoreCase(disc.getTitle())) {
            for (int j = index + 1; j < count; j++) {
                itemsOrdered[j - 1] = itemsOrdered[j];
            }
            itemsOrdered[--count] = null;
            System.out.println("The disc has been removed");
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("The disc has not existed");
    }
}
    public float totalCost(){
        float sum = 0;
        for (int i = 0; i < count; i++){
        	if (itemsOrdered[i] != null) {
        		sum += itemsOrdered[i].getCost();
        }
        }
        return sum;
}
}
