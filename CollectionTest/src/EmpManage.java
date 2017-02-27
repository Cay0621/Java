import java.util.ArrayList;

//��Ա����
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
		empList.add(emp);// ����Ա��
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

	// ��ʾĳ��Ա������Ϣ
	public void showInfo(String empNo) {
		// ����
		int index = findEmp(empNo);
		if (index != -1) {
			Emp e = (Emp) empList.get(index);
			System.out.println("�ҵ���Ա������ϢΪ��");
			System.out.println("Ա����ţ�" + e.getIdNo());
			System.out.println("Ա��������" + e.getName());
			System.out.println("Ա�����ʣ�" + e.getSalary());
		} else {
			System.out.println("δ�ҵ����Ϊ" + empNo + "��Ա��");
		}
	}

	// �޸�Ա��н��
	public void UpdateSalary(String empNo, float newSalary) {
		int index = findEmp(empNo);
		if (index != -1) {
			Emp e = (Emp) empList.get(index);
			e.setSalary(newSalary);
		} else {
			System.out.println("δ�ҵ����Ϊ" + empNo + "��Ա��");
		}
	}

	// ɾ��Ա��
	public void delEmp(String empNo) {
		int index = findEmp(empNo);
		if (index != -1) {
			empList.remove(index);
		} else {
			System.out.println("δ�ҵ����Ϊ" + empNo + "��Ա��");
		}
	}
}

//��Ա
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