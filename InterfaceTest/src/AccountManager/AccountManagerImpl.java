package AccountManager;

import java.util.Map;
import java.util.HashMap;

public class AccountManagerImpl implements AccountManager {

	private Map<String, User> users = new HashMap<String, User>();
	private int idx = 1;
	
	@Override
	public User register(String name, String pwd, String email)
			throws UserExistException {
		// TODO Auto-generated method stub
		User u = users.get(name);
		if(u != null)
			throw new UserExistException("已经注册过了.");
		
		User user = new User();
		user.setId(idx++);
		user.setName(name);
		user.setPwd(pwd);
		user.setEmail(email);
		
		users.put(name, user);
		return user;
	}

	@Override
	public User login(String name, String pwd) 
			throws NameOrPwdException {
		// TODO Auto-generated method stub
		
		User u = users.get(name);
		if(u == null)
			throw new NameOrPwdException("用户不存在.");
		
		if(!u.getPwd().equals(pwd))
			throw new NameOrPwdException("用户密码错误.");
			
		return u;
	}

}
