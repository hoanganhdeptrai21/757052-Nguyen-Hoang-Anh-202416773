package Package;
import java.util.Scanner;
public class Aims {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        Cart aChange = new Cart();
        while(choose != 4){
            System.out.println("----MENU----");
            System.out.println("Choose a number");
            System.out.println("1. Add a cart");
            System.out.println("2. Remove a cart");
            System.out.println("3. Calculate total cost");
            System.out.println("4. Exit");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    System.out.println("What do you want to add: ");
                    System.out.println("1. Add only title");
                    System.out.println("2. Add category,title and cost");
                    System.out.println("3. Add director, category, title and cost");
                    System.out.println("4. Add title, category, director, length and cost");
                    int chose = sc.nextInt();
                    sc.nextLine();
                    switch(chose){
                        case 1:
                            System.out.println("Write title");
                            String title = sc.nextLine();
                            DigitalVideoDisc dv1 = new DigitalVideoDisc(title);
                            aChange.addDigitalVideoDisc(dv1);
                            break;

                        case 2:
                            System.out.println("Write category");
                            String category = sc.nextLine();
                            System.out.println("Write title");
                            String title2 = sc.nextLine();
                            System.out.println("Write cost");
                            float cost = sc.nextFloat();
                            sc.nextLine();
                            DigitalVideoDisc dv2 = new DigitalVideoDisc(category, title2, cost);
                            aChange.addDigitalVideoDisc(dv2);
                            break;

                        case 3:
                            System.out.println("Write director");
                            String director = sc.nextLine();
                            System.out.println("Write category");
                            String category2 = sc.nextLine();
                            System.out.println("Write title");
                            String title3 = sc.nextLine();
                            System.out.println("Write cost");
                            float cost2 = sc.nextFloat();
                            sc.nextLine();
                            DigitalVideoDisc dv3 = new DigitalVideoDisc(director, category2, title3, cost2);
                            aChange.addDigitalVideoDisc(dv3);
                            break;

                        case 4:
                            System.out.println("Write title");
                            String title4 = sc.nextLine();
                            System.out.println("Write category");
                            String category3 = sc.nextLine();
                            System.out.println("Write director");
                            String director2 = sc.nextLine();
                            System.out.println("Write length");
                            int length = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Write cost");
                            float cost3 = sc.nextFloat();
                            sc.nextLine();
                            DigitalVideoDisc dv4 = new DigitalVideoDisc(title4, category3, director2, length, cost3);
                            aChange.addDigitalVideoDisc(dv4);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("What do you want to remove: ");
                    System.out.println("1. Remove by title");
                    System.out.println("2. Remove by category,title and cost");
                    System.out.println("3. Remove by director, category, title and cost");
                    System.out.println("4. Remove by title, category, director, length and cost");
                    int chse = sc.nextInt();
                    sc.nextLine();
                    switch(chse){
                        case 1:
                            System.out.println("Write title");
                            String title = sc.nextLine();
                            DigitalVideoDisc dv1 = new DigitalVideoDisc(title);
                            aChange.removeDigitalVideoDisc(dv1);
                            break;
                        case 2:
                            System.out.println("Write category");
                            String category = sc.nextLine();
                            System.out.println("Write title");
                            String title2 = sc.nextLine();
                            System.out.println("Write cost");
                            float cost = sc.nextFloat();
                            sc.nextLine();
                            DigitalVideoDisc dv2 = new DigitalVideoDisc(category, title2, cost);
                            aChange.removeDigitalVideoDisc(dv2);
                            break;
                        case 3:
                            System.out.println("Write director");
                            String director = sc.nextLine();
                            System.out.println("Write category");
                            String category2 = sc.nextLine();
                            System.out.println("Write title");
                            String title3 = sc.nextLine();
                            System.out.println("Write cost");
                            float cost2 = sc.nextFloat();
                            sc.nextLine();
                            DigitalVideoDisc dv3 = new DigitalVideoDisc(director, category2, title3, cost2);
                            aChange.removeDigitalVideoDisc(dv3);
                            break;
                        case 4:
                            System.out.println("Write title");
                            String title4 = sc.nextLine();
                            System.out.println("Write category");
                            String category3 = sc.nextLine();
                            System.out.println("Write director");
                            String director2 = sc.nextLine();
                            System.out.println("Write length");
                            int length = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Write cost");
                            float cost3 = sc.nextFloat();
                            sc.nextLine();
                            DigitalVideoDisc dv4 = new DigitalVideoDisc(title4, category3, director2, length, cost3);
                            aChange.removeDigitalVideoDisc(dv4);
                            break;
                    }
                    break;
                case 3: 
                    System.out.println("Total cost: ");
                    System.out.println(aChange.totalCost());
                    break;
            }}
        }

    }
