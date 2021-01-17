/**
 * @Author Jorge Martinez (nothing4free)
 * This class contains the methods that encode and decode the text from the GUI input.
 * The methods are called whenever the corresponding GUI buttons are pressed, and are
 * passed whatever text was introduced in the input text areas.
 */

//includes the class in the package "main/core" and imports the libraries needed to encode and decode Base64
package main.core;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Converter {
    //byteString attribute that contains the text input bytes and is passed to the Base64 encoder/decoder
    private static byte[] byteString;

    //Base64 encoder method that encodes the plain text string "initialPlain" and returns it
    public static String toBase64(String initialPlain){
        byteString = initialPlain.getBytes(StandardCharsets.UTF_8);
        String output64 = Base64.getEncoder().encodeToString(byteString);
        return output64;
    }

    //Base64 decoder method that decodes the base64 string "initial64" and returns it
    public static String toPlainText(String initial64){
        byteString = Base64.getDecoder().decode(initial64);
        String outputPlain = new String(byteString);
        return outputPlain;
    }

}
