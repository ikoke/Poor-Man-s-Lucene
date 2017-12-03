//Class representing trie node. 
//Each node contains a list of line indexes which contain the word terminating at that particular node
//So we can easily return the lines where the search term occurred
//Contains methods for trie insertion & search
package FileRead;
import java.util.*;

class TrieNode {

	TrieNode arr[]=new TrieNode[255];
//	ArrayList<Long> loc_ptr=new ArrayList<Long>();
	ArrayList<Long> tok_cntr=new ArrayList<Long>();
	int flag=0;
	TrieNode()
	{
		for(int i=0;i<255;i++)
			arr[i]=null;
	}
	void insert(String v,int i)
	{
		if(v.isEmpty() || v==null)
		{
			flag=1;
			tok_cntr.add((long)i);
			return;
		}
		
		if(v.charAt(0)>255)
			System.out.println("I'm afraid you are going out of our supported charset. amigo.");
			
		
		if(arr[v.charAt(0)]!=null)
		{
			//arr[v.charAt(0)].loc_ptr.add((long)g_i);
		//	System.out.print(v.charAt(0));
			arr[v.charAt(0)].insert(v.substring(1),i);
		}
		else
		{
			
			arr[v.charAt(0)]=new TrieNode();
		//	arr[v.charAt(0)].loc_ptr.add((long)g_i);
		//	System.out.print(v.charAt(0));
			arr[v.charAt(0)].insert(v.substring(1),i);
			
		}	
		
	}
	
	ArrayList<Long> find(String v,int i)
	{
		//System.out.println("Matched till "+((i-1>=0)?i-1:"not till now"));
		
		if(i==v.length())
		{
			//System.out.println("Aha! Matched!");
			return tok_cntr;
		}
			
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
				{
					temp_res.addAll(temp_res2);
					return temp_res;
				} 
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
		
		}
			
		
	}
	
}
