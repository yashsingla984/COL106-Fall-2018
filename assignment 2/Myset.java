import java.util.*;
import java.io.*;
import java .lang.*;

class Myset
{
	Node head=null; //declaring starting node and end node
	Node tail=null;
	int size=0;

	public Boolean IsEmpty()
	{
	 if(size==0)
	 	return true;
	 else 
	 	return false;
    }
	public Boolean IsMember(int o)
	{
		Node current=head;
	  while(current!=null)
	 {
		if(((MobilePhone)current.data).newmobile==o)
			return true;
		current=current.next;
		
	 }
	  return false;
    }

	public void Insert(MobilePhone o)
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
	public void Delete(MobilePhone o)
	{
		Node temp=head;
	   Node prev=null;
	// If head node itself holds the key to be deleted
	    if(temp!=null&&temp.data==o)
	   {
		  head=temp.next;
		  temp=null;
		  return;
	    }
	      // Search for the key to be deleted, keep track of the
          // previous node as we need to change temp.next
	    while (temp != null && temp.data != o)
        {
            prev = temp;
            temp = temp.next;
        } 
         // If key was not present in linked list
        if (temp == null) return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    
    }
    
    Boolean isPresent (Node head, MobilePhone data)
    {
        Node t = head;
        while (t != null)
        {
            if (t.data == data)
                return true;
            t = t.next;
        }
        return false;
    }
	public Myset Union(Myset a)
	{
		Myset c=new Myset();
		Node t1=this.head;
		Node t2=a.head;
		if(a.size==0)
			return this;
		else 
			if(this.size==0)
				return a;
		while (t1 != null)
        {
            Node new_node = new Node(t1.data);
 
            /*Make next of new Node as head */
           new_node.next = c.head;
 
        /*Move the head to point to new Node */
          c.head = new_node;
          t1=t1.next;
        }
 
        // insert those elements of list2 that are not present
        while (t2 != null)
        {
            if (!isPresent(c.head, (MobilePhone)t2.data))
                {
                	Node new_node = new Node(t2.data);
 
                    /*Make next of new Node as head */
                     new_node.next = c.head;
 
                  /*Move the head to point to new Node */
                      c.head = new_node;
                }
           
            t2 = t2.next;
        }
        return c;
		
         

	}
	public Myset Intersection(Myset a)
	{
		Myset d=new Myset();
		Node result = null;
        Node t1 = head;
        Node t2= a.head;
        if(t1==null||t2==null)
        	return null;
        while (t1 != null)
        {
            if (isPresent(t2, (MobilePhone)t1.data))
            {
                Node new_node = new Node(t1.data);
 
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







