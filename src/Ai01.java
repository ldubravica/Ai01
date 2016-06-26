import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Luka on 23.6.2016..
 */
public class Ai01 {

    private static Scanner scanInput = new Scanner(System.in);
    private static HashMap<String, String> definitions = new HashMap<>();
    private static String output;

    public static void main(String[] args){ while(true){

        System.out.print("I: ");
        String userInput = scanInput.nextLine();

        userInput = userInput.toLowerCase();
        String arrayInput[] = userInput.split(" ");

        boolean is_first = arrayInput[0].equals("is");
        boolean is_contains = Arrays.asList(arrayInput).contains("is");
        boolean define_contains = Arrays.asList(arrayInput).contains("define");

        if(!is_first && is_contains) {
            define(arrayInput);
        }
        else if(is_first){
            check(arrayInput);
        }
        else if(define_contains) {
            answer(arrayInput);
        }
        else{
            output = "Unknown command";
        }

        System.out.println("O: " + output);

    }}

    private static String define(String arrayInput[]){

        output = "Method define - failed";

        ArrayList<String> arrayBefore = new ArrayList<>();
        ArrayList<String> arrayAfter = new ArrayList<>();

        int is_pos = Arrays.asList(arrayInput).indexOf("is");

        for(int i = 0; i < is_pos; i++){
            arrayBefore.add(arrayInput[i]);
        }

        for(int i = is_pos + 1; i < arrayInput.length; i++){
            arrayAfter.add(arrayInput[i]);
        }

        String stringBefore = String.join(" ", arrayBefore);
        String stringAfter = String.join(" ", arrayAfter);

        definitions.put(stringBefore, stringAfter);
        output = "Is " + stringBefore + " " + definitions.get(stringBefore) + "?";

        return output;

    }

    private static String answer(String arrayInput[]){

        output = "Method answer - failed";

        ArrayList<String> arrayTerm = new ArrayList<>();

        int define_pos = Arrays.asList(arrayInput).indexOf("define");

        for(int i = define_pos + 1; i < arrayInput.length; i++){
            arrayTerm.add(arrayInput[i]);
        }

        String stringterm = String.join(" ", arrayTerm);

        if(definitions.containsKey(stringterm)){
            output = "It is " + definitions.get(stringterm);
        }
        else{
            output = "Term not found";
        }

        return output;

    }

    private static String check(String arrayInput[]){

        output = "Method check - failed";

        int is_pos = Arrays.asList(arrayInput).indexOf("is");
        int i = is_pos + 1;

        ArrayList<String> arrayKey = new ArrayList<>();
        ArrayList<String> arrayValue = new ArrayList<>();

        String whileKey = null;
        String whileValue = null;

        while(!definitions.containsKey(whileKey) && i < arrayInput.length){

            arrayKey.add(arrayInput[i]);
            i++;
            whileKey = String.join(" ", arrayKey);

        }

        if(definitions.containsKey(whileKey)){

            while(!definitions.get(whileKey).equals(whileValue) && i < arrayInput.length){

                arrayValue.add(arrayInput[i]);
                i++;
                whileValue = String.join(" ", arrayValue);
                System.out.println(whileKey + " + " + whileValue + " + " + i);

            }

            if(definitions.get(whileKey).equals(whileValue)){
                output = "Yes";
            }
            else{
                output = "No";
            }

        }
        else {
            output = "Term not found";
        }

        return output;

    }

}