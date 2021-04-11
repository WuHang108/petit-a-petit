import java.util.*;

public class CombinationNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] dp = new long[n+1][m+1];
        for(int i=0; i<=n; ++i) {
            dp[i][0] = 1;
        }
        for(int i=1; i<=m; ++i) {
            for(int j=i; j<=n; ++j) {
                dp[j][i] = (dp[j-1][i-1]%1000000007 + dp[j-1][i]%1000000007) %1000000007;
            }
        }
        System.out.println(dp[n][m]);
    }
}