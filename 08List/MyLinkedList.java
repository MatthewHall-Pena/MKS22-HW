public class MyLinkedList{
    private LNode start;
    private int size;
    public MyLinkedList(){
    }
    public MyLinkedList(int nSize){
	if(nSize>0){
	    start=new LNode(0);
	    constructor(nSize,start);
	}
    }
    private void constructor(int nSize,LNode node){
	if(nSize>0){
	    LNode Node =new LNode(0);
	    node.setNext(Node);
	    constructor(nSize-1,Node);
	}
    }
    public boolean add(int value){
	if(start==null){
	    start=new LNode(value);
	    return true;
	}
	return add(value,start);
    }
    private boolean add(int value, LNode node){
	if(node.getNext()==null){
	    node.setValue(value);
	    return true;
	}
	return get(value,node.getNext());
    }
    public int get(int index){
	return get(index,start);
    }
    private int get(int index, LNode node){
	if(index==0){
	    return node.getValue();
	}
	return get(index-1,node.getNext());
    }
    public int set(int index,int newValue){
	return set(index,newValue,start)
    }
    private int set(int index,int value, LNode node){
	if(index==0){
	    return node.setValue(value);
	}
	return set(index-1,node.getNext());
    }
    public int size(){
	return size;
    }
    public int indexOf(int value){
	return indexOf(size,value,start);
    }
    private int indexOf(int index,int value, LNode node){
	if(index==0){
	    return -1;
	}
	if(node.getValue()==value){
	    return size-index;
	}
	return indexOf(index-1,value,node.getNext());
    }
    public String toString(){
	return toString(size,start,"[ ")+" ]";
    }
    private String toString(int index,LNode node,String s){
	if(index==1){
	    s+=node.getValue();
	    return s;
	}
	s+=node.getValue()+", ";
	toString(index-1,node.getNext(),s);
    }
}
