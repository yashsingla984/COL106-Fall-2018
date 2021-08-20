import java.util.*;
import java.io.*;
import java .lang.*;
public class avlTree
{
    ATNode root;
    public avlTree()
    {
    	root=null;
    }
    public avlTree(ATNode a){
        root=a;
    }

void insert(Position key)           //we will insert new position 
{
    root=insertrec(root,key);         //helping function to insert key
}

int heights(ATNode root)
{
    if(root==null)
    return 0;
    return (root.height);
}
ATNode leftrotate(ATNode x)
{
    ATNode y=x.right;
    ATNode T2=y.left;
    
    //now rotate
    y.left=x;
    x.right=T2;
    
    // now update height
    x.height=Math.max(heights(x.left),heights(x.right))+1;
    y.height=Math.max(heights(y.left),heights(y.right))+1;
    return y;
}
ATNode rightrotate(ATNode y)
{
    ATNode x=y.left;
    ATNode T2=x.right;
    
    //now rotate
    x.right=y;
    y.left=T2;
    // update height
    y.height=Math.max(heights(y.left),heights(y.right))+1;
    x.height=Math.max(heights(x.left),heights(x.right))+1;
    
    return x;
}

    
int getbalance(ATNode node)
  {
     if(node==null)
       return 0;
     int balan=heights(node.left)-heights(node.right);
       return balan;
  }
        
ATNode insertrec(ATNode node,Position key)
{
    if(node==null)
    {
        root=new ATNode(key);
        return root;
    }
    else if(key.index<node.key.index)
    {
        node.left=insertrec(node.left,key);
    }
    else if(key.index>node.key.index)
    {
        node.right=insertrec(node.right,key);
    }
    else 
    return root;
    
    node.height=Math.max(heights(node.left),heights(node.right))+1;
    int balance=getbalance(node);
    
    if(balance>1&&key.index<node.left.key.index)
    return rightrotate(node);
    else if(balance<-1&&key.index>node.right.key.index)
    return leftrotate(node);
    else if(balance>1&&key.index>node.left.key.index)
    {
        node.left=leftrotate(node.left);
        return rightrotate(node);
    }
    else if(balance<-1&&key.index<node.left.key.index)
    {
        node.right=rightrotate(node.right);
        return leftrotate(node);
    }
    return node;
    
    
    
    
    
}
public boolean isEmpty() 
   {
   	if(root==null)
        return true;
    else
    	return false;
    }
public ATNode search(Position pos)
{
	if(isEmpty())
	{
		return null;
	}
	else if(pos.index==root.key.index)
	{
		return root;
	}
	else if(pos.index<root.key.index)
	{
	   avlTree x = new avlTree(root.left);
        return x.search(pos);
	}
	else
	{
	   avlTree x = new avlTree(root.right);
        return x.search(pos);
	}

}
public boolean IsMember(Position pos)
{
	if(search(pos)==null)
		return false;
	else 
		return true;
}
public ArrayList<Position> traverseavl() 
{
        ArrayList<Position> avltravel = new ArrayList<Position>();
        if (this.isEmpty()) 
        {
            return avltravel;
        }
        if (root.left==null && root.right==null) 
        {
            avltravel.add(root.key);
        } 
        else {
            avlTree lefttree = new avlTree(root.left);
            avlTree righttree = new avlTree(root.right);
            avltravel.addAll(lefttree.traverseavl());
            avltravel.add(root.key);
            avltravel.addAll(righttree.traverseavl());
        }
        return avltravel;
    }
    public Position positionofsuccessor(int p1)
    {
    	ArrayList<Position> array1=this.traverseavl();
    	for(int i=0;i<array1.size();i++)
    	{
    		if(array1.get(i).index==(p1))
    			return array1.get(i+1);
    	}
    	return null;
    }

   /* public ATNode maximum() 
    {
        if (isEmpty()) 
        {
            return root;
        } 
        else if (root.right==null) 
        {
            return root;
        } 
        else 
        {
            avlTree newt = new avlTree(root.right);
            return newt.maximum();
        }
    }

    public ATNode minimum() 
    {
        if (isEmpty()) 
        {
            return root;
        } 
        else if (root.left==null) 
        {
            return root;
        } 
        else 
        {
            avlTree newt = new avlTree(root.left);
            return newt.minimum();
        }
    }*/
/*void inorder()
    {
        inorderrec(root);
    }
void inorderrec(ATNode root)
    {
        if(root!=null)
        {
            inorderrec(root.left);
            System.out.println(+root.key.index);
            inorderrec(root.right);
        }
    }*/
/*public static void main(String args[])
{
    avlTree tree=new avlTree();
    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(25);
    tree.insert(50);
    tree.insert(2);
    tree.inorder();
}*/
}
