//Point of entry for program. Iterates through the input path & creates list of all files. Creates a ReadContents object for each file
//Also accepts the queries & returns the results of each query in sub-second time leveraging ReadContents class & TrieNode class
package FileRead;
import java.io.*;
import java.util.*;
public class Main {
	ArrayList<File> ftotalist=new ArrayList<File>(); 
static int i=10;static int fc=0;static int dc=0;
//ArrayList<ReadContents> f_arr;
ArrayList<ReadContents> f_arr=new ArrayList<ReadContents>();
public static void main(String args[])throws IOException
{
	Main code=new Main();
	try {
		code.FileListMaker();
		code.Invoke_Reader();
		code.QueryRunner();
	}
	catch(Exception e)
	{
		System.err.println("Dumb- that caused an exception");
	}
	
}

void FileListMaker()throws IOException
{
	System.out.println("Enter path:- ");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String path=br.readLine();
//	System.out.println("Accepted= "+path);
	ArrayList<File> flist=new ArrayList<File>();
	File s=new File(path);
	flist.add(s);
	//System.out.println(s.getPath());
	
	int lc=0;
	do {
	//	System.out.println(lc+++" and "+flist.get(0).getPath());
	if(flist.get(0).isDirectory())
	{
		String flist_t[]=new String[(flist.get(0).list()).length];
		flist_t=flist.get(0).list();
		dc++;
	//	System.out.print("children being added number as "+flist_t.length+" and they are= ");
		for(String pitem:flist_t)
		{
			
		//	System.out.print(flist.get(0).getPath()+"\\"+pitem+",");
			flist.add(flist.size(),new File(flist.get(0).getPath()+"\\"+pitem));
			
		}
	//	System.out.println("Being deleted= "+flist.get(0));
		flist.remove(0);
		
	//	System.out.println(";");
			
	}
	else {
	//	System.out.println("File name= "+flist.get(0).getName());
		
//		System.out.println("Being deleted= "+flist.get(0));
		ftotalist.add(flist.get(0));
		flist.remove(0);
		fc++;
			}
	
	}while(flist.size()>0);
//	System.out.println("Out of there! Total number of files= "+fc+" and of directories= "+dc);
}
void Invoke_Reader()throws IOException
{
	@SuppressWarnings("unused")
	ReadContents t_obj;	
	for(File p:ftotalist)
	{
	//	System.out.println("Hohoho ="+p.toString());
		try 
		{
			t_obj=new ReadContents(p);
			t_obj.ReadfrmFile();
			f_arr.add(t_obj);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File "+p.getAbsolutePath()+" not found");
		}
		catch(Exception e)
		{
		   System.out.println("Some other shit happened when trying to objectify "+p.getAbsolutePath()+". The exact error i= "+e.toString());
		}		
	}
	for(ReadContents p:f_arr)
	{
		//System.out.println("File= "+p.p.toString());
		
		try 
		{
			//p.Indexer();
			p.WordIndexer();
		}
		catch(Exception e)
		{
			System.out.println("Error while indexing file "+p.p.getName()+". Exact error is "+e.toString());
		}
		
	}
//	System.out.println("Out of there! Total number of files= "+fc+" and of directories= "+dc);
}

void QueryRunner()throws Exception
{
	boolean conti=true;
	while(conti)
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter search text= ");
		String q_st=br.readLine();
		for(ReadContents f:f_arr)
		{
			//System.out.println("Searching in file= "+f.p.toString());
			ArrayList<Long> res=null;
			res=f.positionfinder(q_st);
			if(res!=null)
			{				
				System.out.println("FOUND IN FILE "+f.p.getAbsolutePath()+":-");
				System.out.println("Number of times= "+res.size());
				for(long t:res)
				{
					System.out.println("        At line "+(t));
					System.out.println("context= ");
					f.otl.get((int)t);
				}
			}
			
		}
	//	if(flag==0)
		//	System.out.println("Not found");
		System.out.println("Got anymore ?");
		conti=Boolean.parseBoolean(br.readLine());
	}
}


}
