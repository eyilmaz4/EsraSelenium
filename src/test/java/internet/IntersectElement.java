package internet;


import java.util.Arrays;

public class IntersectElement {
    public static void main(String[] args) {
        int arr[][]=new int[3][2];
        //System.out.println(Arrays.toString(arr));
        for (int a[]:arr
             ) {

            for (int b:a
                 ) {

                System.out.println(b);
            }
            System.out.println(" ");
        }
    }


}
