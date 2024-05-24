/*Worked with Russell Ostergaard*/
/*Imports the Java Random Class*/
import java.util.Random;
public class AlteredQuicksort {

       public static void main(String[] args) {

    	   	  /*Creates random object*/
              Random rand = new Random();
              
              /*Creates two arrays one of 1000 and the other of 50000*/
              int[] ary50000 = new int[50000];
              int[] ary1000= new int[1000];
              
              /*These next two for loops fill the arrays with values of 1 to 100*/
              for(int i = 0; 50000 > i; i++) {
                     ary50000[i] = rand.nextInt(101);
              }
              
              for(int i = 0; 1000 > i; i++) {
                     ary1000[i] = rand.nextInt(101);
              }
              
              /*Time Efficinecy Testing and the Altered Quicksort method is called to sort the arrays*/
              long start = System.currentTimeMillis();
              alteredquicksort(ary1000, 0, ary1000.length - 1);
              long end = System.currentTimeMillis();
              System.out.println("Time Efficiency for an Array of 1000:");
              System.out.println(end - start);
              //printArray(ary1000);
              
              /*Time Efficinecy Testing and the Altered Quicksort method is called to sort the arrays*/
              start = System.currentTimeMillis();
              alteredquicksort(ary50000, 0, ary50000.length - 1);
              end = System.currentTimeMillis();
              System.out.println("Time Efficiency for an Array of 50000:");
              System.out.println(end - start);
              //printArray(ary50000);
            
       }
       
       /*The actual altered quicksort. It splits the initial array into two arrays around a pivot and then calls the selection sort to sort them 
        * before calling merger to bring them back together*/
       static void alteredquicksort(int[] numbers, int lowindex,int highindex) {
              int pivot=numbers[(highindex)];
              while(lowindex<=highindex){
                     while(numbers[lowindex]<pivot) {
                           lowindex++;
                     }
              while(numbers[highindex]>pivot) {
                     highindex--;
              }
              if(lowindex<=highindex) {
                     int temp=numbers[lowindex];
                     numbers[lowindex]=numbers[highindex];
                     numbers[highindex]=temp;
                     lowindex++;
                     highindex--;
              }
              }
              int[] ary3 = new int[ (numbers.length - highindex) - 1];
              int[] ary4 = new int [highindex + 1];
              int j = 0;
              
              /*Makes two new arrays- one full of intergers below and above the pivot number*/
              for(int i = highindex + 1 ; i < numbers.length; i++) {
                     ary3[j] = numbers[i];
                     j++;
              }
              j = 0;
              for(int i = 0; i < highindex + 1 ; i++) {
                     ary4[j] = numbers[i];
                     j++;

              }
              /*Calls selection sort once for both new arrays*/
              selectionsort(ary4);
              selectionsort(ary3);
              
              /*Merges the arrays back into one*/
              merger(numbers,ary4,ary3);

       }
       
       /*Selection sort method that does the actual sorting of the two arrays*/
       public static void selectionsort(int [] array) {
       /*This uses the minimum number in the array to do the sorting*/
              int min, temp=0;
              for(int i=0;i<array.length;i++) {
                     min=i;
                     for(int j=i+1;j<array.length;j++) {
                           if(array[j]<array[min]) {
                                  min=j;
                           }
                     }
       /*The code that does the swapping of the variables*/
                     temp=array[i];
                     array[i]=array[min];
                     array[min]=temp;
              }
       }

       /*Method that just prints out an array*/
       static void printArray(int[] numbers) {
              for(int i=0; i<numbers.length;i++ ) {
                     System.out.println(numbers[i]);
              }
}
       
       /*Takes arrays and merges them back together*/
       public static void merger(int[] numbers, int[] left, int[] right) {
   		int leftsize = left.length;
   		int rightsize = right.length;
   		int n = 0, e = 0, g = 0;
   		while (n < leftsize && e < rightsize) {
   			if (left[n] <= right[e]) {
   				numbers[g] = left[n];
   				n++;
   			}
   			else {
   				numbers[g] = right[e];
   				e++;
   			}
   			g++;
   		}
   		
   		while (n < leftsize) {
   			numbers[g] = left[n];
   			n++;
   			g++;
   		}
   		
   		while (e < rightsize) {
   			numbers[g] = right[e];
   			e++;
   			g++;
   		}
   	}
       
       
       
}