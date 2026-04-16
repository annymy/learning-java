//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextBeautifulNumber(1));
        System.out.println(solution.nextBeautifulNumber(1000));
    }
}

class Solution {
    public int nextBeautifulNumber(int n) {
        int len = 0;
        int num = n;
        while (num>0){
            len++;
            num/=10;
        }
        int []countDigits = new int[10];
        int result = search(n, 0, len, countDigits);
        if(result == 0) return search(0, 0, len+1, countDigits);
        return result;
    }

    private int search(int n, int current, int remaining, int[] countDigits){
        if(remaining ==0){
            if(current>n){
                for (int d = 1; d < 10; d++) {
                    if(countDigits[d]>0 && countDigits[d]!=d){
                        return 0;
                    }
                }
                return current;
            }
            return 0;
        }
        int result = 0;
        for (int d = 1; d < 10 && result==0; d++) {
            if(countDigits[d]<d && d-countDigits[d]<=remaining){
                countDigits[d]++;
                result = search(n, current*10+d, remaining-1, countDigits);
                countDigits[d]--;
            }
        }
        return  result;
    }

}