package graphs;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumDistanceNode {

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
	MinimumDistanceNode(int vertices,int edges)
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
 
        MinimumDistanceNode graph = new MinimumDistanceNode(V, E);
        int distance[][] = new int[V][V];
        for(int i=0;i<V;i++)
        	Arrays.fill(distance[i], Integer.MAX_VALUE);
		
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
      
        for(int i=0;i<V;i++)
        	graph.MDN(graph, i,distance);
        
        int max[] = new int[V];
        Arrays.fill(max, Integer.MIN_VALUE);
        
       /* for(int i=0;i<V;i++)
        {	
        	System.out.print("vertex "+(i+1)+"-> ");
        	for(int j=0;j<V;j++)
        	{
        		System.out.print(distance[i][j]+" ");
        	}
        	System.out.println();
        }*/
        for(int i=0;i<V;i++)
        	for(int j=0;j<V;j++)
        	{
        		if(distance[i][j]==Integer.MAX_VALUE)
        		{
        			max[i]=-1;
        			break;
        		}
        		else if(max[i]<distance[i][j])
        			max[i]=distance[i][j];
        	}
        
        
     /*   for(int i=0;i<V;i++)
        	System.out.print(max[i]+" ");
         System.out.println();*/
        
        int min=max[0],node=-1;
        for(int i=1;i<V;i++)
        {
        	if(max[i]!=-1&&max[i]<min)
        	{
        		min=max[i];
        		node=i;
        	}
        //	System.out.println(min+" "+node);
        }
        if(node==-1&&max[0]!=-1)
        	node=0;
        
        
        if(node!=-1)
        	System.out.println(min+" "+(node+1));
        else
        	System.out.println(min+" "+node);
    }


	void MDN(MinimumDistanceNode graph, int src,int distance[][]) {
		// TODO Auto-generated method stub
		int V=graph.V,E=graph.E;
		
		
		distance[src][src]=0;
		for(int i=1;i<V;i++)
		{
			for(int j=0;j<E;j++)
			{
				int u=graph.edge[j].src;
				int v=graph.edge[j].dest;
				int w=graph.edge[j].weight;
				if(distance[src][u]!=Integer.MAX_VALUE&&distance[src][u]+w<distance[src][v])
					distance[src][v]=distance[src][u]+w;
			}
		}
		
		/*for(int j=0;j<E;j++)
		{
			int u=graph.edge[j].src;
			int v=graph.edge[j].dest;
			int w=graph.edge[j].weight;
			if(distance[src][u]!=Integer.MAX_VALUE&&distance[src][u]+w<distance[src][v])
			{
				//System.out.println("There is a negative cycle");
				//System.out.println(-1);
				//printDistance(distance);
				return ;
			}
		}
		*/
		//printDistance(distance);
		
	}

	
	/*void printDistance(int[][] distance,int src) {
		// TODO Auto-generated method stub
		int V=distance.length;
		System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
        	 System.out.println(i+" \t\t "+distance[src][i]);
		
	}*/
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

4 9
0 1 1
1 0 1
0 2 4
2 0 3
1 2 2
2 1 3
2 3 5
3 2 3
3 1 1

5 8
0 1 1
0 2 4
1 2 3
1 3 2
1 4 2
3 2 5
3 1 1








4 3 3

8 8 
0 1 1
1 2 2
2 3 1
3 0 3
4 5 1
5 6 2
6 7 1
7 4 3

4 3
0 1 1
1 2 2
2 3 1


4 4
0 1 1
1 2 -1
2 3 -1
3 0 -1
*/
