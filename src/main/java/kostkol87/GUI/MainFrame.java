package kostkol87.GUI;


import kostkol87.tools.FileUtil;
import kostkol87.tools.PresetAdd;
import kostkol87.tools.VGInstaller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;

/**
 * Created by Konstantin on 07.03.2015.
 */
public class MainFrame extends JFrame {

    public void frameInit() {

        //Main frame
        JFrame mainFrame = new JFrame("presets manager");
        JPanel mainPanel = new JPanel();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.X_AXIS));
        mainFrame.add(bottomPanel);

        //JList model
        final DefaultListModel<File> model = new DefaultListModel<File>();
        final File[] fileList = FileUtil.getFileList("outer_src/presets");
        for (File currentFile : fileList){
            model.addElement(currentFile);
        }


//        //list of presets
        final JList <File> list = new JList(model);
        list.setFixedCellHeight(30);
        list.setSize(500,500);
        list.setFont(list.getFont().deriveFont(18.0f));
        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.setVisible(true);
        mainPanel.add(list);

        //add to list button


        JButton addPreset = new JButton("add preset");
        addPreset.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isInList = false;
                File[] newPresets = PresetAdd.add();
                for (File currFile : newPresets){
                    for(File x : fileList){
                        if (x.getName().equals(currFile.getName()))
                        isInList = true;
                    }
                    if (currFile.getName().endsWith(".vgp") &&  !isInList)
                    model.addElement(currFile);
                }
            }
        });
        mainPanel.add(addPreset);

        //Install button
        final JButton installButton = new JButton(" install VirtualGamepad");
        ImageIcon vgpi = createIcon("kostkol87/GUI/img/ico_123_exe0001.png");
        installButton.setIcon(vgpi);
        installButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VGInstaller.install();
            }
        });
        installButton.setBounds(800, 750, 850, 300);
        mainPanel.add(installButton);
//        list.


        //draw frames
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setPreferredSize(new Dimension(640, 480));
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    protected static ImageIcon createIcon(String path) {
        URL imgURL = MainFrame.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }
}
