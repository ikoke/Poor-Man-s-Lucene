package FileRead;
import java.io.*;
import java.util.*;

class ReadContents {
	 ArrayList<Character> f_cont=new ArrayList<Character>();
	 private StringBuilder s=new StringBuilder("");
	TrieNode root=new TrieNode();
	TrieNodeIter iroot=new TrieNodeIter();
	File p;
	ReadContents(File p)
	{
		this.p=p;
		System.out.println("In ReadContents= "+p.toString());
		
	}
	void ReadfrmFile()throws Exception
	{
		FileReader fr=new FileReader(p);
		System.out.println("Going to start reading now");
		while(true)
			{			
			int g=fr.read();
			if(g!=-1)
				s.append((char)g);
			else
				break;
			}
		
		//System.out.println("Result= "+s.toString());	
		fr.close();
		
	}
	void Indexer()
	{		
		System.out.println("In indexer");
		System.out.println("In indexer string is "+s);
		for(int i=0;i<s.length();i++)
			iroot.insert(s.substring(i), i);
	}
	ArrayList<Long> positionfinder(String s_t)
	{
		return iroot.find(s_t, 0);
	}

}
