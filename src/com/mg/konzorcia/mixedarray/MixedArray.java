package com.mg.konzorcia.mixedarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MixedArray {

    public static void main(String[] args) {

        Object[] mixedArray=new Object[10];

        for (int i=0; i < mixedArray.length; i++) {
            if (Math.random() < 0.5) {
                // Random Integer-t ad hozzá.
                mixedArray[i]=(int) (Math.random() * 100);
            } else {
                // Random String-et ad hozzá.
                Random rnd=new Random();
                String random="";
                int stringLength=rnd.nextInt(10);

                for (int j=0; j < stringLength; j++) {
                    random+=(char) ('a' + rnd.nextInt(26));
                }
                mixedArray[i]=random;
            }
            System.out.println(mixedArray[i]);
        }

        Arrays.sort(mixedArray, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1="";
                String s2="";
                s1=(o1 instanceof Integer) ? String.valueOf(o1) : (String) o1;
                s2=(o2 instanceof Integer) ? String.valueOf(o2) : (String) o2;
                return s1.compareTo(s2);
            }
        });

        for (int i=0; i < mixedArray.length; i++) {
            System.out.println(mixedArray[i]);
        }

    }
}
