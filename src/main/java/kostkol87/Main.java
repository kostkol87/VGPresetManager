package kostkol87;



import kostkol87.GUI.MainFrame;

import javax.swing.*;

/**
 * Created by Konstantin on 07.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                new MainFrame();
            }
        });
    }
}
