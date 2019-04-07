package cn.yank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
public class jiami   {
	
	File infilename,outfilename; //�������ܺͽ��ܵ�λ��//= new File("1.bmp");
	FileInputStream in;
	FileOutputStream out;

	jiami()
	{	
		infilename=outfilename=null;
		in=null;
		out=null;
	}

	public void setname(String a,String b)//()//= new FileInputStream(filename);
	{
		infilename = new File(a);
		outfilename=new File(b);
	}

	void write(String words) throws Throwable
	{
		char[] c = words.toCharArray();
		int i,j,k=0;
		int hehe;
		int temp=0;
		int flag=0;
		in = new FileInputStream(infilename);
		out=new FileOutputStream(outfilename);
		temp=in.read();
		while(temp!=-1)
		{
			if(flag==0&&k>=54)
			{
			
				for(j=0;j<words.length();j++)
				{
					if(c[j]=='$')
					{
						flag=1;
					}
					for(i=0;i<8;i++)
					{
						hehe=(c[j]>>(7-i)&0x01);
						temp=hehe+(temp&0xfe);
						out.write(temp);
						// int a = intemp.read();
						// System.out.print(a+" ");
						// temp=temp-a;
						temp=in.read();
						k++;
					}
				}
			}
			else
			{
				out.write(temp);
				k++;
				// temp=intemp.read();
				temp=in.read();
			}
			
		};
		System.out.println("end");
	}
}