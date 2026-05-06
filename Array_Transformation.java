import java.util.Arrays;
import java.util.Scanner;

class Array_Transformation
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();    
        System.out.println("Enter "+n+" elements");
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        System.out.print("Enter a number: ");
        int k = sc.nextInt();
       int op =  minOperations(k,arr);
       System.out.println("Number of operations required is: "+op);
       sc.close();
    }

    static int minOperations(int k, int[] arr)
    {
        int n = arr.length;
        int rem = arr[0] % k;
        for(int i=1; i<n; i++)
        {
            if(arr[i] % k != rem)
                return -1;
        }
        Arrays.sort(arr);
        int med = arr[n/2];
        int op = 0;
        for(int item : arr)
             op += Math.abs(item - med) / k;
        return op;
    }

}