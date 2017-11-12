package edu.tum.cs.i1.pse;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES implements CipherBase{

    String initVector = "RandomInitVector"; // 16 bytes IV

    @Override
    public String encryptWord(String w, Object k) {
        if (w.contains(" ")) {
            throw new IllegalArgumentException("No spaces allowed!");
        }
        String result = new String();

        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(k.toString().getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(w.getBytes());

            result = Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public String decryptWord(String w, Object k) {
        if (w.contains(" ")) {
            throw new IllegalArgumentException("No spaces allowed!");
        }
        String result = new String();

        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(k.toString().getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(w));

            result = new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
