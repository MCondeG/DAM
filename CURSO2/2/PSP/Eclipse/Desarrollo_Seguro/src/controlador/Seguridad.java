package controlador;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public abstract class Seguridad {
	
	
	public static String codificarPassword(String password) {
		
		String hashedStringPass;
		byte[] hash = null;
		byte[] salt = new byte[16];
		SecureRandom random = new SecureRandom();
		KeySpec spec;
		SecretKeyFactory factory;
		
		random.nextBytes(salt);	
		spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hash = factory.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		hashedStringPass = Seguridad.toBase64(hash);
		
		return hashedStringPass;
	}
	
	
	private static String toBase64(byte[] hash) {
		
		String base64encoded = Base64.getEncoder().encodeToString(hash);
		
		return base64encoded;	
	}
}