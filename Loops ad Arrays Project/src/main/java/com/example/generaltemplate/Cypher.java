package com.example.generaltemplate;

import java.security.AlgorithmParameterGenerator;
import java.util.ArrayList;

public class Cypher {
    String[] alphabet={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public ArrayList<String> getCortezPossibilities(){
        ArrayList<String> cortezPossibilities = new ArrayList<>();
        for (int i=0; i<alphabet.length;i++){
            cortezPossibilities.add(getCaesar("cortez",i));
        }
        return cortezPossibilities;
    }
    /*
        precondition: input String to encode and integer affect and alphabet list
        return encoded Caesar
    */
    public String getCaesar(String inptString,int numAffect){
        for (int i =0; i<inptString.length();i++){
            boolean changed=false;
            if (!Character.isUpperCase(inptString.charAt(i))){
                for (int j=0;j<alphabet.length;j++){
                    if (inptString.substring(i,i+1).equals(alphabet[j])&&!changed){
                        if (j+numAffect>alphabet.length-1){
                            inptString = inptString.substring(0, i) + alphabet[j+numAffect-alphabet.length] + inptString.substring(i + 1);
                        }else if(j+numAffect<0){
                            inptString = inptString.substring(0, i) + alphabet[j+numAffect+alphabet.length] + inptString.substring(i + 1);
                        }else {
                            inptString = inptString.substring(0, i) + alphabet[j + numAffect] + inptString.substring(i + 1);
                        }
                        changed = true;
                    }
                }
            }else{
                for (int j=0;j<alphabet.length;j++){
                    if (inptString.substring(i,i+1).equals(alphabet[j].toUpperCase())&&!changed){
                        if (j+numAffect>alphabet.length-1){
                            inptString = inptString.substring(0, i) + alphabet[j+numAffect-alphabet.length].toUpperCase() + inptString.substring(i + 1);
                        }else if(j+numAffect<0){
                            inptString = inptString.substring(0, i) + alphabet[j+numAffect+alphabet.length].toUpperCase() + inptString.substring(i + 1);
                        }else {
                            inptString = inptString.substring(0, i) + alphabet[j + numAffect].toUpperCase() + inptString.substring(i + 1);
                        }
                        changed = true;
                    }
                }
            }

        }
        return inptString;
    }
    /*
    precondition: String to encode/decode with Atbash Cipher and alphabet list
    return encoded/decoded atbash cipher
     */
    public String atbashCipher(String inptString){
        for (int i =0; i<inptString.length();i++){
            boolean changed=false;
            if (!Character.isUpperCase(inptString.charAt(i))){
                for (int j=0;j<alphabet.length;j++){
                    if (inptString.substring(i,i+1).equals(alphabet[j])&&!changed){
                        inptString=inptString.substring(0, i) + alphabet[alphabet.length-1-j] + inptString.substring(i + 1);
                        changed=true;
                    }
                }
            }else{
                for (int j=0;j<alphabet.length;j++){
                    if (inptString.substring(i,i+1).equals(alphabet[j].toUpperCase())&&!changed){
                        inptString=inptString.substring(0, i) + alphabet[alphabet.length-1-j].toUpperCase() + inptString.substring(i + 1);
                        changed=true;
                    }
                }
            }

        }
        return inptString;
    }

}
