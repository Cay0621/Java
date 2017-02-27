import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long now = System.currentTimeMillis();
		
		int year = (int)(now / 1000 / 60 / 60 / 24 / 365) + 1970;
		System.out.println(year);
		
		Date date = new Date(now);
		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		System.out.println(year);
		System.out.println(month + 1);
		System.out.println(day);
		System.out.println(hour);
		
		
		Date date1 = new Date();
		System.out.println(date1);
		
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = fmt.format(date1);
		System.out.println(str);
		
		
		String s = "2013-06-21";
		Date dt = new Date(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			 dt = sdf.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dt);
		
		//把日期转换为yyyy-MM-dd的格式
		System.out.println(sdf.format(dt));
		
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(fmt2.format(dt));
		
		Date nowDate = new Date();
		DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
		System.out.println(df.format(nowDate));
		
	}

}
