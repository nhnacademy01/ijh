public class IfExpressions {
    public static void main(String[] args) {
        IfExpressions i = new IfExpressions();
        i.switchPrint(65);
    }

    void elseIfToTriOperator(){
        int score =50;
        String grade;

        grade = score >= 90 ? "A" :
                score >= 80 ? "B" :
                        "F";
        System.out.println("Grade : " + grade);
    }

    void print(int score){
        if(score >= 90){
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }

    void switchPrint(int score){
        switch (score / 10) {
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }
    }
}
