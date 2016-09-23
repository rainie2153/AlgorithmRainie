package Important;

/**
 * Created by yuliu on 7/16/16.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null) {
            return;
        }

        int len = num.length;
        for (int i = len - 2; i >= 0; i--) {//back count
            if (num[i + 1] > num[i]) {
                int j;
                for (j = len - 1; j > i - 1; j--) {
                    if (num[j] > num[i]) {
                        break;
                    }
                }

                swap(num, i, j);
                reverse(num, i + 1, len - 1);
                return;
            }
        }

        reverse(num, 0, len - 1);
    }
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void reverse(int[] num, int beg, int end) {
        for (int i = beg, j = end; i < j; i++, j--) {
            swap(num, i, j);
        }
    }

    public static void main (String[] args) {
        NextPermutation test = new NextPermutation();
        int[] input = new int[]{4,5,6,9,8,7};
        test.nextPermutation(input);
    }
}


