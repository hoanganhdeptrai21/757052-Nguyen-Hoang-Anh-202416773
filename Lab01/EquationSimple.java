import java.util.Scanner;

public class EquationSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. ax+b=0\n2. he 2 an\n3. ax^2+bx+c=0\n");
            int c = sc.nextInt();
            switch (c) {
                case 1: {
                    double a = sc.nextDouble(), b = sc.nextDouble();
                    if (a == 0) System.out.println(b == 0 ? "vo so nghiem" : "vo nghiem");
                    else System.out.println("x = " + (-b / a));
                    break;
                }
                case 2: {
                    double a11 = sc.nextDouble(), a12 = sc.nextDouble(), b1 = sc.nextDouble();
                    double a21 = sc.nextDouble(), a22 = sc.nextDouble(), b2 = sc.nextDouble();
                    double D = a11 * a22 - a12 * a21;
                    double D1 = b1 * a22 - a12 * b2;
                    double D2 = a11 * b2 - b1 * a21;
                    if (D != 0) System.out.println("x1=" + (D1 / D) + ", x2=" + (D2 / D));
                    else System.out.println((D1 == 0 && D2 == 0) ? "vo so nghiem" : "vo nghiem");
                    break;
                }
                case 3: {
                    double a = sc.nextDouble(), b = sc.nextDouble(), c2 = sc.nextDouble();
                    if (a == 0) {
                        if (b == 0) System.out.println(c2 == 0 ? "vo so nghiem" : "vo nghiem");
                        else System.out.println("x=" + (-c2 / b));
                    } else {
                        double d = b * b - 4 * a * c2;
                        if (d < 0) System.out.println("vo nghiem");
                        else if (d == 0) System.out.println("nghiem kep x=" + (-b / (2 * a)));
                        else System.out.println("x1=" + ((-b + Math.sqrt(d)) / (2 * a)) +
                                                ", x2=" + ((-b - Math.sqrt(d)) / (2 * a)));
                    }
                    break;
                }
            }
        }
    }
}
