public class SungJuk1 {
    public static void main(String[] args) {
        String[] names = {"Henry", "Gosling", "Luca", "Mesi", "Ronaldo"};
        int[] javaLang = {95, 100, 98, 88, 78};
        int[] cLang = {67, 98, 100, 85, 74};
        int[] webLang = {89, 92, 100, 85, 74};

        System.out.println("\t\t====성적표====");
        System.out.println("이름\t\t\tJava\tC\t\tWeb\t\t평균\t\t학점");
        System.out.println("----------------------------------------");

        for (int i = 0; i < names.length; i++) {
            int total = javaLang[i] + cLang[i] + webLang[i];
            double average = total / 3.0;
            char grade = calculateGrade(average);

            System.out.printf("%s\t\t%d\t\t%d\t\t%d\t\t%.1f\t%c\n",
                    names[i], javaLang[i], cLang[i], webLang[i], average, grade);
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
