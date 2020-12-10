package dao;

public interface SignDao {
    int checkDay(String account);

    void addSign(String account, int date);
}
