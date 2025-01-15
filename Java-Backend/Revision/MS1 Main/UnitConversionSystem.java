import java.util.Scanner;

public class UnitConversionSystem {

    // complete implementation here
    public static float convertGramsToKilograms(int grams){
        float result = (grams/1000f);
        return result;
    }

    public static float convertMillilitersToLiters(int milliliters){
        float result = (milliliters/1000f);
        return result;
    }

    public static double convertCelsiusToFahrenheit(int celsius){
        float result = (celsius * 9/5f) + 32f;                
        return result;
    }

    public static void main(String[] args) {
        
    }


}
