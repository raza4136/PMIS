package pmais.razatech.objects;

public class UserObject extends ParentObject {
    private String Password;
    private String Phone;
    private int Designation;

    public UserObject(int Id, String Title, String password, String phone, int designation) {
        super(Id, Title);
        Password = password;
        Phone = phone;
        Designation = designation;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getDesignation() {
        return Designation;
    }

    public void setDesignation(int designation) {
        Designation = designation;
    }
}
