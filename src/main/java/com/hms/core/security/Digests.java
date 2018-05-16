package com.hms.core.security;

import org.apache.commons.lang3.Validate;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Digests {
    private static final String SHA1 = "SHA-1";
    private static final String MD5 = "MD5";

    private static SecureRandom random = new SecureRandom();

    public static byte[] sha1(byte[] input){
        return digest(input, SHA1, null,1);
    }

    public static byte[] sha1(byte[] input,byte[] salts){
        return digest(input,SHA1,salts,1);
    }

    public static byte[] sha1(byte[] input,byte[] salts,int iterations){
        return digest(input,SHA1,salts,iterations);
    }

    public static byte[] MD5(byte[] input){
        return digest(input, MD5, null,1);
    }

    public static byte[] MD5(byte[] input,byte[] salts){
        return digest(input,MD5,salts,1);
    }

    public static byte[] MD5(byte[] input,byte[] salts,int iterations){
        return digest(input,MD5,salts,iterations);
    }

    private static byte[] digest(byte[] input,String algorithm,byte[] salts,int iterations){
        try{
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            if(salts !=null){
                digest.update(salts);
            }
            byte[] result = digest.digest(input);
            for(int i=1;i<iterations;i++){
                digest.reset();
                result = digest.digest(result);
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public  static byte[] generateSalt(int numBytes){
        Validate.isTrue(numBytes >0,"numByte must be a positive integer",numBytes);
        byte[] bytes = new byte[numBytes];
        random.nextBytes(bytes);
        return bytes;
    }
}
