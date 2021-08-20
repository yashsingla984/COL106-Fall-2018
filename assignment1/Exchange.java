import java.util.*;
import java.io.*;
import java .lang.*;
class Exchange
{
	int uniqueid;
	int childrensize;// size of children linklist
	Exchange parnt;
	Linklist childrens;
	MobilePhoneSet newresidentset=new MobilePhoneSet(); //consists of many mobile numbers in 1 exchange

	Exchange(int number)
	{
		this.uniqueid=number;
		this.parnt=null;           //because exchange has no parent
		childrens=new Linklist();
		this.childrensize=0;        //initially childrensize is 0 because 



	}
	public Exchange parent()
	{
		return this.parnt;

	}
	public int numChildren()
	{
		childrensize=childrens.size;

		return childrensize;

	}
	public Exchange child(int i)
	{
		int variable=1;
		Node temp=childrens.head;
		//if(temp==null)
			//return null;
		while(temp!=null)
		{
			if(variable==i)
				return (Exchange)temp.data;
			else
			{
				variable++;
				temp=temp.next;
			}
		}

			
return null;
	}

	public Boolean isRoot()
	{
		if(this.parnt==null)
		   return true;
		else 
			return false;

	}
	public RoutingMapTree subtree(int i)
	{
     if(this.child(i)==null)
      return null;
      RoutingMapTree newbaba=new RoutingMapTree(this.child(i));
      return newbaba;
	}
	public MobilePhoneSet residentSet()
	{
		return newresidentset;
		
	}
}