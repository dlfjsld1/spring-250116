package com.example.demo.domain.home.controller;

import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller // 이 클래스가 컨트롤러임을 나타내는 어노테이션입니다.
@ResponseBody
public class HomeController { // HomeController 클래스를 정의합니다.

    private int age = 0;

    @Autowired
    private List<Integer> numList;

    @Autowired
    private List<Integer> numList2;

    @GetMapping("/numList2")
    public List<Integer> getNumList2() {
        return numList2;
    }

    @GetMapping("/numList")
    public List<Integer> getNumList() {
        return numList;
    }

    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/introduce")
    public String introduce() {
        return "안녕하세요. 저는 홍길동입니다.";
    }

    @GetMapping("/ageUp")
    public int ageUp() {
        return ++age;
    }
    @GetMapping("/short")
    public short getShort() {
        return 1;
    }

    @GetMapping("/long")
    public long getLong() {
        return 1;
    }

    @GetMapping("/float")
    public float getFloat() {
        return 3.14f;
    }

    @GetMapping("/double")
    public double getDouble() {
        return 3.14;
    }

    @GetMapping("/char")
    public char getChar() {
       return '안';
    }

    @GetMapping("/boolean")
    public boolean getBoolean() {
        return true;
    }

    @GetMapping("/array")
    public String[] getArray() {
        return new String[] {"a", "b", "c"};
    }

    @GetMapping("/list")
    public List<String> getList() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/map")
    public Map<String, String> getMap() {
        return Map.of("k1", "v1", "k2", "v2");
    }

    @GetMapping("/article")
    public Article getArticle() {
        //빌더를 이용하면 생성자에 값을 잘못 넣어 실수할 확률이 줄고 가독성 면에서 좋다
        //단, 빌더를 쓸 때는 빌더에 넣는 값만 넣는다. 만약  미리 세팅된 값을 쓰려면 객체에
        //@Builder.Default이런 추가 어노테이션이 필요
        return Article.builder()
                .title("제목")
                .body("내용")
                .isDeleted(false)
                .build();
        //생성자도 여전히 현업에서 쓴다
        //return new Article("제목", "내용");
    }

    @GetMapping("/mapList")
    public List<Map<String, String>> getMapList() {
        return List.of(
                Map.of("k1", "v1", "k2", "v2"),
                Map.of("k1", "v3", "k2", "v4")
        );
    }

    @GetMapping("/articleList")
    public List<Article> getArticleList() {
        return List.of(
                Article.builder().title("제목1").body("내용1").isDeleted(false).build(),
                Article.builder().title("제목2").body("내용2").isDeleted(false).build()
        );
    }

    @GetMapping("/articleList.html")
    public String getArticleListHtml() {
        Article a1 = Article.builder().title("aaa").body("내용1").isDeleted(false).build();
        Article a2 = Article.builder().title("bbb").body("내용2").isDeleted(false).build();

        List<Article> articleList = List.of(a1, a2);

        String list = articleList.stream()
                .map(a -> "<li>%s</li>".formatted(a.getTitle()))
                .collect(Collectors.joining());
        //자바에서 꾸미지 않고, html에서 하라고 template(자바로 작동하는 html)
        return "<ul>" + list + "</ul>";
    }

