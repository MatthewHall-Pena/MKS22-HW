
public class BSTree<T extends comparable<T>>{
    private class Node{
 T data;
 Node left;
 Node right;
 // set/get: data/left/right


 //real methods here
 public int getHeight(){
	    int r=right.getHeight();
	    int l=left.getHeight();
	    if(r>=l){
		return r+1;
	    }
	    return l+1;
	}
 public void add(T value){
 }
 public String toString(){
    return "";
 }
 public boolean contains(T value){
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
