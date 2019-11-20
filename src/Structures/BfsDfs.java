package Structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BfsDfs {
	
	public static <V> List<V> bfs(Graph<V> g, V v){
		return traversal(g, v, new Stack<>());
	}
	
	public static <V> List<V> dfs (Graph<V> g, V v){
		return traversal(g, v, new LinkedList<V>());
	}
	
	private static <V> List<V> traversal(Graph<V> g, V v, Stack<V> ds){
		List<V> trav = new ArrayList<>();
		//Invariant: Each algorithm adds the given element first. 

		V vertex = v;
		ds.push(vertex);
		
		boolean[] visited = new boolean[g.getVertexSize()];
		
		//Invariant: While the traversal occurs, the given DS to be used will have, at least, one element.
		while(!ds.isEmpty()) {
			 //Invariant: Element added is always retired from the DS
			vertex = (V) ds.pop();
			int indexV = g.getIndex(vertex);
			
			if(!visited[indexV]) {
				trav.add(vertex);
				visited[indexV] = true;
				
				List<V> adjacents = g.vertexAdjacent(vertex);
				ds.addAll(adjacents);
			}
		}
		return trav;
	}

}
