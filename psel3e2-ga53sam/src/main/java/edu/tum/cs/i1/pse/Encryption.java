package edu.tum.cs.i1.pse;

public abstract class Encryption{
    protected CipherBase imp;

    public abstract String encrypt(String word, Object key);

    public abstract String decrypt(String word, Object key);
}
