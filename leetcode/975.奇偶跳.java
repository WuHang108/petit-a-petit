import java.util.*;

/*
 * @lc app=leetcode.cn id=975 lang=java
 *
 * [975] 奇偶跳
 */

// @lc code=start
class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int[][] a = new int[n][2];
        int[] oddnext = new int[n];
        int[] evennext = new int[n];

        for(int i=0; i<n; ++i) {
            a[i][0] = i;
            a[i][1] = arr[i];
        }

        Arrays.sort(a, new Comparator<int[]>(){
            @Override
            public int compare(int[] aa, int[] bb) {
                return aa[1] == bb[1] ? aa[0]-bb[0] : aa[1]-bb[1];
            }
        });
        oddnext = make(a);
        for(int i=0; i<n; ++i) {
            a[i][0] = i;
            a[i][1] = -arr[i];
        }

        Arrays.sort(a, new Comparator<int[]>(){
            @Override
            public int compare(int[] aa, int[] bb) {
                return aa[1]==bb[1]?aa[0]-bb[0]:aa[1]-bb[1];
            }
        });
        evennext = make(a);

        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];

        odd[n-1] = even[n-1] = true;
        for(int i=n-2; i>=0; i--) {
            if(oddnext[i] != -1)
                odd[i] = even[oddnext[i]];
            if(evennext[i] != -1)
                even[i] = odd[evennext[i]];
        }

        int ans = 0;
        for(int i=0; i<n; i++)
            if(odd[i])
                ans++;
        return ans;
    }

    int[] make(int[][] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for(int i=0; i<n; ++i) {
            while(!st.isEmpty() && arr[i][0]>st.peek()) {
                ans[st.pop()] = arr[i][0];
            }
            st.add(arr[i][0]);
        }
        return ans;
    }
}
// @lc code=end

