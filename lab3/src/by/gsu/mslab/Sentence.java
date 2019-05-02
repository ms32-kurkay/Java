package by.gsu.mslab;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private String sentence;
    private List<Word> words = new ArrayList<>();

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public void splitSentence(){
        String[] w = sentence.split("[^(\\w)]|\\,|\\*|\\(|\\)");
        for(int i = 0; i < w.length; i++){
            Word word = new Word();
            word.setWord(w[i]);
            words.add(word);
        }
    }
}
