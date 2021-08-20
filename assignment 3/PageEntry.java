
import java.util.*;
import java.io.*;
import java .lang.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
class PageEntry
{

	PageIndex pindex;
	String pgname;
	PageEntry(String pageName)
	{
		this.pgname= pageName;
            pindex=new PageIndex();
      
      try{
      	//System.out.println(pageName);
      //FileInputStream file=new FileInputStream(this.pgname);
      String s=new String(Files.readAllBytes(Paths.get(pgname)));
      // System.out.println("bai aa ja ");
      //Scanner s=new Scanner(file);
      //int count=0;
      //String array;
     // while(s.hasNext())
      //{
            //System.out.println(s.nextLine());
      //}	//count=count++;
      	//System.out.println(count);
            //String str=s.nextLine();
            //String[] array=s.split(" ");
      //String str=s.next();
      String s1=s.replace("}"," ");
            s1=s1.replace("\n"," ");
      String s2=s1.replace("{"," ");
      String s3=s2.replace("["," ");
      String s4=s3.replace("]"," ");
      String s5=s4.replace("<"," ");
      String s6=s5.replace(">"," ");
      String s7=s6.replace("="," ");
      String s8=s7.replace("("," ");
      String s9=s8.replace(")"," ");
      String s10=s9.replace("."," ");
      String s11=s10.replace(","," ");
      String s12=s11.replace(";"," ");
      String s13=s12.replace("'"," ");
      String s14=s13.replace('"',' ');
      String s15=s14.replace("?"," ");
      String s16=s15.replace("#"," ");
      String s17=s16.replace("!"," ");
      String s18=s17.replace("-"," ");
      String s19=s18.replace(":"," ");
      String s20=s19.toLowerCase();
      String s21=s20.replace("stacks","stack");
      String s22=s21.replace("structures","structure");
      String s23=s22.replace("applications","application");
      String s24=s23.replace("  "," ");
     


      //while(s23.hasNext())
      	String[] array=s24.split(" ");
      	// System.out.println("length of array is "+array.length);
      	for(int i=0;i<array.length;i++)
      	{
                  // System.out.println("i is "+i);
      		//System.out.print(array[i]+" ");
      		//Position p=Position();
            
                   //System.out.print("bar"+" ");
                  String[] connector = {"a", "an", "the", "they", "these", "this", "for", "is", "are", "was", "of","or", "and", "does", "will", "whose"};
      		boolean pre = false;
                  for(int j = 0;j<connector.length;j++)
                                {
                                    //System.out.print(connector.length+" ");
                                      if(array[i].equals(connector[j]))
                                    {
                                            pre = true;
                                            break;
                                      }
                                
                                }
                  // System.out.println(pre);
                  //if(((!array[i].equals("a"))||(!array[i].equals("an"))||(!array[i].equals("the"))||(!array[i].equals("they"))||(!array[i].equals("these"))||
                        //(!array[i].equals("this"))||(!array[i].equals("for"))||(!array[i].equals("is"))||(!array[i].equals("are"))||(!array[i].equals("was"))||(!array[i].equals("of"))
                        //||(!array[i].equals("or"))||(!array[i].equals("and"))||(!array[i].equals("does"))||(!array[i].equals("will"))||(!array[i].equals("whose"))))
                  //{    			
                        //Position p=new Position(this,i);
      			//System.out.println(+i);
      		     //this.pindex.addPositionForWord(array[i],p);
                       //System.out.println("lkop");                // Node<type> node_name=new Node<type>();
      		if(pre==false)
                  {
                        // System.out.println("word is "+array[i]);
                        Position p=new Position(this,i);
                        // System.out.println("Created new word!!!!!!");
                        this.pindex.addPositionForWord(array[i],p);
                  //System.out.print(array[i]+",");
                  }

      		//System.out.println(+count);
      	    //}
      	}
      

      }
      //System.out.println(+count);
      catch(Exception en)
      {
       System.out.println("File not found");
      }
  
  }
  public PageIndex getPageIndex()
	 {

	 	return pindex;
	 }

	
}