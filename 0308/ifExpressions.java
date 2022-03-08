public class ifExpressions {
    static boolean isSpring(int month)
    {
        return month >=3 && month <=5;
    }

    public static void main(String[] args) {
        int month =3;

        if(isSpring(month))
        {
            System.out.println("flowers bloom");
        }
    }
}

class test
{
    static boolean isSpring(int month)
    {
        return month >=3 && month <=5;
    }
    int month =3;
    boolean isSpring = isSpring(month);

    public static void main(String[] args) {

    }
}
