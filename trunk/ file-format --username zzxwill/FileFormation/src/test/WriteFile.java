package test;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	public  void write(String fileName, String content) {
		try {
			// ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws IOException{
		String fileName = "C:/source/hello.txt";
		String content = "\r\nfffffffffffffffffffffffffff";
		WriteFile w=new WriteFile();
		w.write(fileName, content);
	}

}
