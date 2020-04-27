package isproject;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class ParseRsaKeys {
   public static void main(String args[]) throws Exception{
	   //Creating a Signature object
      Signature sign = Signature.getInstance("SHA256withRSA");
      
      //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      //Initializing the key pair generator
      keyPairGen.initialize(2048);
      
      //Generate the pair of keys
      KeyPair pair = keyPairGen.generateKeyPair();   
      
      //Getting the public key from the key pair
      PublicKey publicKey = pair.getPublic();
       System.out.println("Before:"+publicKey.getEncoded().length);
       String s = Base64.getEncoder().encodeToString(publicKey.getEncoded());
       System.out.println("After:"+Base64.getDecoder().decode(s).length);
      publicKey = loadPublicKey(s);
      //Creating a Cipher object
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

      //Initializing a Cipher object
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
      
      //Add data to the cipher
      byte[] input = "Welcome to Tutorialspoint and this is muzamil nawaz ajkldajdljkadj ajkdljakldja lajkkaljd adklajsd asd ksdjaksjd akljsd asdkasd akldjakdjkalsd adjakld jalkdjasdjkla dad klajd adjlkad ad asdkja daldjlad adjkadlasdj adlkjad adj".getBytes();	  
      cipher.update(input);
	  
      //encrypting the data
      byte[] cipherText = cipher.doFinal();	
       System.out.println("Before:"+pair.getPrivate().getEncoded().length);
      PrivateKey pk = loadPrivateKey(Base64.getEncoder().encodeToString(pair.getPrivate().getEncoded()));
       System.out.println("After:"+pk.getEncoded().length);
       s = Base64.getEncoder().encodeToString(pk.getEncoded());
       System.out.println(Base64.getDecoder().decode(s));
      //Initializing the same cipher for decryption
      cipher.init(Cipher.DECRYPT_MODE, pk);
      
      //Decrypting the text
      byte[] decipheredText = cipher.doFinal(cipherText);
      System.out.println(new String(decipheredText));
   }
    public static PrivateKey loadPrivateKey(String base64PrivateKey){
        PrivateKey privateKey = null;
        try{
            System.out.println(base64PrivateKey);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
            return privateKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }
    public static PublicKey loadPublicKey(String base64PublicKey){
        PublicKey publicKey = null;
        try{
            
            System.out.println(base64PublicKey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }
}