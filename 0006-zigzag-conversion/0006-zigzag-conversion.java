class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int currRow = 0;
        boolean direction = false;
        String[] rows = new String[numRows];
        Arrays.fill(rows, "");
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            rows[currRow] += c;
            if(currRow == 0 || currRow == numRows-1){
                direction = !direction;
            }
            if(direction) currRow++;
            else currRow--;
        }
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<numRows;i++){
            str.append(rows[i]);
        }
        return str.toString();
    }
}