package JDBC_3.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class XMLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			is = new FileInputStream("src" + File.separator + "JDBC_3"
					+ File.separator + "xml" + File.separator + "db_info.xml");

			List<DBInfo> infos = XMLUtils.xmlToDBInfo(is);
			for (DBInfo dbInfo : infos) {
				System.out.println(dbInfo);
			}

			// ≤‚ ‘–¥
			File file = new File("out.xml");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fos = new FileOutputStream(file);
			try {
				XMLUtils.writeDBInfosToXML(fos, infos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (is != null)
					is.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
