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

	Boolean isPresent (Node head, X data)
    {
        Node<X> t = head;
        while (t != null)
        {
            if (t.data == data)
                return true;
            t = t.next;
        }
        return false;
    }
	public MySet<X> union(MySet<X> otherSet)
	{
		MySet<X> c=new MySet<X>();
		Node<X> t1=this.head;
		Node<X> t2=otherSet.head;
    
		if(otherSet.size==0)
		  return this;
		else 
		  if(this.size==0)
			 return otherSet;
		while (t1 != null)
        {
         // Node<X> tt=new Node<X>(o);
          Node<X> new_node =t1;//Node(t1.data);
         // new_node = Node(t1.data);
 
            /*Make next of new Node as head */
           new_node.next = c.head;
 
        /*Move the head to point to new Node */
          c.head = new_node;
          t1=t1.next;
        }
        // insert those elements of list2 that are not present
        while (t2 != null)
        {
            if (!isPresent(c.head,t2.data))
                {
                	Node<X> new_node =t2;
                  //Node<X> new_node = Node(t2.data);

 
                    /*Make next of new Node as head */
                     new_node.next = c.head;
 
                  /*Move the head to point to new Node */
                      c.head = new_node;
                }
           
            t2 = t2.next;
        }
        return c;

	}
	public MySet<X> intersection(MySet<X> otherSet)
	{
		MySet<X> d=new MySet<X>();
		//Node<X> result = new Node<X>();
    //result = null;
        Node<X> t1 = this.head;
        //t1 = this.head;
        Node<X> t2= otherSet.head;
        //t2= otherSet.head;
        if(t1==null||t2==null)
        	return null;
        while (t1 != null)
        {
            if (isPresent(t2,t1.data))
            {
                Node<X> new_node = t1;//new Node(t1.data);
 
                    /*Make next of new Node as head */
                     new_node.next = d.head;
 
                  /*Move the head to point to new Node */
                      d.head = new_node;
            }
            t1 = t1.next;
        }
        return d;
	}		

	
}