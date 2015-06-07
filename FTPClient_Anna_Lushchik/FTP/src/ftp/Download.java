package ftp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;

public class Download {

	public static void downloadFile(FTPClient ftpClient) throws IOException {

		Download.createFolder();

		Scanner input = new Scanner(System.in);
		System.out.println("Input path to file on FTP");
		String pathOnFTP = input.nextLine();
		System.out.println("Input path to save");
		String pathOnMachine = input.nextLine();

		try {
			String remoteFile = pathOnFTP;
			File downloadFile = new File(pathOnMachine);
			OutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(downloadFile));
			boolean successDownload = ftpClient.retrieveFile(remoteFile,
					outputStream);
			outputStream.close();
			if (successDownload) {
				System.out.println("File has been downloaded successfully.");
			}
		} catch (IOException e) {
			System.out.println("Couldn't download file:" + e.getMessage());
		}
	}

	public static void createFolder() {
		File folder = new File("folder");
		folder.mkdir();
		folder.mkdirs();
	}
}
