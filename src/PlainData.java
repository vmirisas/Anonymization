public class PlainData {
    private String id;
    private String name;
    private String surname;
    private String phonenumber;

    public PlainData(String id, String name, String surname, String phonenumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    @Override
    public String toString() {
        return (this.getId()+ " " + this.getName() + " " + this.getSurname() + " " + this.getPhonenumber());
    }
}
