/**
 * @Author Jorge Martinez (nothing4free)
 * This class creates the Graphic User Interface and calls the encoder/decoder when ordered by the user.
 * As of now, it's really basic yet functional. Along with the addition of new features, design will also be updated.
 */

//includes the class in the package "main/gui", and imports the encoder/decoder class from "main/core"
package main.gui;
import main.core.Converter;
//imports GUI libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    //takes information from the user's screen to launch the GUI centered
    private static final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int screenWidth = (int) screen.getWidth();
    private static final int screenHeight = (int) screen.getHeight();

    //Frame dimensions
    private static final int FRAME_WIDTH = 1300;
    private static final int FRAME_HEIGHT = 800;

    //Calculations needed to launch the GUI centered
    private static final int widthOffset = FRAME_WIDTH / 2;
    private static final int heightOffset = FRAME_HEIGHT / 2;

    public Frame(){

        //Basic frame setup: size, spawn location, title...
        JFrame jFrame = new JFrame();
        jFrame.setLayout(null);
        jFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        jFrame.setLocation((screenWidth /2 - widthOffset), (screenHeight /2 - heightOffset));
        jFrame.setTitle("B64-EncodeDecode v0.1 [DEV_PREVIEW]");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        //"About" button
        JButton about = new JButton("About");
        about.setBounds(1198, 5, 80, 30);
        about.addActionListener(new ActionListener() {
            //this ActionListener allows the "about" popup window to appear when the user clicks the "About" button
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "B64-EncodeDecode v0.1\nAn Open-Source, Java-Based Base64 Encoder and Decoder.\nMade by Jorge Martinez (github.com/nothing4free)");
            }
        });
        jFrame.add(about);

        // Plain text to Base64 section --------------------------------------------------------------------------------

        //"Encode plain text to Base64" text label
        JLabel plainToBase = new JLabel("Encode plain text to Base64: ");
        plainToBase.setBounds(10, 15, 800, 15);
        jFrame.add(plainToBase);

        //"Encode plain text to Base64" text input area
        JTextArea plainToBaseInputArea = new JTextArea();
        plainToBaseInputArea.setBounds(10, 40, 580, 300);
        plainToBaseInputArea.setLineWrap(true);
        jFrame.add(plainToBaseInputArea);

        //"Encode plain text to Base64" text output area
        JTextArea plainToBaseOutputArea = new JTextArea();
        plainToBaseOutputArea.setBounds(696, 40, 580, 300);
        plainToBaseOutputArea.setLineWrap(true);
        jFrame.add(plainToBaseOutputArea);

        //"Encode" button
        JButton plain2base = new JButton("ENCODE");
        plain2base.setBounds(600, 165, 85, 30);
        plain2base.addActionListener(new ActionListener() {
            //this ActionListener grabs the text in the input area and passes it to the encoder method.
            //once encoded, previous text is cleared from the output area, and the Base64 encoded text is appended.
            public void actionPerformed(ActionEvent e) {
                String plainText = plainToBaseInputArea.getText();
                plainToBaseOutputArea.setText(null);
                plainToBaseOutputArea.append(Converter.toBase64(plainText));
            }
        });
        jFrame.add(plain2base);

        //Base64 to plain text section ---------------------------------------------------------------------------------

        //"Decode Base64 to plain text" text label
        JLabel baseToPlain = new JLabel("Decode Base64 to plain text: ");
        baseToPlain.setBounds(10, 370, 800, 15);
        jFrame.add(baseToPlain);

        //"Decode Base64 to plain text" text input area
        JTextArea baseToPlainInputArea = new JTextArea();
        baseToPlainInputArea.setBounds(10, 400, 580, 300);
        baseToPlainInputArea.setLineWrap(true);
        jFrame.add(baseToPlainInputArea);

        //"Decode Base64 to plain text" text output area
        JTextArea baseToPlainOutputArea = new JTextArea();
        baseToPlainOutputArea.setBounds(696, 400, 580, 300);
        baseToPlainOutputArea.setLineWrap(true);
        jFrame.add(baseToPlainOutputArea);

        //"Decode" button
        JButton base2plain = new JButton("DECODE");
        base2plain.setBounds(600, 545, 85, 30);
        base2plain.addActionListener(new ActionListener() {
            //this ActionListener grabs the text in the input area and passes it to the decoder method.
            //once decoded, previous text is cleared from the output area, and the decoded text is appended.
            public void actionPerformed(ActionEvent e) {
                String baseText = baseToPlainInputArea.getText();
                baseToPlainOutputArea.setText(null);
                baseToPlainOutputArea.append(Converter.toPlainText(baseText));
            }
        });
        jFrame.add(base2plain);

        //Displays the GUI
        jFrame.setVisible(true);

    }

}
