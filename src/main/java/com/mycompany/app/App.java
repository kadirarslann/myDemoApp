package com.mycompany.app;


import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

	//////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/", (req, res) -> "indexlerinin carpımı 8-400 arası sayıların sayısı");

        post("/compute", (req, res) -> {
          System.out.println(req.queryParams("input1"));
          System.out.println(req.queryParams("input2"));
	int s1=0;int s2=0; int s3=0;
	int[] dizi1=new int[100];
	int[] dizi2=new int[100];
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
         // java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            dizi1[s1++]=value;
          }
          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
        //  java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            dizi2[s2++]=value;
          }
       
	for(int i1=0;i1<s1;i1++)
		for(int i2=0;i2<s2;i2++)
			if(aradadir(dizi1,dizi2,8,400))
	 			s3++;
         // boolean result = App.(inputList, input2AsInt);

         Map map = new HashMap();
          map.put("result", s3);
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
	//////////////////////////////////////////////////////////
}
