package Important;

/**
 * Created by yuliu on 8/25/16.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1 || numRows == 0) return s;
        char[] c = s.toCharArray();
        char[] result = new char[c.length];
        int r = 0;
        int cycle = 2 * (numRows - 1);//cycle = 4
        for (int col = 0; col < c.length; col += cycle) {
            result[r++] = c[col];//paypal  完成第一行result[pahn]
        }
        for(int row = 1; row < numRows - 1; row++) {//处理从第二行开始到倒数第二行
            for(int col = row; col < c.length; col += cycle) {//从左到右
                result[r++] = c[col]; //1,5,9,13
                int secondJ = col - row + cycle - row; //
                if(secondJ < c.length)
                    result[r++] = c[secondJ];
            }
        }
        for(int col = numRows - 1; col < c.length; col = col + cycle){
            result[r++] = c[col];
        }
        return String.valueOf(result);
    }
    public static void main(String args[]) {
        ZigZagConversion test = new ZigZagConversion();
        String s = "paypalishiring";
        System.out.print(test.convert(s, 3));
    }
}
