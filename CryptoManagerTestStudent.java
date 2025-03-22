
import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("HELLO"));
        assertFalse(CryptoManager.isStringInBounds("hello")); // lowercase letters are out of bounds
    }

    @Test
    public void testCaesarEncryption() {
        assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hello", 3));
    }

    @Test
    public void testCaesarDecryption() {
        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
    }

    @Test
    public void testBellasoEncryption() {
        assertEquals("DOVGHSZ", CryptoManager.bellasoEncryption("ABCDEFG", "CMSC"));
    }

    @Test
    public void testBellasoDecryption() {
        assertEquals("ABCDEFG", CryptoManager.bellasoDecryption("DOVGHSZ", "CMSC"));
    }
}