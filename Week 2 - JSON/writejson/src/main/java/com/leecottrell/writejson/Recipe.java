package com.leecottrell.writejson;
import java.util.*;

public class Recipe {
    private String recipeName;
    private int Calories;
    private List <String> Ingredients;
    private Map <String, String> Steps;
    private boolean AllergyWarning;

    //setters getters constructors

    public Recipe() {
    }

    public Recipe(String recipeName, int Calories, List<String> Ingredients, Map<String,String> Steps, boolean AllergyWarning) {
        this.recipeName = recipeName;
        this.Calories = Calories;
        this.Ingredients = Ingredients;
        this.Steps = Steps;
        this.AllergyWarning = AllergyWarning;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getCalories() {
        return this.Calories;
    }

    public void setCalories(int Calories) {
        this.Calories = Calories;
    }

    public List<String> getIngredients() {
        return this.Ingredients;
    }

    public void setIngredients(List<String> Ingredients) {
        this.Ingredients = Ingredients;
    }

    public Map<String,String> getSteps() {
        return this.Steps;
    }

    public void setSteps(Map<String,String> Steps) {
        this.Steps = Steps;
    }

    public boolean isAllergyWarning() {
        return this.AllergyWarning;
    }

    public boolean getAllergyWarning() {
        return this.AllergyWarning;
    }

    public void setAllergyWarning(boolean AllergyWarning) {
        this.AllergyWarning = AllergyWarning;
    }

    public Recipe recipeName(String recipeName) {
        setRecipeName(recipeName);
        return this;
    }

    public Recipe Calories(int Calories) {
        setCalories(Calories);
        return this;
    }

    public Recipe Ingredients(List<String> Ingredients) {
        setIngredients(Ingredients);
        return this;
    }

    public Recipe Steps(Map<String,String> Steps) {
        setSteps(Steps);
        return this;
    }

    public Recipe AllergyWarning(boolean AllergyWarning) {
        setAllergyWarning(AllergyWarning);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Recipe)) {
            return false;
        }
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeName, recipe.recipeName) && Calories == recipe.Calories && Objects.equals(Ingredients, recipe.Ingredients) && Objects.equals(Steps, recipe.Steps) && AllergyWarning == recipe.AllergyWarning;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName, Calories, Ingredients, Steps, AllergyWarning);
    }

    @Override
    public String toString() {
        return "{" +
            " recipeName='" + getRecipeName() + "'" +
            ", Calories='" + getCalories() + "'" +
            ", Ingredients='" + getIngredients() + "'" +
            ", Steps='" + getSteps() + "'" +
            ", AllergyWarning='" + isAllergyWarning() + "'" +
            "}";
    }

    
}
