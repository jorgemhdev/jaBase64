package main.core;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Converter {

    private static byte[] byteString;

    public static String toBase64(String initialPlain){
        byteString = initialPlain.getBytes(StandardCharsets.UTF_8);
        String output64 = Base64.getEncoder().encodeToString(byteString);
        return output64;
    }

    public static String toPlainText(String initial64){
        byteString = Base64.getDecoder().decode(initial64);
        String outputPlain = new String(byteString);
        return outputPlain;
    }

}
