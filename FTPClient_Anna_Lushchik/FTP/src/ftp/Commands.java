package ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class Commands {

	public static void executeCommand(String command, FTPClient ftpClient) throws IOException {
		switch (command) {
		case "Download":
			Download.downloadFile(ftpClient);
			break;
		case "GoToDir":
			ChangeDir.changeFolder(ftpClient);
			break;
		case "GoToParentDir":
			ChangeDir.goToParentDirAndShowFiles(ftpClient);
			break;
		case "ListFiles":
			String pathToDir = "";
			ListFiles.printNames(ftpClient, pathToDir);
			break;
		default:
			break;
		}

	}
}