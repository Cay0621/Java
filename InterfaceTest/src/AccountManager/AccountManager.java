package AccountManager;

public interface AccountManager {
	/*ÓÃ»§×¢²á*/
	User register(String name, String pwd, String email)
		throws UserExistException;
	
	/*µÇÂ¼*/
	User login(String name, String pwd)
		throws NameOrPwdException;
}
