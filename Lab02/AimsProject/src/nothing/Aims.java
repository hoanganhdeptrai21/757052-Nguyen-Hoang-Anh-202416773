package nothing;

public class Aims{
    public static void main(String[] args){
        Cart anOrder = new Cart();
        DigitalVideoDisc dv1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dv1);
        DigitalVideoDisc dv2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dv2);
        DigitalVideoDisc dv3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dv3);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
} 
