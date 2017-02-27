package FlashGet;

import java.io.Serializable;

public class FlashGetInfo implements Serializable {
	/**
	 * �汾�ţ�����ƥ�䵱ǰ�����䱻�����л��Ķ����Ƿ���ͬ���������������б�һ�µȣ�
	 * �����л�ʱ��ObjectInputStream����ݱ������л�����İ汾
	 * 	�뵱ǰ��İ汾�Ž���ƥ���������Ƿ����л�
	 * ���Ӱ汾�ſ��ԣ����ǿ��ܴ��ڷ����л�ʧ�ܵķ���
	 * 
	 * �ؼ��֣�transient,���ڱ�transient���ε����Բ��������л������ԶԸ����Ե����л�
	 */
	private static final long serialVersionUID = 1L;
	
	private String url;		//�����ļ��ĵ�ַ
	private transient long pos;	//�Ѿ����ص��ֽ������������transient�ؼ��֣��ڷ����л���ʱ���ʹ��Ĭ��ֵ�������Ǿ�������ֵ
	private long fileSize;	//�ļ��ܴ�С
	private String fileName;//�ļ���
	
	public FlashGetInfo(String url, String fileName) {
		super();
		this.url = url;
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getPos() {
		return pos;
	}

	public void setPos(long pos) {
		this.pos = pos;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
