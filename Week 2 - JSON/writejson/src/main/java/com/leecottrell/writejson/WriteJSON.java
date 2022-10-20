package com.leecottrell.writejson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJSON 
{
    public static void main( String[] args )
    {
        ObjectMapper mapper = new ObjectMapper();//jackson
        Recipe pbj = new Recipe();
        pbj.setRecipeName("Peanut Butter and Jelly");
        pbj.setCalories(200);
        pbj.setAllergyWarning(true);
        pbj.setIngredients(Arrays.asList("2 Pieces of bread", 
            "Peanut Butter", "Jelly"));
        Map<String, String> theSteps = new HashMap(){
            {
            put("Step 1", "Put bread on plate");
            put("Step 2", "Put peanut butter on one slice of bread");
            put("Step 3", "Put jelly on one slice of bread");
            put("Step 4", "Put the two pieces of bread together");
            }
        };
        pbj.setSteps(theSteps);

        //System.out.println(pbj.toString());

        try{
            String JSON;// = mapper.writeValueAsString(pbj);
            JSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pbj);
            //System.out.println(JSON);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("c:\\data\\vorhees.json"), pbj);

            List<Recipe> recipes = new ArrayList<Recipe>();
            recipes.add(pbj);
            recipes.add(pbj);
            recipes.add(pbj);
            recipes.add(pbj);
            JSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipes);
            System.out.println(JSON);
        }
        catch(JsonProcessingException jse){
            System.out.println(jse.toString());
            System.exit(1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            System.exit(1);
        }

    }
}
