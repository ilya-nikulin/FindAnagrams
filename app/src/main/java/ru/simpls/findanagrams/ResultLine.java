package ru.simpls.findanagrams;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 11/19/2014.
 */
public class ResultLine {
    private List<String> line = new ArrayList<String>();
    public ResultLine(String word){
        getLine().add(word);
    }
    public void add(String word){
        getLine().add(word);
    }
    public void write(Writer bw) throws IOException {
        if (getLine().size()<2) return;
        for (int i=0; i< getLine().size(); i++){
            bw.write(getLine().get(i));
            if (i== getLine().size()-1) bw.write("\n");
            else bw.write(", ");
        }
    }

    public List<String> getLine() {
        return line;
    }

    public void setLine(List<String> line) {
        this.line = line;
    }
}
