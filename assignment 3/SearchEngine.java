import java.util.*;
import java.io.*;
import java .lang.*;
class SearchEngine
{
	InvertedPageIndex  ipindex;
	SearchEngine()
	{
		ipindex=new InvertedPageIndex();
	}

	public void performAction(String actionMessage)
	{
		String a="";
		String b="";
		Scanner s= new Scanner(actionMessage);
		String x=s.next();
		String returnvalue="";
		if (x.equals("addPage"))
		{
			try{
				a=s.next();
				//System.out.println(a);
				PageEntry page =new PageEntry(a);
				//System.out.println("mai aa gaya");
				ipindex.addPage(page);
				//System.out.println("mai aa gaya");

			}
			catch(Exception en)
			{

			}
		}
		else if(x.equals("queryFindPagesWhichContainWord"))
		{
			try{
				a=s.next();
			    MySet<PageEntry> tmp = ipindex.getPagesWhichContainWord(a);
			    int k = tmp.size;
			    String stri = "";
			    if(k==0)
			    {
				System.out.println("No webpage contains word "+a);
			    }
			    else
			      {
			       //for(int i = 1; i<=k;i++)
			      	Node<PageEntry> tp=tmp.head;
			      	while(tp!=null)
			          {
			          	//System.out.println("I get it in webpages "+a);
				        stri = stri+tp.data.pgname +",";
				         tp=tp.next;
			          }
			           stri = stri.substring(0,stri.length()-1);
			           System.out.println(stri);
			      }
		       }
		       catch(Exception en)
		       {

		       }
		}
		else if (x.equals("queryFindPositionsOfWordInAPage")) {
			try{
                 a=s.next();
                 b=s.next(); //I have to take care of typecast of document
                 PageEntry temp=new PageEntry(b);
                 PageIndex temp1=temp.getPageIndex();
                 Node<WordEntry> temp2=temp1.getWordEntries().head;
                 String stri="";
                boolean chk = false;
               // MySet<PageEntry> tmp = ipindex.getPagesWhichContainWord(a);
                //Node<PageEntry> tp=tmp.head;
                while(temp2!=null) {
                    if (temp2.data.getword().equals(a)) {
                        chk = true;
                        	Node<Position> temp3=temp2.data.getAllPositionsForThisWord().head;
                               while(temp3!=null)
                               {
                                 stri=stri+(temp3.data.getWordIndex())+", ";
                                 temp3=temp3.next;
                               }
                               break;
                    }   
                    temp2=temp2.next; 
                        

                    }
                
                if ((!chk)&&ipindex.web_pages.IsMember(temp)) 
                {
                   System.out.println("Webpage "+b+"does not contain word "+a); 
                
                }
                else
                {
                	stri=stri.substring(0,stri.length()-2);
                	System.out.println(stri);
                }
            }
            catch(Exception en)
            {
              System.out.println("No webpage "+ b+" found");
            }
            } 
		/*else
		{
			if()
			try
			{
				a=s
			}
		}*/
	}
}