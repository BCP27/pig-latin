package edu.htc.piglatin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {

    public static String translateToPigLatin(String sentence)
    {

        String[] divider = sentence.split("\\s");
        String translatedSentence = "";
        for (int i = 0; i < divider.length; i++)
        {
            translatedSentence = translatedSentence + wordFromPigLatin(divider[i]) + " ";
        }
        return translatedSentence;
    }

    /*public static String translateFromPigLatin(String sentence) {

    }

    protected static String wordToPigLatin(String word)
    {

    }*/

    protected static String wordFromPigLatin(String word)
    {
        int a = 0;
        int b = 1;
        Pattern vowelSearch = Pattern.compile("[aeiouyAEIOUY]");
        Pattern punctuationSearch = Pattern.compile("[,:;\\.]");
        String firstLetter = word.substring(a,b);
        String lastLetter = word.substring(word.length() - 1, word.length());
        Matcher matchVowel = vowelSearch.matcher(firstLetter);
        Matcher matchPunctuation = punctuationSearch.matcher(lastLetter);
        String punctuation = "";
        if (matchPunctuation.matches())
        {
            punctuation = word.substring(word.length() - 1, word.length());
            word = word.substring(0, word.length() - 1);
        }
        if (matchVowel.matches())
        {
            word = word + "'ay";
        }
        else
        {
            while (!matchVowel.matches())
            {
                a = a + 1;
                b = b + 1;
                firstLetter = word.substring(a,b);
                matchVowel = vowelSearch.matcher(firstLetter);
            }
            int vowel = word.indexOf(firstLetter);
            String leadCharacters = word.substring(0, vowel);
            word = word.substring(vowel);
            word = word + "'" + leadCharacters + "ay";
        }
        word = word + punctuation;
        return word;
    }


}
