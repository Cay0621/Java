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
	 * 计算促销日期：到保质期之前两周的周末，为促销日
	 * @param createDay
	 * @param expMonths
	 * @return
	 */
	public static Calendar specialDay(Date createDay, int expMonths)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(createDay);
		
		//在生产日期上加上保质期的月份，计算出过期的日期
		cal.add(Calendar.MONTH, expMonths);
		
		//过期日的前两周
		cal.add(Calendar.WEEK_OF_YEAR, -2);
		
		//设置当前周的周日0
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal;
	}
}
