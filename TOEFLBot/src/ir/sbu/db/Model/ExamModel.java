package ir.sbu.db.Model;

/**
 * Created by fkohankhaki on 5/13/18.
 */
public class ExamModel
{
    private long id;
    private String section;
    private String date;
    private String price;

    public ExamModel()
    {
    }

    public ExamModel(long id, String section, String date, String price)
    {
        this.id = id;
        this.section = section;
        this.date = date;
        this.price = price;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }
}