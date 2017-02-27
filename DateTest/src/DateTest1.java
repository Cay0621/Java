import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String s = "20130621";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = sdf.parse(s);
		Calendar c = specialDay(d, 3);
		System.out.println(sdf.format(c.getTime()));
	}

	/**
	 * ����������ڣ���������֮ǰ���ܵ���ĩ��Ϊ������
	 * @param createDay
	 * @param expMonths
	 * @return
	 */
	public static Calendar specialDay(Date createDay, int expMonths)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(createDay);
		
		//�����������ϼ��ϱ����ڵ��·ݣ���������ڵ�����
		cal.add(Calendar.MONTH, expMonths);
		
		//�����յ�ǰ����
		cal.add(Calendar.WEEK_OF_YEAR, -2);
		
		//���õ�ǰ�ܵ�����0
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal;
	}
}
