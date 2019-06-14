package day12.contact.exception;
/*
* 姓名重复自定义异常类
* */
public class NameRepeatException extends Exception{
    public NameRepeatException(String msg) {
        super(msg);
    }
}
