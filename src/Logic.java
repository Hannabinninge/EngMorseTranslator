import java.util.HashMap;

public class Logic {
    public static HashMap<String, String> EngTranslator = new HashMap<>();
    public static HashMap<String, String> MorseTranslator = new HashMap<>();

    static {
        EngTranslator.put("A", ".-");
        EngTranslator.put("B", "-...");
        EngTranslator.put("C", "-.-.");
        EngTranslator.put("D", "-..");
        EngTranslator.put("E", ".");
        EngTranslator.put("F", "..-.");
        EngTranslator.put("G", "--.");
        EngTranslator.put("H", "....");
        EngTranslator.put("I", "..");
        EngTranslator.put("J", ".---");
        EngTranslator.put("K", "-.-");
        EngTranslator.put("L", ".-..");
        EngTranslator.put("M", "--");
        EngTranslator.put("N", "-.");
        EngTranslator.put("O", "---");
        EngTranslator.put("P", ".--.");
        EngTranslator.put("Q", "--.-");
        EngTranslator.put("R", ".-.");
        EngTranslator.put("S", "...");
        EngTranslator.put("T", "-");
        EngTranslator.put("U", "..-");
        EngTranslator.put("V", "...-");
        EngTranslator.put("W", ".--");
        EngTranslator.put("X", "-..-");
        EngTranslator.put("Y", "-.--");
        EngTranslator.put("Z", "--..");

        //Översättning morsekod till bokstäver
        for (String key : EngTranslator.keySet()) {
            MorseTranslator.put(EngTranslator.get(key), key);
        }
    }

    // Kollar om det är morsekod
    public static boolean notMorse(String input) {
        for (char c : input.toCharArray()) {
            if (c != '.' && c != '-' && c != ' ') {
                return false;
            }

        }
        return true;
    }

    // Text till morse

    public static String toMorse(String text) {
        StringBuilder morse = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            //Hämtar rätt morsekod
            if (c == ' ') {
                morse.append("   ");
            } else {
                String morseCode = EngTranslator.get(String.valueOf(c).toUpperCase());
                if (morseCode != null) {
                    morse.append(morseCode).append(" ");
                }
            }
        }

        return morse.toString();
    }

    // är morsekoden korrekt?
    public static boolean correctMorse(String input) {
        return notMorse(input);
    }


    // Kollar om det är text eller inte
    public static boolean isText(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;

    }

    // Felhantering om det inte är korrekt morsekod
    public static String fromMorse(String morse) {
        if (!correctMorse(morse)) {
            return "Wrong morse code format: ";
        }

        String text = "";

        String[] letters = morse.split(" ");
        for  (String letter:letters) {
            // System.out.println(letter);//  String letter = morse
            String translatedLetter = MorseTranslator.get(letter);
            //System.out.println(translatedLetter);
            if (translatedLetter != null) {
                text = text.concat(translatedLetter);
            } else {

                return "This is not a part of the morse alphabet: " + letter + " Please try again.";
            }
        }

        return text;
    }
}



