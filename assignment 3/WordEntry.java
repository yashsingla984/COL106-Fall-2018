import java.util.*;
import java.io.*;
import java .lang.*;
public class WordEntry extends MyLinkedList
{
	MyLinkedList<Position> wordspositionlist;
	String str;
	//Position p;
	WordEntry(String word)
	{
		this.str=word;
		wordspositionlist =new MyLinkedList<Position>();
	}
	public void addPosition(Position position)
	{
        this.wordspositionlist.Insert(position);
       
	}
	public void addPositions(MyLinkedList<Position> positions)
	{
      Node<Position> tmp=positions.head;
      while(tmp!=null)
      {
      	this.wordspositionlist.Insert((Position)tmp.data);  //tmp.data is of Position type
      	tmp=tmp.next;
      }
	}
	public MyLinkedList<Position> getAllPositionsForThisWord()
	{
      return wordspositionlist;
	}
	public String getword()
	{
		return str;
	}
	//public float getTermFrequency(String word)
	//{

      // return 0.0;
	//}
}