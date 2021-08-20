import java.util.*;
import java.io.*;
import java .lang.*;
class Position
{
	PageEntry page;
    int index;
	Position(PageEntry p,int wordIndex)
	{
		page=p;
		index=wordIndex;
	}
	public PageEntry getPageEntry()  
	{
		return page;

	}
	public int getWordIndex()
	{
		return index;
	}
}