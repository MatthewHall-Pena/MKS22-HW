import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       data=new Comparable[10];
       data=(T)data;
   }
   public MyHeap(T[] array){
       int size=array.length;
       data=new Comparable[array.length];
       data=(T)data;
       Object.arraycopy(array,0,data,0,array.length);
   }
   private void swap(int k,int n){
       T temp=data[k];
       data[k]=data[n];
       data[n]=temp;
   }
   private void down(int k){
       if(k*2<data.length){
	   if(data[k*2]>data[k]&&(k*2+1>=data.length||data[k*2]>data[k*2+1])){
	       swap(k,k*2);
	       down(k*2);
	   }
	   else if(k*2+1>=data.length&&(data[k*2+1]>data[k]&&data[k*2+1]>data[k*2])){
	       swap(k,k*2+1);
	       down(k*2+1);
	   }

       }
   }
   private void up(int k){
       if(k/2>=0&&data[k/2]<data[k]){
	   swap(k,k/2);
	   up(k/2);
       }
   }
   private void heapify(){
   }
   public T delete(){
       
   }
   public void add(T x){
       
   }
   private void doubleSize(){
   }
   public String toString(){
       String str="[ ";
       for(int x=0;x<data.length-1;x++){
	   str+=data[x]+", ";
       }
       str+=data[x]+"]";
       return str;
   }

   //do this last
   public MyHeap(boolean isMax){
   }
   public MyHeap(T[] array, boolean isMax){

   }

}

