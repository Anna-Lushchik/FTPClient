package ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SocketException, IOException {

		String server = "ftp.tomsk.ru";
		String user = "anonymous";
		String password = "";
		// System.out.println("Enter FTPserver, login, password");
		// Scanner input = new Scanner(System.in);
		// String server = input.nextLine();
		// String user = input.nextLine();
		// String password = input.nextLine();

		boolean successConnect = false;
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(server);
			successConnect = ftpClient.login(user, password);
			ftpClient.enterLocalPassiveMode();
			System.out.println("Connected.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (successConnect) {
			listOfCommands();
			
			Scanner input = new Scanner(System.in);
			System.out.println("Input command");
			String command = input.nextLine();
			while (!command.equals("Disconnect")) {
				Commands.executeCommand(command, ftpClient);
				System.out.println("Input command");
				command = input.nextLine();
			}
			
			try {
				ftpClient.disconnect();
				System.out.println("Disconnected.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Could not connect to the server.");
		}
	}

	private static void listOfCommands() {
		System.out.println("Available commands:\n"
				+ "  Download - download file;\n"
				+ "  GoToDir - go into directory;\n"
				+ "  GoToParentDir - go to parent directory;\n"
				+ "  ListFiles - show list files and directorys;\n"
				+ "  Disconnect.\n");

	}

}
