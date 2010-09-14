package test;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	public  void write(String fileName, String content) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
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
