package FileRead;
import java.util.*;

class TrieNode {

	TrieNode arr[]=new TrieNode[26];
	ArrayList<Long> loc_ptr=new ArrayList<Long>();
	TrieNode()
	{
		for(int i=0;i<26;i++)
			arr[i]=null;
	}
	void insert(String v,int g_i)
	{
		if(arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65]!=null)
		{
			arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65].loc_ptr.add((long)g_i);
			arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65].insert(v.substring(1),g_i+1);
		}
		else
		{
			arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65]=new TrieNode();
			arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65].loc_ptr.add((long)g_i);
			arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65].insert(v.substring(1),g_i+1);
			
		}		
		
	}
	
	ArrayList<Long> find(String v,int i)
	{
		
		if(i==v.length()-1)
			return loc_ptr;
		else 
		{
			if(arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65]!=null)
				return arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65].find(v,i+1);
			else
				return null;
		}
			
		
	}
	
}
