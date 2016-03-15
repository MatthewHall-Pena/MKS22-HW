public class MyLinkedList{
    private LNode start;
    private int size;
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
	return toString(size,start,"[")+" ]";
    }
    private String toString(int index,LNode node,String s){
	if(size==0){
	    return s;
	}
	s+=" "+node.getValue();
	toString(index-1,node.getNext(),s);
    }
}
