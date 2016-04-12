import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	int r,c;
	Node prev;
    
	public Node(int row,int col,Node previous){
	    r=row;
	    c=col;
	    prev=previous;
	}
	public Node getPrev(){
	    return prev;
	}
	public int[] get(){
	    int[] coordinates={r,c};
	    return coordinates;
	}
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> frontier;
    private boolean  animate;//default to false
    private Node solution;
   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/      
	return new int[1];
    }    

    public boolean solveBFS(){  
        frontier=new FrontierQueue();
	return solve();
    }   

    public boolean solveDFS(){  
        frontier=new FrontierStack();  
	return solve();
    }    

    private boolean solve(){  
        frontier.add(new Node(startRow,startCol,null));

	while(frontier.hasNext()){
	    for(Node n:getNexts(frontier.next())){
		if(maze[n.get()[0]][n.get()[1]]=='E'){
		    solution=n;
		    return true;
		}
	    }
	}
	return false;
    }    
    private ArrayList getNexts(Node n,Node current){
	ArrayList<Node> nexts=new ArrayList<Node>();
	int r=current.get()[0];
	int c=current.get()[1];
	for (int a = -1; a < 2; a++) {
	     for (int b = -1; b < 2; b++) {
		if (a != b && a != -b) {
		    if(r+a>-1&&r+b>-1&&r+a<maze.length&&r+b<maze[0].length&&maze[r+a][c+b]!='#'&&maze[r+a][c+b]!='.'){
			nexts.add(new Node(r+a,r+b,current));
		    }
		}

	     }
	}
    }

    public void setAnimate(boolean b){  
	animate=b;
    }    

    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;

	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    maxc = line.length();
		}
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }
    



    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    
