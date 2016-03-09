import java.util.Random;

public class Quick {
	public static String name(){
		return "7,Hall-Pena,Matthew"; 
    	}
public static void printArray(int[] data) {
		String s = "[ ";
		for (int x = 0; x < data.length; x++) {
			s += data[x];
			if (x + 1 != data.length) {
				s += ", ";
			}
		}
		s += "]";
		System.out.println(s);
	}
    private static void swap(int[]data,int a, int b){
	int old = data[a];
	data[a]=data[b];
	data[b]=old;
    }
	private static int partition(int[] data, int left, int right) {
		Random r = new Random();
		int index = left + r.nextInt() % ((right - left + 1) / 2) + (right - left + 1) / 2;
		int split = data[index];
	        swap(data,right,index);
		while (left != right) {
			if (data[left] > split) {
			    swap(data,right,left);
				right --;
			} else if (data[right] < split) {
				swap(data,right,left);
				left ++;
			} else {
				left ++;
			}
		}
		return left;
	}

	public static int quickselect(int[] data, int k) {
		int left = 0;
		int right = data.length - 1;
		int index = 0;
		while (right > k) {
			index = partition(data, left, right);
			if (index == right) {
				right --;
			} else if (index >= k) {
				right = index;
			} else if (index < k) {
				left = index;
			}
		}
		int max = data[left];
		for (int x = left + 1; x < right + 1; x++) {
			if (data[x] > max) {
				max = data[x];
			}
		}
		return max;
	}
    private static boolean isSorted(int[] data){
	if(data.length<=1){
	    return true;
	}
	for(int x=1;x<data.length;x++){
	    if(data[x-1]>data[x]){
		return false;
	    }
	}
	return true;
    }
    public static void quickSort(int[] data){
	while(!isSorted(data)){
	    partition(data,0,data.length-1);
	}
    }
    public static void main(String[]args){
	int[] data={2,3,5,1,6,7,10,9,8,0};
	quickSort(data);
	printArray(data);
    }
}
