import by.gsu.mslab.Paragraph;
import by.gsu.mslab.Sentence;
import by.gsu.mslab.Word;
import by.gsu.mslab.WordComparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;
        WordComparator wc = new WordComparator();
        List<Paragraph> paragraphs = new ArrayList<>();
        List<Sentence> sentences = new ArrayList<>();
        List<Word> words = new ArrayList<>();
        List<Word> startVowels = new ArrayList<>();
        try{
            sc = new Scanner(new File("src/in.txt"));
            while(sc.hasNextLine()){
                Paragraph p = new Paragraph();
                String line = sc.nextLine().trim();
                p.setParagraph(line);
                if(!line.isEmpty())
                    paragraphs.add(p);
            }
            for(Paragraph p: paragraphs){
                p.splitParagraph();
               for(Sentence s: p.getSentences()){
                   s.splitSentence();
                    sentences.add(s);
                    for(Word w: s.getWords()){
                        if(!w.getWord().equals("")){
                            words.add(w);
                        }
                    }
                }
            }

            System.out.println("Sorted list of words:");
            System.out.println("------------");
            for(Word w: words) {
                w.getWord().toLowerCase();
                if (w.getWord().matches("^([aeiouy]).*")) {
                    startVowels.add(w);
                    }
                }

            Set<Word> sortedWords = new TreeSet<>(wc);
            sortedWords.addAll(startVowels);
            for (Word w: sortedWords){
                System.out.println(w.getWord());
            }

        }catch(FileNotFoundException e){
            System.err.println("File not founded");
        }finally{
            if(sc!=null)
                sc.close();
        }
    }
}
