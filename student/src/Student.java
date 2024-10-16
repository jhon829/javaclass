public class Student {
    private String name;
    private int age;
    private String dept;

    // 생성자
    public Student(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    // name에 대한 getter와 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // age에 대한 getter와 setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // dept에 대한 getter와 setter
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
