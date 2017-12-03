//Encapsulates all information regarding one file, including the head pointer of the trie built for that file,
//and the list of lines in the file, stored in sequential order
package FileRead;
import java.io.*;
import java.util.*;

class ReadContents {
	ArrayList<Character> f_cont=new ArrayList<Character>();
	private StringBuilder s=new StringBuilder("");
	OrderedTokenList otl=new OrderedTokenList();
	TrieNode root=new TrieNode();
	TrieNode sep_words_root=new TrieNode();
	//TrieNodeIter iroot=new TrieNodeIter();
	File p;
	ReadContents(File p)
	{
		this.p=p;
	//	System.out.println("In ReadContents= "+p.toString());
		
	}
	void ReadfrmFile()throws Exception
	{
		FileReader fr=new FileReader(p);
	//	System.out.println("Going to start reading now");
		while(true)
			{			
			int g=fr.read();
			if(g!=-1)
				s.append((char)g);
			else
				break;
			}
		
	//	System.out.println("Result= "+s.toString());	
		fr.close();
		
	}
/*	void Indexer()
	{		
	//	System.out.println("In indexer");
	//	System.out.println("In indexer string is "+s);
		for(int i=0;i<s.length();i++)
			iroot.insert(s.substring(i), i);
	}*/
	void WordIndexer()
	{		
		//System.out.println("In word-indexer");
		//System.out.println("In word-indexer string is "+s);
		StringTokenizer st=new StringTokenizer(s.toString(),"\n");
		int c=0;
		while(st.hasMoreTokens())		
		{
			String token=st.nextToken();
			StringTokenizer st1=new StringTokenizer(token,",;=()[]{}. +-/*");
			
			while(st1.hasMoreTokens())
			{
				String token1=st1.nextToken();
				sep_words_root.insert(token1,c);
			}
			
		//	System.out.println(token);
			otl.put(token);
			c++;
		}
			
		
		
	}
	ArrayList<Long> positionfinder(String s_t)
	{
		//return iroot.find(s_t, 0);
		return sep_words_root.find(s_t, 0);
	}
	
	

}
