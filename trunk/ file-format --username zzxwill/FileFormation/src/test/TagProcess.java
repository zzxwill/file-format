package test;

import java.io.*;
public class TagProcess {

	/**
	 * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ��ı������ֵ����͵��ļ�
	 * 
	 * @param fileName
	 *            �ļ���
	 * @throws IOException 
	 */
	public  void readFileByChars(String fileName,String fileW) throws IOException {
		
		
		FileWriter writer = new FileWriter(fileW, true);
		
		
//		String content = "abc";
		
		File file = new File(fileName);
		Reader reader = null;
		try {
			System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
			// һ�ζ�һ���ַ�
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;

			while ((tempchar = reader.read()) != -1) {
				// ����windows�£�rn�������ַ���һ��ʱ����ʾһ�����С�
				// ������������ַ��ֿ���ʾʱ���ỻ�����С�
				// ��ˣ����ε�r����������n�����򣬽������ܶ���С�

				System.out.print((char) tempchar);

			}
			System.out.println();
			reader = new InputStreamReader(new FileInputStream(file));

			while ((tempchar = reader.read()) != -1) {
				// ����windows�£�rn�������ַ���һ��ʱ����ʾһ�����С�
				// ������������ַ��ֿ���ʾʱ���ỻ�����С�
				// ��ˣ����ε�r����������n�����򣬽������ܶ���С�
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
			System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");
			// һ�ζ�����ַ�
			char[] tempchars = new char[1];
			int charread = 0;

			/*
			 * ��ǣ��ı���ʼ�Ĳ��ӿ���
			 */
			int flag = 0;
			reader = new InputStreamReader(new FileInputStream(fileName));
			// �������ַ����ַ������У�charreadΪһ�ζ�ȡ�ַ���
			while ((charread = reader.read(tempchars)) != -1) {
				flag++;
				// ͬ�����ε�r����ʾ
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
		// System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");
		// // һ�ζ�����ַ�
		// char[] tempchars = new char[30];
		// int charread = 0;
		// reader = new InputStreamReader(new FileInputStream(fileName));
		// // �������ַ����ַ������У�charreadΪһ�ζ�ȡ�ַ���
		// while ((charread = reader.read(tempchars)) != -1) {
		// // ͬ�����ε�r����ʾ
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
