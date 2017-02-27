package FlashGet;

import java.io.Serializable;

public class FlashGetInfo implements Serializable {
	/**
	 * 版本号，用于匹配当前类与其被反序列化的对象是否处于同样的特征（属性列表一致等）
	 * 反序列化时，ObjectInputStream会根据被反序列化对象的版本
	 * 	与当前类的版本号进行匹配来决定是否反序列化
	 * 不加版本号可以，但是可能存在反序列化失败的风险
	 * 
	 * 关键字：transient,对于被transient修饰的属性不进行序列化，忽略对该属性的序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private String url;		//下载文件的地址
	private transient long pos;	//已经下载的字节数，如果加上transient关键字，在反序列化的时候就使用默认值，而不是具体对象的值
	private long fileSize;	//文件总大小
	private String fileName;//文件名
	
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
