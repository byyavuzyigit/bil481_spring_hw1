package com.mycompany.app;

import java.util.*;


/**
 * Hello world!
 *
 */
public class App 
{
    // iterates through both arraylists and appends the corresponding text
    // (text1 for list1's elements, text2 for list2's elements) to the result String.
    public static String method(ArrayList<Integer> list1, ArrayList<Integer> list2, String text1, String text2){
        int i=0;
        int j=0;
        String result = "";
        while(i < list1.size() && j < list2.size()){
            int count1 = list1.get(i) > 0 ? list1.get(i) : 0;
            for(int k=0; k<count1; k++){
                result += text1;
            }
            int count2 = list2.get(j) > 0 ? list2.get(j) : 0;
            for(int k=0; k<count2; k++){
                result += text2;
            }
            i++;
            j++;
        }
        if(i < list1.size()){
            int count1 = list1.get(i) > 0 ? list1.get(i) : 0;
            for(int k=0; k<count1; k++){
                result += text1;
            }
            i++;
        }
        if(j < list2.size()){
            int count2 = list2.get(j) > 0 ? list2.get(j) : 0;
            for(int k=0; k<count2; k++){
                result += text2;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args){

        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(method(list1,list2,"aa","bbb"));


    }
}
