class Solution {
    public void func(int i, String digits, StringBuilder temp, List<String> list, Map<Character, String> map){
        if(i == digits.length()){
            list.add(temp.toString());
            return;
        }
        String str = map.get(digits.charAt(i));
        for(int j=0;j<str.length();j++){
            temp.append(str.charAt(j));
            func(i+1, digits, temp, list, map);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> list = new ArrayList<>();
        func(0, digits, new StringBuilder(), list, map);
        return list;
    }
}