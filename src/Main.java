import com.formdev.flatlaf.FlatLightLaf;
import ma.ilisi2.library.ui.BookCreate;
import ma.ilisi2.library.ui.BookList;
import ma.ilisi2.library.ui.Home;

import javax.swing.*;
import java.awt.*;

public class Main {
public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
//            BookCreate bookUI = new BookCreate();
//            var bookUI = new BookList();
            var bookUI = new Home();
            //Set default style
            bookUI.setMinimumSize(new Dimension(1024, 900));
            bookUI.pack();
            bookUI.setLocationRelativeTo(null);
            bookUI.setVisible(true);
        }
    });
}
}