    @GetMapping("/grandma")
    public String grandma() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>FPS 게임 이야기</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Comic Sans MS', cursive, sans-serif;\n" +
                "            background-color: #ffcccb;\n" +
                "            color: #800000;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background-image: url('https://www.transparenttextures.com/patterns/snow.png');\n" +
                "        }\n" +
                "        header {\n" +
                "            background-color: #ff4500;\n" +
                "            color: white;\n" +
                "            padding: 30px;\n" +
                "            text-align: center;\n" +
                "            font-size: 3em;\n" +
                "            border-bottom: 5px dotted yellow;\n" +
                "        }\n" +
                "        h1 {\n" +
                "            font-size: 4em;\n" +
                "            text-shadow: 2px 2px 3px black;\n" +
                "        }\n" +
                "        .content {\n" +
                "            margin: 20px auto;\n" +
                "            max-width: 800px;\n" +
                "            padding: 20px;\n" +
                "            background: #ffffe0;\n" +
                "            border: 5px solid pink;\n" +
                "            border-radius: 15px;\n" +
                "            box-shadow: 0 0 15px purple;\n" +
                "        }\n" +
                "        h2 {\n" +
                "            font-size: 3em;\n" +
                "            text-decoration: underline;\n" +
                "        }\n" +
                "        p, ul li {\n" +
                "            font-size: 1.5em;\n" +
                "        }\n" +
                "        img {\n" +
                "            max-width: 100%;\n" +
                "            border: 3px solid red;\n" +
                "            border-radius: 10px;\n" +
                "            margin: 20px 0;\n" +
                "        }\n" +
                "        footer {\n" +
                "            background-color: #ff4500;\n" +
                "            color: white;\n" +
                "            text-align: center;\n" +
                "            padding: 20px;\n" +
                "            font-size: 2em;\n" +
                "            margin-top: 30px;\n" +
                "            border-top: 5px dotted yellow;\n" +
                "        }\n" +
                "        .emoji {\n" +
                "            font-size: 3em;\n" +
                "            margin: 10px;\n" +
                "        }\n" +
                "        a {\n" +
                "            color: blue;\n" +
                "            font-weight: bold;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "        a:hover {\n" +
                "            text-decoration: underline;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <header>\n" +
                "        <h1>\uD83C\uDF1F FPS 게임 이야기 \uD83C\uDF1F</h1>\n" +
                "        <p class=\"emoji\">\uD83C\uDFAE\uD83D\uDCA5\uD83E\uDD20✨</p>\n" +
                "    </header>\n" +
                "\n" +
                "    <div class=\"content\">\n" +
                "        <h2>\uD83C\uDFAE 최신 소식</h2>\n" +
                "        <p>\"아이고, 요새 게임이란 게 정말 멋지구만! 총알이 슝슝~ 화면이 번쩍번쩍! \"헤드샷 마스터 2025\"라는 게 나왔대요! 이게 아주 <strong>신기한 무기</strong>가 나온다지 뭐예요! \uD83C\uDFC6</p>\n" +
                "        <img src=\"https://cdn.pixabay.com/photo/2016/03/27/21/36/game-1280914_1280.jpg\" alt=\"게임 이미지\">\n" +
                "\n" +
                "        <h2>\uD83D\uDCA1 게임하면서 이런 것도 알면 좋지!</h2>\n" +
                "        <ul>\n" +
                "            <li>\"애미야, 고수들은 하루 종일 총 쏜단다. 10시간이나 훈련한대! \uD83D\uDE32\"</li>\n" +
                "            <li>\"옛날에 내가 듣기론 FPS라는 게 1993년에 처음 나왔다더라~ \uD83D\uDD79\uFE0F\"</li>\n" +
                "            <li>\"사람이 혼자 하면 재미가 없지. 팀워크가 중요한 거란다~ \uD83E\uDD1D\"</li>\n" +
                "        </ul>\n" +
                "    </div>\n" +
                "\n" +
                "    <footer>\n" +
                "        <p>© 2025 FPS Gamers Hub - \"게임은 한 방이다!\"</p>\n" +
                "        <p class=\"emoji\">\uD83D\uDD25\uD83D\uDC7E\uD83E\uDD16\uD83D\uDC51</p>\n" +
                "    </footer>\n" +
                "</body>\n" +
                "</html>\n";
    }

