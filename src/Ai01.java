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

        boolean is_first = arrayinput[0].equals("is");
        boolean is_contains = Arrays.asList(arrayinput).contains("is");
        boolean define_contains = Arrays.asList(arrayinput).contains("define");

        if(!is_first && is_contains) {
            define(arrayinput);
        }
        else if(is_first){
            check(arrayinput);
        }
        else if(define_contains) {
            answer(arrayinput);
        }
        else{
            output = "Unknown command";
        }

        System.out.println("O: " + output);

    }}

    private static String define(String arrayinput[]){

        output = "method define failed";

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

        output = "method answer failed";

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

    private static String check(String arrayinput[]){

        output = "method check failed";

        int is_pos = Arrays.asList(arrayinput).indexOf("is");
        int begOfKey = is_pos + 1;

        ArrayList finalarray = new ArrayList();
        String whileKey = arrayinput[begOfKey];
        String whileValue;

        if(definitions.containsKey(whileKey)) {
            finalarray.add(whileKey);
        }
        else {

            System.out.println("whileKey = " + whileKey + "\n" + "containsKey = " + definitions.containsKey(whileKey) + "\n");

            int i = begOfKey + 1;

            while(!definitions.containsKey(whileKey) && i < arrayinput.length){

                whileKey += " ";
                whileKey += arrayinput[i];
                i++;

            }

            System.out.println("whileKey = " + whileKey + "\n" + "containsKey = " + definitions.containsKey(whileKey) + "\n");

            if(definitions.containsKey(whileKey)){

                whileValue = arrayinput[i];
                i++;

                System.out.println("whileValue = " + whileValue + "\n" + "arrayinput = " + arrayinput + "\n" + "containsKey = " + definitions.containsKey(whileKey) + "\n" + "key equals value = " + definitions.get(whileKey) != whileValue + "\n");

                while(definitions.get(whileKey) != whileValue && i < arrayinput.length){
                    whileValue += " ";
                    whileValue += arrayinput[i];
                    i++;
                }

                System.out.println("whileValue = " + whileValue + "\n" + "containsKey = " + definitions.containsKey(whileKey) + "\n" + "key equals value = " + definitions.get(whileKey) != whileValue + "\n");

                if(definitions.get(whileKey).equals(whileValue)){
                    output = "Yes";
                }
                else{
                    output = "No";
                }

            }

            else{
                output = "Term not found";
            }

            output = "Term not found";

        }

        return output;

    }

}