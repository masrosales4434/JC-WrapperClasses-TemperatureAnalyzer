package org.example;
import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Day 1 High Temperature: ");
        String day1TempStr = input.nextLine();

        System.out.println("Enter Day 2 High Temperature: ");
        String day2TempStr = input.nextLine();

        System.out.println("Enter Day 3 High Temperature: ");
        String day3TempStr = input.nextLine();

        System.out.println("--- Temperature Analysis ---");
        double day1TempPrimitive = 0;
        double day2TempPrimitive = 0;


        try{
            day1TempPrimitive = Double.parseDouble(day1TempStr);
            System.out.println("Parsed Day 1 Temp (primitive double): " + day1TempPrimitive);
        } catch (NumberFormatException e) {
            System.out.println("You have entered an invalid input format. The input must be in proper Temperature format.");
            System.exit(0);
        }

        try{
             day2TempPrimitive = Double.parseDouble(day2TempStr);
            System.out.println("Parsed Day 2 Temp (primitive double): " + day2TempPrimitive);

        } catch (NumberFormatException e) {
            System.out.println("You have entered an invalid input format. The input must be in proper Temperature format.");
            System.exit(0);
        }


        Double day1TempWrapper = Double.valueOf(day1TempPrimitive);
        Double day2TempWrapper = Double.valueOf(day2TempPrimitive);

        int compareResult = day1TempWrapper.compareTo(day2TempWrapper);

        if(compareResult == 0){
            System.out.println("\nDay 1 (" +day1TempWrapper+" C) had the same temp with Day 2 ("+day2TempWrapper+" °C).");
        }else if(compareResult >0){
            System.out.println("\nDay 1 (" +day1TempWrapper+" C) was warmer than Day 2 ("+day2TempWrapper+" °C).");
        }else {
            System.out.println("\nDay 1 (" +day1TempWrapper+" C) was colder than Day 2 ("+day2TempWrapper+" °C).");
        }


        float day1TempFloat = day1TempWrapper.floatValue();
        int day2TempInt = day2TempWrapper.intValue();

        System.out.println("\nExtracted Day 1 Temp (primitive float from Double wrapper): "+day1TempFloat);
        System.out.println("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): "+day2TempInt);

        double day3TempPrimitive = Double.parseDouble(day3TempStr);
        Double day3TempWrapper = Double.valueOf(day3TempPrimitive);

        double maxTemp = Math.max(day1TempWrapper,day2TempWrapper);

        if(maxTemp< day3TempWrapper){
            maxTemp = day3TempWrapper;
        }
        System.out.println("\nThe highest temperature recorded was: " + maxTemp + "°C");
    }
}