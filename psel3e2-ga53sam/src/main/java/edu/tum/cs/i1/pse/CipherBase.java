package edu.tum.cs.i1.pse;

public interface CipherBase {

    public String encryptWord(String w, Object k);

    public String decryptWord(String w, Object k);

}
