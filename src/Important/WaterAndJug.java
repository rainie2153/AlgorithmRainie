package Important;

/**
 * Created by yuliu on 8/1/16.
 */
public class WaterAndJug {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(x + y < z) return false;
        //case x or y is zero
        if( x == z || y == z || x + y == z ) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z%GCD(x, y) == 0;
    }

    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static void main (String[] args) {
        WaterAndJug test = new WaterAndJug();
        System.out.print(test.canMeasureWater(3,5,4));
    }
}