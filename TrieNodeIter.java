//Class representing suffix trie. Currently not being used
//suffix trie for large set of files is completely eating up the available heap space & throwing exception at runtime
//since the only advantage suffix trie gives in this scenario is to allow multi token searches, we are choosing Simple Trie 
//for now.
package FileRead;

import java.util.ArrayList;

class TrieNodeIter {
	
	TrieNodeIter arr[]=new TrieNodeIter[255];
	ArrayList<Long> loc_ptr=new ArrayList<Long>();
	TrieNodeIter()
	{
		for(int i=0;i<255;i++)
			arr[i]=null;
	}
	void insert(String v,int g_i)
	{
		TrieNodeIter c_node=this;
		if(v.isEmpty() || v==null)
			return;
		
		for(int i=0;i<v.length();i++)
		{
			if(c_node.arr[v.charAt(i)]!=null)
			{
				c_node=c_node.arr[v.charAt(i)];
				c_node.loc_ptr.add((long)g_i);
				
				
			}
			else
			{
				c_node.arr[v.charAt(i)]=new TrieNodeIter();
				c_node=c_node.arr[v.charAt(i)];
				c_node.loc_ptr.add((long)g_i);
			//	c_node.arr[v.charAt(0)].insert(v.substring(1),g_i+1);
				
			}	
			System.out.print(v.charAt(i));
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
		TrieNodeIter c_node=this;
		ArrayList<Long> fl=null;
		
		for(int j=0;j<=v.length();j++)
		{
			if(j==v.length())
				return c_node.loc_ptr;
			else 
			{
				ArrayList<Long> temp_res=null,temp_res2=null;
				if((v.charAt(j)>=65&&v.charAt(j)<=90)||(v.charAt(j)>=97&&v.charAt(j)<=122))
				{
					
					if(c_node.arr[v.charAt(j)]!=null)
					{
						c_node=c_node.arr[v.charAt(j)];						
					}
					
				}
				else
				{
					if(c_node.arr[v.charAt(i)]!=null)
					{
						c_node=c_node.arr[v.charAt(i)];
					}						
					else
						break;
					
				}
			/*	if(arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65]!=null)
					return arr[(v.charAt(0)>=97)?v.charAt(0)-97:v.charAt(0)-65].find(v,i+1);
				else
					return null;*/
				
			}
			
		
		}
		
		
		return fl;
	}

}
