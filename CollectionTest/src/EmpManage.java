import java.util.ArrayList;

//雇员管理
public class EmpManage {
	ArrayList empList = null;

	public EmpManage() {
		empList = new ArrayList();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public void addEmp(Emp emp) {
		empList.add(emp);// 增加员工
	}

	int findEmp(String empNo) {
		for (int i = 0; i < empList.size(); ++i) {
			Emp e = (Emp) (empList.get(i));
			if (e.getIdNo().equals(empNo)) {
				return i;
			}
		}
		return -1;
	}

	// 显示某个员工的信息
	public void showInfo(String empNo) {
		// 遍历
		int index = findEmp(empNo);
		if (index != -1) {
			Emp e = (Emp) empList.get(index);
			System.out.println("找到该员工，信息为：");
			System.out.println("员工编号：" + e.getIdNo());
			System.out.println("员工姓名：" + e.getName());
			System.out.println("员工工资：" + e.getSalary());
		} else {
			System.out.println("未找到编号为" + empNo + "的员工");
		}
	}

	// 修改员工薪资
	public void UpdateSalary(String empNo, float newSalary) {
		int index = findEmp(empNo);
		if (index != -1) {
			Emp e = (Emp) empList.get(index);
			e.setSalary(newSalary);
		} else {
			System.out.println("未找到编号为" + empNo + "的员工");
		}
	}

	// 删除员工
	public void delEmp(String empNo) {
		int index = findEmp(empNo);
		if (index != -1) {
			empList.remove(index);
		} else {
			System.out.println("未找到编号为" + empNo + "的员工");
		}
	}
}

//雇员
class Emp {
	String idNo;
	String name;
	float salary;

	public Emp(String idNo, String name, float salary) {
		super();
		this.idNo = idNo;
		this.name = name;
		this.salary = salary;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null)
			return false;
		
		if(obj == this)
			return true;
		
		if(obj instanceof Emp)
		{
			Emp e = (Emp)obj;
			return e.idNo.equals(idNo) && e.name.equals(name) && e.salary == salary;
		}
		return false;
	}

}