package com.isa.cm3.delegations;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DelegationSaveToFile {

    public static List<Delegation> list = new ArrayList<>();

    public static void saveToFile (Path path, Delegation delegation){

        if (Files.notExists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Reader reader = Files.newBufferedReader(path);
            if (((BufferedReader) reader).readLine() == null){
                Writer writeOnce = Files.newBufferedWriter(path,Charset.defaultCharset());
                writeOnce.write(delegation.toString());
                writeOnce.close();
            }else {
                Writer writeOut = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.APPEND);
                ((BufferedWriter) writeOut).newLine();
                writeOut.write(delegation.toString());
                writeOut.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void saveToList (Delegation delegation){

        this.list.add(delegation);

    }

    public static List<Delegation> getList() {
        return list;
    }
}
