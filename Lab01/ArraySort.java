import java.util.Scanner;
import java.util.Arrays;
public class ArraySort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap mang");
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i <= parts.length - 1; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }
        sc.close();    
        for (int i = 0; i <= parts.length - 2; i++){
            for (int k = 0; k <= parts.length - 2; k++){
                int h = arr[k];
                int g = arr[k + 1];
                if (h > g){
                    arr[k + 1] = h;
                    arr[k] = g;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for (int i = 0; i <= arr.length - 1; i++){
            sum += arr[i];
        }
        System.out.println(sum);
        double avg = (double) sum / arr.length;
        System.out.printf("Trung bình = %.2f%n", avg);

    }
}
