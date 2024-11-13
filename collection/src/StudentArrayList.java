import java.util.ArrayList;
import java.util.List;

public class StudentArrayList {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();


        //1
        student1.setName("김동년1");
        student1.setId("jhon829");
        student1.setAge(24);
        student1.setDept("소프트웨어융합학과");
        student1.setPhone("010-3342-1027");

        //1
        student2.setName("김동년2");
        student2.setId("jhon829");
        student2.setAge(24);
        student2.setDept("소프트웨어융합학과");
        student2.setPhone("010-3342-1027");

        //3
        student3.setName("김동년3");
        student3.setId("jhon829");
        student3.setAge(24);
        student3.setDept("소프트웨어융합학과");
        student3.setPhone("010-3342-1027");

        //4
        student4.setName("김동년4");
        student4.setId("jhon829");
        student4.setAge(24);
        student4.setDept("소프트웨어융합학과");
        student4.setPhone("010-3342-1027");

        //5
        student5.setName("김동년5");
        student5.setId("jhon829");
        student5.setAge(24);
        student5.setDept("소프트웨어융합학과");
        student5.setPhone("010-3342-1027");


        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);


        for(Student s: studentList){
            System.out.println(s.getName());
            System.out.println(s.getId());
            System.out.println(s.getDept());
            System.out.println(s.getPhone());
            System.out.println(s.getAge());
        }
    }
}
