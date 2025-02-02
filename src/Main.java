import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text or Morse code:");
        String input = scanner.nextLine().trim();
        String result = processInput(input);
        System.out.println(result);

    }

    //Felhantering
    public static String processInput(String input) {

        if (input.contains("å") || input.contains("ä") || input.contains("ö") ||
                input.contains("Å") || input.contains("Ä") || input.contains("Ö")) {
            return "Please only use letters a-z.";
        }

        if (Logic.notMorse(input)) {
            String morseMessage = Logic.fromMorse(input);
            if (morseMessage.startsWith("Wrong")) {
                return morseMessage;
            }
            return morseMessage;
        } else if (Logic.isText(input)) {
            String morseMessage = Logic.toMorse(input.toUpperCase());
            return "Your text in morse code is: " + morseMessage;
        }

        //Felhantering om det inte är morsekod eller text
        else {
            return "Only use a-z and not any other characters";
        }
    }
}