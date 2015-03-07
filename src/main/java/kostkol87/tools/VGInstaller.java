package kostkol87.tools;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Konstantin on 07.03.2015.
 */
public class VGInstaller {
    public static void install(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {

            Path target = Paths.get(fileChooser.getCurrentDirectory().getAbsolutePath() + "/VirtualGamepad.exe");
            Path source = Paths.get(new File("outer_src/executable/VirtualGamepadBeta").getAbsolutePath());

            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                Desktop.getDesktop().open(new File(String.valueOf(target)));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }


    }
}
