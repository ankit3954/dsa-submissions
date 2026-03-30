class Solution {

    public String sortString(String i){
        char[] charArray = i.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        return sortedString;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        List<List<String>> groupAnagram = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String sortedString = sortString(strs[i]);
            anagramMap.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(strs[i]);
        }

        for(Map.Entry<String, List<String>> entry : anagramMap.entrySet()){
            List<String> anagrams = entry.getValue();
            groupAnagram.add(anagrams);
        }

        return groupAnagram;
    }
}
