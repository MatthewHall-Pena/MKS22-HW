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
   private void pushDown(int k){
       
   }
   private void pushUp(int k){
       
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

