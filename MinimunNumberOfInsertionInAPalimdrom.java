package algorithms;

import java.util.Scanner;

public class MinimunNumberOfInsertion {

	
	//Recursive Version
	
	private static Scanner sc;
	int MNI(char s[],int l,int h)
	{
		//System.out.println(s[l]+" "+s[h]);
		if(l>h)
			return Integer.MAX_VALUE;
		if(l==h)
			return 0;
		if(l==h-1)
		{
			return s[l]==s[h]?0:1;
			/*if(s[l]==s[h])
				return 1;
			else
			{
				System.out.println("Add "+s[h]+" at "+h);
				return 0;
			}*/
		}
		return s[l]==s[h]?MNI(s,l+1,h-1):Math.min(MNI(s,l+1,h),MNI(s,l,h-1) )+1;
			
	}/**/
	
	
	//Dynamic version
	void MNIDynamic(char s[],int n)
	{
		int table[][] = new int[n][n];
		/*
		//By default values are zero in array;
		Arrays.fill(table[0], 1);
		Arrays.fill(table[0], 1);
		for(int i=0;i<=h;i++)
			table[0][i]=0;*/
		
		
		
		for(int gap=1;gap<n;gap++)
		{
			for(int l=0,h=gap;h<n;l++,h++)
			{
				table[l][h] = (s[l] == s[h])?
                        table[l+1][h-1] :
                        (Math.min(table[l][h-1], 
                         table[l+1][h]) + 1);
			}
			//System.out.println();
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		String s=sc.next();
		char a[]= s.toCharArray();
		MinimunNumberOfInsertion mni=new MinimunNumberOfInsertion();
		System.out.println(String.copyValueOf(a));
		System.out.println(mni.MNI(a, 0, a.length-1));
		mni.MNIDynamic(a,a.length);
	}
}
