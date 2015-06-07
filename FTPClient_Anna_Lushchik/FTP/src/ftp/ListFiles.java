package ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ListFiles {

	static void printNames(FTPClient ftpClient, String path) throws IOException {
		String remoteDirPath = "/" + path;
		FTPFile[] files = ftpClient.listFiles(remoteDirPath);
		for (FTPFile file : files) {
			String details = file.getName();
			if (file.isDirectory()) {
				System.out.println("Directory:  " + details);
			}
			if (file.isFile()) {
				System.out.println("File:  " + details);
			}
		}
	}
}
