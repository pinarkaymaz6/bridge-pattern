package edu.tum.cs.i1.pse;

public class EnterpriseEncryption extends Encryption {
    public EnterpriseEncryption() {
        imp= new Caesar();
    }

    @Override
    public String encrypt(String word, Object key) {
        if(((byte)key) < 10){
            throw new RuntimeException("RuntimeException: Error in EnterpriseEncryption");
        }
        String[] words = word.split("\\s+");
        String result="";
        for(String w:words){
            result+=imp.encryptWord(w,((byte)key)) +" ";
        }
        return result.trim();

    }

    @Override
    public String decrypt(String word, Object key) {
        String[] words = word.split("\\s+");
        String result="";
        for(String w:words){
            result+=imp.decryptWord(w,((byte)key)) + " ";
        }
        return result.trim();
    }


}
