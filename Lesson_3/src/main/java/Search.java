import java.util.Arrays;

public class Search {

    public static void main(String[] args) {
        int[] arrNum = {1,2,3,4,5,7,8,9,10,11,12,13,14};

        for (int i = 0; i < arrNum.length; i++) {
            if (i + 1 < arrNum.length ) {
                int subLeft = arrNum[i+1] - arrNum[i];

                if(subLeft > 1){
                    System.out.println(arrNum[i] + 1);
                }
            }
        }
    }
}
