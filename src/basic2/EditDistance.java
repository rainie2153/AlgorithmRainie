package basic2;

/**
 * Created by yuliu on 6/27/16.
 */
//Given two strings of alphanumeric characters determine the min number of Replace, Delete and Insert operations needed
    //to transform one string into the other.
public class EditDistance {
    public int editDistance(String one, String two) {
        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1);
                    distance[i][j] = Math.min(distance[i - 1][j - 1] + 1, distance[i][j]);
                }
            }
        }
        System.out.print(distance[one.length()][two.length()]);
        return distance[one.length()][two.length()];
    }
    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        String one = "asitn";
        String two = "sign";
        test.editDistance(one, two);
    }
}
