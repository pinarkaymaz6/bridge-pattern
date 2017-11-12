package edu.tum.cs.i1.pse;

public class PersonalEncryption extends Encryption{

    public PersonalEncryption() {
        imp=new Transpose();
    }

    @Override
    public String encrypt(String word, Object key) {
        String[] words = word.split("\\s+");
        String result="";
        for(String w:words){
            if(w.trim()!="") {
                result += imp.encryptWord(w, ((byte)key)) + " ";
            }
        }
        return result.trim();
    }

    @Override
    public String decrypt(String word, Object key) {
        String[] words = word.split("\\s+");
        String result="";
        for(String w:words){
            if(w.trim()!="") {
                result += imp.decryptWord(w, ((byte)key)) + " ";
            }
        }
        return result.trim();

    }

}
