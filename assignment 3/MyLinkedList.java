import java.util.*;
import java.io.*;
import java .lang.*;
class MyLinkedList<X>
{
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
	Node<X> head;
	Node<X> tail;
	int size;
	public MyLinkedList()
	{
		//head=new Node<X>();
		head=null;
		//tail=new Node<X>();
		tail=null;
		size=0;
	}
public void Insertfront(X o)
{
	if(head==null)
	{
		Node<X> tt=new Node<X>(o);
		head=tt;
		size=size+1;
	}
	else
	{
		Node<X> tmp=new Node<>(o);             //=new Node<X>();
		//tmp=Node(o);
		tmp.next=head;
		head=tmp;
		size=size+1;

	}
}
public void Insert(X o)
	{
	  if(head==null)
	  {
	  	Node<X> tt=new Node<X>(o);
		head=tt;
		tail=head;
		size=size+1;
	   }
	  else
	  {
	  	Node<X> tt=new Node<X>(o);
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

public void Delete(X o)
	{
	   Node<X> temp=head;
	   Node<X> prev=null;
	// If head node itself holds the key to be deleted
	    if(temp!=null&&temp.data.equals(o))
	   {
		  head=temp.next;
		  temp=null;
		  return;
	    }
	      // Search for the key to be deleted, keep track of the
          // previous node as we need to change temp.next
	    while (temp != null && !temp.data.equals(o))
        {
            prev = temp;
            temp = temp.next;
        } 
         // If key was not present in linked list
        if (temp == null) return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    
    }
/*void print()
{
	Node n=head;
	while(n!=null)
	{
		System.out.println(+n.data);
		n=n.next;
	}
	System.out.println(+size);

}  */
/*public static void main(String[] args) 
{
	MySet<X> list1=new MySet<X>();
	list1.add(1);
	list1.add(15);
	list1.add(115);
	list1.add(51);
	list1.add(18);
	list1.print();
	
}*/
}    
