import javax.swing.JOptionPane;
import java.util.Arrays;

public class ArraySort {
    public static void main (String[] args) {
        String line = JOptionPane.showInputDialog("Nhập mảng:");
        String[] parts = line.split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }

        for (int i = 0; i < parts.length - 1; i++){
            for (int k = 0; k < parts.length - 1; k++){
                int h = arr[k];
                int g = arr[k + 1];
                if (h > g){
                    arr[k + 1] = h;
                    arr[k] = g;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("Mảng sau khi sắp xếp: ").append(Arrays.toString(arr)).append("\n");

        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        result.append("Tổng = ").append(sum).append("\n");

        double avg = (double) sum / arr.length;
        result.append(String.format("Trung bình = %.2f", avg));

        JOptionPane.showMessageDialog(null, result.toString());
    }
}
