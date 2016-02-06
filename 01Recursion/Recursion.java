import java.lang.IllegalArgumentException;
public class Recursion{
    public String name(){
	return "Hall-Pena,Matthew";
    }
    public static double sqrt(double n){
	return sqrt1(n,n/2);
    }
    public double sqrt1(double n,double guess){
	/*if(n<0){
	    throw IllegalArgumentException();
	    }*/
	if(Math.abs(guess*guess/n-1)<.000001){
	    return guess;
	}
	return sqrt1(n,( n / guess + guess) / 2);
    }
    public void main(String[] args){
	
    }
}
