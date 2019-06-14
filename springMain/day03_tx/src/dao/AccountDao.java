package dao;

public interface AccountDao {
    //转账
    public void out(String outer, Integer money);
    //收款
    public void in(String inner, Integer money);
}
