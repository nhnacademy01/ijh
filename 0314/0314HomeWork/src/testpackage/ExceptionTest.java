package testpackage;

public class ExceptionTest {
    public static void main(String[] args) {
        TestMethod testMethod = new TestMethod();
        testMethod.setOpeands(10,0);
    }
}

class TestMethod {
    int a,b;
    public void setOpeands(int a, int b) {
        if(b==0){
            System.out.println("두번째 인자는 0을 허용하지 않습니다.");
        }
        this.a = a;
        this.b = b;
    }
}