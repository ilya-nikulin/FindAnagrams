package ru.simpls.findanagrams;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ilya on 11/19/2014.
 */
public class Result{
    private Map<String, ResultLine> sortedKeys = new HashMap<String, ResultLine>();
    private List<ResultLine> lines = new ArrayList<ResultLine>();
    //////////////////////////////////////
    public void write(Writer bw) throws IOException {
        for (ResultLine line: getLines()){
            line.write(bw);
        }
    }
    public void processWord(String word, boolean add, int startLine){
        String sortedWord = sortWord(word);
        ResultLine line = getAnagram(sortedWord, word);
        if (line!=null) {
            int linePos = lines.indexOf(line);
            if (linePos>=startLine) {
                line.add(word);
            }
        }
        else if (add){
            addFirstWord(sortedWord, word);
        }
    }
    private ResultLine getAnagram(String sortedWord, String word){
        ResultLine resultLine = sortedKeys.get(sortedWord);
        if (resultLine==null) return null;
        return resultLine;
    }
    //////////////////////////////////////////////////
    private void addFirstWord(String sortedWord, String word){
        ResultLine newLine = new ResultLine(word);
        getLines().add(newLine);
        sortedKeys.put(sortedWord,newLine);
    }
    ////////////////////////////////////////////////
    private static String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sortedWord = String.valueOf(chars);
        return sortedWord;
    }
    ////////////////////////////////////////////////
    public void deleteExtraWords(){
        for (int i=0; i< getLines().size(); i++){
            if (getLines().get(i).getLine().size()<2){
                getLines().remove(i);
                i--;
            }
        }
    }

    public List<ResultLine> getLines() {
        return lines;
    }

    public void setLines(List<ResultLine> lines) {
        this.lines = lines;
    }
}
