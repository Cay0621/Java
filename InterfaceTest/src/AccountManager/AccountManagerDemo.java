package AccountManager;

public class AccountManagerDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AccountManager am = new AccountManagerImpl();
		User u1 = am.register("111", "123", "111@qq.com");
		User u2 = am.register("123", "323", "121@qq.com");
		User u3 = am.register("145", "186", "118@qq.com");
		
		User u = am.login("123", "323");
		System.out.println(u);
	}

}
