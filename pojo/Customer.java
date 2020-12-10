package pojo;

public class Customer {
    private String name;
    private String regdate;
    private String account;

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getRegdate() {
        return regdate;
    }
}
