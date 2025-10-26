package Package;

import java.util.*;

public class Aims {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Cart cart = new Cart();
        List<DigitalVideoDisc> cartMirror = new ArrayList<>(); 
        DigitalVideoDisc[] store = buildStore();
        while (true) {
            System.out.println("\n=== AIMS ===");
            System.out.println("1) Show first 8 DVDs");
            System.out.println("2) Search by title");
            System.out.println("3) View cart (" + cart.qtyOrdered + ")");
            System.out.println("4) Checkout");
            System.out.println("0) Quit");
            int op = readInt("Choose: ");
            if (op == 0) { System.out.println("Goodbye!"); break; }
            if (op == 1) listStore(store, cart, cartMirror);
            else if (op == 2) searchByTitle(store, cart, cartMirror);
            else if (op == 3) viewCart(cart, cartMirror);
            else if (op == 4) checkout(cart, cartMirror);
        }
    }
    static void listStore(DigitalVideoDisc[] store, Cart cart, List<DigitalVideoDisc> cartMirror) {
        for (int i = 0; i < Math.min(8, store.length); i++)
            System.out.println((i+1) + ". " + brief(store[i]));
        int idx = readInt("Pick an index to see details (0 = back): ");
        if (idx <= 0 || idx > Math.min(8, store.length)) return;
        DigitalVideoDisc d = store[idx - 1];
        System.out.println(detail(d));
        if (yes("Add to cart? (y/n): ")) {
            if (cart.qtyOrdered >= Cart.MAX_NUMBERS_ORDERED) {
                System.out.println("Cart is already full.");
                return;
            }
            cart.addDigitalVideoDisc(d);
            cartMirror.add(d);
        }
    }
    static void searchByTitle(DigitalVideoDisc[] store, Cart cart, List<DigitalVideoDisc> cartMirror) {
        System.out.print("Enter keyword: ");
        String kw = sc.nextLine().toLowerCase();
        List<DigitalVideoDisc> rs = new ArrayList<>();
        for (DigitalVideoDisc d : store)
            if (d.getTitle().toLowerCase().contains(kw)) rs.add(d);
        if (rs.isEmpty()) { System.out.println("No result."); return; }
        for (int i = 0; i < rs.size(); i++)
            System.out.println((i+1) + ". " + brief(rs.get(i)));
        int idx = readInt("Pick an index to see details (0 = back): ");
        if (idx <= 0 || idx > rs.size()) return;
        DigitalVideoDisc d = rs.get(idx - 1);
        System.out.println(detail(d));
        if (yes("Add to cart? (y/n): ")) {
            if (cart.qtyOrdered >= Cart.MAX_NUMBERS_ORDERED) {
                System.out.println("Cart is already full.");
                return;
            }
            cart.addDigitalVideoDisc(d);
            cartMirror.add(d);
        }
    }
    static void viewCart(Cart cart, List<DigitalVideoDisc> cartMirror) {
        if (cart.qtyOrdered == 0 || cartMirror.isEmpty()) { System.out.println("Your cart is empty."); return; }
        float sum = 0f;
        for (int i = 0; i < cartMirror.size(); i++) {
            DigitalVideoDisc d = cartMirror.get(i);
            System.out.println((i+1) + ". " + detail(d));
            sum += d.getCost();
        }
        System.out.println("Items: " + cart.qtyOrdered + " | Total (listed price): $" + money(sum));

        int rm = readInt("Enter index to remove (0 = skip): ");
        if (rm > 0 && rm <= cartMirror.size()) {
            DigitalVideoDisc target = cartMirror.get(rm - 1);
            cart.removeDigitalVideoDisc(target);
            cartMirror.remove(rm - 1);
        }
    }
    static void checkout(Cart cart, List<DigitalVideoDisc> cartMirror) {
        if (cart.qtyOrdered == 0) { System.out.println("Your cart is empty."); return; }
        float total = cart.totalCost(); 

        System.out.println("\n--- BILL ---");
        for (DigitalVideoDisc d : cartMirror) System.out.println("- " + detail(d));
        System.out.println("TOTAL (listed price): $" + money(total));

        if (yes("Confirm payment? (y/n): ")) {
            System.out.println("Order placed. Thank you!");
            System.exit(0);
        }
    }
    static DigitalVideoDisc[] buildStore() {
        return new DigitalVideoDisc[] {
            new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f),
            new DigitalVideoDisc("Star Wars","Sci-Fi","George Lucas",124,24.95f),
            new DigitalVideoDisc("Aladdin","Animation",18.99f),
            new DigitalVideoDisc("Inception","Sci-Fi","Christopher Nolan",148,29.99f),
            new DigitalVideoDisc("The Dark Knight","Action","Christopher Nolan",152,22.99f),
            new DigitalVideoDisc("Interstellar","Sci-Fi","Christopher Nolan",169,25.99f),
            new DigitalVideoDisc("Avatar","Sci-Fi","James Cameron",162,27.99f),
            new DigitalVideoDisc("Titanic","Romance","James Cameron",195,20.99f)
        };
    }
    static String brief(DigitalVideoDisc d) { return d.getTitle() + " - $" + money(d.getCost()); }
    static String detail(DigitalVideoDisc d) { return d.getTitle() + " | $" + money(d.getCost()); }

    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) { sc.next(); System.out.print("Enter a number: "); }
        int v = sc.nextInt(); sc.nextLine(); return v;
    }
    static boolean yes(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim().toLowerCase().startsWith("y");
    }
    static String money(float f) { return String.format("%.2f", f); }
}
