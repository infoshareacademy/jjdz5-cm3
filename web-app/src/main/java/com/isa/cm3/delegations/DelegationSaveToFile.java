package com.isa.cm3.delegations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DelegationSaveToFile {

    public void saveToFile (Delegation delegation){


        Path path = Paths.get(System.getProperty("user.dir"),"delegations.txt");


        try {
            Writer writeOut = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.APPEND);
            ((BufferedWriter) writeOut).newLine();
            writeOut.write(delegation.toString());
            writeOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
