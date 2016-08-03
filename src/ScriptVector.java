/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei Borovsky <andrei.borovsky@gmail.com>
 */

import java.nio.charset.Charset;
import java.util.ArrayList;

public class ScriptVector {
    public ArrayList<Note> notes = new ArrayList();
    public int pos;
    public void start()
    {
        pos = -1;
    }
    public void load()
    {
        start();
        notes.clear();
        String s = "C#4 D4 Eb4 F4 G4 C3 F#4    F#3";
        ArrayList<String> v1 = ScriptReader.tokenize(s);
        notes = ScriptNote.getNotes(v1);
    }
    public void load(String path)
    {
        pos = -1;
        notes.clear();
        ArrayList<String> v1 = ScriptReader.readScript(path, Charset.defaultCharset());
        notes = ScriptNote.getNotes(v1);
    }
    public int index()
    {
        pos++;
        return (pos)%notes.size();
    }
    public static final ScriptVector INSTANCE = new ScriptVector();
}
