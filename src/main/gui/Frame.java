package main.gui;
import main.core.Converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    private static final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int screenWidth = (int) screen.getWidth();
    private static final int screenHeight = (int) screen.getHeight();

    private static final int FRAME_WIDTH = 1300;
    private static final int FRAME_HEIGHT = 800;

    private static final int widthOffset = FRAME_WIDTH / 2;
    private static final int heightOffset = FRAME_HEIGHT / 2;

    public Frame(){

        //FRAME SETUP
        JFrame jFrame = new JFrame();
        jFrame.setLayout(null);
        jFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        jFrame.setLocation((screenWidth /2 - widthOffset), (screenHeight /2 - heightOffset));
        jFrame.setTitle("B64-EncodeDecode v0.1 [DEV_PREVIEW]");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        //ABOUT BUTTON
        JButton about = new JButton("About");
        about.setBounds(1198, 5, 80, 30);
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "B64-EncodeDecode v0.1\nAn Open-Source, Java-Based Base64 Encoder and Decoder.\nMade by Jorge Martinez (github.com/nothing4free)");
            }
        });
        jFrame.add(about);

        //PLAIN TO BASE GUI -----------------------------------------------------------------------------------------

        //PLAIN TO BASE TEXT LABEL
        JLabel plainToBase = new JLabel("Encode plain text to Base64: ");
        plainToBase.setBounds(10, 15, 800, 15);
        jFrame.add(plainToBase);

        //PLAIN TO BASE INPUT TEXT AREA
        JTextArea plainToBaseInputArea = new JTextArea();
        plainToBaseInputArea.setBounds(10, 40, 580, 300);
        plainToBaseInputArea.setLineWrap(true);
        jFrame.add(plainToBaseInputArea);

        //PLAIN TO BASE OUTPUT TEXT AREA
        JTextArea plainToBaseOutputArea = new JTextArea();
        plainToBaseOutputArea.setBounds(696, 40, 580, 300);
        plainToBaseOutputArea.setLineWrap(true);
        jFrame.add(plainToBaseOutputArea);

        //PLAIN TO BASE BUTTON
        JButton plain2base = new JButton("ENCODE");
        plain2base.setBounds(600, 165, 85, 30);
        plain2base.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String plainText = plainToBaseInputArea.getText();
                plainToBaseOutputArea.setText(null);
                plainToBaseOutputArea.append(Converter.toBase64(plainText));
            }
        });
        jFrame.add(plain2base);

        //BASE TO PLAIN GUI -----------------------------------------------------------------------------------------

        //BASE TO PLAIN TEXT LABEL
        JLabel baseToPlain = new JLabel("Decode Base64 to plain text: ");
        baseToPlain.setBounds(10, 370, 800, 15);
        jFrame.add(baseToPlain);

        //BASE TO PLAIN INPUT TEXT AREA
        JTextArea baseToPlainInputArea = new JTextArea();
        baseToPlainInputArea.setBounds(10, 400, 580, 300);
        baseToPlainInputArea.setLineWrap(true);
        jFrame.add(baseToPlainInputArea);

        //BASE TO PLAIN OUTPUT TEXT AREA
        JTextArea baseToPlainOutputArea = new JTextArea();
        baseToPlainOutputArea.setBounds(696, 400, 580, 300);
        baseToPlainOutputArea.setLineWrap(true);
        jFrame.add(baseToPlainOutputArea);

        //BASE TO PLAIN BUTTON
        JButton base2plain = new JButton("DECODE");
        base2plain.setBounds(600, 545, 85, 30);
        base2plain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String baseText = baseToPlainInputArea.getText();
                baseToPlainOutputArea.setText(null);
                baseToPlainOutputArea.append(Converter.toPlainText(baseText));
            }
        });
        jFrame.add(base2plain);

        //MAKE FRAME VISIBLE
        jFrame.setVisible(true);

    }

}
