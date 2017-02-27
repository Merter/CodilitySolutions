// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// Codility - Easy
class BinaryGap {
  public int solution(int N) {
    int maxGap = 0;
    int begin = mostSignificantBitForPositive(N);
    while (begin != 0) {
      N -= (1 << begin);
      if (N == 0)
        return maxGap;
      int end = mostSignificantBitForPositive(N);
      int gap = begin-end-1;
      if (gap > maxGap)
        maxGap = gap;
      begin = end;
    }
    return maxGap;
  }

  private int mostSignificantBitForPositive(int N) {
    if (N <= 0)
      return -1;
    int pos = -1;
    while (N != 0) {
      N >>= 1;
      pos++;
    }
    return pos;
  }
}
