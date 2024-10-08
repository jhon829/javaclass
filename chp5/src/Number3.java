public class Number3 {
    public static void main(String[] args) {
        int[][][] threeDArray = new int[3][3][4];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 4; z++) {
                    if (x == 0) {
                        threeDArray[x][y][z] = (int)(Math.random() * 51);
                    } else if (x == 1) {
                        threeDArray[x][y][z] = (int)(Math.random() * 50) + 51;
                    } else {
                        threeDArray[x][y][z] = (int)(Math.random() * 50) + 101;
                    }
                }
            }
        }


        printArray(threeDArray);
    }

    // 출력을 위한 메소드
    public static void printArray(int[][][] array) {
        for (int x = 0; x < 3; x++) {
            System.out.println((x + 1) + "면");
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 4; z++) {
                    System.out.print(array[x][y][z] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}



