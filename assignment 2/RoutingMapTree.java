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
	public void Insertinparent(Exchange exchparnt,MobilePhone n)
	{
		exchparnt.newresidentset.x.Insert(n);
	}
	public void switchOn(int a , int b )
	{
		  
		Exchange mynewmobilexchange=searchExchangen(b,rootnode); //we go for searching node of a in tree

		MobilePhone n=new MobilePhone(a);
		n.switchOn();
		try
		{
			mynewmobilexchange.newresidentset.x.Insert(n); //we are inserting in its MobilePhoneSet
			n.basestation=mynewmobilexchange;
			while(mynewmobilexchange!=this.rootnode)
			{
				Insertinparent(mynewmobilexchange.parnt,n);
				mynewmobilexchange=mynewmobilexchange.parnt;
			}
			

		}
		catch(Exception en)
		{
			// System.out.println("Exchange not found");
		}

	}
	 public Boolean containsNode(Exchange a)
	 {
       if(rootnode.uniqueid==a.uniqueid)
       	return true;
       Exchange searchnode=searchExchangen(a.uniqueid,rootnode);
       if(searchnode==null)
       	return false;
       else return true;
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
	public void doswitchoff(RoutingMapTree tr,int a)
	{
		Exchange basevalastation=(Exchange)findPhone(a);
		Node temp=basevalastation.newresidentset.x.head;
		while(basevalastation!=tr.rootnode)
		{
			//Node temp=basevalastation.newresidentset.x.head;
			while(temp!=null)
			{
				if(((MobilePhone)temp.data).newmobile==a)
				{
					basevalastation.newresidentset.x.Delete((MobilePhone)temp.data);
					break;
				}
				temp=temp.next;
			}
			basevalastation=basevalastation.parnt;
		}
		if(basevalastation==tr.rootnode)
			basevalastation.newresidentset.x.Delete((MobilePhone)temp.data);
		/*
		if(tr.rootnode.newresidentset.x.head!=null&&tr.rootnode.newresidentset.x.IsMember(a))//I doubt how to take ismember
		{
			Node temp=tr.rootnode.newresidentset.x.head;
			while(temp!=null)
			{
				if(((MobilePhone)temp.data).newmobile==a)
				{
					tr.rootnode.newresidentset.x.Delete((MobilePhone)temp.data);
					return;
				}
				temp=temp.next;
			}
		}
		for (int count=1;count<=tr.rootnode.childrensize;count++)
			doswitchoff(tr.rootnode.subtree(count),a);
			*/
	}
	public void add(int a,int b)
	{
		Exchange newExchangenode=new Exchange(b);
		Exchange p=searchExchangen(a,rootnode);
		try
		{
			newExchangenode.parnt=p;
			p.childrens.Insert(newExchangenode);
		}
		catch(Exception e)
		{
			// System.out.println("Exchange "+a+" not found.");
		}
		//I think size will automatically increase because I have size in linklist

	}
	public String mobilephones(Exchange a)
	{
		String returnvalue="";
		if(a==null)
			return returnvalue;
		Node dd=a.newresidentset.x.head;
	    while(dd!=null)
	    {
			if (((MobilePhone)dd.data).checknewnumberstatus)
			 {
			 	if(returnvalue!="")
			 		returnvalue+=", ";
				returnvalue+=((MobilePhone)dd.data).newmobile;
			 }
			    dd=dd.next;
	    }
	    /*for(int i=1;i<=a.childrensize;i++)
	    {
	    	String ret=mobilephones(a.child(i));
	    	if(ret!="")
	    	{
	    		if(returnvalue!="")
	    			returnvalue+=", "+ret;
	    		else returnvalue=ret;
	    	}
	    }*/
	    return returnvalue;
	}
	public String exchangeliststring(ExchangeList a)
	{
		//System.out.println("baba ji");
		String returnvalue="";
		if(a.f.head==null)
			return returnvalue;
		Node dd=a.f.head;
		while(dd!=null)
		{
			if(returnvalue!="")
				returnvalue+=", ";
			returnvalue+=((Exchange)dd.data).uniqueid;
			dd=dd.next;
		}
		return returnvalue;
	}
	public Exchange findPhone(int m)
	{
		//System.out.println("baba ji");   
	    Node mob=this.rootnode.newresidentset.x.head;
       
          while(((MobilePhone)mob.data).newmobile!=m)
          {
              mob=mob.next;
          }
             //System.out.println("baba ji");
              MobilePhone n=((MobilePhone)mob.data);
              return n.basestation;
	}
	public Exchange lowestRouter(int a, int b)
	 {
	 	Exchange newa=searchExchangen(a,rootnode);
	 	Exchange newb=searchExchangen(b,rootnode);
	 	if(a==b)
	 		return newa;
	 	else
	 		return lowestRouter(newa.parnt.uniqueid,newb.parnt.uniqueid);  //we move upward 


	 }
	public ExchangeList routeCall(int a, int b)
	  {
	  	//Exchange newadaa=(Exchange)findPhone(a);
	  	//Exchange newadab=(Exchange)findPhone(b);

	  		//if((this.rootnode.newresidentset.x.IsMember(a)==true)&&(this.rootnode.newresidentset.x.IsMember(b)==true))
	  		//{
	  		   /* Node mob1=this.rootnode.newresidentset.x.head;
	  		    Node mob2=this.rootnode.newresidentset.x.head;
	  		    while(((MobilePhone)mob1.data).newmobile!=a)
                  {
                    mob1=mob1.next;
                  }
                  while(((MobilePhone)mob2.data).newmobile!=b)
                   {
                     mob2=mob2.next;
                   }
	  		    
	  	      MobilePhone ra=((MobilePhone)mob1.data);
	  	      MobilePhone rb=((MobilePhone)mob2.data);
	  	      */

                   //System.out.println("yes");
                Exchange newa=(Exchange)findPhone(a);
                
                Exchange newb=(Exchange)findPhone(b);
                Exchange compi=lowestRouter(newa.uniqueid,newb.uniqueid);
                Linklist collecta=new Linklist();
                Linklist collectb=new Linklist();
                while(newa.uniqueid!=compi.uniqueid)
                {
        	     collecta.Insert(newa);
        	      newa=newa.parnt;
        	    //  System.out.println(+newa.uniqueid);
                }
                collecta.Insert(newa);
                  while(newb.uniqueid!=newa.uniqueid)
                  {
        	       collectb.Insertfront(newb);
        	       newb=newb.parnt;
                  }
                   collecta.tail.next=collectb.head;
                   ExchangeList map = new ExchangeList();
                   map.f=collecta;

                  // System.out.println("yes");
                   return map;
               //}
               //return null;
           
	  }
	public void movePhone(int a, int b)
	  {
	  //	Exchange newexb=searchExchangen(b,rootnode);
	  //	try{		
            // if((rootnode.newresidentset.x.IsMember(a)==true)&&(newexb.subtree(0)==null))
            // {
               switchOff(a);
               switchOn(a,b);

             //}
         //}
         //catch(Exception en)
         //{

         //}
	  }
	public String performAction(String actionMessage)
	{
		int a=0,b=0;
		Scanner s= new Scanner(actionMessage);
		String x=s.next();
		String returnvalue="";
		if (x.equals("addExchange"))
		{
			try{
				a=s.nextInt(); // Add b to a Exchange 
				b=s.nextInt();
				// System.out.println("Came here\n");
				//System.out.println("code baba namaste");
				if(this.containsNode(new Exchange(a))==false)
					throw new Exception();
				else
				{
					this.add(a,b);
					searchExchangen(a,rootnode).childrensize++;
				}
				// System.out.println("Added node" +a+b);
			}
			catch(Exception en)
			{
				// returnvalue="ERROR because Exchange a is not in this routingMaptree "+a;
			}
		}
			else if (x.equals("switchOnMobile"))
			{
				try
				{
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
					// returnvalue="ERROR because Exchange b is not in this routingMaptree "+b;
				}
			}
			else if(x.equals("switchOffMobile"))
			{
              
               try
               {
		          a=s.nextInt();
		          doswitchoff(this,a);
		       }
		       catch(Exception e)
		       {
		       	// returnvalue="Mobile phone not found "+a;
		       	 // System.out.println("Mobile not found "+a);
		       }
			}
			else if(x.equals("queryNthChild"))
			{
				try
				{
				    a=s.nextInt();
				    b=s.nextInt();
				    b++;
				    int c=this.searchExchangen(a,rootnode).childrensize;
				    // if(b<0||c<b||this.containsNode(new Exchange(a))==false)
				    // 	throw new Exception();
				    // else
				    {
				      returnvalue=actionMessage+": ";
                      returnvalue+=this.searchExchangen(a,rootnode).child(b).uniqueid;
				    }
				}
				catch(Exception en)
			    {
				 // returnvalue="ERROR because Exchange a is not in this routingMaptree "+a;
			    }
			}
			else if(x.equals("findPhone"))
			{
				try
				{
					a=s.nextInt();

					if(this.rootnode.newresidentset.x.IsMember(a)!=true)  //why it is going inside even we have desired number
					{
						//System.out.println("meraif");
						throw new Exception();
					}
						else
						{ 
					      Exchange newm;
					      newm=findPhone(a);
					      returnvalue=""+"queryFindPhone"+" "+a+": "+newm.uniqueid;
				        }
					//System.out.println(returnvalue);
				}
				catch(Exception en)
				{
					returnvalue=""+"queryFindPhone"+" "+a+": "+"Error - No mobile phone with identifier "+a+" found in the network";
                    //System.out.println("my name is khan");
				}
			}
			else if(x.equals("lowestRouter"))
			{

				try
				{
					a=s.nextInt();
					b=s.nextInt();
					if((this.containsNode(new Exchange(a))==false)||(this.containsNode(new Exchange(b))==false))
						throw new Exception();
					else
					{
					   Exchange newe=lowestRouter(a,b);
                       //System.out.println("querylowestRouter "+a+" "+b+" ");
					   returnvalue=""+"queryLowestRouter "+a+" "+b+": "+newe.uniqueid;
				    }

				}
				catch(Exception en)
				{

				}
			}
			else if (x.equals("findCallPath")) 
			{
				//System.out.println("baba");
				try{


				a=s.nextInt();
			    b=s.nextInt();
			    if((this.rootnode.newresidentset.x.IsMember(a)!=true)||(this.rootnode.newresidentset.x.IsMember(b)!=true))
			    {
			    	//System.out.println("callvaliline");
			    	throw new Exception();
			    }
			    else
			    {
			    	//System.out.println("baba");
			     ExchangeList ab=routeCall(a,b);
			    // System.out.println("rendevous");
			     String wet=exchangeliststring(ab);
			    //System.out.println(wet);
			     returnvalue=""+"queryFindCallPath "+a+" "+b+": "+wet;
			    }
			}
			    catch(Exception en)
			    {
			    	if(this.rootnode.newresidentset.x.IsMember(a)!=true)
			    	{
                      returnvalue=""+"queryFindCallPath "+a+" "+b+": "+"Error - Mobile phone with identifier "+a+" is currently switched off";
                    }
                    else
                    	returnvalue=""+"queryFindCallPath "+a+" "+b+": "+"Error - Mobile phone with identifier "+b+" is currently switched off";
			    }

				
			}
			else if (x.equals("movePhone")) 
			{
				try{


				a=s.nextInt();
			    b=s.nextInt();
			    if((this.rootnode.newresidentset.x.IsMember(a)!=true)||(this.containsNode(new Exchange(b))==false))
			    	throw new Exception();
			    else
		          {
			        movePhone(a,b);
				  }
				}
				catch(Exception en)
				{

				}
			}
			else
			{
				try
				{
					// System.out.println("Reached here");
					returnvalue=actionMessage+": ";
					a=s.nextInt();
					if (this.containsNode(new Exchange(a))==false)
						throw new Exception();
					returnvalue+=mobilephones(this.searchExchangen(a,rootnode));
				}
				catch(Exception en)
				{
					// returnvalue="Error ! Exchange not found. "+a;
				}

			}
// 			if(returnvalue!="")
 				System.out.println(returnvalue);
			return returnvalue;
		}
		
	}
	