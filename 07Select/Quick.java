public class Quick{
    private static int partition(int[]data, int left, int right) {
	Random r =new Random();
	int split=data[r.nextInt%data.length/2+data.length/2];
	int old=0;
	while(left!=right){

	    if(data[left]>split){
		old=data[right];
		data[right]=data[left];
		data[left]=old;
		right-=1;
	    }
	    else if(data[right]<split){
		old=data[right];
		data[right]=data[left];
		data[left]=old;
		left+=1;
	    }
	    else{
	       left+=1
	    }
	   }
    }
    public static int quickselect(int[]data, int k){
	
    } 
}