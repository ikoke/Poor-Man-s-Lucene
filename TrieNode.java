package FileRead;
import java.util.*;

class TrieNode {

	TrieNode arr[]=new TrieNode[255];
	ArrayList<Long> loc_ptr=new ArrayList<Long>();
	TrieNode()
	{
		for(int i=0;i<255;i++)
			arr[i]=null;
	}
	void insert(String v,int g_i)
	{
		if(v.isEmpty() || v==null)
			return;
		
		if(arr[v.charAt(0)]!=null)
		{
			arr[v.charAt(0)].loc_ptr.add((long)g_i);
			System.out.print(v.charAt(0));
			arr[v.charAt(0)].insert(v.substring(1),g_i+1);
		}
		else
		{
			arr[v.charAt(0)]=new TrieNode();
			arr[v.charAt(0)].loc_ptr.add((long)g_i);
			System.out.print(v.charAt(0));
			arr[v.charAt(0)].insert(v.substring(1),g_i+1);
			
		}	
		
		
	/*	if(arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65]!=null)
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
		*/
	}
	
	ArrayList<Long> find(String v,int i)
	{
		
		if(i==v.length())
			return loc_ptr;
		else 
		{
			ArrayList<Long> temp_res=null,temp_res2=null;
			if((v.charAt(i)>=65&&v.charAt(i)<=90)||(v.charAt(i)>=97&&v.charAt(i)<=122))
			{
				
				if(arr[v.charAt(i)]!=null)
					temp_res=arr[v.charAt(i)].find(v,i+1);
				if(v.charAt(i)>=97&&arr[v.charAt(i)-32]!=null)
					temp_res2=arr[v.charAt(i)-32].find(v,i+1);
				else if(v.charAt(i)<=90&&arr[v.charAt(i)+32]!=null)
					temp_res2=arr[v.charAt(i)+32].find(v,i+1);
				if(temp_res!=null&&temp_res2!=null)
				 temp_res.addAll(temp_res2);
				else if(temp_res!=null)
					return temp_res;
				else 
					return temp_res2;
				
			}
			else
			{
				if(arr[v.charAt(i)]!=null)
					return arr[v.charAt(i)].find(v,i+1);
				else
					return temp_res;
				
			}
		/*	if(arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65]!=null)
				return arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65].find(v,i+1);
			else
				return null;*/
			return temp_res;
		}
			
		
	}
	
}
