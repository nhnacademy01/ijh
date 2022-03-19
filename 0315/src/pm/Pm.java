package pm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pm {
    public static void main(String[] args) {
        Pm pm = new Pm();
        //pm.satisfy();
        //pm.group();
//        pm.replace();
        pm.training1();
    }

    // 정규표현식 만족
    public void satisfy() {
        Pattern p = Pattern.compile("^c.*");    // 'c'로 시작하는 문자열
        Matcher m = p.matcher("car");
        if (m.matches()) {
            System.out.println("Starts with 'c'");
        } else {
            System.out.println("Not starts with 'c'");
        }
    }

    // 정규표현식 그룹
    private void group() {
        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        Matcher m = p.matcher("이메일은 hong@nhn.com 입니다.");
        while (m.find()) {
            System.out.println("m.groupCount(): " + m.groupCount());
            System.out.println("m.group(): " + m.group());  // m.group(0)
            System.out.println("m.group(1): " + m.group(1));
            System.out.println("m.group(2): " + m.group(2));
        }
    }

    // 정규표현식 치환
    private void replace() {
        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        Matcher m = p.matcher("이메일은 hong@nhn.com 입니다.");
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            String localPart = m.group(1);
            m.appendReplacement(result, localPart + "@nhnacademy.com");
        }
        m.appendTail(result);
        System.out.println(result);
    }

    public void training1() {
        Pattern p = Pattern.compile("^03(?:0\1[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$"); // 정규표현식
        Matcher m = p.matcher("031-0032-0320");
        StringBuffer result = new StringBuffer();

        while (m.find()) {
            System.out.println("입장");
            String localPart = m.group(1);
            m.appendReplacement(result, localPart + "찾음");
        }

        m.appendTail(result);
        System.out.println(result);
    }
}
