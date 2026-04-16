//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(totalFruit(new int[]{1,2,1}));
        System.out.println(totalFruit(new int[]{0,1,2,2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{1,2,2,2,3,1,2,2,3,2,3}));
        System.out.println(totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
    }

    public static int totalFruit(int[] fruits) {
        int maxCount = 0;
        int first = fruits[0], second = fruits[0];
        int count = 0;
        int current = 0;
        int change = 0;
        int prev = fruits[0];
        while(current<fruits.length){
            if(fruits[current]==first || fruits[current]==second){
                count++;
            } else {
                first = prev;
                second = fruits[current];
                count = current-change+1;
            }
            if(count>maxCount){
                maxCount = count;
            }
            if(!(fruits[current] == prev)){
                change = current;
            }
            prev = fruits[current];
            current++;
        }
        return maxCount;
    }
}