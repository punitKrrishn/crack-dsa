package Stringss;

public class SortTheSentence {
    public static void main(String[] args) {
        String sentence = "boy4 i1 good5 am2 a3";
        String sortedSentence = sortSentence(sentence);
        System.out.println(sortedSentence); // Output: "i am a good boy"
    }

    private static String sortSentence(String sentence) {

        String[] words = sentence.split(" ");
        String[] sortedWords = new String[words.length];

        for(String word : words) {
            int position = word.charAt(word.length()-1)-'0';
            String actualWord = word.substring(0,word.length()-1);
            sortedWords[position-1] = actualWord;
        }
        return String.join(" ", sortedWords);

    }
}
