package cn.yank;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class FileChoose extends JFrame{
	private static final long serialVersionUID = -5957681917403551823L;
	String path = "res/image/4_1.bmp";
	String str;
			//C:\\Users\\john\\Desktop\\original_5MV1_7216000155f2118f.jpg";
	JFrame jf=new JFrame("LSB Steganography");
	Container container=jf.getContentPane();
	JLabel showpic=new JLabel("Picture Preview",JLabel.CENTER);
	JLabel pswtip=new JLabel("Input data to write");
	JLabel pathtip=new JLabel("Current file path");
	JButton headerRedundancyButton=new JButton("Header redundancy");
	JButton tailAppendButton=new JButton("Tail append");
	JButton dataCoverageButton=new JButton("Data area coverage");
	JButton choose=new JButton("Choose Image");
	JButton undo=new JButton("read");
	JTextField text=new JTextField();
	public static void main(String[] args) {
		new FileChoose();
	}
	public FileChoose()
	{
		super();
		container.add(showpic);
		container.add(headerRedundancyButton);
		container.add(tailAppendButton);
		container.add(dataCoverageButton);
		container.add(choose);
		container.add(text);
		container.add(undo);
		container.add(pswtip);
		container.add(pathtip);
		container.setLayout(null);
		try {
			Image icon = ImageIO.read(new File("res/icon.jpg"));
			jf.setIconImage(icon);
		} catch (IOException e) {
			//TODO: handle exception
		}
		jf.setVisible(true);
		jf.setSize(1000, 628);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		headerRedundancyButton.setBounds(400, 320,200,30);
		tailAppendButton.setBounds(400, 360,200,30);
		dataCoverageButton.setBounds(400, 400,200,30);
		undo.setBounds(400, 450, 200, 30);
		choose.setBounds(400, 280,200,30);
		pathtip.setBounds(200, 60, 200, 30);
		text.setBounds(150, 320, 230, 120);
		showpic.setIcon(new ImageIcon("res/default.jpg"));
		showpic.setHorizontalTextPosition(JLabel.CENTER);
		showpic.setVerticalTextPosition(JLabel.BOTTOM);
		pswtip.setBounds(20, 400, 120,30);
		
		jf.add(showpic);
		showpic.setBounds(100, 0, 400,400);
		JMenuBar menuBar=new JMenuBar();
		JMenu filemenu=new JMenu("File");
		jf.setJMenuBar(menuBar);
		menuBar.add(filemenu);
		JMenuItem open = new JMenuItem("open");
		JMenuItem exit = new JMenuItem("exit");
		filemenu.add(open);
		filemenu.add(exit);
		
		repaint();
		exit.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	
		headerRedundancyButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked (MouseEvent arg0)//throws Throwable
			{
				jiami first = new jiami();
				first.setname(path,  "a.bmp");
				str=text.getText()+"$";
				try {
					first.write(str);
					JOptionPane.showMessageDialog(getContentPane(), "Image steganography sucess, save target file in target_img folder");
				} catch (Throwable e) {
					JOptionPane.showMessageDialog(getContentPane(), "Failed to open file");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		choose.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked (MouseEvent arg0)//throws Throwable
			{
				JFileChooser filechoose = new JFileChooser();
				int returnval=filechoose.showOpenDialog(null);//getContentPane());
				if(returnval==JFileChooser.APPROVE_OPTION)
				{
					File pic = filechoose.getSelectedFile();
					path=pic.getAbsolutePath();
					Image myimage =null;
					try{
						ImageIO.write(ImageUtils.resizeImage(path, ImageUtils.IMAGE_GIF, 400, 400), "BMP", new FileOutputStream("res/temp.bmp"));  
						myimage=ImageIO.read(new File("res/temp.bmp"));
					}catch(IOException ex){}
					showpic.setIcon(new ImageIcon(myimage));
					showpic.setText("Current File Path "+path);
			
				}
			}
		});
		undo.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked (MouseEvent arg0)//throws Throwable
			{
				String text;
				jiemi second = new jiemi();
				try {
					text=second.gettext(path);
					JOptionPane.showMessageDialog(getContentPane(), "You Have write:"+text);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(getContentPane(), "An Error occurs when read data");
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				
				
			}
			});
		}

}
