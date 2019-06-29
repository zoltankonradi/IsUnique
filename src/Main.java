import java.util.HashMap;
import java.util.Map;

public class Main {

    /*

     Cracking the Coding Interview - Arrays and Strings

     1.1 - Is Unique:
     Implement an algorithm to determine if a string has all unique characters.
     What if you cannot use additional data structures?

     */

    public static void main(String[] args) {
        System.out.println(withOtherDataStructure("Hello World!"));
        System.out.println(withoutOtherDataStructure("Hello World!"));
        System.out.println(withOtherDataStructure("no duplicates"));
        System.out.println(withoutOtherDataStructure("no duplicates"));
    }

    public static boolean withOtherDataStructure(String string) {
        Map<String, Integer> characters = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (characters.containsKey(Character.toString(string.charAt(i)))) {
                characters.put(Character.toString(string.charAt(i)), characters.get(Character.toString(string.charAt(i))) + 1);
            } else {
                characters.put(Character.toString(string.charAt(i)), 1);
            }
        }
        for(Map.Entry<String, Integer> element : characters.entrySet()) {
            if (element.getValue() > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean withoutOtherDataStructure(String string) {
        String character;
        int counter;
        for (int i = 0; i < string.length(); i++) {
            counter = 0;
            character = Character.toString(string.charAt(i));
            for (int j = 0; j < string.length(); j++) {
                if (Character.toString(string.charAt(j)).equals(character)) {
                    counter++;
                }
            }
            if(counter > 1) { return false; }
        }
        return true;
    }
}
