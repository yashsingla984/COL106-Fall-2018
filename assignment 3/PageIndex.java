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
}