package com.hardQuestion.array;

//Rotate Matrix by 90 Degrees in Java

/**
 * <a>src/main/resources/rotate-matrix-by-90-degrees-in-java.png</a>
 * https://www.javatpoint.com/rotate-matrix-by-90-degrees-in-java
 */

public class LeftRotationArray {
    static int matrix[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public static void main(String[] args) {
        printMatrix();
        System.out.println("left rotation");
        LeftRotation(matrix, 3);
      //  rightRotation(matrix ,3);
        printMatrix();

    }

    private static void rightRotation(int[][] matrix, int n) {
    //determines the transpose of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

//then we reverse the elements of each row
        for (int i = 0; i < n; i++) {
//logic to reverse each row i.e 1D Array.
            int low = 0, high = n - 1;
            while (low < high) {
                int temp = matrix[low][i];
                matrix[low][i] = matrix[high][i];
                matrix[high][i] = temp;
                low++;
                high--;
            }
        }

    }

    static public void LeftRotation(int matrix[][], int n) {
        //determines the transpose of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //then we reverse the elements of each row
        for (int i = 0; i < n; i++) {
            //logic to reverse each row i.e 1D Array.
            int low = 0, high = n - 1;
            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }

    }



    static void printMatrix() {
        //prints matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //prints the elements of the matrix
                System.out.print(matrix[i][j] + " " + "\t");
            }
            System.out.println();
        }
    }
}