class Solution {
    public int findJudge(int n, int[][] trust) {
        int trustTrack[][] = new int[n][n];

        //looping over the trust 
        for(int i = 0;i<trust.length;i++){
            int from = trust[i][0];
            int to = trust[i][1];

            trustTrack[from-1][to-1] = 1;
        }
        //now tracking of any row has no ones 
        int index = -1;
        for(int i =0;i<n;i++){
            boolean flag = false;
            for(int j = 0;j<n;j++){
                if(trustTrack[i][j] == 1){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                index = i +1;
            }
        }
        
        if(index != -1){
            //every cell of column with the value of index should be 1 expect index 
            for(int i = 0;i<n;i++){
                if(i != index-1 && trustTrack[i][index-1] == 0){
                    index = -1;
                    break;
                }
            }
        }
        return index;
    }
}