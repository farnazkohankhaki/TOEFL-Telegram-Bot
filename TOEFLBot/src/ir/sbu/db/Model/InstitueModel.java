package ir.sbu.db.Model;

/**
 * Created by fkohankhaki on 5/13/18.
 */
public class InstitueModel
{
    private long id;
    private String name;
    private String phone;
    private String address;

    public InstitueModel()
    {
    }

    public InstitueModel(long id, String name, String phone, String address)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}