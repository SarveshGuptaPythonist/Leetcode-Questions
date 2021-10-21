class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int len = image.length;
        int temp;
        for(int i = 0; i < len; i++){
            
            for(int j = 0; j < len / 2; j++){
                temp = image[i][j];
                image[i][j] = image[i][len - j - 1];
                image[i][len - j - 1] = temp;
            }
            
            for(int j = 0; j < len; j++){
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
            
            
        }
        return image;
        
    }
}


Traversing row wise, We have data to flip, which can be done easily,
FLip for [[1,1,0],[1,0,1],[0,0,0]]
Line 9 - 0 index and 2 index will interchange for once only, since j-loop is running for half time.
And then next j-loop will flip in a line.  if its value is found 0 it changes to 1 and vice versa.
