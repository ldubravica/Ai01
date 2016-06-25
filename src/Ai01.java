import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Luka on 23.6.2016..
 */
public class Ai01 {

    private static Scanner scaninput = new Scanner(System.in);
    private static HashMap<String, String> definitions = new HashMap<>();
    private static String output;

    public static void main(String[] args){ while(true){

        System.out.print("I: ");
        String userinput = scaninput.nextLine();

        userinput = userinput.toLowerCase();
        String arrayinput[] = userinput.split(" ");

        if(Arrays.asList(arrayinput).contains("is") & arrayinput[0] == "is") {
            define(arrayinput);
        }
        else if(Arrays.asList(arrayinput).contains("define")) {
            answer(arrayinput);
        }
        else{
            output = "Unknown command";
        }

        System.out.println("O: " + output);

    }}

    private static String define(String arrayinput[]){

        ArrayList arraybefore = new ArrayList();
        ArrayList arrayafter = new ArrayList();

        int is_pos = Arrays.asList(arrayinput).indexOf("is");

        for(int i = 0; i < is_pos; i++){

            arraybefore.add(arrayinput[i]);

        }

        for(int i = is_pos + 1; i < arrayinput.length; i++){

            arrayafter.add(arrayinput[i]);

        }

        String stringbefore = String.join(" ", arraybefore);
        String stringafter = String.join(" ", arrayafter);

        definitions.put(stringbefore, stringafter);
        output = "Is " + stringbefore + " " + definitions.get(stringbefore) + "?";

        return output;

    }

    private static String answer(String arrayinput[]){

        ArrayList arrayterm = new ArrayList();

        int define_pos = Arrays.asList(arrayinput).indexOf("define");

        for(int i = define_pos + 1; i < arrayinput.length; i++){

            arrayterm.add(arrayinput[i]);

        }

        String stringterm = String.join(" ", arrayterm);

        if(definitions.containsKey(stringterm)){
            output = "It is " + definitions.get(stringterm);
        }
        else{
            output = "Term not found";
        }

        return output;

    }

}