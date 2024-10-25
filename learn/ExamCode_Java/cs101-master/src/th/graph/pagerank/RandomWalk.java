package th.graph.pagerank;
import th.io.Console;
import th.io.Instream;
import th.probability.Rand;
// Capture the process of moving from page to page
public class RandomWalk {

  public static double[][] transitionMatrix(String webGraph, double alpha) {
    Instream in = new Instream(webGraph);
    int size = in.readInt();
    int[][] counts = new int[size][size];
    int[] outDegree = new int[size];
    while (!in.empty()) {
      int i = in.readInt();
      int j = in.readInt();
      outDegree[i]++;
      counts[i][j]++;
    }

    double[][] matrix = new double[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = alpha * counts[i][j] / outDegree[i] + (1 - alpha) / size;
      }
    }
    Console.print2DArray("%5.2f", matrix);
    return matrix;
  }

  public static double[] computeRanks(String webGraph, double alpha, int steps) {
    double[][] p = transitionMatrix(webGraph, alpha);
    int n = p.length;
    int[] freq = new int[n];

    int page = 0;
    for (int t = 0; t < steps; t++) {
      page = Rand.discrete(p[page]);
      freq[page]++;
    }

    double[] ranks = new double[n];
    for (int i = 0; i < n; i++) {
      ranks[i] = (double) freq[i] / steps;
    }    
    return ranks;
  }

  public static void main(String[] args) {
    String model_file = "/home/td/Dropbox/git/cs101/src/th/graph/pagerank/web.model1";
    double[] ranks = computeRanks(model_file, 0.8, 1000000);
    Console.printArray("%5.2f", ranks);
  }
}
