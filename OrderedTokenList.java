//Class used to generate the neighborhood of each occurrence of the search term. 
//It stores each line of each indexed file as a separate token
//Since we store the line numbers where a particular token appear in the trie, we can easily use that to index into
//the Lst arraylist in this class & get the neighborhood of reference of the search token.
package FileRead;

import java.util.*;

class OrderedTokenList {
private ArrayList<String> Lst=new ArrayList<String>();

void put(String j)
{
	Lst.add(j);
}

void get(int i)
{
	System.out.print(Lst.get(i)+" ");
	System.out.println();
	
}
}
