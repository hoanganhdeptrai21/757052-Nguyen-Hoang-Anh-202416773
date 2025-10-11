package nothing;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int count = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (count == MAX_NUMBERS_ORDERED - 1){
            System.out.println("The cart is almost full");
            return;
        }
        else{
            itemsOrdered[count] = disc;
            count += 1;
            System.out.println("The disc has been added");

        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean found = false;
        for (int index = 0; index <= count - 1; index++ ){
            if (itemsOrdered[index] == disc){
                itemsOrdered[index] = null;
                System.out.println("The disc has been removed");
                found = true;
            }
        }
        if (!found){
            System.out.println("The disc has not existed");
        }
    }
    public float totalCost(){
        float sum = 0;
        for (int i = 0; i <= count; i++){
        	if (itemsOrdered[i] != null) {
        		sum += itemsOrdered[i].getCost();
        }
        }
        return sum;
}
}

