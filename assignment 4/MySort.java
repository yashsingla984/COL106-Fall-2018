import java.util.*;
import java.io.*;
import java .lang.*;
public class MySort<Sortable>
{
	public ArrayList<SearchResult> sortThisList(MySet<SearchResult> listOfSortableEntries)
	{
		ArrayList<SearchResult> newarray=new ArrayList<SearchResult>();
		for(int i=0;i<listOfSortableEntries.size;i++)
		{
			newarray.add(listOfSortableEntries.getelement(i).data);
		}
		Collections.sort(newarray);

		return newarray;
	}
}