public class DirectoryNode {
String name;
DirectoryNode left;
DirectoryNode middle;
DirectoryNode right;
boolean isFile;
public DirectoryNode() {
	
}
/**
 * Constructor that takes in a name and creates a directory node with that name and where it is not a file
 * @param name Name that we want our node to be
 */
public DirectoryNode(String name) {
	this.name=name;
	isFile=false;
}

/**
 * Constructor that takes in a String name as the name we want to set it to and
 * a boolean in which we will set the isFile to.
 * 
 * @param name Name that we want our node to be
 * @param b    Whether we want our node to be a file or not
 */
public DirectoryNode(String name, boolean b) {
	this.name=name;
	isFile=b;
}
public void setIsFile(boolean b) {
	isFile=b;
}
public boolean getIsFile() {
	return isFile;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name=name;
}
public DirectoryNode getLeft() {
	return left;
}
public DirectoryNode getMiddle() {
	return middle;
}
public DirectoryNode getRight() {
	return right;
}
/**
 * 
 * @param newChild The child node that we will add to the parent node as a child
 * @throws FullDirectoryException	Throws if the directory is full.
 * @throws NotADirectoryException	Throws if the parent that we are trying to add a child to is a file.
 */
public void addChild(DirectoryNode newChild) throws FullDirectoryException,NotADirectoryException{
	if(getIsFile() ) {
		throw new NotADirectoryException("Not a directory");
	}
	else {
		if(left==null) {
			left=newChild;
		}
		else if(middle==null) {
			middle=newChild;
		}
		else if(right==null) {
			right=newChild;
		}
		else {
			throw new FullDirectoryException("Directory is full");
		}
	}
}
}
