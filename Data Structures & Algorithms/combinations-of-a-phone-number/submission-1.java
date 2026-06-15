class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        String arr[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for(int i = 2; i < 10; i++){
            char key = (char) (i + '0');
            map.putIfAbsent(key, arr[i-2]);
        }

        return letterCombinationsHelper(digits, map);
    }

    public List<String> letterCombinationsHelper(String digits, HashMap<Character, String> map) {
        if(digits.length() == 0){
            List<String> ans = new ArrayList<>();
            return ans;
        }

        List<String> res = letterCombinationsHelper(digits.substring(1), map);
        if(res.size() == 0){
            res.add("");
        }
        String s = map.get(digits.charAt(0));
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < res.size(); j++){
                String finalString = s.charAt(i) + res.get(j);
                ans.add(finalString);
            }

        }
        return ans;
    
    }

}
