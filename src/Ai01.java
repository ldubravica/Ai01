import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Luka on 23.6.2016..
 */
public class Ai01 {

    private static Scanner scaninput = new Scanner(System.in);
    private static Dictionary definitions = new Hashtable();
    private static String output;

    public static void main(String[] args){ while(true){

        System.out.print("I: ");
        String userinput = scaninput.nextLine();

        userinput = userinput.toLowerCase();
        String arrayinput[] = userinput.split(" ");

        if(Arrays.asList(arrayinput).contains("is")) {
            defining(arrayinput);
        }
        else if(Arrays.asList(arrayinput).contains("define")) {
            define(arrayinput);
        }

        System.out.println(output);

    }}

    private static String defining(String arrayinput[]){

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
        output = "O: " + "Is " + stringbefore + " " + definitions.get(stringbefore) + "?";

        return output;

    }

    private static String define(String arrayinput[]){

        ArrayList arrayterm = new ArrayList();

        int define_pos = Arrays.asList(arrayinput).indexOf("is");

        for(int i = define_pos + 1; i < arrayinput.length; i++){

            arrayterm.add(arrayinput[i]);

        }

        String stringterm = String.join(" ", arrayterm);
        output = "O: " + "It is " + definitions.get(stringterm);

        return output;

    }

}