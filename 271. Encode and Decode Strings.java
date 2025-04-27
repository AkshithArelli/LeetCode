Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.


  class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String word : strs) {
            int length = word.length();
            encodedString.append(length);
            encodedString.append("#");
            encodedString.append(word);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        int i=0;
        while (i<str.length()) {
            int j=i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            j++;
            String subString = str.substring(j,j+length);
            decodedList.add(subString);
            i = j+length;
        }
        return decodedList;
    }
}
