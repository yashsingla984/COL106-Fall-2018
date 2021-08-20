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
int totalpagecount=0;
public double invdocfrequency(String wordidf)
{
  double idf=0.0;
  Node<PageEntry> n=ipindex.getPagesWhichContainWord(wordidf).head;   //we are taking start point
  if(n==null)
  {
  	return 0.00;
  }
  else
  {
  	while(n!=null)
  	{
  		idf++;
  		n=n.next;
  	}
  }
  return Math.log((ipindex.web_pages.size)/idf);
}
	public void performAction(String actionMessage)
	{
		String a="";
		String b="";
		//Scanner s= new Scanner(actionMessage);
		//String x=s.next();
		//String returnvalue="";
		String[] stra = actionMessage.split(" ");
		if (stra[0].equals("addPage"))
		{
			try{
				a=stra[1];
				//System.out.println(a);
				PageEntry page =new PageEntry(a);
				//System.out.println("mai aa gaya");
				ipindex.addPage(page);
				totalpagecount++;
				//System.out.println("mai aa gaya");

			}
			catch(Exception en)
			{

			}
		}
		else if(stra[0].equals("queryFindPagesWhichContainWord"))
		{
			try{
				a=stra[1];
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
		else if (stra[0].equals("queryFindPositionsOfWordInAPage")) {
			try{
                 a=stra[1];
                 b=stra[2]; //I have to take care of typecast of document
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
		else if (stra[0].equals("queryFindPagesWhichContainAllWords"))
		{
			//ArrayList<SearchResult> giveinsort=
			String[] stri=new String[stra.length-1];
			for(int i=0;i<stri.length;i++)
				{
					stri[i]=stra[i+1];
				}
				ArrayList<SearchResult> giveinsort=new ArrayList<SearchResult>[ipindex.getPagesWhichContainAllWords(stri).size];
				Node<PageEntry> temp4=ipindex.getPagesWhichContainAllWords(stri).head;
                while(temp4!=null)
                {
                	double relevance=0.0;
				  for(int j=0;j<stri.length;j++)
				    {
                     relevance=relevance+invdocfrequency(stri[j])*(temp4.data.termfrequency(stri[j]));
				    }
				    giveinsort.add(temp4.data,relevance);
				    temp4=tem4.next;

			    }

			
		}
		else if (stra[0].equals("queryFindPagesWhichContainAnyOfTheseWords"))
		{

		}
		else if (stra[0].equals("queryFindPagesWhichContainPhrase"))
		{

		}

	}
}