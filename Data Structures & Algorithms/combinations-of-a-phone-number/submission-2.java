class Solution {
    List<String> res = new ArrayList<>();
    String mapToChar[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;    
    }

    public void backtrack(int i, String currString, String digits) {
        if(currString.length() == digits.length()){
            res.add(currString);
            return;
        }
        System.out.println(currString);
        String chars = mapToChar[digits.charAt(i) - '0'];
        char[] characters = chars.toCharArray();

        for(int j = 0; j < characters.length; j++){
            backtrack(i+1, currString + characters[j], digits);
        }
    }
}
