import java.util.*;
class Solution {
    public static void main(String[] args) {
        int[][] t = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new Solution().orangesRotting(t));
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] > 0){
                    map.put(i*n+j,1);
                    if(grid[i][j] == 2) dq.offer(i*n+j);
                    if(grid[i][j]==1 && (i==0 || grid[i-1][j]==0) && (j==0 || grid[i][j-1]==0) && (i==m-1 || grid[i+1][j]==0) && (j==n-1 || grid[i][j+1]==0)) return -1;
                }
            }
        }
        int timer = -1;
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i=0;i<size;i++) {
                int t = dq.poll();
                if(map.get(t) == -1) continue;
                int row = t / n;
                int col = t % n;
                System.out.println(row+","+col);
                if (row > 0 && grid[row - 1][col] == 1 && map.get(t) != -1) {
                    dq.offer((row - 1) * n + col);
                    map.put(row * n + col,-1);
                }
                if (row < m - 1 && grid[row + 1][col] == 1 && map.get(t) != -1){
                    dq.offer((row + 1) * n + col);
                    map.put(row * n + col,-1);
                }
                if (col > 0 && grid[row][col - 1] == 1 && map.get(t) != -1){
                    dq.offer(row * n + col - 1);
                    map.put(row * n + col,-1);
                }
                if (col < n - 1 && grid[row][col + 1] == 1 && map.get(t) != -1){
                    dq.offer(row * n + col + 1);
                    map.put(row * n + col,-1);
                }
                map.put(row * n + col,-1);
            }
            timer++;
            System.out.println("dq的大小=="+dq.size());
            System.out.println("第"+timer+"s");
            System.out.println();
        }
        return timer;
    }
}