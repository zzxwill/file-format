package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFiles {

	/**
	 * 读取某个文件夹下的所有文件夹和文件
	 */
	public static boolean readfile(String filepath)
			throws FileNotFoundException, IOException {
		try {

			File file = new File(filepath);
			/*
			 * 文件
			 */
			// if (!file.isDirectory()) {
			if (file.isFile()) {
				System.out.println("文件zzxwill");
				System.out.println("path=" + file.getPath());
				System.out.println("absolutepath=" + file.getAbsolutePath());
				System.out.println("name=" + file.getName());

				/*
				 * 文件夹
				 */
			} else if (file.isDirectory()) {
				System.out.println("文件夹");
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {

					System.out.println("filelist:" + filelist[i]);
					File readfile = new File(filepath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						System.out.println("path=" + readfile.getPath());
						System.out.println("absolutepath="
								+ readfile.getAbsolutePath());
						System.out.println("name=" + readfile.getName());

					} else if (readfile.isDirectory()) {
						readfile(filepath + "\\" + filelist[i]);
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("readfile() Exception:" + e.getMessage());
		}
		return true;
	}

	/**
	 * 删除某个文件夹下的所有文件夹和文件
	 * 
	 * @param delpath
	 *            String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return boolean
	 */
	public static boolean deletefile(String delpath)
			throws FileNotFoundException, IOException {
		File file = new File(delpath);
		if (!file.isDirectory()) {
			System.out.println("1");
			file.delete();
		} else if (file.isDirectory()) {
			System.out.println("2");
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				File delfile = new File(delpath + "\\" + filelist[i]);
				if (!delfile.isDirectory()) {
					System.out.println("path=" + delfile.getPath());
					System.out.println("absolutepath="
							+ delfile.getAbsolutePath());
					System.out.println("name=" + delfile.getName());
					delfile.delete();
					System.out.println("删除文件成功");
				} else if (delfile.isDirectory()) {
					deletefile(delpath + "\\" + filelist[i]);
				}
			}
			// file.delete();

		}
		return true;
	}

	/**
	 * 读取某个文件夹下的所有文件夹和文件
	 */
	public static void fileOperate(String filepath)
			throws FileNotFoundException, IOException {

		String targetFolder="C:/_forwardBypass-2010-07-19-17209/bypassed/CrsDrop/";
		
		String sourceLanguage="tr-tr";
		String targetLanguage=sourceLanguage.split("-")[0];
		System.out.println("targetLanguage:"+targetLanguage);
		
		String targetFile;
		
		filepath +=sourceLanguage;
		File file = new File(filepath);
		System.out.println("文件夹:" + filepath);
		String[] filelist = file.list();
		
		TagProcess tag = new TagProcess();
		
		for (int i = 0; i < filelist.length; i++) {

			System.out.println("filelist[" + i + "]:" + filelist[i]);
			// File readfile = new File(filepath + "\\" + filelist[i]);
			// if (!readfile.isDirectory()) {
			// System.out.println("path=" + readfile.getPath());
			// System.out.println("absolutepath="
			// + readfile.getAbsolutePath());
			// System.out.println("name=" + readfile.getName());
			//
			// } else if (readfile.isDirectory()) {
			// readfile(filepath + "\\" + filelist[i]);
			// }

			/*
			 * 删除文件
			 */

			// String path[] = filelist[i].split(".");
			//				
			// String path4FolderDel=filepath + "\\" +path[0];
			// String path4FileDel=filepath + "\\" +path[0]+filelist[i];
			//				
			// System.out.println("path4FolderDel"+path4FolderDel);
			// System.out.println("path4FileDel"+path4FileDel);

			if(filelist[i].equals("vistartm.xml")){
				targetFile="de2f9718-9898-4e96-a44d-ee16f20a5a4f.payload";
				targetFile=targetFolder+targetLanguage+"/Windows Vista/main/d/e/de2f9718-9898-4e96-a44d-ee16f20a5a4f/"+targetFile;
				filepath+="/vistartm.xml";
				System.out.println("sourceFile:"+filepath);

				System.out.println("targetFile:"+targetFile);
			//	tag.readFileByChars(filepath, targetFile);
			}
			// String targetFile=

		}

	}

	public static void main(String[] args) {
		try {
			// readfile("C:/converted");

			// readfile("C:/converted/tr-tr");
			fileOperate("C:/converted/");
			// readfile("C:/folder1");
			// deletefile("C:/test");
			// deletefile("D:/file");
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
		System.out.println("ok");
	}

}
