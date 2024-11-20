import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double korean, english, math;

    public Student(String name, double korean, double english, double math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public double getTotal() {
        return korean + english + math;
    }

    public double getAverage() {
        return getTotal() / 3;
    }
}

public class StudentGradeProgram {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("학생 이름과 국어, 영어, 수학 점수를 입력하세요:");
            String name = scanner.next();
            double korean = scanner.nextDouble();
            double english = scanner.nextDouble();
            double math = scanner.nextDouble();
            students.add(new Student(name, korean, english, math));
        }

        System.out.println("\n### 성적표 ###");
        System.out.println("===========================================");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "이름", "국어", "영어", "수학", "총점", "평균");
        System.out.println("-------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-10s%-10.1f%-10.1f%-10.1f%-10.1f%-10.1f\n",
                    student.name, student.korean, student.english, student.math,
                    student.getTotal(), student.getAverage());
        }

        System.out.println("===========================================");
    }
}
