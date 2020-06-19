
/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        int num = 0;
        boolean isallnum = true;
        for(int i=0; i<input.length(); ++i){
            char c = input.charAt(i);
            if(c=='+'||c=='-'||c=='*') {
                List<Integer> leftList = diffWaysToCompute(input.substring(0,i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i+1));
                switch(c){
                    case '+':
                    for(int lint:leftList) for(int rint:rightList){
                        res.add(lint+rint);
                    }
                    break;
                    case '-':
                    for(int lint:leftList) for(int rint:rightList){
                        res.add(lint-rint);
                    }
                    break;
                    case '*':
                    for(int lint:leftList) for(int rint:rightList){
                        res.add(lint*rint);
                    }
                }
                isallnum = false;
            } else if(isallnum == true){// number
                num = num*10 + (c-'0');
            }
        }
        if(isallnum == true){
            res.add(num);
        }
        return res;
    }
}
// @lc code=end

