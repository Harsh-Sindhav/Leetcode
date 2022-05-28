class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList();
        for(int i=0;i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuilder());
        }
        
        int curRow = 0;
    boolean goingDown = false;
        for(char c : s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1){
                goingDown = !goingDown;
                   
            }
            // System.out.print(goingDown + " ");
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder row : rows){ 
                // System.out.print(row + " ");
            ans.append(row);
                                     }
        return ans.toString();
    }
}
