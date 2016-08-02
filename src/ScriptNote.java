/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei Borovsky <andrei.borovsky@gmail.com>
 */

import java.util.HashMap;
import java.util.ArrayList;


public class ScriptNote {
    public ScriptNote()
    {
        KeysPitches = new HashMap();
        KeysPitches.put("C", 0);
        KeysPitches.put("C#", 1);
        KeysPitches.put("Db", 1);
        KeysPitches.put("D", 2);
        KeysPitches.put("D#", 3);
        KeysPitches.put("Eb", 3);
        KeysPitches.put("E", 4);
        KeysPitches.put("E#", 5);
        KeysPitches.put("Fb", 4);
        KeysPitches.put("F", 5);
        KeysPitches.put("F#", 6);
        KeysPitches.put("Gb", 6);
        KeysPitches.put("G", 7);
        KeysPitches.put("G#", 8);
        KeysPitches.put("Ab", 8);
        KeysPitches.put("A", 9);
        KeysPitches.put("A#", 10);
        KeysPitches.put("Bb", 10);
        KeysPitches.put("B", 11);
        
    }
    public void parse(String s)
    {
        String note = "";
        int i = 0;
        for (; i < s.length(); i++) {
           char ch = s.charAt(i);
           if ((ch < '0')||(ch > '9'))
               note += ch;
           else
               break;
        }
        if ((0 == note.length())||(!KeysPitches.containsKey(note))) {
            pitch = 0;
            return;
        }
        if (note.length() == 1)
            alteration = 0;
        else
            if (note.charAt(1) == '#')
                alteration = 1;
            else
                alteration = -1;
        octave = Integer.parseInt(Character.toString(s.charAt(i)));
        if (octave > 8) {
            pitch = 0;
            return;
        }
        pitch = (octave + 1)*12 + KeysPitches.get(note);
    }
    
    boolean secondRow()
    {
        return octave < 4;
    }
    
    int getAlteration()
    {
        return alteration;
    }
    
    public Note getNote()
    {
        //NoteGenerator NG = new NoteGenerator(ap, );
        Note result = new Note(0,1,10,pitch,0,false,0);
        result.addLinesYpos =0;
        result.addLinesNumber = 0;
        result.altType = getAlteration();
        result.ypos = 0;
        result.secondRow = secondRow();
        result.highlight = false;
     
        return result;
    }
    
    public static ArrayList<Note> getNotes(ArrayList<String> tokens)
    {
        ScriptNote sn = new ScriptNote();
        ArrayList<Note> res = new ArrayList<Note>();
        for (String token : tokens) {
            sn.parse(token);
            res.add(sn.getNote());
        }
        return res;
    }
    
    HashMap<String, Integer> KeysPitches;
    Integer pitch;
    Integer octave;
    Integer alteration;
}
