import java.util.*;

public class Sorts {
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

	public static void selectionSort(int[] data) {
		int num;
		for (int x = 0; x < data.length; x++) {

			for (int y = x; y > 0; y--) {
				if (data[y] < data[y-1]) {
					num = data[y];
					data[y] = data[y-1];
					data[y-1]=num;
				}
			}
			
		}
	}

	public static void insertionSort(int[] data) {
		int num;
		for (int y = 0; y < data.length-1; y++) {

			while(data[y] > data[y+1]) {
					num = data[y];
					data[y] = data[y+1];
					data[y+1]=num;
		
			}
			
		}
		printArray(data);

	}
        public static void bubbleSort(int[] data) {
	    int num;
	    int  swap=0;
		for (int x = 0; x < data.length; x++) {

			for (int y = 0; y < data.length-x-1; y++) {
				if (data[y] > data[y+1]) {
					num = data[y];
					data[y] = data[y+1];
					data[y+1]=num;
					swap+=1;
				}
			}
			if (swap==0){
			    x=data.length;
			}
			swap=0;
			
		}

	}
	private static int addIndex(int n, int[] data) {
		int place0 = 0;
		int place1 = data.length;
		double mid;
		while (true) {
			mid = (place1 - place0) / 2.;
			if (place0 == place1) {
				return place0;
			}
			if (data[place0] < n) {
				place0 += mid + .5;
			} else if (place0 - mid > 0 && data[(int) (place0 - mid)] > n) {
				place0 -= mid;
			} else if (place1 + mid < data.length && data[(int) (place1 + mid)] < n) {
				place1 += mid;
			} else {
				place1 -= mid;
			}
		}
	}

	private static int[] add(int index, int element, int[] data) {
		int[] ndata = new int[data.length + 1];
		for (int x = 0; x < index; x++) {
			ndata[x] = data[x];
		}
		ndata[index] = element;
		for (int x = index; x < data.length; x++) {
			ndata[x + 1] = data[x];
		}
		return ndata;
	}
    public static void fillRandom(int[] data){
	Random r=new Random();
	for(int x = 0; x < data.length; x++){
	    data[x]=r.nextInt();
	}
    }
    public static void swap(int[] data,int index,int nIndex){
	int num = data[index];
	data[index] = data[nIndex];
	data[nIndex]=num;
    }


}
