
public class ForEachArray {

    public static void main(String[] args) {
        int [][] one2five = {{0,1,2,3,4}, {5,6,7,8,9}};
        int [][][] one2fives =
                {{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},},
                {{11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}},};
        int sum = 0;
//		sum = mySum(one2five);  // 메서드 호출(mySum)
        //2차원
//		for (int [] i : one2five) {
//			for (int d : i) {
//				sum += d;
//			}
//		}

        //3차원

        for (int i=0; i<one2fives.length;i++){
            System.out.println(i + "면");
            for (int j=0; j<one2fives[i].length;j++){
                System.out.println(j);
                for (int k=0; k<one2fives[i][j].length; k++){
                    System.out.print(k);
                }
            }
        }


//                sum += data[i][j];
//        sum = mySum(one2fives);
    }

    //
    //3차원 배열 처리 메서드
    static int mySum(int [][][] data) {
        int sum = 0;
        for(int[][] i : data)
            for(int[] j : i)
                for (int k : j)
                    sum += k;
        return sum;
    }

    //2차원 배열 처리 메서드
//    static int mySum(int [][] data){  // 메서드 선언
//        int sum = 0;
        //for-each
//	for (int [] i : data)
//		for (int d : i)
//			sum += d;
//
        //for
//        for (int i=0; i<data.length;i++)
//            for (int j=0; j<data[i].length;j++)
//                sum += data[i][j];
//
//        return sum;
//    }


//	static int mySum(int [] data){  // 메서드 선언
//		int sum = 0;
//		for (int d : data)
//			sum += d;
//		return sum;
//	}

}
