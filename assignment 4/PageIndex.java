import java.util.*;
import java.io.*;
import java .lang.*;
public class PageIndex
{
	MyLinkedList<WordEntry> wordsentries;
	PageIndex()
	{
		wordsentries=new MyLinkedList<WordEntry>();
	}
	public void addPositionForWord(String str, Position p)
	{
		//MyLinkedList<Position> wd=new MyLinkedList<Position>();
		//wd.IsMember(str);
		boolean pre =false;
		Node<WordEntry> ttmp=wordsentries.head;
		while(ttmp!=null)
		{
			if(ttmp.data.getword().equals(str))
			{
				pre=true;
				ttmp.data.addPosition(p);
				break;
			}
			else
				ttmp=ttmp.next;
		}
		
		/*if(wordsentries.wd.IsMember(str)==true)
		{
			Node<WordEntry> tmp=wordsentries.head;
			while(!tmp.data.equals(str))
			{
				tmp=tmp.next;
			}
			tmp.data.addPosition(p);
		}*/
		if(pre==false)
		{
		 WordEntry w1=new WordEntry(str);
         wordsentries.Insert(w1);
         w1.addPosition(p);
        }
	}
	public MyLinkedList<WordEntry> getWordEntries()
	{
		
		return wordsentries;
	}
	public Node<WordEntry> getworddata(String w)
	{
		Node<WordEntry> wd=wordsentries.head;
		while(wd!=null)
		{
			if(wd.data.str.equals(w))
			{
			    return wd;
			}
			else
			{
				wd=wd.next;
			}
		}
		return wd;    //check it again not sure some error maybe
	}
	public boolean wordsearch(String w)
	{
		boolean answer=false;
		Node<WordEntry> wdtemp=wordsentries.head;
	       while(wdtemp!=null)
	       {
	       	if(wdtemp.data.str.equals(w))
	       	{
	       		answer=true;
	       		break;
	       	}
	       	else
	       		wdtemp=wdtemp.next;
	       }
	       return answer;
	}
	
}