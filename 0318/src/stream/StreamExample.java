package stream;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.toMap;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        StreamExample ex  = new StreamExample();
        //ex.match();
        //ex.readOnly();
        //ex.readOnce();
        //ex.collect();
        //ex.find();
//        ex.reduce();
       // ex.practice();

        ex.filesLines();
    }

    private void filesLines() throws IOException {
        // 경로는 알아서, 단, 해당 디렉토리에는 파일만 있어야함.
        String dir = "C:\\Users\\123\\Desktop\\0318\\src\\stream";
        Path path = Paths.get(dir);
        Stream<Path> fileStream = Files.list(path);

        fileStream.flatMap(this::getLines)
                .forEach(System.out::println);
    }

    private Stream<String> getLines(Path f) {
        try {
            return Files.lines(f);
        } catch (IOException e) {
            return Stream.empty();
        }
    }

    private void conetd() {

    }

    private void practice() {
        /*
        *   1.	영어 문자열을 입력 받는다.	String
            2.	문자열을 대문자로 변환한다	String	String
            3.	문자열을 문자배열(char[])로 변환한다	String	char[]
            4-1.	문자들를 아스키코드로 변환한다.	char[]	int[]
            4-2.	아스키코드의 합을 구한다.	int[]	long
            *
            * */

        List<String> messages = List.of("Welcome", "NHN", "Academy");
        int sum = messages.stream()
                .map(String::toUpperCase)
                .flatMapToInt(String::chars) // 3, 4-1 까지 한줄만에 끝냄.
                .peek(c -> System.out.print(c + " "))
                .sum();
        System.out.printf(" > sum = " + sum);
    }

    private void readOnly() {

    }

    private void readOnce() {
        List<String> strs = List.of("Welcome", "NHN", "Academy");
        Stream<String> stream = strs.stream();
        stream.sorted().forEach(System.out::println);
        // 재사용 시도: 예외 발생
        stream.forEach(System.out::println);
        // 새로 만들어서 실행: 성공
        strs.stream().forEach(System.out::println);
    }

    // collect를 사용하면 list로 반환할 수 있다.
    private void collect() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy");
        // list
        List<String> list = strs.stream()
                .collect(Collectors.toList());
        System.out.println(list);
        // set
        Set<String> set = strs.stream()
                .collect(Collectors.toSet());
        //    .collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
        // map
        Map<String, Integer> map = strs.stream()
                .distinct() // 이것을 빼면 어떻게 될까?
                .collect(toMap(s -> s, s -> s.length()));
        //      .collect(toMap(Function.identity(), String::length));
        System.out.println(map);
        // joining
        String message = strs.stream()
                .distinct()
                .collect(Collectors.joining(" ", "", "!"));
        //      .collect(Collectors.joining(" "));  // only delimiter
        System.out.println(message);
    }
    // 종결 연산자
    private void match() {
        List<String> strs = List.of("Welcome", "NHN", "Academy");
        // anyMatch
        boolean anyMatch = strs.stream()
                .anyMatch((value) -> value.startsWith("NHN"));
        System.out.println(anyMatch);
        // allMatch
        boolean allMatch = strs.stream()
                .allMatch((value) -> value.length() > 2);
        System.out.println(allMatch);
        // noneMatch
        boolean noneMatch = strs.stream()
                .allMatch(isEqual("Student"));
        System.out.println(noneMatch);
    }

    private void find() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy");
        // finaAny
        String anyLength3 = strs.stream()
                .filter(s -> s.length() == 7)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Not found exception"));
        System.out.println("findAny: " + anyLength3);
        // findFirst
        String firstLength3 = strs.stream()
                .filter(s -> s.length() == 3)
                .findFirst()
                .orElse(null);
        System.out.println("findFirst: " + firstLength3);
    }

    // 줄여서 하나의 값을 표현한다.
    private void reduce() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy", "Academy");
        String concat = strs.stream()
                .distinct()
                .reduce((result, element) -> result + " " + element)
                .orElse("");
        System.out.println("concat: " + concat);

        int specialStrLength = strs.stream()
                .filter(s -> s.length() > 3)
                .map(String::length)
                .reduce(0, Integer::sum);
        // "WelcomeAcademyAcademy".length = 21
        System.out.println("specialStrLength: " + specialStrLength);
    }

}
