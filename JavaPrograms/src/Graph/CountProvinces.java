package Graph;

public class CountProvinces {
    public static void main(String[] args) {
      /*  Problem Description:
        You are given a N x N matrix isConnected, where isConnected[i][j] == 1 represents
        that the i-th city is directly connected to the j-th city, and isConnected[i][j] == 0
        means that the i-th city is not directly connected to the j-th city.
            You are to find the number of provinces, where a province is a group of directly or indirectly connected cities.*/
    }

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int count = 0;

            // DFS for each node
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(isConnected, visited, i);
                    count++; // Every DFS call corresponds to one province
                }
            }

            return count;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int i) {
            // Mark the current city as visited
            visited[i] = true;

            // Visit all cities directly connected to city i
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && !visited[j]) {
                    dfs(isConnected, visited, j);
                }
            }
        }


}
