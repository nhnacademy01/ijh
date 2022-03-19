package stream;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        OptionalExample ex = new OptionalExample();
        ex.basic();

    }

    private void basic() {
        String source = "Comtin";   // source가 null이어도 ofNullable 생성자는 잘 됨
        Optional<String> opt1 = Optional.of("Jordan");        // 값이 무조건 있는 경우
        Optional<String> opt2 = Optional.ofNullable(source);  // 값이 없을 수도 있는 경우.
        Optional<String> opt3 = Optional.empty();             // 값이 없는 경우.

        System.out.println(opt1.map(String::toUpperCase).orElse(""));
        System.out.println(opt2.filter(s -> s.length() > 5)
                .orElseGet(OptionalExample::defaultValue));
        System.out.println(opt3.orElseThrow(() -> new RuntimeException("empty")));
    }

    static String defaultValue() {
        return "default";
    }
}
