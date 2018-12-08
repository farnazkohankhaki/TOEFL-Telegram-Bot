package ir.sbu.db.Model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Word
{
    public static Boolean insert(WordModel wordModel)
    {
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try
        {
            String findLastIDQuery = "SELECT MAX(`id`) AS `maxid` FROM `Word`";
            PreparedStatement pr = dbCon.prepareStatement(findLastIDQuery);
            long lastID = 0;
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next())
                lastID = resultSet.getLong("maxid");
            String query = "INSERT INTO `Word` (`id`,`vocab`, `meaning`) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, lastID + 1);
            preparedStatement.setString(2, wordModel.getVocab());
            preparedStatement.setString(3, wordModel.getMeaning());
            result = preparedStatement.execute();
            dbCon.close();
            return result;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static WordModel getWord(long value)
    {
        Connection dbCon = MysqlHelper.connect();
        WordModel wordModel = new WordModel();
        try
        {
            long wordCount = 0;
            String findWCQuery = "SELECT * FROM User Where id = ?";
            PreparedStatement preparedStatement = dbCon.prepareStatement(findWCQuery);
            preparedStatement.setLong(1, value);
            ResultSet res = preparedStatement.executeQuery();
            if(res.next())
            {
                wordCount = res.getLong("wordCount");
            }
            String query = "SELECT * FROM Word Where id = ?";
            preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, wordCount + 1);
            res = preparedStatement.executeQuery();
            if (res.next())
            {
                wordModel.setId(wordCount + 1);
                wordModel.setVocab(res.getString("vocab"));
                wordModel.setMeaning(res.getString("meaning"));
            }
            String updateUserQuery = "UPDATE USER SET wordCount=?";
            preparedStatement = dbCon.prepareStatement(updateUserQuery);
            preparedStatement.setLong(1, wordCount + 1);
            preparedStatement.execute();
            dbCon.close();
            return wordModel;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return wordModel;
    }

}