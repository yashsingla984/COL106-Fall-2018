import java.util.*;
import java.io.*;
import java .lang.*;
class RoutingMapTree
{
	Exchange rootnode=null;
	RoutingMapTree()
	{
		rootnode=new Exchange(0); //initializing conditions giving position 0

	}
	RoutingMapTree(Exchange x)
	{
		rootnode=x;
	}
	public void switchOn(int a , int b )
	{
		  
		Exchange mynewmobilexchange=searchExchangen(b,rootnode); //we go for searching node of a in tree

		MobilePhone n=new MobilePhone(a);
		n.switchOn();
		
		mynewmobilexchange.newresidentset.x.Insert(n); //we are inserting in its MobilePhoneSet
		/*try{
				a.switchOn();
				b.childrens.Insert(a);
		}
		catch(Exception en)
		{
			System.out.println("");
		}*/


	}
	 public Boolean containsNode(Exchange a)
	 {
       if(rootnode.uniqueid==a.uniqueid)
       	return true;
       Exchange searchnode=searchExchangen(a.uniqueid,rootnode);
       Boolean mytrue=false;
       if(searchnode.uniqueid==a.uniqueid)
       	mytrue=true;
			return mytrue;
       
	 }
	 public Exchange searchExchangen(int uniqid,Exchange node)    //we were traversing the tree to find node which related given uniqueid of excange
	 {
	 	if(uniqid==node.uniqueid)
	 		return node;                                           
        int count=1;
	    Exchange retval=null;
			while(retval==null&&count<=node.numChildren())
			{
				retval=searchExchangen(uniqid,node.child(count));
				if (retval!=null)return retval;
				count++;
			}
			return retval;


	 }
	public void switchOff(int a)
	{
		doswitchoff(this,a);

	}
	static void doswitchoff(RoutingMapTree tr,int a)
	{
		if(tr.rootnode.newresidentset.x.head!=null&&tr.rootnode.newresidentset.x.IsMember(a))//I doubt how to take ismember
		{
			Node temp=tr.rootnode.newresidentset.x.head;
			while(temp!=null)
			{
				if(((MobilePhone)temp.data).newmobile==a)
				{
					tr.rootnode.newresidentset.x.Delete((MobilePhone)temp.data);
					break;
				}
				temp=temp.next;
			}
			for (int count=1;count<=tr.rootnode.childrensize;count++)
			     doswitchoff(tr.rootnode.subtree(count),a);	
		         return ;
		}
	}
	public void add(int a,int b)
	{
		Exchange newExchangenode=new Exchange(b);
		newExchangenode.parnt=searchExchangen(a,rootnode);
		newExchangenode.parnt.childrens.Insert(newExchangenode);
		//I think size will automatically increase because I have size in linklist

	}
	public String performAction(String actionMessage)
	{
		Scanner s= new Scanner(actionMessage);
		String x=s.next();
		String returnvalue="";
		if (x.equals("addExchange"))
		{
			try{
				int a,b;
				a=s.nextInt(); // Add b to a Exchange 
				b=s.nextInt();
				// System.out.println("Came here\n");
				//System.out.println("code baba namaste");
				if(this.containsNode(new Exchange(a))==false)
					throw new Exception();
				else
					this.add(a,b);
				// System.out.println("Added node" +a+b);
			}
			catch(Exception en)
			{
				returnvalue="ERROR because Exchange a is not in this routingMaptree";
			}
		}
			else if (x.equals("switchOnMobile"))
			{
				try
				{
				   int a,b;
				   a=s.nextInt();
				   b=s.nextInt();
				   if (this.containsNode(new Exchange(b))==false)
					throw new Exception();
				   else
				   {
					switchOn(a,b);
				   }
				}
				catch(Exception en)
				{
					returnvalue="ERROR because Exchange b is not in this routingMaptree";
				}
			}
			// else if(x.equals("switchOffMobile"))
			// {
              
   //             // try
   //             {
		 //          int a=s.nextInt();MobilePhone xx=new MobilePhone(-1);
	 	//            Node ddd=this.rootnode.newresidentset.x.head;
		 //            if (!this.rootnode.newresidentset.x.IsMember(a,xx))throw new nomem();
		 //        else
		 //         {
			//       switchOff(a);
		 //         }
		 //       }
		 //       // catch(Exception e)
		 //       // {
		 //       // 	 System.out.println("Mobile not found\n");
		 //       // }
			// }
			// else if(x.equals("queryNthChild"))
			// {
			// 	try
			// 	{
			// 		int a,b;
			// 	    a=s.nextInt();
			// 	    b=s.nextInt();
			// 	    int c=this.searchExchangen(a,rootnode).childrensize;
			// 	    if(b<=0||c<b||this.containsNode(new Exchange(a))==false)
			// 	    	throw new Exception();
			// 	    else
			// 	    {
   //                    returnvalue=""+this.searchExchangen(a,rootnode).child(b).uniqueid;
			// 	    }
			// 	}
			// 	catch(Exception en)
			//     {
			// 	 returnvalue="ERROR because Exchange a is not in this routingMaptree";
			//     }
			// }
			// else
			// {
			// 	try
			// 	{
			// 		int a=s.nextInt();
			// 		if (this.containsNode(new Exchange(a))==false)
			// 			throw new Exception();
			// 		Node dd=this.searchExchangen(a,rootnode).newresidentset.x.head;
			// 	    Linklist values =new Linklist();
			// 	    while(dd!=null)
			// 	    {
					
			// 		if (((MobilePhone)dd.data).checknewnumberstatus)
			// 		 {
			// 			values.Insert(""+((MobilePhone)dd.data).newmobile+"");
			// 		 }
			// 		    dd=dd.next;
			// 	    }
			// 	  dd=values.head;
			// 	   while(dd!=null)
			// 	   {
			// 		 if (dd.next!=null)
			// 		   returnvalue+=""+dd.data+", ";
			// 	     else returnvalue+=dd.data;
			// 		   dd=dd.next;
			// 	   }
			// 	}
			// 	catch(Exception en)
			// 	{
			// 		returnvalue="Error ! Exchange not found.";
			// 	}

			// }
			return returnvalue;
		}


		
	}
	