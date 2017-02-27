package JDBC_1;

public class StudentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stuName = "Cay2";
		StudentService service = new StudentService();
		service.findStudentByName(stuName);

		int age = 16;
		String sex = "1";
		//service.reg(stuName, age, sex);

		//service.findAll();
	}

}
