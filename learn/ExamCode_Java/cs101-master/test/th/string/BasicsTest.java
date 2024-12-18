/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.string;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author td
 */
public class BasicsTest {
    
    public BasicsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of removeDuplicateChars method, of class Basics.
     */
    @Test
    public void testRemoveDuplicateChars() {
        System.out.println("removeDuplicateChars");
        

        // case 1
        String s = "Google.Facebook.Twitter.Apple";
        char str[] = s.toCharArray();
        Basics.removeDuplicateChars(str);        
        assertArrayEquals("Gogle.FacbkTwitrAp           ".toCharArray(), str);
        
        // case 1, no duplicate 
        str = "abcde".toCharArray();
        Basics.removeDuplicateChars(str);
        assertArrayEquals("abcde".toCharArray(), str);
        
        // case 2, null 
        str = "".toCharArray();
        Basics.removeDuplicateChars(str);
        assertArrayEquals("".toCharArray(), str);
    }

    /**
     * Test of isUnique method, of class Basics.
     */
    @Test
    public void testIsUnique() {
        System.out.println("isUnique");
        String str = "";
        Basics instance = new Basics();
        boolean expResult = false;
        boolean result = instance.isUnique(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUniqueChars method, of class Basics.
     */
    @Test
    public void testIsUniqueChars() {
        System.out.println("isUniqueChars");
        Basics instance = new Basics();
        
        String str = "hello";
        boolean result = instance.isUniqueChars(str);
        assertFalse(result);
        
        String str2 = "Go12345";
        boolean result2 = instance.isUniqueChars(str2);
        assertTrue(result2);
        
    }
    
}
