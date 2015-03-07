package kostkol87.tools;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Created by Konstantin on 07.03.2015.
 */
public class PresetAdd {
    File tmp;
    static File[] selectedFiles;
    public static File[] add() {
        JFileChooser jfc = new JFileChooser();
        jfc.setMultiSelectionEnabled(true);

        if (jfc.showOpenDialog(jfc) == JFileChooser.APPROVE_OPTION) {
            selectedFiles = jfc.getSelectedFiles();
        }
        String targetStr = "outer_src/presets";
        Path target;
        Path source;

        File tmp=null;

        try {
            for(File addedFile: selectedFiles){
                if(addedFile.getName().endsWith(".vgp")) {
                    tmp = new File(targetStr + "/" + addedFile.getName());
                    Files.copy(addedFile.toPath(), tmp.toPath());
                }
            }
        } catch (FileAlreadyExistsException e1) {
            JFrame alert = new JFrame("some probmels =(");
            JTextArea errText = new JTextArea("one of new presets has the same name as preset in the list! Change the name and try again =) sorry..."+
                    "\n P.S.: look at " + tmp.getName());
            alert.setSize(300,100);
            alert.add(errText);
            alert.setLocationRelativeTo(null);
            alert.setVisible(true);

            System.out.println("file is exists!");

        } catch (IOException exp){
            exp.printStackTrace();
        }
        finally {

        }
        return selectedFiles;
    }
}
