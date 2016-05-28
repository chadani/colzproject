/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author chadani
 */
public class PasswordEncryption {
    public static String encryptPassword(String inputValue) {
        String salt="admin123!@#";
        String inputValuewithsalt=inputValue+salt;
        String encryptedValue=null;
        if(null==inputValue) return null;
        try{
            MessageDigest digest=MessageDigest.getInstance("MD5");//messagedigest ko obj banara tesma encryption algo MD5 set gareko
            digest.update(inputValuewithsalt.getBytes(),0,inputValuewithsalt.length());//inputValuewithsalt lai bype ma convert garera point 0 dekhi tesko length sama update gareko
            encryptedValue=new BigInteger(1,digest.digest()).toString(16);//encryptedValue lai 16 bit hexa ma convert gareko
            
        }catch(Exception e){
            System.out.println("not converted");
        }
        return encryptedValue;
        
        
        
        
    }
}
