package edu.tum.cs.i1.pse;

public class MilitaryEncryption extends Encryption {

    public MilitaryEncryption(){
        imp= new AES();
    }
    @Override
    public String encrypt(String word, Object key) {
        String[] words = word.split("\\s+");
        String result="";
        for(String w:words){
            if(w.trim()!="") {
                result += imp.encryptWord(w, key.toString()) + " ";
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
                result += imp.decryptWord(w, key.toString()) + " ";
            }
        }
        return result.trim();

    }
}
