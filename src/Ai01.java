import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Luka on 23.6.2016..
 */
public class Ai01 {

    public static void main(String[] args){

        Scanner scaninput = new Scanner(System.in);
        System.out.print("I: ");
        String userinput = scaninput.nextLine();
        userinput = userinput.toLowerCase();

        String arrayinput[] = userinput.split(" ");
        Dictionary definitions = new Hashtable();

        ArrayList arraybefore = new ArrayList();
        ArrayList arrayafter = new ArrayList();

        if(Arrays.asList(arrayinput).contains("is")) {

            int is_pos = Arrays.asList(arrayinput).indexOf("is");

            for(int i = 0; i < is_pos; i++){

                arraybefore.add(arrayinput[i]);

            }

            for(int i = is_pos + 1; i < arrayinput.length; i++){

                arrayafter.add(arrayinput[i]);

            }

        }

        String stringbefore = String.join(" ", arraybefore);
        String stringafter = String.join(" ", arrayafter);

        definitions.put(stringbefore, stringafter);

        System.out.println("O: " + "Is " + stringbefore + " " + definitions.get(stringbefore) + "?");

    }

}