package Controller;

import Dao.UserDAO;
import com.google.gson.Gson;
import javabeans.DictEntity;
import javabeans.UserEntity;
import org.junit.Test;
import org.springframework.web.bind.annotation.*;
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
        DictEntity dictEntity = wordService.selectSingleWordResult(word);
        System.out.println(gson.toJson(dictEntity));
        return gson.toJson(dictEntity);
    }

    @RequestMapping("/register")
    public
    @ResponseBody
    String register(@RequestParam(value = "user", defaultValue = "qwer") String user,
                    @RequestParam(value = "pwd", defaultValue = "qwer") String pwd) {
        UserDAO userDAO = new UserDAO();
        UserEntity userEntity = new UserEntity(0, user, pwd);
        if (userDAO.selectSingleUser(userEntity.getUser()) != null) return "0";

        if (userDAO.selectSingleUser(userEntity.getUser()) == null) {
            userDAO.saveSingleUser(userEntity);
            return "1";
        }
        return "0";
    }
    @RequestMapping("/login")
    public
    @ResponseBody
    String login(@RequestParam(value = "user", defaultValue = "qwer") String user,
                    @RequestParam(value = "pwd", defaultValue = "qwer") String pwd) {
        UserDAO userDAO = new UserDAO();
        UserEntity userEntity = new UserEntity(0, user, pwd);
        if (userDAO.selectSingleUser(userEntity.getUser()) == null) return "0";
        if(userDAO.selectSingleUser(userEntity.getUser()).getPwd().equals(pwd))return "1";
        else return "0";
    }



    @Test
    public void test() {
        System.out.println(getWord("take"));
    }
}








