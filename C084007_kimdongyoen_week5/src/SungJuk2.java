public class SungJuk2 {
    public static void main(String[] args) {
        String[] names = {"Henry", "Gosling", "Luca", "Mesi", "Ronaldo"};
        int[][] student = {
                {95, 67, 89},
                {100, 98, 92},
                {98, 100, 100},
                {88, 85, 85},
                {78, 74, 74}
        };

        System.out.println("\t\t====성적표====");
        System.out.println("이름\t\t\tJava\tC\t\tWeb\t\t평균\t\t학점");
        System.out.println("----------------------------------------");

        for (int i = 0; i < names.length; i++) {
            int total = student[i][0] + student[i][1] + student[i][2];
            double average = total / 3.0;
            char grade = calculateGrade(average);

            System.out.printf("%s\t\t%d\t\t%d\t\t%d\t\t%.1f\t%c\n",
                    names[i], student[i][0], student[i][1], student[i][2], average, grade);
        }
    }

    public static char calculateGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }
}
