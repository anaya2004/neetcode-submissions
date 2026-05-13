class Solution {
    private int isLand(int[][] grid,int i , int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
            return 1;
        }
        if(grid[i][j] == -1){
            return 0;
        }
        grid[i][j] = -1;
        int peri = 0;
        peri += isLand(grid,i,j-1); //calling left
        peri += isLand(grid,i-1,j);  //calling top
        peri += isLand(grid,i,j+1); //calling right
        peri += isLand(grid,i+1,j); //calling down

        return peri;
    }
    public int islandPerimeter(int[][] grid) {
        for(int i = 0 ;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return isLand(grid,i,j);
                }
            }
        }
        return 0;
    }
}