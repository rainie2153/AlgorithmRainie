package LeetCode;

/**
 * Created by yuliu on 7/25/16.
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
    public static void main(String args[]) {
        CompareVersionNumber test = new CompareVersionNumber();
        String v1 = "3.99.9";
        String v2 = "3.0";
        test.compareVersion(v1,v2);
    }
}
