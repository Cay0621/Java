import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmpManage em = new EmpManage();
		System.out.println("欢迎来到雇员管理系统");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 作出一个简易菜单
		while (true) {
			System.out.println("请选择您要进行的操作：");
			System.out.println("1、添加雇员");
			System.out.println("2、查找雇员");
			System.out.println("3、修改工资");
			System.out.println("4、删除雇员");
			System.out.println("5、退出系统");

			String operType = br.readLine();

			if (operType.equals("1")) {
				System.out.println("请输入员工编号");
				String empNo = br.readLine();
				System.out.println("请输入员工姓名");
				String name = br.readLine();
				System.out.println("请输入员工工资");
				float sal = Float.parseFloat(br.readLine());
				
				Emp e = new Emp(empNo, name, sal);
				em.addEmp(e);

			} else if (operType.equals("2")) {
				System.out.println("请输入员工编号");
				String empNo = br.readLine();
				em.showInfo(empNo);

			} else if (operType.equals("3")) {
				System.out.println("请输入员工编号");
				String empNo = br.readLine();
				System.out.println("请输入员工新工资");
				float newSal = Float.parseFloat(br.readLine());
				em.UpdateSalary(empNo, newSal);

			} else if (operType.equals("4")) {
				System.out.println("请输入员工编号");
				String empNo = br.readLine();
				em.delEmp(empNo);

			}
			else if(operType.equals("5"))
			{
				System.out.println("退出系统");
				System.exit(0);
			}
		}
		//br.close();
	}
}


