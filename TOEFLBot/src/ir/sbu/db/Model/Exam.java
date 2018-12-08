package ir.sbu.db.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fkohankhaki on 5/13/18.
 */
public class Exam
{
    public static List<ExamModel> getAll(){
        Connection dbCon = MysqlHelper.connect();
        ResultSet result;
        List<ExamModel> examModels = new ArrayList<ExamModel>();
        try {
            String query = "SELECT * FROM Exam";
            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            result = preparedStatement.executeQuery(query);
            while (result.next())
            {
                examModels.add(new ExamModel(result.getLong("id"), result.getString("section"), result.getString("date"), result.getString("price")));
            }
            result.close();
            dbCon.close();
            return examModels;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return examModels;
    }
}
