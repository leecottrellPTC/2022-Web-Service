package com.leecottrell.readjson;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;



public class ReadJSON 
{
    public  static List<Company> companyList;
    public static String readAllLines(String path){
        String content = "";
        try{
            content = new String(Files.readAllBytes(Paths.get(path)));
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            System.exit(1);
        }
        return content;
    }

    public static int countNA(){
        int counter = 0;
        for(Company aCompany : companyList){
            if(aCompany.getIndustry().equalsIgnoreCase("n/a")){
                counter ++;
            }
        }
        return counter;
    }
    public static void main( String[] args )
    {
        String json;
        json = readAllLines("c:\\data\\companies.json");
      //  System.out.println(json);

      ObjectMapper mapper = new ObjectMapper(); //Jackson JSON converter
      Company aCompany;
   
      try{
            companyList = mapper.readValue(json, 
            new TypeReference<List<Company>>() {
                
            });
            System.out.println("Lines read " + companyList.size());

            System.out.println("Company without industry " + countNA());
           // System.out.println(companyList.get(0).getCompany() + " industry" +
            //companyList.get(0).getIndustry());
      }
      catch(JsonMappingException jme){
        System.out.println(jme.toString());
        return;
      } catch (JsonProcessingException e) {
        System.out.println(e.toString());
    }
    }
}
