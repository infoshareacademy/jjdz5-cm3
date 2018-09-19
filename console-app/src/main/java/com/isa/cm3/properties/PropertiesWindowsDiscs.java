package com.isa.cm3.properties;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PropertiesWindowsDiscs {


    /*
     * Metoda sprawdza dostępne dyski w systemie Windows
     * @return File[] z dyskami bez CD_ROM
     **/


    public File[] windowsDiscs() {
        File[] paths = File.listRoots();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        List<File> list = new ArrayList<>();

        for (int i = 0; i < paths.length; i++) {

            if (fsv.getSystemTypeDescription(paths[i]).contains("CD")) {
                continue;
            } else {
                list.add(paths[i]);
            }
        }

        File[] pathsNoCd = new File[list.size()];
        for (int i = 0; i < list.size(); i++) {
            pathsNoCd[i] = list.get(i);
        }
        return pathsNoCd;
    }
}
