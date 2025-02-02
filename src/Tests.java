import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    //Testa enkel översättning till morsekod
    @Test
    public void toMorse() {
        String input = "helloworld";
        String expectedOutput = "Your text in morse code is: .... . .-.. .-.. --- .-- --- .-. .-.. -.. ";  // Förväntat resultat med prefix
        String actualOutput = Main.processInput(input);
        assertEquals(expectedOutput, actualOutput);
    }


    //Testa enkel översättning till text
    @Test
    public void toText() {
        String input = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";
        String expectedOutput = "HELLOWORLD";
        String actualOutput = Main.processInput(input);
        assertEquals(expectedOutput, actualOutput);
    }


    //Testa ogiltiga tecken
    @Test
    public void invalidChars() {
        String input = "Hej hej hej!!";
        String expectedOutput = "Only use a-z and not any other characters";
        String actualOutput = Main.processInput(input);
        assertEquals(expectedOutput, actualOutput);
    }


    //Testa otillåtna bokstäver
    @Test
    public void invalidLetters() {
        String input = "Hej och hå hästen gillar hö";
        String expectedOutput = "Please only use letters a-z.";
        String actualOutput = Main.processInput(input);
        assertEquals(expectedOutput, actualOutput);
    }

    // Fel inmatning av morsekord
    @Test
    public void invalidMorse() {
        String input = ".... . .--- ... .------- -.";
        String expectedOutput = "This is not a part of the morse alphabet: .------- Please try again.";
        String actualOutput = Main.processInput(input);
        assertEquals(expectedOutput, actualOutput);

    }
}
