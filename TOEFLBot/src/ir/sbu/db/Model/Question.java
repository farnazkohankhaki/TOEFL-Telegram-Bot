package ir.sbu.db.Model;

import sun.jvm.hotspot.debugger.win32.coff.MachineTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fkohankhaki on 5/6/18.
 */
public class Question
{
    public static QuestionModel getQuestion(long value)
    {
        Connection dbCon = MysqlHelper.connect();
        QuestionModel questionModel = new QuestionModel();
        try
        {
            String findLastIDQuery = "SELECT * FROM User Where id = ?";
            PreparedStatement preparedStatement = dbCon.prepareStatement(findLastIDQuery);
            preparedStatement.setLong(1, value);
            long lastID = 0;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                lastID = resultSet.getLong("wordCount");
            long rand = (long)(Math.random() * (lastID + 1));
            String query = "SELECT * FROM `Question` WHERE wid = ?";
            preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, rand);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                questionModel.setQues(resultSet.getString("ques"));
                questionModel.setA1(resultSet.getString("a1"));
                questionModel.setA2(resultSet.getString("a2"));
                questionModel.setA3(resultSet.getString("a3"));
                questionModel.setA4(resultSet.getString("a4"));
                questionModel.setAns(resultSet.getString("ans"));
            }
            dbCon.close();
            return questionModel;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return questionModel;
    }

}