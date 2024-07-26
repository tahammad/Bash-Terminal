package hw5;
/**
 * 
 * @author Tanjim Ahammad SBU Email: tanjim.ahammad@stonybrook.edu
 *  Recitation:R03 SBU ID:114863193
 */
public class DirectoryTree {
DirectoryNode root= new DirectoryNode("root");
DirectoryNode cursor;
String workingDirectory=root.getName();
public DirectoryTree() {
	cursor=root;
	
}
public void resetCursor() {
	cursor=root;
	workingDirectory=root.getName();
}
/**
 * Will check to see if there is a child node with the String name and if there is it will go to it,
 * and adds to the working directory member variable, 
 * if there isn't it will throw an error that states there is not a directory with String name.
 *  If the parent is a file, it will throw an exception. 
 * @param name The name of the child directory we are trying to go to.
 * @throws NotADirectoryException Throws if the parent node is a file.
 */
public void changeDirectory(String name) throws NotADirectoryException{
	if(cursor.getIsFile()) {
		throw new NotADirectoryException("");
	}
	else if(cursor.getLeft()!=null&&cursor.getLeft().getName().equals(name)&&!(cursor.getLeft().getIsFile())) {
		cursor=cursor.getLeft();
	}
	else if(cursor.getLeft()!=null&&cursor.getLeft().getName().equals(name)&&(cursor.getLeft().getIsFile())) {
		throw new NotADirectoryException("");
	}
	else if(cursor.getMiddle()!=null&&cursor.getMiddle().getName().equals(name)&&!(cursor.getMiddle().getIsFile())) {
		cursor=cursor.getMiddle();
	}
	else if(cursor.getMiddle()!=null&&cursor.getMiddle().getName().equals(name)&&(cursor.getMiddle().getIsFile())) {
		throw new NotADirectoryException("");
	}
	else if(cursor.getRight()!=null&&cursor.getRight().getName().equals(name)&&!(cursor.getRight().getIsFile())) {
		cursor=cursor.getRight();
	}
	else if(cursor.getRight()!=null&&cursor.getRight().getName().equals(name)&&(cursor.getRight().getIsFile())) {
		throw new NotADirectoryException("");
	}
	else if(!cursor.getName().equals(name)) {
		System.out.println("ERROR: No such directory named '"+name+"'.");
	}
	if(cursor.getName().equals(name)) {
		workingDirectory=workingDirectory+"/"+cursor.getName();}
	}
/**
 * 
 * @return A formatted String with the children of the node
 */
public String listDirectory() {
	String ld="";
	if(cursor.getLeft()!=null) {
		ld+=cursor.getLeft().getName()+" ";
	}
	if(cursor.getMiddle()!=null) {
		ld+=cursor.getMiddle().getName()+" ";
	}
	if(cursor.getRight()!=null) {
		ld+=cursor.getRight().getName()+" ";
	}
	return ld;
}
/**
 * Prints a formatted representation of the directories from the cursor
 * Uses helper method print
 */
public void printDirectoryTree() {
	print(cursor,0);
}
/**
 * Prints a formatted representation of the directories from the DirectoryNode start
 * @param start	Where we want to start printing from
 * @param numtab Used in the recursion to create the desired formatting.
 */
public void print(DirectoryNode start,int numtab) {
	if(start==null) {
		return;
	}
	for(int i=0;i<numtab;i++) {
		System.out.print('\t');
	}
	if(!start.getIsFile()) {
	System.out.println("|-"+start.getName());}
	else {
		System.out.println("-"+start.getName());
	}
	print(start.getLeft(),numtab+1);
	print(start.getMiddle(),numtab+1);
	print(start.getRight(),numtab+1);
}


/**
 * Creates a directory and adds it as a child to the cursor
 * @param name	Name of the directory we want to create
 * @throws IllegalArgumentException	If the name of the directory contains "" or /
 * @throws FullDirectoryException	Needed as we use the addChild method
 * @throws NotADirectoryException	Needed as we use the addChild method
 */
public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
	if(name.contains(" ")||name.contains("/")) {
		throw new IllegalArgumentException();
	}
	else {
	 cursor.addChild(new DirectoryNode(name));}
}
/**
 * 
 * @param name	Name of the file we want to create
 * @throws IllegalArgumentException	If the name of the directory contains "" or /
 * @throws FullDirectoryException	Needed as we use the addChild method
 * @throws NotADirectoryException	Needed as we use the addChild method
 */
public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
	if(name.contains(" ")||name.contains("/")) {
		throw new IllegalArgumentException();
	}
	else {
	 cursor.addChild(new DirectoryNode(name,true));}
}

/**
 * Uses the changeDirectory method to add to the member 
 * variable workingDirectory.
 * @return
 */
public String presentWorkingDirectory() {

	
	return workingDirectory;
	
}



}
