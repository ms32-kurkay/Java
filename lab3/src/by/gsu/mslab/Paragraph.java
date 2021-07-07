package by.gsu.mslab;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {
    private String paragraph;
    private List<Sentence> sentences = new ArrayList<>();

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void splitParagraph(){
       String[] s = paragraph.split("\\.\\s|\\!\\s|\\.{3}|\\?\\s|\\?!\\s|\\!{3}|\\?{3}|\\:\\s{2,}");
        for(int i = 0; i < s.length; i++){
            if(!s[i].equals("}")){
                Sentence sentence = new Sentence();
                sentence.setSentence(s[i]);
                sentences.add(sentence);}
        }
    }
}
