package graphs;

import java.util.LinkedList;

public class Representation {

	static class Graph
	{
		int V;
		LinkedList<Integer> adjList[];
		
		Graph(int Vertices)
		{
			V=Vertices;
			adjList = new LinkedList[V];
			for(int i=0;i<V;i++)
				adjList[i] = new LinkedList<>();
		}
		
	}
	
	static void addEdge(Graph g,int src,int des)
	{
		g.adjList[src].addFirst(des);
		g.adjList[des].addFirst(src);
		
		
	}
	
	static void printAdjList(Graph g)
	{
		for(int i=0;i<g.V;i++)
		{
			System.out.print("AdjList of "+i+"->>");
			for(int j=0;j<g.adjList[i].size();j++)
			{
				System.out.print(g.adjList[i].get(j)+"->");;
			}
			System.out.println("end");
		}
	}
	public static void main(String[] args) {
		
		int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
      
        // print the adjacency list representation of 
        // the above graph
        printAdjList(graph);
       // printGraph(graph);
	}
}
