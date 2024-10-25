package th.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Write an algorithm to extract the shortest snippet of text in a document that
 * contains all occurrences of a search query. The query has k terms.
 * 
 * Term-1 occurred at positions p11, p12, …, p1n1 Term-2 occurred at positions
 * p21, p22, …, p2n2
 * 
 * ........
 * 
 * Term-k occurred at positions pk1, pk2, …, pknk
 * 
 * 
 */
public class ShortSnippet
{

  private static void updateSolPointers(int[] sol_pointers, int minIdx, List<int[]> data)
  {
    if (sol_pointers[minIdx] < data.get(minIdx).length - 1)
    {
      sol_pointers[minIdx] = sol_pointers[minIdx] + 1;
    } else
    {
      boolean update = false;
      int nextMinIdx = 0;
      int nextMinVal = Integer.MAX_VALUE;
      for (int i = 0; i < sol_pointers.length; i++)
      {
        if ((i != minIdx) && (sol_pointers[i] < data.get(i).length - 1))
        {
          if (data.get(i)[sol_pointers[i]] < nextMinVal)
          {
            nextMinIdx = i;
            nextMinVal = data.get(i)[sol_pointers[i]];
            update = true;
          }
        }
      }
      if (update && sol_pointers[nextMinIdx] < data.get(nextMinIdx).length - 1)
      {
        sol_pointers[nextMinIdx] = sol_pointers[nextMinIdx] + 1;
      }
    }
  }

  static Solution findBetterSolution(Solution initial_sol)
  {
    Solution current_sol = initial_sol;
    Solution best_sol = current_sol;
    int[] sol_pointers = current_sol.copySolutionPointers();
    int minIdx = current_sol.getMinIndex();

    while (true)
    {
      if (isStopable(sol_pointers, current_sol))
      {
        best_sol = current_sol;
        break;
      } else
      {

        updateSolPointers(sol_pointers, minIdx, current_sol.getData());
        Solution candidate = new Solution(current_sol.getData(), sol_pointers);
        minIdx = candidate.getMinIndex();
        if (candidate.getSnippetLength() < current_sol.getSnippetLength())
        {
          current_sol = candidate;
          System.out.println("Better solution: " + current_sol);
        }

      }
    }
    return best_sol;
  }

  private static boolean isStopable(int[] sol_pointers, Solution sol)
  {
    for (int i = 0; i < sol_pointers.length; i++)
    {
      if (sol_pointers[i] < sol.getPositionArray(i).length - 1)
      {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args)
  {

    // Select first element from individial list as our initial solution
    int[] pointers = { 0, 0, 0, 0 };
    List<int[]> position_lists = testData1();

    Solution initial_sol = new Solution(position_lists, pointers);
    System.out.println("Initial solution: " + initial_sol);

    Solution final_sol = findBetterSolution(initial_sol);
    System.out.println("Final solution: " + final_sol);

  }

  private static List<int[]> testData1()
  {
    // example/test data
    int[] term1_pos_lst = { 5, 25, 1025, 1557 };
    int[] term2_pos_lst = { 1000, 1040, 2775, 3885 };
    int[] term3_pos_lst = { 125, 130, 1020, 3220 };
    int[] term4_pos_lst = { 1, 131, 1030, 4220 };

    List<int[]> position_lists = new ArrayList();
    position_lists.add(term1_pos_lst);
    position_lists.add(term2_pos_lst);
    position_lists.add(term3_pos_lst);
    position_lists.add(term4_pos_lst);

    return position_lists;
  }

  private static List<int[]> testData2()
  {
    // example/test data
    int[] term1_pos_lst = { 0, 89, 130 };
    int[] term2_pos_lst = { 95, 123, 177, 199 };
    int[] term3_pos_lst = { 70, 105, 117 };

    List<int[]> position_lists = new ArrayList();
    position_lists.add(term1_pos_lst);
    position_lists.add(term2_pos_lst);
    position_lists.add(term3_pos_lst);

    return position_lists;
  }
}

class Solution
{

  // data contains a list of k position array
  private List<int[]> data;
  // solution pointer pointing to the position lists
  private int[] sol_pointers;

  public Solution(List<int[]> position_lists, int[] pointers) {
    this.data = position_lists;
    this.sol_pointers = new int[pointers.length];
    System.arraycopy(pointers, 0, this.sol_pointers, 0, pointers.length);
  }

  int getMinIndex()
  {
    int minIdx = 0;
    int minVal = Integer.MAX_VALUE;

    for (int i = 0; i < sol_pointers.length; i++)
    {
      if (data.get(i)[sol_pointers[i]] < minVal)
      {
        minIdx = i;
        minVal = data.get(i)[sol_pointers[i]];
      }
    }

    return minIdx;
  }

  int getMaxIndex()
  {
    int maxIdx = 0;
    int maxVal = Integer.MIN_VALUE;

    for (int i = 0; i < sol_pointers.length; i++)
    {
      if (data.get(i)[sol_pointers[i]] > maxVal)
      {
        maxIdx = i;
        maxVal = data.get(i)[sol_pointers[i]];
      }
    }

    return maxIdx;
  }

  public int getSnippetLength()
  {
    int minIdx = getMinIndex();
    int maxIdx = getMaxIndex();
    int len = data.get(maxIdx)[sol_pointers[maxIdx]] - data.get(minIdx)[sol_pointers[minIdx]];
    return len;
  }

  public int[] copySolutionPointers()
  {
    int[] pointers = new int[sol_pointers.length];
    System.arraycopy(sol_pointers, 0, pointers, 0, sol_pointers.length);
    return pointers;
  }

  public List<int[]> getData()
  {
    return data;
  }

  public int[] getPositionArray(int idx)
  {
    return data.get(idx);
  }

  public int[] getPosArrayForMinIndex()
  {
    int minIdx = getMinIndex();
    return data.get(minIdx);
  }

  @Override
  public String toString()
  {
    int minIdx = getMinIndex();
    int maxIdx = getMaxIndex();
    StringBuilder buf = new StringBuilder();
    buf.append("(");
    buf.append(data.get(minIdx)[sol_pointers[minIdx]]);
    buf.append(", ");
    buf.append(data.get(maxIdx)[sol_pointers[maxIdx]]);
    buf.append(")");
    return buf.toString();
  }
}
