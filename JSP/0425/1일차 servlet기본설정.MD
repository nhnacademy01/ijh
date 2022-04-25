* servlet만들기!!
1. add Framework support
2. web application 추가
3. web->webapp 으로 name 변경 후 src->main 밑으로 위치이동 (maven에서는 src/main으로 root를 정해놓았기 때문임.)
4. class파일 하나 생성

==pom.xml dependency==
<packaging>war</packaging> // 설정해주어야함

<dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>4.0.3</version>
</dependency>

<dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.11</version>
</dependency>

<dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.22</version>
</dependency>

<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.3.0</version>
            </plugin>
        </plugins>
</build>
========================================================

5. 만든 클래스에 HttpServlet 상속받아서 doGet메소드를 override 해야함.
(super.doget 메소드는 지워야함 왜냐? 기본적으로 405라던지 페이지를 던지기 때문에.)

6. PrintWriter out = PrintWriter out = resp.getWriter();
        out.println("hello servlet!!"); // try-with-resources를 사용
    
== web.xml 설정 == 
<servlet>
        <servlet-name>helloServlet</servlet-name> 
        <servlet-class>com.nhnacademy.servlet.HelloServlet</servlet-class>
    </servlet>
    
<servlet-mapping>
        <servlet-name>helloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
</servlet-mapping>
============================================

* logger 사용법
private static final Logger LOGGER = LoggerFactory.getLogger(HelloServlet.class);
-> lombok을 사용하면 이걸 안해도됨

run configuration -> Tomcat Server local로 추가
-> application context를 /로 변경