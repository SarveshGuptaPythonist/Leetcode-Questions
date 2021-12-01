class Solution {
    public String intToRoman(int num) {
        int[] Roman = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] Symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String sh = "";
        for(int i = Roman.length-1; i >=0; i--) {
            
            while(num >= Roman[i]){
                num -= Roman[i];
                sh+= Symbol[i];
            }
        }
        return sh;
    }
}
// Here All Values are made inside a range, Since We Know, That Every number will be created using these values, 
// It is like a basic Greedy approach, where we have to choose the max we Can, If It is 
// 8 - 8 > 5
// 3 - 3 > 1
// 2 - 2 > 1
// 1 - 1 > 1
// --------------
//        VIII -> OutPut
