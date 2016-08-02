/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei Borovsky <andrei.borovsky@gmail.com>
 */

import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScriptReader {
        public static ArrayList<String> readScript(String path, Charset encoding)
        {
            String s = "";
            try {
                byte[] encoded = Files.readAllBytes(Paths.get(path));
                s = new String(encoded, encoding);
            } catch(Throwable t) {
                
            }
            return tokenize(s);
        }

    public static ArrayList<String> tokenize(String s) {
        String tokens[] = s.split("\\s");
        ArrayList<String> v = new ArrayList();
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].isEmpty())
                v.add(tokens[i]);
        }
        return v;
    }
}
