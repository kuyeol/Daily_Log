package th.select;

import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SelectionTest {

  public SelectionTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  // assuming arr is not null and has len > 0
  public static Integer[] intsToIntegers(int[] arr) {
    Integer[] arr2 = new Integer[arr.length];
    for (int i = 0; i < arr.length; i++) {
      arr2[i] = arr[i];
    }
    return arr2;
  }

  /**
   * Test of nonlinearKselect method, of class Selection.
   */
  @Test
  public void testNonlinearKSelect() {
    System.out.println("nonlinearKselect");
    int[] a = {10, 8, 6, 4, 2, 0, 1, 3, 5, 7, 9};
    Integer[] arr = intsToIntegers(a);

    int k = 3;
    int expResult = 8;
    Comparable result = Selection.nonlinearKSelect(arr, k);
    assertEquals(expResult, result);

    k = 4;
    expResult = 7;
    result = Selection.nonlinearKSelect(arr, k);
    assertEquals(expResult, result);
  }

  @Test
  public void testPatition() {
    System.out.println("patition");
    int[] a = {10, 8, 6, 4, 2, 0, 1, 3, 5, 7, 9};
    Integer[] arr = intsToIntegers(a);
    int pivotIndex = 2;
    int expResult = 6;
    int result = Selection.partition(arr, 0, 10, pivotIndex);
    assertEquals(expResult, result);
  }

  @Test
  public void testQuickSelect() {
    System.out.println("quickSelect");
    int[] a = {10, 8, 6, 4, 2, 0, 1, 3, 5, 7, 9};
    Integer[] arr = intsToIntegers(a);
    
    
    int k = 5;
    int expResult = 4;
    Comparable result = Selection.quickSelect(arr, 0, arr.length - 1, k);
    assertEquals(expResult, result);

    k = 10;
    expResult = 9;
    result = Selection.quickSelect(arr, 0, arr.length - 1, k);
    assertEquals(expResult, result);

    k = 11;
    expResult = 10;
    result = Selection.quickSelect(arr, 0, arr.length - 1, k);
    assertEquals(expResult, result);

    k = 1;
    expResult = 0;
    result = Selection.quickSelect(arr, 0, arr.length - 1, k);
    assertEquals(expResult, result);
  }

  @Test
  public void testSelectKSmallest() {
    System.out.println("selectKSmallest");
    int[] a = {10, 8, 6, 4, 2, 0, 1, 3, 5, 7, 9};
    Integer[] arr = intsToIntegers(a);
    
    int k = 3;
    int expInts[] = {0, 1, 2};
    Integer[] expResult = intsToIntegers(expInts);
    Comparable[] result = Selection.selectKSmallest(arr, 0, arr.length - 1, k);

    System.out.println(Arrays.toString(result));
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testQuickSortFirstK() {
    System.out.println("quicksortFirstK");
    int[] a = {10, 4, 12, 8, 6, 4, 2, 0, 1, 3, 5, 12, 7, 9};
    Integer[] arr = intsToIntegers(a);
    
    int k = 4;
    Selection.quickSortFirstK(arr, 0, arr.length - 1, k);

    int ret[] = new int[k];
    int expResult[] = {0, 1, 2, 3};

    System.arraycopy(arr, 0, ret, 0, ret.length);
    System.out.println(Arrays.toString(arr));

    assertArrayEquals(expResult, ret);
  }

  @Test
  public void testQuickFindFirstK() {
    System.out.println("quickFindFirstK");
    int[] a = {10, 4, 12, 8, 6, 4, 2, 0, 1, 3, 5, 12, 7, 9};
    Integer[] arr = intsToIntegers(a);

    int k = 4;
    Selection.quickFindFirstK(arr, 0, arr.length - 1, k);

    System.out.println(Arrays.toString(arr));

    assertTrue(true);
  }
}
