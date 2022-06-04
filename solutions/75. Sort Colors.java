class Solution {
    public void sortColors(int[] arr) {
   int current = 0, zeroPos = 0, twoPos = arr.length-1;
​
        while(current <= twoPos) {
            
        if(arr[current] == 0) {
            
​
            int temp = arr[current];
            arr[current] = arr[zeroPos];
            arr[zeroPos] = temp;    
            zeroPos = zeroPos + 1;
            current = current + 1;
            
        }else if(arr[current] == 2) {
​
            int temp = arr[current];
            arr[current] = arr[twoPos];
            arr[twoPos] = temp;    
            twoPos = twoPos -1;
        }else {
​
            current = current + 1;
            
        }
        
        }
            
        }
    }
​
