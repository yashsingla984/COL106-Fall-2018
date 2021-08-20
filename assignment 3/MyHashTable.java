import java.util.*;
import java.io.*;
class MyHashTable
{
	PageIndex [] htable;
	
	int numbuckets=100;
   public MyHashTable()
	{
           htable=new PageIndex[numbuckets];
	}


	 public int getHashIndex(String str)
	 {
	 	int hcode=str.hashCode();
	 	if(hcode<0)
	 	{
	 		hcode=(hcode%numbuckets)+numbuckets;
	 	}
	 	int hindex=hcode%numbuckets;
	 	return hindex;

	 }
	  public void addPositionsForWord(WordEntry w)
	  {
	  	String s=w.str;
	  	int hashindofs=getHashIndex(s);  //hash index of s
	  	MyLinkedList<Position> woptions=w.getAllPositionsForThisWord();  //we get all positions for this word
	  	if(htable[hashindofs]==null)
	  	{
	  		PageIndex tp=new PageIndex();
	  		Node<Position> tt=woptions.head;
	  		while(tt!=null)
	  		{

               tp.addPositionForWord(w.getword(),tt.data);
               tt=tt.next;
	  		}

            htable[hashindofs]=tp;
	  	}
	  	else
	  	{
	  		Node<WordEntry> tmp=htable[hashindofs].getWordEntries().head;
	  	     while(tmp!=null)
	  	       {
	  	       	if(tmp.data.getword().equals(s))
	  	       	{
	  	       		Node<Position> tt=woptions.head;
                     while(tt!=null)
	  		           {

                         htable[hashindofs].addPositionForWord(w.getword(),tt.data);
                         tt=tt.next;
	  		           }
	  		           break;
	  	       	}
	  	       	tmp=tmp.next;
	  	       }
	  	       htable[hashindofs].getWordEntries().Insert(w);
	  	}
	  	
	  	
	  



	  }
}
class hashnode<v>
{
	v value;
	hashnode<v> next;

	//constructor
	hashnode(v Value)
	{
		this.value=Value;
	}
}