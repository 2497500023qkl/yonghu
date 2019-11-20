package user;

public class member {
    private String username="";
    private String phone=null;

    public member(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }

    public member() {
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "用户名='" + username +
                ", 电话=" + phone ;
    }
}
