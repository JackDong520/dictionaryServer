package Controller;

import com.google.gson.Gson;
import javabeans.WordsEntity;
import org.springframework.web.bind.annotation.*;
import service.WordService;
import service.WordServiceImpl;

@RestController
public class Controller {

    private static WordServiceImpl wordService;
    private static Gson gson;

    static {
        wordService = new WordServiceImpl();
        gson = new Gson();
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/getWord")
    public
    @ResponseBody
    String getWord(@RequestParam(value = "word", defaultValue = "qwer") String word) {
        WordsEntity wordsEntity = wordService.selectSingleWordResult(word);
        System.out.println(gson.toJson(wordsEntity));
        return gson.toJson(wordsEntity);
    }
}








