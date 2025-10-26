package Package;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int count = 0;
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (count == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
            return;
        }
        else{
            itemsOrdered[count] = disc;
            count += 1;
            System.out.println("The disc has been added");
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
    public void printCart() {
        System.out.println("***********************CART***********************\n Ordered Items:\n");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getAllInfor());
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("**************************************************");
    }

}
