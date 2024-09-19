public class Scoretest1 {
    public static void main(String[] args) {
        int score = 85;

        if (score >= 60){
            if(score >= 60 && score < 65){
                System.out.println("D0");
            }
            if(score >= 65 && score < 70){
                System.out.println("D+");
            }
            if(score >= 70 && score < 75){
                System.out.println("C0");
            }
            if(score >= 75 && score < 80){
                System.out.println("C+");
            }
            if(score >= 80 && score < 85){
                System.out.println("B0");
            }
            if(score >= 85 && score < 90){
                System.out.println("B+");
            }
            if(score >= 90 && score < 95){
                System.out.println("A0");
            }
            if(score >= 95){
                System.out.println("A+");
            }
        }else{
            System.out.println("F");
        }

    }
}
