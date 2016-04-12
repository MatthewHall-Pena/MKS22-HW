public class Node{
    int x,y;
    Node prev;
    
    public Node(int newX,int newY,Node previous){
	x=newX;
	y=newY;
	prev=previous;
    }
    public Node getPrev(){
	return prev;
    }
    public int[] getLocation(){
	int[] coordinates={x,y};
	return coordinates;
    }
}
