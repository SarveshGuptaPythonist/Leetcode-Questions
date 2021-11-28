public class Solution {
    List<String> res;
    public void caller(String input, String output, int countofNo, int pos) {
        if(pos == input.length()) {
            if(countofNo > 0) res.add(output+countofNo);
            else res.add(output);

            return;
        }
        char ch = input.charAt(pos);
        caller(input, output + (countofNo == 0 ? "": countofNo) + ch, 0, pos+1);// yes call
        caller(input, output , countofNo+1, pos+1);
    }
    public List<String> generateAbbreviations(String word) {
        // Write your code here
        res = new ArrayList<>();
        caller(word, "", 0, 0);
        Collections.sort(res);
        return res;
    }
}
