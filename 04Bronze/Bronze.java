public class Bronze{
    public boolean stomp(int r,int c,int diff,int[][] elev){
	if(r+2<elev.length||c +2<elev[0].length||diff==0){
	    return false;
	}
	int max=big(r,c,elev);
	for(int x=r;x<r+3;x++){
	    for(int y=c;y<c+3;y++){
		
	    }
	}
	return true;
    }
    public int big(int r,int c,int[][] elev){
	int max=0;
	for(int x=r;x<r+3;x++){
	    for(int y=c;y<c+3;y++){
		if(elev[x][y]>max){
		    max=elev[x][y];
		}
	    }
	}
	return max;
    }
    public static void main(String[]args){
	Scanner s=new Scanner(new File("makelake.in"));
	
    }
}
