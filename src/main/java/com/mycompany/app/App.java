package com.mycompany.app;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App 
{
    // iterates through both arraylists and appends the corresponding text
    // (text1 for list1's elements, text2 for list2's elements) to the result String.
    public static String concatText(ArrayList<Integer> list1, ArrayList<Integer> list2, String text1, String text2){
        int i=0;
        int j=0;
        String result = "";

        while(list1 != null && list2 != null && i < list1.size() && j < list2.size()
                && text1 != null && text2 != null){

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

        // appends text1 to the result if there are remaining elements in the list1
        while(list1 != null && i < list1.size() && text1 != null){
            int count1 = list1.get(i) > 0 ? list1.get(i) : 0;
            for(int k=0; k<count1; k++){
                result += text1;
            }
            i++;
        }

        // appends text2 to the result if there are remaining elements in the list2
        while(list2 != null && j < list2.size() && text2 != null){
            int count2 = list2.get(j) > 0 ? list2.get(j) : 0;
            for(int k=0; k<count2; k++){
                result += text2;
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            ArrayList<Integer> list1 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                list1.add(value);
            }
            System.out.println(list1);


            String input2 = req.queryParams("input2");
            Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            ArrayList<Integer> list2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                list2.add(value);
            }
            System.out.println(list2);

            String input3 = req.queryParams("input3");
            input3 = input3 != null ? input3.replaceAll("\\s","") : "";

            String input4 = req.queryParams("input4");
            input4 = input4 != null ? input4.replaceAll("\\s","") : "";

            String result = concatText(list1, list2, input3, input4);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}



