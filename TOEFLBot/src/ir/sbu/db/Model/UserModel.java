package ir.sbu.db.Model;

public class UserModel
{
    private long id;
    private String aliasName;
    private String state;
    private String email;
    private long wordCount;
    private long idiomCount;

    public UserModel()
    {
    }

    public UserModel(long id, String aliasName, String state, String email, long wordCount, long idiomCount)
    {
        this.id = id;
        this.aliasName = aliasName;
        this.state = state;
        this.email = email;
        this.wordCount = wordCount;
        this.idiomCount = idiomCount;
    }

    public UserModel(String aliasName, String state, String email, long wordCount, long idiomCount)
    {
        this.aliasName = aliasName;
        this.state = state;
        this.email = email;
        this.wordCount = wordCount;
        this.idiomCount = idiomCount;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getAliasName()
    {
        return aliasName;
    }

    public void setAliasName(String aliasName)
    {
        this.aliasName = aliasName;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public long getWordCount()
    {
        return wordCount;
    }

    public void setWordCount(long wordCount)
    {
        this.wordCount = wordCount;
    }

    public long getIdiomCount()
    {
        return idiomCount;
    }

    public void setIdiomCount(long idiomCount)
    {
        this.idiomCount = idiomCount;
    }
}