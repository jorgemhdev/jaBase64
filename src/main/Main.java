/**
 * @Author Jorge Martinez (nothing4free)
 * Main class containing the public static void method. It creates a Frame object containing the GUI.
 * All text input and output is handled by the GUI (package "main/gui")
 * All text encoding/decoding is handled by the package "main/core"
 */

//includes the class in the package "main" and imports the Frame class from "main/gui"
package main;
import main.gui.Frame;

//Main class containing the Main method that creates a Frame object containing the GUI
public class Main {
    public static void main(String[] args){
        Frame gui = new Frame();
    }
}
