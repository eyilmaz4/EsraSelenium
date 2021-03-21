package internet;

import base.BaseClass;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Random;
import java.util.stream.IntStream;

public class MathRandom {
    public static void main(String[] args) {
        int num=(int)(Math.random());
        System.out.println(num);
        Random a=new Random();
        int sonuc=a.nextInt(5);
        System.out.println(sonuc);
    }


}
