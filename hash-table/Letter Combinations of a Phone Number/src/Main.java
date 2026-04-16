import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("2"));
    }


}

class Solution{
    Map<Character, String[]> buttons = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        buttons.put('2', new String[]{"a", "b", "c"});
        buttons.put('3', new String[]{"d", "e", "f"});
        buttons.put('4', new String[]{"g", "h", "i"});
        buttons.put('5', new String[]{"j", "k", "l"});
        buttons.put('6', new String[]{"m", "n", "o"});
        buttons.put('7', new String[]{"p", "q", "r", "s"});
        buttons.put('8', new String[]{"t", "u", "v"});
        buttons.put('9', new String[]{"w", "x", "y", "z"});
        List<String> words = new ArrayList<>();
        char[] digit = digits.toCharArray();
        words = (search(words, digit, 0, new StringBuilder()));
        return words;

    }

    private List<String> search(List<String>words, char[] digit, int idx, StringBuilder word){
        char number = digit[idx];
        String[] letters = buttons.get(number);
        for (int i = 0; i < letters.length; i++) {
            StringBuilder newWord = new StringBuilder();
            newWord.append(word);
            newWord.append(letters[i]);
            if(idx==digit.length-1){
                words.add(newWord.toString());
            } else {
                search(words, digit, idx+1, newWord);
            }
        }
        return words;
    }

}