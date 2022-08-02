/*
 * @lc app=leetcode id=648 lang=java
 *
 * [648] Replace Words
 */

// @lc code=start
class Solution {
    class Node{
        boolean isWord;
        String word;
        Node[] nodes;
        public Node(){
            this.nodes=new Node[26];
        }

    }
    Node root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new Node();
        for(String w:dictionary)
            buildTrie(w);

        String[] arr=sentence.split(" ");

        for(int i=0;i<arr.length;i++){
            Node cur=root;
            String word=arr[i];
            for(int j=0;j<word.length();j++){
                int v=word.charAt(j)-'a';
                if(cur.nodes[v]==null||cur.isWord)
                    break;
                cur=cur.nodes[v];
            }
            if(cur.isWord)
                arr[i]=cur.word;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
            if(i>0)
                sb.append(" ");
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    private void buildTrie(String word){
        Node cur=root;

        for(int i=0;i<word.length();i++){

            int v=word.charAt(i)-'a';
            if(cur.nodes[v]==null)
                cur.nodes[v]=new Node();
            cur=cur.nodes[v];
        }
        cur.isWord=true;
        cur.word=word;

    }
}
// @lc code=end

