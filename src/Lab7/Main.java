package Lab7;

import java.security.NoSuchAlgorithmException;


public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String user_salt = Hashing.generateSalt();

        System.out.println(Hashing.hashing("hello", user_salt));
    }
}
