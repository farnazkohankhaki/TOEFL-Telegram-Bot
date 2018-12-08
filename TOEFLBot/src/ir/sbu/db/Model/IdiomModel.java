package ir.sbu.db.Model;

/**
 * Created by fkohankhaki on 5/13/18.
 */
public class IdiomModel
{
    private long id;
    private String sentence;
    private String meaning;

    public IdiomModel()
    {
    }

    public IdiomModel(long id, String sentence, String meaning)
    {
        this.id = id;
        this.sentence = sentence;
        this.meaning = meaning;
    }

    public IdiomModel(String sentence, String meaning)
    {
        this.sentence = sentence;
        this.meaning = meaning;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getSentence()
    {
        return sentence;
    }

    public void setSentence(String sentence)
    {
        this.sentence = sentence;
    }

    public String getMeaning()
    {
        return meaning;
    }

    public void setMeaning(String meaning)
    {
        this.meaning = meaning;
    }
}
