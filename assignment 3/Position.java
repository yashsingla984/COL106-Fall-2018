import java.util.*;
import java.io.*;
import java .lang.*;
class Position<p,i>
{
	p page;
    i index;
	Position(p position,i wordIndex)
	{
		page=position;
		index=wordIndex;
	}
	public p getPageEntry()  
	{
		return page;

	}
	public i getWordIndex()
	{
		return index;
	}
}