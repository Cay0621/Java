package WriterAndReader;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * BufferedWriter:缓冲输出流，高级流
 * 特点：能够以整行输出
 * @author 木石前盟Cam
 *
 */
public class BufferedWriterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		BufferedWriter bw = null;

		try {
			fos = new FileOutputStream("writer.txt");

			// BufferedWriter不支持参数为字节流的构造函数，但支持参数为Writer的子类
			bw = new BufferedWriter(new OutputStreamWriter(fos));

			bw.write("你好！");
			bw.newLine();// 换行符
			bw.write("第二行");
			bw.newLine();
			bw.write("第三行");
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)

					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
