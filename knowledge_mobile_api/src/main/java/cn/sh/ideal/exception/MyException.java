package cn.sh.ideal.exception;

public class MyException extends Exception {
	
	public MyException(){
		 super();
	}
	
	//用详细信息指定一个异常
    public MyException(String message){
        super(message);
    }
}
