import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmpManage em = new EmpManage();
		System.out.println("��ӭ������Ա����ϵͳ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ����һ�����ײ˵�
		while (true) {
			System.out.println("��ѡ����Ҫ���еĲ�����");
			System.out.println("1����ӹ�Ա");
			System.out.println("2�����ҹ�Ա");
			System.out.println("3���޸Ĺ���");
			System.out.println("4��ɾ����Ա");
			System.out.println("5���˳�ϵͳ");

			String operType = br.readLine();

			if (operType.equals("1")) {
				System.out.println("������Ա�����");
				String empNo = br.readLine();
				System.out.println("������Ա������");
				String name = br.readLine();
				System.out.println("������Ա������");
				float sal = Float.parseFloat(br.readLine());
				
				Emp e = new Emp(empNo, name, sal);
				em.addEmp(e);

			} else if (operType.equals("2")) {
				System.out.println("������Ա�����");
				String empNo = br.readLine();
				em.showInfo(empNo);

			} else if (operType.equals("3")) {
				System.out.println("������Ա�����");
				String empNo = br.readLine();
				System.out.println("������Ա���¹���");
				float newSal = Float.parseFloat(br.readLine());
				em.UpdateSalary(empNo, newSal);

			} else if (operType.equals("4")) {
				System.out.println("������Ա�����");
				String empNo = br.readLine();
				em.delEmp(empNo);

			}
			else if(operType.equals("5"))
			{
				System.out.println("�˳�ϵͳ");
				System.exit(0);
			}
		}
		//br.close();
	}
}


