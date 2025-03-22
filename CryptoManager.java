
/**
 * Class: CMSC203-31338
 * Instructor: Ashique Tanveer
 * Description: This class provides methods for encrypting and decrypting text using the Caesar Cipher and Bellaso Cipher.
 * Due: 03/21/2025
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Cedric Nji
 */
public class CryptoManager {

    // Define the allowable ASCII range for characters
    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    /**
     * Checks if a string is within the allowable bounds of ASCII codes.
     *
     * @param plainText The string to be checked.
     * @return true if all characters are within bounds, false otherwise.
     */
    public static boolean isStringInBounds(String plainText) {
        for (char c : plainText.toCharArray()) {
            if (c < LOWER_RANGE || c > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

    /**
     * Encrypts a string using the Caesar Cipher.
     *
     * @param plainText The string to be encrypted.
     * @param key       The offset for the Caesar Cipher.
     * @return The encrypted string, or an error message if the input is out of bounds.
     */
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        StringBuilder encryptedText = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            int encryptedChar = c + key;
            // Wrap around if the character exceeds the upper range
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append((char) encryptedChar);
        }
        return encryptedText.toString();
    }

    /**
     * Decrypts a string encrypted with the Caesar Cipher.
     *
     * @param encryptedText The string to be decrypted.
     * @param key           The offset used for encryption.
     * @return The decrypted string.
     */
    public static String caesarDecryption(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            int decryptedChar = c - key;
            // Wrap around if the character falls below the lower range
            while (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append((char) decryptedChar);
        }
        return decryptedText.toString();
    }

    /**
     * Encrypts a string using the Bellaso Cipher.
     *
     * @param plainText  The string to be encrypted.
     * @param bellasoStr The keyword used for encryption.
     * @return The encrypted string.
     */
    public static String bellasoEncryption(String plainText, String bellasoStr) {
        StringBuilder encryptedText = new StringBuilder();
        int bellasoLength = bellasoStr.length();

        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char bellasoChar = bellasoStr.charAt(i % bellasoLength);
            int encryptedChar = plainChar + bellasoChar;

            // Wrap around if the character exceeds the upper range
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append((char) encryptedChar);
        }
        return encryptedText.toString();
    }

    /**
     * Decrypts a string encrypted with the Bellaso Cipher.
     *
     * @param encryptedText The string to be decrypted.
     * @param bellasoStr    The keyword used for encryption.
     * @return The decrypted string.
     */
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();
        int bellasoLength = bellasoStr.length();

        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char bellasoChar = bellasoStr.charAt(i % bellasoLength);
            int decryptedChar = encryptedChar - bellasoChar;

            // Wrap around if the character falls below the lower range
            while (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append((char) decryptedChar);
        }
        return decryptedText.toString();
    }
}