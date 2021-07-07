package by.gsu.mslab;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {
    private final static String CONSONANTS = "bcdfghjklmnpqrstvxzwy";

    public static boolean isConsonant(Character ch) {
        return CONSONANTS.indexOf(Character.toLowerCase(ch)) > -1;
    }

    private Character firstConsonant(String string) {
        for (int i = 0; i < string.length(); ++i)
            if (isConsonant(string.charAt(i)))
                return string.charAt(i);
        return Character.MIN_VALUE;
    }

    @Override
    public int compare(Word o1, Word o2) {
        Character consonant1 = firstConsonant(o1.getWord());
        Character consonant2 = firstConsonant(o2.getWord());
        return consonant1.compareTo(consonant2);
    }
}
