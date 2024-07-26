import java.util.*;

/**
 * 
 * @author Tanjim Ahammad SBU Email: tanjim.ahammad@stonybrook.edu
 *         Recitation:R03 SBU ID:114863193
 */
public class BashTerminal {

	public static void main(String[] args) {
		System.out.println("Starting bash terminal.");
		DirectoryTree bst = new DirectoryTree();
		boolean run = true;
		Scanner sk = new Scanner(System.in);
		do {
			System.out.print("[tahammad@host]: $ ");
			String line = sk.nextLine();
			String[] arguments = line.split(" ");
			switch (arguments[0]) {
			case "pwd":
				System.out.println(bst.presentWorkingDirectory());
				break;
			case "mkdir":
				try {
					bst.makeDirectory(arguments[1]);
				} catch (FullDirectoryException e) {
					System.out.println("ERROR: Present directory is full.");
				} catch (NotADirectoryException f) {
					System.out.println("ERROR: Present directory is full.");
				}
				catch (IllegalArgumentException j) {
					System.out.println("ERROR: Name is invalid");
				}
				break;
			case "ls":
				if (arguments.length == 1) {
					System.out.println(bst.listDirectory());
				} else if(arguments.length>1&&arguments[1].equalsIgnoreCase("-R")) {
					bst.printDirectoryTree();
				}
				break;
			case "cd":
				if (arguments.length > 1 && arguments[1].equals("/")) {
					bst.resetCursor();
				} else {
					try {
						bst.changeDirectory(arguments[1]);
					} catch (NotADirectoryException e) {
						System.out.println("ERROR: Cannot change directory into a file.");
					}
					catch(ArrayIndexOutOfBoundsException j) {
						
					}
				}
				break;
			case "touch":
				try {
					bst.makeFile(arguments[1]);
				} catch (FullDirectoryException e) {
					System.out.println("ERROR: Present directory is full.");
				} catch (NotADirectoryException f) {
					System.out.println("ERROR: Present directory is full.");
				} catch (IllegalArgumentException j) {
					System.out.println("ERROR: Name is invalid");
				}
				break;
			case "exit":
				run = false;
				break;
			}

		} while (run);
		System.out.println("Program terminating normally");
	}
}
