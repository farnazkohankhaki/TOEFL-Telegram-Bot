package ir.sbu.db.Model;

public class WordModel
{
    private long id;
    private String vocab;
    private String meaning;

    public WordModel()
    {
    }

    public WordModel(long id, String vocab, String meaning)
    {
        this.id = id;
        this.vocab = vocab;
        this.meaning = meaning;
    }

    public WordModel(String vocab, String meaning)
    {
        this.vocab = vocab;
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

    public String getVocab()
    {
        return vocab;
    }

    public void setVocab(String vocab)
    {
        this.vocab = vocab;
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