    @GetMapping("/cat") // "/" 경로로 GET 요청이 들어오면 이 메서드가 실행됩니다.
    public String cat() { // home 메서드를 정의합니다.
return "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "    <title>고양이의 하루</title>\n" +
        "    <style>\n" +
        "        body {\n" +
        "            font-family: 'Roboto', sans-serif;\n" +
        "            background-color: #fdf5e6;\n" +
        "            color: #444;\n" +
        "            text-align: center;\n" +
        "            margin: 0;\n" +
        "            padding: 0;\n" +
        "        }\n" +
        "        header {\n" +
        "            background-color: #ffa500;\n" +
        "            color: white;\n" +
        "            padding: 20px 0;\n" +
        "            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n" +
        "        }\n" +
        "        h1 {\n" +
        "            font-size: 2.5em;\n" +
        "        }\n" +
        "        .content {\n" +
        "            margin: 20px auto;\n" +
        "            max-width: 800px;\n" +
        "            padding: 20px;\n" +
        "            background: white;\n" +
        "            border-radius: 10px;\n" +
        "            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);\n" +
        "        }\n" +
        "        img {\n" +
        "            max-width: 100%;\n" +
        "            border-radius: 10px;\n" +
        "        }\n" +
        "        .fun-facts {\n" +
        "            background-color: #ffe4b5;\n" +
        "            padding: 20px;\n" +
        "            border-radius: 10px;\n" +
        "            margin-top: 20px;\n" +
        "            text-align: left;\n" +
        "        }\n" +
        "        footer {\n" +
        "            margin-top: 20px;\n" +
        "            padding: 10px 0;\n" +
        "            background-color: #ffa500;\n" +
        "            color: white;\n" +
        "        }\n" +
        "        a {\n" +
        "            color: #ff6347;\n" +
        "            text-decoration: none;\n" +
        "        }\n" +
        "        a:hover {\n" +
        "            text-decoration: underline;\n" +
        "        }\n" +
        "    </style>\n" +
        "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap\" rel=\"stylesheet\">\n" +
        "</head>\n" +
        "<body>\n" +
        "    <header>\n" +
        "        <h1>\uD83D\uDC3E 고양이의 하루 \uD83D\uDC3E</h1>\n" +
        "        <p>\"야옹~ 오늘은 고양이처럼 살기 딱 좋은 날!\"</p>\n" +
        "    </header>\n" +
        "\n" +
        "    <div class=\"content\">\n" +
        "        <h2>✨ 아침: 고양이 스트레칭!</h2>\n" +
        "        <p>아침 햇살을 맞으며 우아하게 스트레칭을 하는 고양이! 고양이는 하루를 느긋하고도 활기차게 시작해요.</p>\n" +
        "        <img src=\"https://cdn.pixabay.com/photo/2017/11/09/21/41/cat-2934720_960_720.jpg\" alt=\"아침 스트레칭\">\n" +
        "\n" +
        "        <h2>✨ 점심: 간식 타임!</h2>\n" +
        "        <p>\"야옹~\" 냉장고 근처에서 들리는 소리! 고양이는 오늘도 주인의 간식 봉지 스킬에 감탄합니다. \uD83D\uDE3A</p>\n" +
        "        <img src=\"https://cdn.pixabay.com/photo/2015/11/16/22/14/cat-1046544_960_720.jpg\" alt=\"간식 먹는 고양이\">\n" +
        "\n" +
        "        <h2>✨ 저녁: 모험가 모드 ON!</h2>\n" +
        "        <p>의자 위, 책상 아래, 갑자기 벽을 타고 올라가는 고양이! 고양이의 상상력은 끝이 없어요. 탐험가의 하루는 바쁩니다.</p>\n" +
        "        <img src=\"https://cdn.pixabay.com/photo/2017/02/15/12/12/cat-2068462_960_720.jpg\" alt=\"탐험 중인 고양이\">\n" +
        "\n" +
        "        <div class=\"fun-facts\">\n" +
        "            <h3>\uD83D\uDCA1 고양이의 재미있는 사실들</h3>\n" +
        "            <ul>\n" +
        "                <li>고양이는 하루 16시간 이상 잠을 자요. 정말 부럽죠!</li>\n" +
        "                <li>\"고양이 골골송\"은 치유 효과가 있다는 연구 결과도 있답니다!</li>\n" +
        "                <li>고양이의 앞발에는 다섯 개의 발톱, 뒷발에는 네 개가 있어요.</li>\n" +
        "            </ul>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "\n" +
        "    <footer>\n" +
        "        <p>❤\uFE0F 더 많은 고양이 이야기를 알고 싶다면 <a href=\"https://en.wikipedia.org/wiki/Cat\" target=\"_blank\">여기</a>를 클릭하세요! \uD83D\uDC31</p>\n" +
        "    </footer>\n" +
        "</body>\n" +
        "</html>\n";
        //        return "hello"; // "hello" 문자열을 반환합니다. 이 문자열이 클라이언트에게 전송됩니다.
    }
}

// 스프링에 잭슨이 기본으로 내장되어 있음
@Getter
//RequiredArgsConstructor와 AllArgsConstructor의 차이는 final이 붙은 필드만 생성자를 만드는지 아닌지
@Builder
class Article {
    @Builder.Default
    private int id = 1;
    private final String title;
    private final String body;
    private boolean isDeleted;
}
