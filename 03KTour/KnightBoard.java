public class KnightBoard{
    int[][] board;
    public KnightBoard(int r,int c){
	board=new int[r][c];
    }
    public boolean move(int m,int a,int b,int c){
	if(m==0){
	    if(a-2>0&&b-1>0){
		board[a-2][b-1]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==1){
	    if(a-2>0&&b+1<board[0].length){
		board[a-2][b+1]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==2){
	    if(a+1<board.length&&b+2<board[0].length){
		board[a+1][b+2]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==3){
	    if(a+1<board.length&&b-2>0){
		board[a+1][b-2]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==4){
	    if(a+2<board.length&&b-1>0){
		board[a+2][b-1]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==5){
	    if(a+2<board.length&&b+1<board[0].length){
		board[a+2][b+1]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==6){
	    if(a-1>0&&b+2<board[0].length){
		board[a-1][b+2]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==7){
	    if(a+1<board.length&&b+2<board[0].length){
		board[a+1][b+2]=c;
		board[a][b]=0;
		return true;
	    }
	}
	return false;
    }
public boolean rmove(int m,int a,int b,int c){
	if(m==0){
	    if(a+2<board.length&&b+1<board[0].length){
		board[a+2][b+1]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==1){
	    if(a+2<board.length&&b-1>0){
		board[a+2][b-1]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==2){
	    if(a-1>0&&b-2>0){
		board[a-1][b-2]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==3){
	    if(a+1<board.length&&b-2>0){
		board[a+1][b-2]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==4){
	    if(a+2<board.length&&b-1>0){
		board[a+2][b-1]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==5){
	    if(a+2<board.length&&b+1<board[0].length){
		board[a+2][b+1]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==6){
	    if(a-1>0&&b+2<board[0].length){
		board[a-1][b+2]=c;
		board[a][b]=0;
		return true;
	    }
	}
	if(m==7){
	    if(a+1<board.length&&b+2<board[0].length){
		board[a+1][b+2]=c;
		board[a][b]=0;
		return true;
	    }
	}
	return false;
    }
	public void print() {
		String s = "";
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
				if (board[x][y] == 1) {
					s += " Q ";
				} else {
					s += " _ ";
				}
			}
			System.out.println(s);
			s = "";
		}

	}
	public void print() {
		String s = "";
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
			    s+=board[x][y];
			}
			System.out.println(s);
			s = "";
		}

	}
    public void printSolution(){
	solve();
	print();
    }
    public boolean solve(){
	return solver(1);
    }
    public boolean solver(int c){
	
    }

}
