package kostkol87.tools;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Konstantin on 07.03.2015.
 */
public class FileUtil {
    public static File[] getFileList(String path){
        File[] fileList = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String str = pathname.getName().toLowerCase();
                if (str.endsWith(".vgp"))return true;
                else return false;
            }
        });
        return fileList;
    }
}
