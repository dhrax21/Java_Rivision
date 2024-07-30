package GraphDataStructure;

import java.util.ArrayList;

public class WordBoggleDFS {
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        ArrayList<String> ans=new ArrayList<>();

        for(String str : dictionary){
            if(present(board,str)){
                ans.add(str);
            }
        }
        String[] res=new String[ans.size()];
        int i=0;
        for(String s : ans){
            res[i++]=s;
        }
        return res;
    }

    boolean present(char[][] board,String word){
        int m=board.length;
        int n=board[0].length;

        boolean[][] vis=new boolean[m][n];
        int idx=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(idx)){
                    if(dfs(board,word,vis,i,j,idx))
                        return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board,String word,boolean[][] vis,int r,int c,int idx){
        if(idx==word.length()) return true;
        if(r>=0 && r<board.length && c>=0 && c<board[0].length && !vis[r][c] && board[r][c]==word.charAt(idx)){
            vis[r][c]=true;

            if(dfs(board,word,vis,r-1,c,idx+1)
                    || dfs(board,word,vis,r+1,c,idx+1)
                    || dfs(board,word,vis,r,c+1,idx+1)
                    || dfs(board,word,vis,r,c-1,idx+1)
                    || dfs(board,word,vis,r+1,c+1,idx+1)
                    || dfs(board,word,vis,r-1,c-1,idx+1)
                    || dfs(board,word,vis,r+1,c-1,idx+1)
                    || dfs(board,word,vis,r-1,c+1,idx+1)){
                return true;
            }
            vis[r][c]=false;
        }
        return false;
    }
}
