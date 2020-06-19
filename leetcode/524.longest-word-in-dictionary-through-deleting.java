import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        int max_len = 0;
        char[] str1 = s.toCharArray();
        for(String goal:d){
            char[] str2 = goal.toCharArray();
            int i1 = 0, i2 = 0;
            while(i1<str1.length && i2<str2.length){
                if(str1[i1] == str2[i2]){
                    ++i1;++i2;
                } else {
                    ++i1;
                }
            }
            if(i2>=str2.length){
                if(str2.length>max_len){
                    max_len = str2.length;
                    res = goal;
                } else if (str2.length == max_len){
                    int i = 0;
                    while(i<max_len && str2[i] == res.charAt(i)){
                        ++i;
                    }
                    if(i<max_len && str2[i] < res.charAt(i)){
                        res = goal;
                    }
                }
            }
        }
        return res;
    }
}

