package ftp;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;

public class ChangeDir {

	public static void changeFolder(FTPClient ftpClient) {
		System.out.println("Input path to directory");
		Scanner input = new Scanner(System.in);
		String path = input.nextLine();
		String remoteDirPath;
		try {
			remoteDirPath = path + "/";
			ftpClient.changeWorkingDirectory(path);
			ListFiles.printNames(ftpClient, remoteDirPath);
			System.out.println("Successfully changed working directory.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void goToParentDirAndShowFiles(FTPClient ftpClient){
		String path = "/";
		try{
			String[] parentDir = path.split("/");
			StringBuilder resultString = new StringBuilder();
			for (int i = 0; i < parentDir.length - 1; i++) {
				resultString.append(parentDir[i]).append("/");
				path = resultString.toString();
			}
			ListFiles.printNames(ftpClient, path);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
