package pojo;

public class Staff {
    private String account;
    private String name;
    private String salary;
    private int type;

    public Staff() {

    }

    public Staff(String account,String name,String salary,int type) {
        this.account = account;
        this.name = name;
        this.salary = salary;
        this.type = type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getType() {
        return type;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }
}
