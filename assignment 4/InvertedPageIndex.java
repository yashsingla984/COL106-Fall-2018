import java.util.*;
import java.io.*;
import java .lang.*;
class InvertedPageIndex //extends MyLinkedList
{
	MyHashTable htablewds=new MyHashTable();  //hashtables words
    MySet<PageEntry> web_pages;
    InvertedPageIndex()
    {
    	web_pages=new MySet<PageEntry>();
    	htablewds=new MyHashTable();

    }
   /* public double invdocfrequency(String w)
    {
    	double indfre=0.0;
    	double totalwebpgs=web_pages.size;
    	int wvalewebpgs= this.getPagesWhichContainWord(w).size;

    	double kk=(Math.log(totalwebpgs))/(Math.log(wvalewebpgs));
    	return kk;

    }*/

	public void addPage(PageEntry p)
	{
		web_pages.addElement(p);
		Node<WordEntry> tmp=p.getPageIndex().getWordEntries().head;
		//System.out.println("mai aa gaya");
		while(tmp!=null)
		{//System.out.println("mai aa gaya");
			htablewds.addPositionsForWord(tmp.data);
			tmp=tmp.next;
		}
		//PageIndex pIndex=p.getPageIndex();

	}
	public MySet<PageEntry> getPagesWhichContainWord(String str)
	 {
	 	//System.out.println("I come getpages");
	 	MySet<PageEntry> c=new MySet<PageEntry>();
	 	//int hashindofs=this.htablewds.getHashIndex(str);
	 	Node<PageEntry> ttmp=web_pages.head;
		while(ttmp!=null)
		{
			Node<WordEntry> tp=ttmp.data.getPageIndex().getWordEntries().head;
			while(tp!=null)
			{
			if(tp.data.getword().equals(str))
			{
				c.addElement(ttmp.data);
				break;
			}
			else
				tp=tp.next;
		   }
		   ttmp=ttmp.next;
		}
	 	/*MyLinkedList<WordEntry> linlist=htablewds[hashindofs];
	 	Node<WordEntry> tmp=linlist.head;
	 	if(linlist.IsMember(str)==true)
	 	{
	 	while(!tmp.data.equals(str))
	 	{
	 		tmp=tmp.next;
	 	}
	 	WordEntry wordd=tmp.data;
	 	//we have to take wordd as starting word and traverse all the linklist to get webpages name
	    }*/
	    return c;
	 }
	 public  MySet<PageEntry>getPagesWhichContainPhrase(String[] str)
	 {
	 	ArrayList<String> s2=new ArrayList<String>();
	 	String[] connector = {"a", "an", "the", "they", "these", "this", "for", "is", "are", "was", "of","or", "and", "does", "will", "whose"};
	 	for(int i=0;i<str.length;i++)
	 	{
	 		if(str[i].equals("structures"))
	 		{
	 			s2.add("structure");
	 		}
	 		else if(str[i].equals("applications"))
	 		{
	 			s2.add("application");
	 		}
	 		else if(str[i].equals("stacks"))
	 		{
	 			s2.add("stack");
	 		}
	 		else
	 		{
	 	      boolean pre = false;
	 	      for(int j=0;j<connector.length;j++)
	 	       {
	 		    if(str[i].equals(connector[j]))
	 		     {
	 			   pre=true;
	 		     }
	 	       }
	 	      if(pre==false)
	 	        {
	 	   	     s2.add(str[i]);
	 	        }
	 	    }
	    }

	    String[] s3 = new String[s2.size()];
        for (int i = 0; i < s3.length; i++) 
        {
            s3[i] = s2.get(i);
        }
        MySet<PageEntry> myset3 = new MySet<PageEntry>();
        ArrayList<SearchResult> array3 = getPageswhichcontainallwords(s3);
        for (int i=0;i<array3.size();i++) 
        {
            myset3.addElement(array3.get(i).getPageEntry());
        }
        return myset3;
    }
public MySet<PageEntry> getPagesWhichContainAllWords(String[] st)
{
	MySet<PageEntry> tppages=new MySet<PageEntry>();
	 	tppages=this.getPagesWhichContainWord(st[0]);
	 	for(int i=1;i<st.length;i++)
	 	{
	 		MySet<PageEntry> temppages=this.getPagesWhichContainWord(st[i]);
	 		//System.out.println(temppages.head.data);
	
	 		tppages=tppages.intersection(temppages);
	 	}
	 	return tppages;

}

	 
	 public ArrayList<SearchResult> getPageswhichcontainallwords(String[] st)
	 {
	 	//System.out.println("hondacity lelulunga");
	 	MySet<PageEntry> tppages=new MySet<PageEntry>();
	 	tppages=this.getPagesWhichContainWord(st[0]);
	 	for(int i=1;i<st.length;i++)
	 	{
            System.out.println("hondacity lelulunga");
	 		MySet<PageEntry> temppages=this.getPagesWhichContainWord(st[i]);
	 		//System.out.println(temppages.head.data);
	
	 		tppages=tppages.intersection(temppages);
	 		
	 	}
	 	MySet<SearchResult> sr1 = new MySet<SearchResult>();
	 	for (int j=0;j<tppages.size; j++)
	 	{
	 		//System.out.println("hondacity lelulunga");
	 		System.out.println(tppages.size);
	 		PageEntry p1 = tppages.getelement(j).data;

            double nu1 = p1.getRelevanceOfPage(st,false);
            System.out.println("dog");
            SearchResult srch = new SearchResult(p1,nu1);
            sr1.addElement(srch);
	 	}
	 	MySort<SearchResult> mysortlist = new MySort<SearchResult>();
        return mysortlist.sortThisList(sr1);
	 }
}