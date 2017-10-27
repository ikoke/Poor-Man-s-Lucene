package FileRead;
import java.io.*;
import java.util.*;
public class Main {
	ArrayList<File> ftotalist=new ArrayList<File>(); 
static int i=10;static int fc=0;static int dc=0;
ArrayList<ReadContents> f_arr;
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
	System.out.println("Accepted= "+path);
	ArrayList<File> flist=new ArrayList<File>();
	File s=new File(path);
	flist.add(s);
	System.out.println(s.getPath());
	
	int lc=0;
	for(File f:flist)
		System.out.print(f.getName()+"=====");
	do {
		System.out.println(lc+++" and "+flist.get(0).getPath());
	if(flist.get(0).isDirectory())
	{
		String flist_t[]=new String[(flist.get(0).list()).length];
		flist_t=flist.get(0).list();
		dc++;
		System.out.print("children being added number as "+flist_t.length+" and they are= ");
		for(String pitem:flist_t)
		{
			
			System.out.print(flist.get(0).getPath()+"\\"+pitem+",");
			flist.add(flist.size(),new File(flist.get(0).getPath()+"\\"+pitem));
			
		}
		System.out.println("Being deleted= "+flist.get(0));
		flist.remove(0);
		
		System.out.println(";");
			
	}
	else {
		System.out.println("File name= "+flist.get(0).getName());

		System.out.println("Being deleted= "+flist.get(0));
		ftotalist.add(flist.get(0));
		flist.remove(0);
		fc++;
			}
		//flist.add(s);
		System.out.println("List at end of"+ lc+"th cycle= ");
		for(File f:flist)
		System.out.print(f.getName()+",");
		System.out.println();
	}while(flist.size()>0&&lc<=500000);
	System.out.println("Out of there! Total number of files= "+fc+" and of directories= "+dc);
}
void Invoke_Reader()
{
	
	for(File p:ftotalist)
	{
		try 
		{
			f_arr.add(new ReadContents(p));
			f_arr.get(f_arr.size()-1).ReadfrmFile();			
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
		try 
		{
			p.Indexer();
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
			ArrayList<Long> res=f.positionfinder(q_st);
			if(res!=null)
			{
				System.out.println("FOUND IN FILE "+f.p.getAbsolutePath()+":-");
				for(long t:res)
				{
					System.out.println("        At position "+(t-q_st.length()));
				}
			}
			
		}
		System.out.println("Got anymore ?");
		conti=Boolean.parseBoolean(br.readLine());
	}
}


}
