package ir.sbu.db.Controller;

import ir.sbu.db.Model.User;
import ir.sbu.db.Model.UserModel;
import java.util.List;

public class UserController
{
    public static Boolean add()
    {
        String username = "admin";
        String state = "123";
        String email = "fkohan8@gmail.com";
        UserModel userModel = new UserModel();
        userModel.setAliasName(username);
        userModel.setState(state);
        userModel.setEmail(email);
        Boolean result = User.insert(userModel);
        return result;
    }

    public static Boolean update()
    {
        String findUsername = "admin";
        String username = "admin2";
        String state = "1234";
        String email = "fkohan88@gmail.com";
        UserModel userModel = new UserModel();
        userModel.setAliasName(username);
        userModel.setState(state);
        userModel.setEmail(email);
        Boolean result = User.update(userModel, findUsername);
        return result;
    }

    public static Boolean remove()
    {
        String findUsername = "admin2";
        Boolean result = User.remove(findUsername);
        return result;
    }

    public static void showAll()
    {
        List<UserModel> userModelList = User.getAll();
        for (UserModel usermodel : userModelList)
        {

            System.out.println("id: "+ usermodel.getId() + " | username: " + usermodel.getAliasName());
        }
    }
}