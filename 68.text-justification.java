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
    // 2.i<=arr.length
    // 3.if i==arr.length || count + i-index-1 + 1 space + word.length() =>justification!
    // 4.Left
    // 5 Middle
    public List<String> fullJustify(String[] words, int maxWidth) {
        int max=maxWidth;
        int count=0;
        List<String> list=new ArrayList<String>();
        int index=0;
        int i=0;
        //i  0 - Array.length . i for next word,so space = i- index - 1
        while(i<=words.length){
            //End of array or 
            //Word + space + next word + next space
            if(i==words.length||count+(i-index-1)+1+words[i].length()>max){
                StringBuilder sb =new StringBuilder();
                //Left justification
                if(i-index==1||i==words.length){
                    for(int j=index;j<i;j++){
                        sb.append(words[j]);
                        if(j<i-1)
                            sb.append(" ");
                    }
                    while(sb.length()<max)
                        sb.append(" ");
                //Middle justification
                }else{
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

