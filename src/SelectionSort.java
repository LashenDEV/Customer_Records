    public class SelectionSort {  

       
    
        public static int[] sort(int []arr){ /* function to sort an array with selection sort */  
              
                int i, j, small;  
                int n = arr.length;  
                    for (i = 0; i < n-1; i++)  
                {  
                    small = i; //minimum element in unsorted array  
              
                     for (j = i+1; j < n; j++)  
                         if (arr[j] < arr[small])  
                         small = j;  
                // Swap the minimum element with the first element  
                
                int temp = arr[small];  
                arr[small] = arr[i];  
                arr[i] = temp;  
      
            }  
    
            return arr;
        }

       
    }  

