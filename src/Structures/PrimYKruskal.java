package Structures;

import java.util.ArrayList;
import java.util.Comparator;

public class PrimYKruskal {
	public int[][] Kruskal(int[][] pesos, int infinito){		
	     DisjointSet<Integer> set = new DisjointSet<>();
	     
		int[][] MST = new int[pesos.length][pesos.length];		
		
		for(int i = 0; i < pesos.length; i++)
			set.makeSet(i);		
		   class obj {			
			int A;
			int B;
			int P;			
			obj(int a, int b, int p){
				A = a;
				B = b;
				P = p;
			}
			int getA() {
				return A;
			}	
			int getB() {
				return B;
			}
			int getP() {
				return P;
			}
		}		
		   ArrayList<obj> aristas = new ArrayList<>();		
		for(int i = 0; i < pesos.length;  i++) {
			for(int j = 0; j < pesos.length; j++) {
				int peso = pesos[i][j];
				if(peso > 0 && peso < infinito) {
					obj o = new obj(i, j, peso);
					aristas.add(o);
				}
			}
		}	
		
		Comparator<obj> comparador = new Comparator<obj>() {			
			@Override
			public int compare(obj a, obj b) {
				if(a.getP() > b.getP())
					return  1;
				else if (a.getP() < b.getP())
					return -1;
				else
					return 0;
			}
		};	
		
		
		aristas.sort(comparador);		
		for(int i = 0; i < aristas.size(); i++) {
			obj arista = aristas.get(i);
			if(set.findSet(arista.getA()) != set.findSet(arista.getB())) {
				set.union(arista.getA(), arista.getB());
				MST[arista.getA()][arista.getB()] = arista.getP();
				MST[arista.getB()][arista.getA()] = arista.getP();
			}
		}		
		return MST;
	}
		
		
		/**
		 * halla el vertice mas pequeno y lo retorna
		 * @param weight los pesos que tiene el arbol
		 * @param inMst  lista que dice si los vertices ya estan dentro del mst
		 * @param vertexs numero de vertices
		 * @return el vertice con el peso mas pequeno
		 */
		
		public int minVertex(int[] weight, boolean[] inMst, int vertices){
			int minValue = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < vertices; i++) {
				if(inMst[i] == false && weight[i] < minValue){
					minValue = weight[i];
					minVertex = i;
				}
			}
			return minVertex;
		}
		
		
		public void prim(int[][] matrix){	
		int[] mst = new int[matrix.length];	//lista de adyacencia
		int[] weight = new int[matrix.length];	// pesos del mst
		boolean[] inMst = new boolean[matrix.length];	// si ya estan conectados en el arbol		// inicio los pesos en valores maximos y conexiones en el arbol en false
		for (int i = 0; i < matrix.length; i++) {
			weight[i] = Integer.MAX_VALUE;
			inMst[i] = false;
		}		
		
		// se hace prim desde el vertice 0
		weight[0] = 0; 	// peso cero
		mst[0] = -1;			
		
		for (int i = 0; i < matrix.length-1; i++) {
			int u = minVertex(weight, inMst, matrix.length);
			inMst[u] = true;
			for (int j = 0; j < matrix.length; j++) {
				if(matrix[u][j] != 0 && inMst[j] == false && matrix[u][j] < weight[j]){
					mst[j] = u;
					weight[j] = matrix[u][j];
				}
			}
		}		
	}

		
		/**
		 * Imprime prim
		 * @param parent
		 * @param n
		 * @param graph
		 */
		
		public void printMST(int parent[], int n, int graph[][]){
			System.out.println("Edge \tWeight");
			for (int i = 1; i < graph.length; i++)
				System.out.println(parent[i]+" - "+ i+"\t"+ graph[i][parent[i]]);
		}
		
}
