package Structures;

public class Dijkstra_FloydMarshmallow {
	
	public static void main(String[] args) {
		
		int[][] W = new int[5][5];
		
		W[0][0] = 0;
		W[0][1] = 3;
		W[0][2] = 1;
		W[0][3] = 4;
		W[0][4] = Integer.MAX_VALUE;
		W[1][0] = 3;
		W[1][1] = 0;
		W[1][2] = 5;
		W[1][3] = Integer.MAX_VALUE;
		W[1][4] = 8;
		W[2][0] = 1;
		W[2][1] = 5;
		W[2][2] = 0;
		W[2][3] = 2;
		W[2][4] = Integer.MAX_VALUE;
		W[3][0] = 4;
		W[3][1] = Integer.MAX_VALUE;
		W[3][2] = 2;
		W[3][3] = 0;
		W[3][4] = 1;
		W[4][0] = Integer.MAX_VALUE;
		W[4][1] = 8;
		W[4][2] = Integer.MAX_VALUE;
		W[4][3] = 1;
		W[4][4] = 0;
		
		int[][] D = floydMarshmallow(W);
		
		for(int i=0; i<D.length; i++) {
			String imp = "";
			for(int j=0; j<D[0].length; j++) {
				imp += D[i][j] +" ";
			}
			System.out.println(imp);
		}
		
	}

	public static int[][] floydMarshmallow(int[][] W) {
		
		int n = W.length;
		int[][] D = W;
		int v = 0;
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					
					if(j != k || i != k) {
						
						if(D[i][k] != Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE) {
							
							v = D[i][k] + D[k][j];
							
							if(D[i][j] > v) D[i][j] = v;
							
						}
						
					}
					
				}
			}
		}
		
		return D;
		
	}
	
	public static <V> int[] dijkstra(int[][] g, int v){
		int[] dis = new int[g.length];
		boolean[] vis = new boolean[g.length];
		
		
		for (int i=0; i < dis.length; i++) { 
            dis[i] = Integer.MAX_VALUE; 
        }
		dis[v] = 0;
		
		for (int i=0; i<v-1; i++) {  
            int u = minIndex(dis, vis); 
  
            vis[u] = true; 

            for (int j=0; j<v; j++) {
                if (!vis[v] && g[u][v] != 0 && dis[u] != Integer.MAX_VALUE && dis[u] + g[u][v] < dis[v]) 
                   dis[v] = dis[u] + g[u][v]; 
            }
        }
		
		return dis;
		
	}
	
	private static int minIndex(int[] dis, boolean[] vis) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE;
        int indx = -1; 
  
        for (int i=0; i<dis.length; i++) 
            if (vis[i] == false && dis[i] <= min) { 
                min = dis[i]; 
                indx = i; 
            } 
  
        return indx; 
    }

}
