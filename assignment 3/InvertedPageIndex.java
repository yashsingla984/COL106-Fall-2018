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
}