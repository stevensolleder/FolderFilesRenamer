import java.io.File;



class FolderFilesRenamer
{
	//Change this method implementation to your needs.
	//The variable fileToBeRenamed is the currently renamed file of the folder, so you can base the new file name on its attributes.
	//The return value is the new name of the currently renamed file of the folder.
	private static String renameFile(File fileToBeRenamed)
	{
		//This is an example implementation, where every file will get an eight random numbers long file name:
		
		String newName="";
		
		for(int i=0; i<9; i++)
		{
			newName+=Integer.toString((int) (Math.random()*9));
		}
		
		return newName;
	}
	
	

	public static void main(String[] args)
	{
		if(args.length>1 || args.length==0)
		{
			System.out.println("Please write the path to the directory as one argument.");
			System.exit(0);
		}
		
		File sourceFolder=new File(args[0]);
		
		{
			if(!sourceFolder.exists())
			{
				System.out.println("The given file does not exist.");
				System.exit(0);
			}
			
			if(!sourceFolder.isDirectory())
			{
				System.out.println("The given file is not a folder.");
				System.exit(0);
			}
		}
		
		{
			int allFiles=sourceFolder.listFiles().length;
			int renamedFiles=0;
			
			for(File file:sourceFolder.listFiles())
			{
				if(file.exists())
				{
					file.renameTo(new File(sourceFolder, renameFile(file)+"."+getFileExtension(file)));
					renamedFiles++;
				}
			}
			
			System.out.println(renamedFiles+" of "+allFiles+" files were renamed.");
		}
	}
	
	private static String getFileExtension(File fileToGetExtension)
	{
		String extension="";
		String fileName=fileToGetExtension.getName();
		
		int pointIndex = fileName.lastIndexOf('.');
		if (pointIndex >= 0)
		{
			extension = fileName.substring(pointIndex+1);
		}
		
		return extension;
	}
}