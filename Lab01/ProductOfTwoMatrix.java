import java.util.Scanner;
public class ProductOfTwoMatrix {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of row 1: ");
        int R1 = input.nextInt();
        System.out.print("Enter the number of column 1: ");
        int C1 = input.nextInt();
        System.out.print("Enter the number of row 2: ");
        int R2 = input.nextInt();
        System.out.print("Enter the number of column 2: ");
        int C2 = input.nextInt();
        int[][] matrix1 = new int[R1][C1];
        int[][] matrix2 = new int[R2][C2];
        if(C1 != R2){
            System.out.println("Can not find product of matrix1 and matrix2");
            return;
        }
        int[][] matrix3 = new int[R1][C2];
        for (int i1 = 0; i1 < R1 ; i1++){
            for (int j1 = 0; j1 < C1; j1++){
                System.out.printf("Enter the matrix1[%s][%s]: ", i1, j1); 
                matrix1[i1][j1] = input.nextInt();
            }
        }
        for (int i2 = 0; i2 < R2 ; i2++){
            for (int j2 = 0; j2 < C2; j2++){
                System.out.printf("Enter the matrix1[%s][%s]: ", i2, j2); 
                matrix2[i2][j2] = input.nextInt();
            }
        }
        for (int i = 0; i < R1; i++) {
            for (int j = 0; j < C2; j++) {
                for (int k = 0; k < R2; k++) {
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }
        for (int i = 0; i < R1; i++){
            for (int j = 0; j < C2; j++){
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }
}