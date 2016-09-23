package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 9/2/16.
 *///Given a string containing only digits, restore it by returning all possible valid IP address combinations
    //Given "25525511135"
    //
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {//如果基本的IP 0.0.0.0 长度至少是4都不满足就直接返回个空结果
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, 0, sb, res);
        return res;
    }

    private void dfs(String s, int level, int count, StringBuilder sb, List<String> res) {
        if (count == 4 && level == s.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 1; i < 4 && i + level <= s.length(); i++) {//比如给0000只有4,那么i=1,level最多3,i=3level最多1
            int num = Integer.parseInt(s.substring(level, level + i));
            if (num >= 0 && num <= 255) {
                if (num < 10 && i > 1) {
                    return;
                }
                StringBuilder newSb = new StringBuilder(sb);
                if (count == 0) {
                    newSb.append(num);//加第一个的时候不用.
                } else {
                    newSb.append(".").append(num);
                }

                dfs(s, level + i, count + 1, newSb, res);

            } else {
                break;
            }
        }
    }
    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs2(s, 0, 0, sb, res);
        return res;
    }

    public void dfs2(String s, int index, int count, StringBuilder sb, List<String> res) {
        if (count == 4 && index == s.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 1; i <= 3 && i + index <= s.length(); i++) {
            int num = Integer.parseInt(s.substring(index, index + i));
            if (num >= 0 && num <= 255) {
                if (num < 10 && i > 1) {
                    return;
                }
                StringBuilder newSb = new StringBuilder(sb);
                if (count == 0) {
                    newSb.append(num);
                }
                else {
                    newSb.append(".").append(num);
                }
                dfs2(s, index + i, count + 1, newSb, res);
            } else {
                break;
            }
        }
    }
    public static void main(String args[]) {
        RestoreIPAddresses test = new RestoreIPAddresses();
        System.out.print(test.restoreIpAddresses("0001"));
    }
}







