package ir.sbu.db.Model;

/**
 * Created by fkohankhaki on 5/13/18.
 */
public class IdiomQuestionModel
{
    private long id;
    private long iid;
    private String ques;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String ans;

    public IdiomQuestionModel()
    {
    }

    public IdiomQuestionModel(long id, long iid, String ques, String a1, String a2, String a3, String a4, String ans)
    {
        this.id = id;
        this.iid = iid;
        this.ques = ques;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.ans = ans;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getIid()
    {
        return iid;
    }

    public void setIid(long iid)
    {
        this.iid = iid;
    }

    public String getQues()
    {
        return ques;
    }

    public void setQues(String ques)
    {
        this.ques = ques;
    }

    public String getA1()
    {
        return a1;
    }

    public void setA1(String a1)
    {
        this.a1 = a1;
    }

    public String getA2()
    {
        return a2;
    }

    public void setA2(String a2)
    {
        this.a2 = a2;
    }

    public String getA3()
    {
        return a3;
    }

    public void setA3(String a3)
    {
        this.a3 = a3;
    }

    public String getA4()
    {
        return a4;
    }

    public void setA4(String a4)
    {
        this.a4 = a4;
    }

    public String getAns()
    {
        return ans;
    }

    public void setAns(String ans)
    {
        this.ans = ans;
    }

}
