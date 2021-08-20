import java.util.*;
import java.io.*;
import java .lang.*;
public class MySet<X> //extends MyLinkedList
{
  Node<X> head; //declaring starting node and end node
  Node<X> tail;
	 /*public class Node
    {
      X data;
      Node next;
      Node(X d)
      {
        data=d;
        next=null;
      }
    }*/
    //public MySet()
	//Node<X> head=null; //declaring starting node and end node
	//Node<X> tail=null;
  //tail=null;
	int size=0;
	public void addElement(X element)
	{
		if(head==null)
	  {
      Node<X> tt=new Node<X>(element);
		head=tt;
		tail=head;
		size=size+1;
	   }
	  else
	  {
      Node<X> tt=new Node<X>(element);
		tail.next=tt;
	    tail=tail.next;
	    size=size+1;
	   }
		
	}
	public Node<X> getelement(int i)
{
	Node<X> temp=head;
	for(int k =0;k<i;i++)
		{
	
			temp=temp.next;
		}
		return temp;
}
  public Boolean IsMember(X o)
  {
    Node<X> current=head;
    while(current!=null)
   {
    if(current.data.equals(o))
      return true;
    current=current.next; 
   }
    return false;
    }

	/*Boolean isPresent (Node head, X data)
    {
        Node<X> t = head;
        while (t != null)
        {
            if (t.data == data)
                return true;
            t = t.next;
        }
        return false;
    }*/
	public MySet<X> union(MySet<X> otherSet)
	{
		MySet<X> c=new MySet<X>();
		Node<X> t1=this.head;
		Node<X> t2=otherSet.head;
    
		if(otherSet.size==0)
		  return this;
		else 
		{
		  if(this.size==0)
			 return otherSet;
		}
		
		while(t2!=null)
    {
      if(!this.IsMember(t2.data))
      {
        this.addElement(t2.data);
      }
      else
      {
        t2=t2.next;
      }
    }
    return this;


	}
	public MySet<X> intersection(MySet<X> otherSet)
	{
		MySet<X> n = new MySet<X>();
        //if (this.isEmpty())
            //return n;
          Node<X> t1=this.head;
          Node<X> t2=otherSet.head;
          while(t2!=null)
          {
            if(this.IsMember(t2.data))
              {
                n.addElement(t2.data);
              }
              t2=t2.next;
          }
        return n;
	}		

	
}