import javax.swing.JOptionPane;

public class MatrixAddition {
    public static void main(String[] args) {
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Nhập số hàng của ma trận:"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Nhập số cột của ma trận:"));

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sum = new int[rows][cols];

        JOptionPane.showMessageDialog(null, "Nhập các phần tử cho ma trận 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
                        "Nhập phần tử matrix1[" + i + "][" + j + "]:"));
            }
        }

        JOptionPane.showMessageDialog(null, "Nhập các phần tử cho ma trận 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
                        "Nhập phần tử matrix2[" + i + "][" + j + "]:"));
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        StringBuilder result = new StringBuilder("Kết quả cộng 2 ma trận:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.append(sum[i][j]).append(" ");
            }
            result.append("\n");
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }
}
