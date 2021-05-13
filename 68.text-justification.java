import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int max=maxWidth;
        int count=0;
        List<ArrayList<String>> list=new ArrayList<>();
        ArrayList<String> cur=new ArrayList<>();
        for(String word:words){
            count+=word.length();
            int space=cur.size()==0?0:cur.size()-1;
            if((count+space)>maxWidth){
                list.add(cur);
                cur=new ArrayList<String>();
                count=word.length();
            }
            cur.add(word);
        }
        list.add(cur);
        List<String> res=new ArrayList<>();
        
        for(int i=0;i<list.size();i++){
            cur=list.get(i);
            count=0;
            for(String word:cur)
                count+=word.length();
            int extra=max-(count+cur.size()-1);
            StringBuilder sb=new StringBuilder();
            //left justify
            if(i==list.size()-1||cur.size()==1){
               for(int j=0;j<cur.size();j++){
                    sb.append(cur.get(j));
                    if(j<cur.size()-1)
                        sb.append(" ");
               }
               while(extra!=0){
                    sb.append(" ");
                    extra--;
               }
            }else{
              int space=extra%(cur.size()-1);
               for(int j=0;j<cur.size()-1;j++){
                    int same=extra/(cur.size()-1);
                    if(j<cur.size()-1){
                        sb.append(cur.get(j)+" ");  
                        if(j<space)same+=1;
                        for(int k=0;k<same;k++){
                            sb.append(" ");
                        }
                    }

               }
               sb.append(cur.get(cur.size()-1));  
            }
            res.add(sb.toString());
        }
        return res;
    }
}
// @lc code=end

