import java.util.Scanner;

public class Main_3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int T = scanner.nextInt();
    long modulo = scanner.nextLong();
    int[][] pos = new int[N][2];
    for (int i = 0; i < N; i++) {
      pos[i][0] = Math.abs(scanner.nextInt());
      pos[i][1] = Math.abs(scanner.nextInt());
    }
    scanner.close();
    
    long result = 1;
    
    for (int i = 0; i < N; i++) {
      int x = pos[i][0];
      int y = pos[i][1];
      if (T - x - y < 0 || (T - x - y) % 2 != 0) {
        System.out.println(0);
        return;
      }
      
      int ru = (T - x - y) / 2;
      int ld = x + y + ru;
      int lu = x + ru;
      int rd = y + ru;
      
      result *= (combMod(T, ru, modulo) * combMod(T, lu, modulo)) % modulo;
      result %= modulo;
    }
    System.out.println(result);
  }
  
  private static long combMod(int n, int r, long modulo) {
    if (r > n) {
      return 0;
    }
    if (r == 0 || n == r) {
      return 1;
    } else if (r == 1) {
      return n;
    }
    return (combMod(n - 1, r, modulo) % modulo
           + combMod(n - 1, r - 1, modulo) % modulo) % modulo;
  }
}






























