class Solution {
      private int size;
    private List<List<String>> solutions = new ArrayList<List<String>>();
    public int totalNQueens(int n) {
         size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }
​
        placeQueens(emptyBoard,0);
        return solutions.size();
    }
    
     private  void placeQueens(char board[][],int row) {
    int n = board.length;
    if(row ==n) {  // prints all possible positions
          List<String> ans = new ArrayList<String>();
        for (int rowdash= 0; rowdash < size; rowdash++) {
            String current_row = new String(board[rowdash]);
            ans.add(current_row);
        }
        solutions.add(ans);
        return;
    }
    for (int cols = 0; cols < board.length; cols++) {
        if(isItsafePlaceForTheQueen(board, row, cols)){
            board[row][cols] = 'Q';
            placeQueens(board, row + 1);
            board[row][cols]='.';
        }
    }
}
​
​
public  boolean isItsafePlaceForTheQueen(char board[][],int row,int cols) {
    // check if 1 is present on top left diagonal
    for(int i = row -1,j = cols-1;i >=0 && j>=0; i--,j--) {
        if (board[i][j] =='Q') {
            return false;
        }
    }
    // check if 1 is present on bottom right diagonal  
    for(int i = row +1,j = cols+1;i < board.length && j <board.length;i++,j++) {
        if (board[i][j] =='Q') {
            return false;
        }
    }
    // check if 1 is present on top right diagonal 
        for(int i = row -1,j = cols+1;i>=0 && j<board.length;i--,j++) {
            if (board[i][j] =='Q') {
                return false;
            }
        }
​
        // check if 1 is present on bottom left diagonal
        for(int i = row + 1,j = cols-1;i<board.length && j>=0;i++,j--) {
            if (board[i][j] =='Q') {
                return false;
            }
        }
        
        // check if 1 is present on top  
        for(int i = row -1; i >= 0; i--) {
            if (board[i][cols] =='Q') {
                return false;
            }
        }
        
        // check if 1 is present on bottom
        for(int i = row + 1; i < 0; i++) {
            if (board[i][cols] =='Q') {
                return false;
            }
        }
            
        return true;
        
}
}
