package graphs;

import java.util.Arrays;
import java.util.Scanner;
//if negative cycle is present in the graph but is not connected
public class NegativeCycleThroughBellmanFord {

	class Edge
	{
		int src,dest,weight;
		Edge()
		{
			src=dest=weight=0;
		}	
	}
	
	
	int V,E;
	Edge edge[];
	private static Scanner sc;
	public NegativeCycleThroughBellmanFord(int vertices,int edges)
	{
		V=vertices;
		E=edges;
		edge = new Edge[E];
		for(int i=0;i<E;i++)
			edge[i]=new Edge();
	}
	
	
	public static void main(String[] args)
    {
        
        sc = new Scanner(System.in);
        
        int V = sc.nextInt();  // Number of vertices in graph
        int E = sc.nextInt();  // Number of edges in graph
 
        NegativeCycleThroughBellmanFord graph = new NegativeCycleThroughBellmanFord(V, E);
        
        int counter=0;
        while(counter<E)
        {
        	int x=sc.nextInt();
        	graph.edge[counter].src = x;
        	x=sc.nextInt();
            graph.edge[counter].dest = x;
            x=sc.nextInt();
            graph.edge[counter].weight = x;
        	counter++;
        }
        /*
        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
       
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
        
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
        
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
        
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
 
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
 
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
        
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
        /**/
        graph.BellmanFordStart(graph, 0);
    }


	boolean BellmanFordGraph(NegativeCycleThroughBellmanFord graph, int src,int []distance) {
		// TODO Auto-generated method stub
		int V=graph.V,E=graph.E;
		
		distance[src]=0;
		for(int i=1;i<V;i++)
		{
			for(int j=0;j<E;j++)
			{
				int u=graph.edge[j].src;
				int v=graph.edge[j].dest;
				int w=graph.edge[j].weight;
				if(distance[u]!=Integer.MAX_VALUE&&distance[u]+w<distance[v])
					distance[v]=distance[u]+w;
			}
		}
		
		for(int j=0;j<E;j++)
		{
			int u=graph.edge[j].src;
			int v=graph.edge[j].dest;
			int w=graph.edge[j].weight;
			if(distance[u]!=Integer.MAX_VALUE&&distance[u]+w<distance[v])
			{
			//	System.out.println("There is a negative cycle");
			//	printDistance(distance);
				return true;
			}
		}
		
		printDistance(distance);
		return false;
		
	}

	void BellmanFordStart(NegativeCycleThroughBellmanFord g,int src)
	{
		int V=g.V;
		boolean visited[]=new boolean[V];
		int distance[] = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int k=0;
		if(g.BellmanFordGraph(g, src, distance))
		{
			System.out.println("There is a negative cycle");
			printDistance(distance);
		}
		for(int i=0;i<V;i++)
		{
			
			if(visited[i]==false)
			{
				int f=0,in=i;
				for(int j=0;j<V;j++)
				{
					if(distance[j]!=Integer.MAX_VALUE)
						visited[j]=true;
					else
					{
						f=1;
						in=j;
					}
				}
				boolean a=g.BellmanFordGraph(g, in, distance);
				if(f==1&&a)
				{
					System.out.println("There is a negative cycle");
					printDistance(distance);
					k++;
				}
				else if(!a)
					k++;
				
			}	
		}
		System.out.println("There are "+k+" disconnected component => "+(k+1)+" total component");
		
	
	}

	void printDistance(int[] distance) {
		// TODO Auto-generated method stub
		int V=distance.length;
		System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+distance[i]);
		
	}
}

/*

5 8
0 1 -1
0 2 4
1 2 3
1 3 2
1 4 2
3 2 5
3 1 1
4 3 -3

4 4
0 1 1
1 2 -1
2 3 -1
3 0 -1

8 8 
0 1 1
1 2 -1
2 3 -1
3 0 -1
4 5 1
5 6 -1
6 7 -1
7 4 -1
*/
