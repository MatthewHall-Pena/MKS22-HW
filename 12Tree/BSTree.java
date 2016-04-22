
public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;
	
	public Node(T value){
	    data=value;
	}
	
	public int getHeight(){
	    int r=0;
	    int l=0;
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
	    if(data.compareTo(value)>0){
		if(right.equals(null)){
		    right=new Node(value);
		}
		else{
		    right.add(value);
		}
	    }
	    else{
		if(left.equals(null)){
		    left=new Node(value);
		}
		else{
		    left.add(value);
		}
	    }
	   
	    
	}
	public String toString(){
	    if(!left.equals(null) &&!right.equals(null)){
		return ""+data+left.toString()+right.toString();
	    }
	    if(left.equals(null) &&!right.equals(null)){
		return ""+data+"_"+right.toString();
	    }
	    if(!left.equals(null) &&right.equals(null)){
		return ""+data+left.toString()+"_";
	    }
	    return ""+data+"_"+"_";
	}
	public boolean contains(T value){
	    if(data.compareTo(value)!=0&&left.equals(null)&&right.equals(null)){
		return false;
	    }
	    else if((!left.equals(null) &&left.data.compareTo(value)==0) ||(!right.equals(null)&& right.data.compareTo(value)==0)){
		return true;
	    }
	    else if((right.equals(null)&&!left.equals(null))|| right.data.compareTo(value)>0){
		return left.contains(value);
	    }
	    else if((!right.equals(null)&&left.equals(null))|| left.data.compareTo(value)<0){
		return right.contains(value);
	    }
	    return false;
	}
    
    }

    private Node root;

    public int getHeight(){
	return root.getHeight();
    }

    public void add(T value){
	if(root.equals(null)){
	    root=new Node(value);
	}
	else{
	    root.add(value);
	}
    }
    public String toString(){
	if(root.equals(null)){
	    return "";
	}
	return root.toString();
    }
    public boolean contains(T value){
	if(root.equals(null)){
	    return false;
	}
	return root.contains(value);
    }
}
