package com.example.generaltemplate;

import java.util.ArrayList;

public class ArrayWordSearch {
    private String[] listOfWords = {"they", "these", "though","fun","ball","soccer","fall"};
    public boolean getIsWordInArray(String word){
        for (int i=0; i< listOfWords.length;i++){
            if (listOfWords[i].equals(word)){
                return true;
            }
        }
        return false;
    }
    public int getPositonOfWord(String word){
        if (getIsWordInArray(word)){
            for (int i=0; i< listOfWords.length;i++){
                if (listOfWords[i].equals(word)){
                    return i;
                }
            }
        }
        return -1;
    }
    public ArrayList<String> getPartialWordSearchInArray(String partialWord){
        ArrayList<String> wordsWithPartialWords = new ArrayList<>();
        if (!partialWord.isEmpty()) {
            for (int i = 0; i < listOfWords.length; i++) {
                for (int j = 0; j < listOfWords[i].length() + 1 - partialWord.length(); j++) {
                    if (listOfWords[i].substring(j, j + partialWord.length()).equals(partialWord)) {
                        wordsWithPartialWords.add(listOfWords[i]);
                    }
                }
            }
        }
        return wordsWithPartialWords;
    }
}

