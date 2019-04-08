package cn.yank;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Decrypt {
File infilename;

public String gettext(String a) throws IOException
{
	String text="";
	int temp=0;
	int i;
	int key=0;
	char tempchar;
	File filea=new File(a);
	FileInputStream in = new FileInputStream(filea);
	in.skip(54);
	do
	{
		key=0;
		for(i=0;i<8;i++)
		{
			key=key*2;
			temp=in.read();
			temp=temp%2;
			key+=temp;
			
		}
		tempchar=(char)key;
		text=text+tempchar;
	}while(key!='$');
	in.close();
	return text;
	}

	public void getText(File outputFile, File imageFile) throws FileNotFoundException{
		FileInputStream fin = new FileInputStream(imageFile);
		FileOutputStream fout = new FileOutputStream(outputFile);
		try {
			fin.skip(6);
			for (int i = 0; i < 4; i++) {

				int temp = fin.read();
				if (temp == 0 )
					break;
				fout.write(temp);
			}
			fin.close();
			fout.close();
		} catch (IOException e) {
			//TODO: handle exception
		}
	}
}
