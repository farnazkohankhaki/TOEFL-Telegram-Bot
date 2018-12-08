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
public class Institue
{
    public static List<InstitueModel> getAll(){
        Connection dbCon = MysqlHelper.connect();
        ResultSet result;
        List<InstitueModel> institueModels = new ArrayList<InstitueModel>();
        try {
            String query = "SELECT * FROM Institue";
            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            result = preparedStatement.executeQuery(query);
            while (result.next())
            {
                institueModels.add(new InstitueModel(result.getLong("id"), result.getString("name"), result.getString("phone"), result.getString("address")));
            }
            result.close();
            dbCon.close();
            return institueModels;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return institueModels;
    }
}
