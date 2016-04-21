
public class BSTree<T extends comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	public int getHeight(){
	    int r;
	    int l;
	    if(!right.equals(null)){
		r=right.getHeight();
	    }
	    if(!left.equals(null)){
		l=left.getHeight();
	    }	    
	    if(r>=l){
		return r+1;
	    }
	    return l+1;
	}
	public void add(T value){
	    
	}
	public String toString(){
	    if(!left.equals(null) &&!right.equals(null)){
		return ""+data+left.toString()+right.toString();
	    }
	    if(left.equals(null)l &&!right.equals(null)){
		return ""+data+"_"+right.toString();
	    }
	    if(!left.equals(null)l &&right.equals(null)){
		return ""+data+left.toString()+"_";
	    }
	    return ""+data+"_"+"_";
	}
	public boolean contains(T value){
	    if(!left.equals(null) &&left.data.compareTo(T)==0 ||right.data.compareTo(T)==0){
		return true;
	    }
	    else if(left.data.compareTo(T)<0){
		return left.contains(value);
	    }
	    
	    return false;
	}
    
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public getHeight(){
 //call the root's methods
 //check for empty first!
 return root.height();
    }

    public void add(T value){
 //check for empty before you do things with root.
    }
    public String toString(){
 //check for empty before you do things with root.
 return "";
    }
    public boolean contains(T value){
 //check for empty before you do things with root.
 return false;
    }
}
