import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class Cyclic_Substring_MaxSum
{
    public static void main(String[] args) 
    {
        System.out.println("Enter input string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        String str = s + s;
        Set <Character> h = new HashSet<>();
        int sum = 0, maxSum = 0, left = 0, right;
        for(right = 0; right < str.length(); right++)
        {
            char ch = str.charAt(right);
            int val = ch - 'a' +1;
            while (h.contains(ch)) 
            {
                char removeChar = str.charAt(left);
                sum -= (removeChar - 'a' + 1);
                h.remove(removeChar);
                left++;
            }
            h.add(ch);
            sum += val;
            while (right - left + 1 > n) {
                char removeChar = str.charAt(left);
                sum -= (removeChar - 'a' + 1);
                h.remove(removeChar);
                left++;
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
    
}