import java.util.*;
import java.io.*;
import java .lang.*;
public class ATNode
{
    Position key;
    ATNode left;
    ATNode right;
    int height;
    public ATNode()
    {
    	key=null;
        ATNode left=null;
        ATNode right=null;
        int height=0;
    }
    public ATNode(Position d)
    {
        key=d;
        ATNode left=null;
        ATNode right=null;
        int ht=1;
    }
    public Position getposition()
    {
    	return key;
    }
    public int height()
    {
    	return height;
    }
}