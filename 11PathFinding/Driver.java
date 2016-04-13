public class Driver{

    public static void main(String[]args){
        BetterMaze f;
        f = new BetterMaze("data3.dat");//true animates the maze.
        
        f.clearTerminal();
        f.solveBFS();

        f.clearTerminal();
        System.out.println(f);
    }
}

