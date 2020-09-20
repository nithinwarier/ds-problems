

public class ConsecutiveMax1s {

    static int max1s(int[] A) {
        int sum1 = 0, sum0 = 0, res = 0;
        for (int value : A) {
            if (value == 1) {
                if (sum1 == 0)
                    sum0 = 0;
                sum1 += 1;
            } else {
                if (sum0 == 0) {
                    res = sum1;
                    sum1 = 0;
                }
                //Suppose we encounter a 0 and we find out that res is greater than equal to half of array length,
                // so we should return res as there is no point in checking the array further.
                if (res >= A.length / 2) {
                    return res;
                }
                sum0 += 1;
            }
        }

        return Math.max(sum1, res);
    }


    public static void main(String[] args) {
        System.out.println("max1s: "+max1s(new int[]{1,1,0,0,1,1,1,1,0}));
    }
}