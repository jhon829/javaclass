public class Phone {
        public static void main(String[] args) {
            Phonemodel myPhone = new Phonemodel();
            myPhone.model = "Sony";
            myPhone.value = 150;
            myPhone.print();

            Phonemodel yourPhone = new Phonemodel();
            yourPhone.model = "삼성";
            yourPhone.value = 200;
            yourPhone.print();
        }
}

class Phonemodel {
    String model;
    int value;

    void print() {
        System.out.println(value + " 원짜리 " + model + "카메라");
    }
}
