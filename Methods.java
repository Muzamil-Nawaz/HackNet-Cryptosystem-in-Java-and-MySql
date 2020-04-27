/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isproject;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import javax.mail.Transport;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Methods {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static PrivateKey privateKey;
    private static PublicKey publicKey;
    public static Cipher cipher = null;
    public static void initKeys(){
        try {
          
            Signature sign = Signature.getInstance("SHA256withRSA");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            setPublic(keyPair.getPublic());
            setPrivate(keyPair.getPrivate());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void setPublic(PublicKey pk){
      
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            publicKey = pk;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void setPrivate(PrivateKey pk){
        privateKey =pk;
    }
    public static PublicKey getPublic(){
        return publicKey;
    }
    public static PrivateKey getPrivate(){
        return privateKey;
    }
    public static void sendEmail(String publicKey , String privateKey,String email){
        try{
            String host ="smtp.gmail.com" ;
            String user = "your-mail";
            String pass = "your-pass";
            String to = email;
            String from = "your-email";
            String subject = "Email Sent By HackNet Administration";
            String messageText = "Welcome to HackNet Encryption System,\nYou have successfully registered for using our magnificent features.\n\nHope you enjoy secure communication through our services.\nRegards,\nHackNet Team.";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from,pass);
            }});
           // mailSession.setDebug(sessionDebug);
            MimeMessage msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            msg.setSubject(subject); 
            msg.setSentDate(new Date());
            msg.setText(messageText);
            Transport.send(msg);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
    public static void sendEmail2(String secretkey,String email){
        try{
            String host ="smtp.gmail.com" ;
            String user = "your_mail";
            String pass = "your_pass";
            String to = email;
            String from = "your_mail";
            String subject = "Email by HackNet CryptoSystem";
            String messageText = "Hello Dear user,\nWe hope you are doing well,\n\""+secretkey+"\" this is secret key for your symmetric decryption which is sent by "+Login.user+".\nHave a secure communication.\nRegards,\nHackNet Team";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from,pass);
            }});
           // mailSession.setDebug(sessionDebug);
            MimeMessage msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            msg.setSubject(subject); 
            msg.setSentDate(new Date());
            msg.setText(messageText);
            Transport.send(msg);
            System.out.println("message send successfully");
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) throws GeneralSecurityException {
 
    final String secretKey = "ssshhhhhhhhhhh!!!!";
     
    String originalString = "howtodoinjava.com";
    String encryptedString = encrypt(originalString, secretKey) ;
    String decryptedString = decrypt(encryptedString, secretKey) ;
     
    System.out.println(originalString);
    System.out.println(encryptedString);
    System.out.println(decryptedString);
}
    
   
        private static String encryptMessage(String plainText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
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
  public static PrivateKey loadPrivateKey(String base64PrivateKey){
        PrivateKey privateKey = null;
        try{
            
            System.out.println(base64PrivateKey);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
            Arrays.fill(base64PrivateKey.getBytes(), (byte) 0);
            return privateKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }
    public static String convertPublicToString(PublicKey pk){
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());   
    }
    public static String convertPrivateToString(PrivateKey pk){
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }
    public static String encrypt(byte []data){
	
        try {
            cipher.init(Cipher.ENCRYPT_MODE,getPublic());
            cipher.update(data);
            return Base64.getEncoder().encodeToString(cipher.doFinal());
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            JOptionPane.showMessageDialog(null, "You might have used wrong key, please check out the process and try again.");
        }
        return null;
    }
    public static String decrypt(byte[] data) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, getPrivate());
            return new String(cipher.doFinal(data));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            JOptionPane.showMessageDialog(null, "You might have used wrong key, please check out the process and try again.");
        }
        return null;
    }
     public static String byteToString(byte [] data){
         return Base64.getEncoder().encodeToString(data);
     }
     public static byte[] stringToByte(String d){
         return Base64.getDecoder().decode(d);
     }
     
     public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
            System.out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret){
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (BadPaddingException | InvalidKeyException e) 
        {
            JOptionPane.showMessageDialog(null, "You might have used wrong key, please check out the process and try again.");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException ex) {
            
            JOptionPane.showMessageDialog(null, "Some problem occured , please check out the process and try again.");
        }
        return null;
    }
}

