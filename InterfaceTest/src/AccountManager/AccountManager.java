package AccountManager;

public interface AccountManager {
	/*�û�ע��*/
	User register(String name, String pwd, String email)
		throws UserExistException;
	
	/*��¼*/
	User login(String name, String pwd)
		throws NameOrPwdException;
}
