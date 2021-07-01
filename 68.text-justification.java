import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
    // ***
    // 1.i is the next word, not in this line
    // 2.while i<=arr.length,don't use String word=words[i] ***
    // 3.Check Length 
    //   a.i==arr.length ***
    //   b.count + i-index-1 + 1 space + word.length() ***
    // 4.Left Justification
    // 5 Middle Justification
    //   a.slot = i-index-1
    //   b.space = max-count/slot
    //   c.extra = max-count%slot
    // 6.if i<length, count=words[i].length()
    // 7.else count+=words[i].length()
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList<>();
        int count=0;
        int max=maxWidth;
        int i=0;
        int index=0;
        while(i<=words.length){
            if(i==words.length||count+(i-index-1)+1+words[i].length()>max){
                StringBuilder sb =new StringBuilder();
                //Left justification
                if(i==words.length||i-index==1){

                    for(int j=index;j<i;j++){
                        sb.append(words[j]);
                        if(j<i-1)
                            sb.append(" ");
                    }
                    while(sb.length()<max)
                        sb.append(" ");
                }else{
                //Middle justification
                    int space=(max-count)/(i-index-1);
                    int extra=(max-count)%(i-index-1);
                    for(int j=index;j<i;j++){
                        sb.append(words[j]);
                        if(j<i-1){
                            for(int k=0;k<space;k++)
                                sb.append(" ");
                            if(extra>0){
                                sb.append(" ");
                                extra--;
                            }
                        }
                    }
                }
                list.add(sb.toString());
                index=i;
                if(i<words.length)
                    count=words[i].length();
            }else{
                count+=words[i].length();
            }
            i++;
        }
        return list;
    }
}
// @lc code=end

