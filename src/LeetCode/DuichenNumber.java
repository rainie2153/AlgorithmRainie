package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliu on 7/28/16.
 */
public class DuichenNumber {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        Map<Character, Character> map = buildMap();
        char[] curNum = new char[n];
        char[] numberValidInMiddle = new char[]{'0','1','8'};
        helper(0,n-1, map, result, numberValidInMiddle, curNum);
        return result;
    }
    private void helper(int start, int end, Map<Character, Character> map, List<String> result, char[] mids, char[] curNum){
        if(start > end){
            result.add(new String(curNum));
            return;
        }
        if(start == end){
            //can only add the digits in the mids array
            for(char c : mids){
                curNum[start] = c;
                helper(start + 1, end - 1, map, result, mids, curNum);
            }
        }else{
            for(Map.Entry<Character, Character> entry : map.entrySet()){
                char first = entry.getKey();
                char last = entry.getValue();
                //0 as the first digit is not valid, so need to skip it
                if(start == 0 && first == '0'){
                    continue;
                }
                curNum[start] = first;
                curNum[end] = last;
                helper(start + 1, end - 1, map, result, mids, curNum);
            }
        }
    }

    private Map<Character, Character> buildMap(){
        Map<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        return map;
    }
    public static void main(String args[]) {
        DuichenNumber test = new DuichenNumber();
        test.findStrobogrammatic(2);
    }
}
