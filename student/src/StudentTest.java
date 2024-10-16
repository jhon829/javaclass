public class StudentTest {
    public static void main(String[] args) {
        // Student 객체 생성
        Student student = new Student("name", 0, "deft");

        // 값 설정
        student.setName("김동년");
        student.setAge(24);
        student.setDept("소프트웨어융합학과");

        // 설정된 값 출력
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Department: " + student.getDept());
    }
}
