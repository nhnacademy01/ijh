package homework;
import java.util.Scanner;

public class LoginSignUpProgram {
    Scanner scanner = new Scanner(System.in);
    boolean isLogin = false;                                // 로그인 여부
    Account[] userdb = new Account[10];                     // 유저정보가 들어있는 UserInformation클래스의 객체

    public static void main(String[] args) {
        int menuNum;                                            // 메뉴번호
        LoginSignUpProgram program = new LoginSignUpProgram();  // Login클래스의 객체

        while (!program.isLogin) {
            System.out.print("nhn academy에 오신 것을 환영합니다. 아래에서 메뉴를 선택하세요.\n1. 회원가입\n2. 로그인\n0. 종료\n> ");
            menuNum = Integer.parseInt(program.scanner.nextLine()); // 이 scanner는 참조가 안되면서

            // 메뉴번호 받아서 각 작업 수행
            switch (menuNum) {
                case 0:
                    return;
                case 1:
                    // 비어있는 userdb배열에 가입
                    for (int i = 0; i < program.userdb.length; i++) {
                        if (program.userdb[i] == null) {
                            program.userdb[i] = program.signUp();
                            break;
                        }
                    }
                    break;
                case 2:
                    program.isLogin = program.login(program.userdb); // 로그인 메소드에 유저정보가 담겨있는 userdb를 넘겨줌
                    break;
            }
        }
    }

    // 회원가입
    public Account signUp() {
        Account user = new Account(); // 여기에서 객체를 생성해봤자 밖에서 저장안됨
        String tempPw;

        System.out.println("회원가입을 해주세요.");
        while (true) {
            System.out.print("아이디 > ");
            user.id = scanner.nextLine(); // 이 scanner는 왜 참조가 되지?
            System.out.print("비밀번호 > ");
            user.pw = scanner.nextLine();
            System.out.print("비밀번호 재입력> ");
            tempPw = scanner.nextLine();
            System.out.print("이름> ");
            user.name = scanner.nextLine();
            System.out.print("권한(1:관리자, 2:일반)> ");
            user.admin = scanner.nextInt();
            scanner.nextLine(); // scanner에 남아있는 엔터값을 비워줌

            if (user.id.equals("") || user.pw.equals("") || user.name.equals(""))
                System.out.println("모든 항목의 정보를 입력해주십시오.");
            else if (!user.pw.equals(tempPw))
                System.out.println("비밀번호가 일치하지 않습니다.");
            else {
                System.out.println("회원가입에 성공했습니다. 이전 메뉴로 돌아갑니다.");
                return user;
            }
        }
    }

    // 로그인
    boolean login(Account[] userdb) {
        String tempId, tempPw; // 입력받은 정보 저장용

        System.out.println("로그인 해주세요.");
        while (true) {
            // 로그인정보 입력받음
            System.out.print("아이디 > ");
            tempId = scanner.nextLine();
            System.out.print("비밀번호 > ");
            tempPw = scanner.nextLine();

            // 잠긴 계정인지 확인
            for (int i = 0; i < userdb.length; i++) {
                // 입력받은id와 db에있는id가 일치한지 확인
                // db배열이 50이기 때문에 아직 만들어지지 않은 공간에 접근이 불가능하도록 null처리를 하였음
                if (userdb[i] != null && tempId.equals(userdb[i].id)) {
                    if (userdb[i].failCount == 3) {  // 해당id가 잠긴id인지 확인
                        if(userdb[i].admin == 2) { // 해당id가 관리자 계정인지 확인
                            System.out.println("해당 계정은 잠겼습니다.");
                            return false;
                        }
                    }
                }
            }

            // 입력받은 로그인 정보가 userdb에 있는 idpw와 일치한지 확인
            for (int i = 0; i < userdb.length; i++) {
                if (userdb[i] != null && userdb[i].id.equals(tempId))
                    if (userdb[i].pw.equals(tempPw)) {
                        System.out.printf("%s님 환영합니다.%n", userdb[i].name);
                        return true;
                    } else {
                        userdb[i].failCount++;
                    }
            }

            System.out.println("id와 pw가 일치하지 않습니다. 다시 입력해주세요.");
        }
    }
}

// 계정db
class Account {
    String id;
    String pw;
    String name;
    int admin;
    int failCount = 0;
}

// 제가 짠 내용인데 객체개념과 상속나오면서 부터 이해과정이 무너졌습니다
// 각 기능들로 클래스를 나누는지 메서드를 나누는지 틀을 잡는게 전혀 감이 안잡힙니다.
// 어떻게 시작해나가야 할지 막막합니다.

// 개념 -> 타입 -> 클래스(명사)
// 어떤 개념의 행위(동사)

//프로그램.로그인 -> 아이디로 계정 찾기 -> 비밀번호가 맞는가?
//        .회원가입 -> 계정 생성
//계정.비밀번호 맞음?
//계정.너 관리자임?