import java.util.*;
import java.io.*;
import java .lang.*;
class Linklist
{
	Node head;
	Node tail;
	int size;
	public void LinkList()
	{
		head=null;
		tail=null;
		size=0;
	}
	
public void Insertfront(Object o)
{
	if(head==null)
	{
		head=new Node(o);
		size=size+1;
	}
	else
	{
		Node tmp=new Node(o);
		tmp.next=head;
		head=tmp;
		size=size+1;

	}
}
public void Insert(Object o)
	{
	  if(head==null)
	  {
		head=new Node(o);
		tail=head;
		size=size+1;
	   }
	  else
	  {
		tail.next=new Node(o);
	    tail=tail.next;
	    size=size+1;
	   }
	   
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

}*/
public Boolean IsMember(Object o)
	{
		Node current=head;
	  while(current!=null)
	 {
		if(current.data.equals(o))
			return true;
		current=current.next;	
	 }
	  return false;
    }

public void Delete(Object o)
	{
		Node temp=head;
	   Node prev=null;
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

//public static void main(String[] args) 
//{
	//Myset list1=new Myset();
	//list1.add(1);
	//list1.add(15);
	//list1.add(115);
	//list1.add(51);
	//list1.add(18);
	//list1.print();
	
//}
}
