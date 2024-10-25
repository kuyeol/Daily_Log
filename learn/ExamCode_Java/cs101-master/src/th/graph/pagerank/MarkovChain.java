package th.graph.pagerank;

import th.io.Console;

public class MarkovChain {
  
  
  public static double[] computeRanks(String webGraph, double alpha,
      double residual) {

    double[][] p = RandomWalk.transitionMatrix(webGraph, alpha);
    int n = p.length;

    double[] rank = new double[n];
    rank[0] = 1.0;

    while (true) {
      double[] newRank = new double[n];
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++)
          newRank[j] += rank[k] * p[k][j];
      }

      if (resid(rank, newRank) <= residual) {
        rank = newRank;
        break;
      }
      rank = newRank;
    }
    return rank;
  }

  private static double resid(double[] rank, double[] newRank) {
    double res = 0.0;
    for (int i = 0; i < rank.length; i++) {
      res += Math.abs(newRank[i] - rank[i]);
    }
    return res;
  }
  
  public static void main(String[] args) {
    String model_file = "/home/td/Dropbox/git/cs101/src/th/graph/pagerank/web.model1";
    double[] ranks = computeRanks(model_file, 0.8, 0.01);
    Console.printArray("%5.2f", ranks);
  }  
}
