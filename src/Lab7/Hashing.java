package Lab7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Hashing {

    public static String hashing(String plain_password, String salt) throws NoSuchAlgorithmException {

        String salted_password = salt + plain_password;

        // Some input to run through a hashing algorithm
        byte[] inputBytes = salted_password.getBytes();

        // Get a Digest (hash) algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        // Digest (hash) the input
        byte[] outputBytes = md.digest(inputBytes);

        // Encode the hash bytes as a Base64 string
        return Base64.getEncoder().encodeToString(outputBytes);
    }

    public static String generateSalt() {

        // Create an array of 32 bytes (256 bits) to store random bytes
        byte[] saltBytes = new byte[32];

        // The SecureRandom class provides CSPRNG functionality
        SecureRandom random = new SecureRandom();

        // Fill the byte array with random bytes
        random.nextBytes(saltBytes);

        // Encode the random bytes as a Base64 string
        return Base64.getEncoder().encodeToString(saltBytes);
    }
}
