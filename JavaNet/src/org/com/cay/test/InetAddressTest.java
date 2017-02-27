package org.com.cay.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub

		//获取本机的InetAddress实例
		InetAddress address1 = InetAddress.getLocalHost();
		System.out.println("主机名:" + address1.getHostName());
		System.out.println("IP地址:" + address1.getHostAddress());
		
		byte[] bytes = address1.getAddress();
		System.out.println("字节数组形式的IP:" + Arrays.toString(bytes));
		System.out.println(address1);
		System.out.println("========================");
		
		//根据机器名获取InetAddress实例
		InetAddress address2 = InetAddress.getByName("Cay");
		System.out.println("主机名:" + address2.getHostName());
		System.out.println("IP地址:" + address2.getHostAddress());
		
		System.out.println("========================");
		//根据ip地址获取InetAddress实例
		InetAddress address3 = InetAddress.getByName("192.168.191.1");
		System.out.println("主机名:" + address3.getHostName());
		System.out.println("IP地址:" + address3.getHostAddress());
		
		
	}

}
