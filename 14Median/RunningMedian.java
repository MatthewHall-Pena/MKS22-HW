public class RunningMedian{
    private MyHeap tiny;
    private MyHeap big;
    public RunningMedian(){
        tiny=new MyHeap<Integer>(true);
	big=new MyHeap<Integer>(false);
    }
    public double getMedian(){
	if(tiny.size()<1){
	    throw new NoSuchElementException();
	}
	if(tiny.size()>big.size()){
	    return tiny.peek();
	}
	return (tiny.peek()+big.peek())/2.;
    }
    public void add(Integer x){
	if(tiny.size()-big.size()==0){
	    tiny.add(x);
	}
	if(tiny.size()-big.size()==1){
	    tiny.add(x);
	    big.add(tiny.delete(tiny.peek()));
	}
	}
    }
}
