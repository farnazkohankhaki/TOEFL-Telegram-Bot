package ir.sbu.db.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fkohankhaki on 5/13/18.
 */
public class Idiom
{
    public static IdiomModel getIdiom(long value)
    {
        Connection dbCon = MysqlHelper.connect();
        IdiomModel idiomModel = new IdiomModel();
        try
        {
            long idiomCount = 0;
            String findWCQuery = "SELECT * FROM User Where id = ?";
            PreparedStatement preparedStatement = dbCon.prepareStatement(findWCQuery);
            preparedStatement.setLong(1, value);
            ResultSet res = preparedStatement.executeQuery();
            if(res.next())
            {
                idiomCount = res.getLong("idiomCount");
            }
            String query = "SELECT * FROM Idiom Where id = ?";
            preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, idiomCount + 1);
            res = preparedStatement.executeQuery();
            if (res.next())
            {
                idiomModel.setId(idiomCount + 1);
                idiomModel.setSentence(res.getString("sentence"));
                idiomModel.setMeaning(res.getString("meaning"));
            }
            String updateUserQuery = "UPDATE USER SET idiomCount=?";
            preparedStatement = dbCon.prepareStatement(updateUserQuery);
            preparedStatement.setLong(1, idiomCount + 1);
            preparedStatement.execute();
            dbCon.close();
            return idiomModel;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return idiomModel;
    }

}
