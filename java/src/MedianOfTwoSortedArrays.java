import java.util.Arrays;

class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] num1, int[] num2) {
        if (num1.length == 0) {
            return getMedianValue(num2, 0, num2.length - 1);
        }
        if (num2.length == 0) {
            return getMedianValue(num1, 0, num1.length - 1);
        }
        if (getMedianValue(num1, 0, num1.length - 1) == getMedianValue(num2, 0, num2.length - 1)){
            return getMedianValue(num1, 0, num1.length - 1);
        }
        return findMedianSortedArraysRec(num1, 0, num1.length - 1, num2, 0, num2.length - 1);
    }

    private double findMedianSortedArraysRec(int[] num1, int p11, int p12, int[] num2, int p21, int p22) {

        if (p12 - p11 <= 1 && p22 - p21 <= 1) {
            int[] medianContainingArray;
            if (p12 - p11 == 0 && p21 - p22 == 0) {
                medianContainingArray = new int[]{num1[p11], num2[p22]};
            } else if (p12 - p11 == 0) {
                medianContainingArray = new int[]{num1[p11], num2[p21], num2[p22]};
            } else if (p22 - p21 == 0) {
                medianContainingArray = new int[]{num1[p11], num1[p12], num2[p21]};
            } else {
                medianContainingArray = new int[]{num1[p11], num1[p12], num2[p21], num2[p22]};
            }
            Arrays.sort(medianContainingArray);
            int discardedLeft = p11 + p21;
            int discardedRight = num1.length - (p12 + 1) + num2.length - (p22 + 1);
            if (discardedLeft == discardedRight) {
                return getMedianValue(medianContainingArray, 0, medianContainingArray.length - 1);
            } else if (discardedRight > discardedLeft) {
                return getMedianValue(medianContainingArray, discardedRight - discardedLeft, medianContainingArray.length - 1);
            } else {
                return getMedianValue(medianContainingArray, 0, medianContainingArray.length - 1 - (discardedLeft - discardedRight));
            }
        }

        double m1 = getMedianValue(num1, p11, p12);
        double m2 = getMedianValue(num2, p21, p22);

        //recursion
        if (m1 > m2) {
            p12 = getUpperMedianIndex(p11, p12);
            p21 = getLowerMedianIndex(p21, p22);
        } else {
            p11 = getLowerMedianIndex(p11, p12);
            p22 = getUpperMedianIndex(p21, p22);
        }
        return findMedianSortedArraysRec(num1, p11, p12, num2, p21, p22);
    }

    private double getMedianValue(int[] nums, int lowerbound, int upperbound) {
        boolean isTwoNumbers = (upperbound + lowerbound) % 2 != 0;
        int lowerIndex = (upperbound + lowerbound) / 2;
        return isTwoNumbers ? (double) (nums[lowerIndex] + nums[lowerIndex + 1]) / 2 : (double) nums[lowerIndex];
    }

    private int getUpperMedianIndex(int lowerbound, int upperbound) {
        return (upperbound + lowerbound) % 2 == 0 ? (upperbound + lowerbound) / 2 : (upperbound + lowerbound) / 2 + 1;
    }

    private int getLowerMedianIndex(int lowerbound, int upperbound) {
        return (upperbound + lowerbound) / 2;
    }

}

