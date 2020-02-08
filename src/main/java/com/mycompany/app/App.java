package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static boolean aradadir(int[] arr1,int[] arr2,int altsinir,int üstsinir){
        boolean b=false;
        for(int i1=0;i1<arr1.length;i1++)
            for(int i2=0;i2<arr2.length;i2++)
                if(arr1[i1]*arr2[i2]>altsinir&&arr1[i1]*arr2[i2]<üstsinir) {
                    b=true;
                }

        return b;
	}
}
