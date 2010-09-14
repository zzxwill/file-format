package test;

import java.io.*;
public class TagProcess {

	/**
	 * 以字符为单位读取文件，常用于读文本，数字等类型的文件
	 * 
	 * @param fileName
	 *            文件名
	 * @throws IOException 
	 */
	public  void readFileByChars(String fileName,String fileW) throws IOException {
		
		
		FileWriter writer = new FileWriter(fileW, true);
		
		
//		String content = "abc";
		
		File file = new File(fileName);
		Reader reader = null;
		try {
			System.out.println("以字符为单位读取文件内容，一次读一个字节：");
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;

			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，rn这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。

				System.out.print((char) tempchar);

			}
			System.out.println();
			reader = new InputStreamReader(new FileInputStream(file));

			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，rn这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。
//				if (((char) tempchar) != 'r') {
					System.out.print((char) tempchar);
//				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println();
			System.out.println("以字符为单位读取文件内容，一次读多个字节：");
			// 一次读多个字符
			char[] tempchars = new char[1];
			int charread = 0;

			/*
			 * 标记，文本开始的不加空行
			 */
			int flag = 0;
			reader = new InputStreamReader(new FileInputStream(fileName));
			// 读入多个字符到字符数组中，charread为一次读取字符数
			while ((charread = reader.read(tempchars)) != -1) {
				flag++;
				// 同样屏蔽掉r不显示
				// if ((charread == tempchars.length)
				// && (tempchars[0] == '<')&& (tempchars[1] != '/')) {
				// System.out.println();
				// System.out.print(tempchars);
				//					
				// }
				if ((charread == tempchars.length) && (tempchars[0] == '<')) {

					if (flag != 1) {
						System.out.println();
						/*
						 * 
						 */
						writer.write("\r\n");
						writer.close();

						writer = new FileWriter(fileW, true);

					}
					System.out.print(tempchars);
					writer.write(String.valueOf(tempchars));
					writer.close();
					writer = new FileWriter(fileW, true);

			
				}

				// else if ((charread == tempchars.length)
				// && (tempchars[0] == '>')) {
				//
				// System.out.print(tempchars);
				// System.out.println();
				//
				// }
				else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == '@') {
							continue;
						} else {
							System.out.print(tempchars[i]);
							writer.write(String.valueOf(tempchars[i]));
							writer.close();
							writer = new FileWriter(fileW, true);
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

		// try {
		// System.out.println("以字符为单位读取文件内容，一次读多个字节：");
		// // 一次读多个字符
		// char[] tempchars = new char[30];
		// int charread = 0;
		// reader = new InputStreamReader(new FileInputStream(fileName));
		// // 读入多个字符到字符数组中，charread为一次读取字符数
		// while ((charread = reader.read(tempchars)) != -1) {
		// // 同样屏蔽掉r不显示
		// if ((charread == tempchars.length)
		// && (tempchars[tempchars.length - 1] != 'r')) {
		// System.out.print(tempchars);
		// } else {
		// for (int i = 0; i < charread; i++) {
		// if (tempchars[i] == 'r') {
		// continue;
		// } else {
		// System.out.print(tempchars[i]);
		// }
		// }
		// }
		// }
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// } finally {
		// if (reader != null) {
		// try {
		// reader.close();
		// } catch (IOException e1) {
		// }
		// }
		// }
	}

	public static void main(String args[]) throws IOException {
		String fileR="C:/converted/tr-tr/vistartm.xml";
		String fileW = "C:/source/hello.txt";
		TagProcess tag = new TagProcess();

		tag.readFileByChars(fileR,fileW);
		
		
		
	}
}
