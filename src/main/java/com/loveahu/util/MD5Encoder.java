package com.loveahu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Encode an MD5 digest into a String.
 * <p>
 * The 128 bit MD5 hash is converted into a 32 character long String.
 * Each character of the String is the hexadecimal representation of 4 bits
 * of the digest.
 *
 * @author Remy Maucherat
 * @version $Id: MD5Encoder.java 1364451 2012-07-22 22:23:22Z markt $
 */

public final class MD5Encoder {


    private static final char[] hexadecimal =
    {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
     'a', 'b', 'c', 'd', 'e', 'f'};

    // ----------------------------------------------------- Instance Variables


    /**
     * Encodes the 128 bit (16 bytes) MD5 into a 32 character String.
     *
     * @param binaryData Array containing the digest
     * @return Encoded MD5, or null if encoding failed
     */
    public static String encode( byte[] binaryData ) {

        if (binaryData.length != 16)
            return null;

        char[] buffer = new char[32];

        for (int i=0; i<16; i++) {
            int low = binaryData[i] & 0x0f;
            int high = (binaryData[i] & 0xf0) >> 4;
            buffer[i*2] = hexadecimal[high];
            buffer[i*2 + 1] = hexadecimal[low];
        }

        return new String(buffer);

    }


    // --------------------------------------------------------- Public Methods


    public static void main(String[] args) {
    	System.out.println(md5("2976558f"));
	}

    /** 
     * MD5加密类 
     * @param str 要加密的字符串 
     * @return    加密后的字符串 
     */  
    public static String md5(String str){  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(str.getBytes());  
            byte[]byteDigest = md.digest();  
            int i;  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < byteDigest.length; offset++) {  
                i = byteDigest[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            //32位加密  
            return buf.toString();  
            // 16位的加密  
            //return buf.toString().substring(8, 24);   
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        }  
          
    }  

    
    /**
     * @deprecated  Will be made private in Tomcat 8.0.x
     */
    @Deprecated
    public MD5Encoder() {
        // NOOP
    }
}