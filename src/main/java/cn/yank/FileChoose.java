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
import java.awt.Font;
import java.awt.Color;


public class FileChoose extends JFrame{
	private static final long serialVersionUID = -5957681917403551823L;
	String path = "res/image/4_1.bmp";
	String str;
			//C:\\Users\\john\\Desktop\\original_5MV1_7216000155f2118f.jpg";
	JFrame jf=new JFrame("LSB Steganography");
	Container container=jf.getContentPane();
	JLabel showpic=new JLabel("Image Previewer",JLabel.CENTER);
	JLabel readTipsText=new JLabel("Data read from image:");
	JLabel pathtip=new JLabel("Image Previewer");
	JButton headerRedundancyButton=new JButton("Header Redundancy Writer");
	JButton tailAppendButton=new JButton("Tail Append Writer");
	JButton dataCoverageButton=new JButton("Data Coverage Writer");
	JButton choose=new JButton("Choose Image");
	JButton headerRedundancyReaderButton=new JButton("Header Redundancy Reader");
	JTextField readText=new JTextField();
	private JTextField wirteText;
	private final JLabel lblWarningThe = new JLabel("WARNING : The path of image should not contains CHINESE CHARACTERS !!!");
	public static void main(String[] args) {
		
		new FileChoose();
	}
	public FileChoose()
	{
		super();
		jf.setLocationRelativeTo(null);
		container.add(showpic);
		container.add(headerRedundancyButton);
		tailAppendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		container.add(tailAppendButton);
		container.add(dataCoverageButton);
		container.add(choose);
		readText.setColumns(30);
		readText.setHorizontalAlignment(SwingConstants.LEFT);
		container.add(readText);
		container.add(headerRedundancyReaderButton);
		readTipsText.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(readTipsText);
		pathtip.setFont(new Font("SimSun", Font.BOLD, 29));
		pathtip.setHorizontalAlignment(SwingConstants.CENTER);
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
		headerRedundancyButton.setBounds(501, 194,200,30);
		tailAppendButton.setBounds(501, 264,200,30);
		dataCoverageButton.setBounds(501, 334,200,30);
		headerRedundancyReaderButton.setBounds(736, 194, 200, 30);
		choose.setBounds(180, 73,114,30);
		pathtip.setBounds(106, 20, 262, 45);
		readText.setBounds(674, 405, 262, 138);
		showpic.setIcon(new ImageIcon("res/default.jpg"));
		showpic.setHorizontalTextPosition(JLabel.CENTER);
		showpic.setVerticalTextPosition(JLabel.BOTTOM);
		readTipsText.setBounds(507, 458, 157,30);
		
		jf.getContentPane().add(showpic);
		showpic.setBounds(37, 143, 400,400);
		
		JButton tailAppendReaderButton = new JButton("Tail Append Reader");
		tailAppendReaderButton.setBounds(736, 264, 200, 30);
		jf.getContentPane().add(tailAppendReaderButton);
		
		JButton btnDataCoverageReader = new JButton("Data Coverage Reader");
		btnDataCoverageReader.setBounds(736, 334, 200, 30);
		jf.getContentPane().add(btnDataCoverageReader);
		
		JLabel writeTipsText = new JLabel("Data write into image:");
		writeTipsText.setHorizontalAlignment(SwingConstants.CENTER);
		writeTipsText.setBounds(507, 73, 157, 30);
		jf.getContentPane().add(writeTipsText);
		
		wirteText = new JTextField();
		wirteText.setColumns(30);
		wirteText.setBounds(674, 20, 262, 138);
		jf.getContentPane().add(wirteText);
		lblWarningThe.setForeground(Color.RED);
		lblWarningThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningThe.setBounds(21, 113, 432, 15);
		
		jf.getContentPane().add(lblWarningThe);
		JMenuBar menuBar=new JMenuBar();
		JMenu filemenu=new JMenu("File");
		jf.setJMenuBar(menuBar);
		menuBar.add(filemenu);
		JMenuItem open = new JMenuItem("open");
		JMenuItem exit = new JMenuItem("exit");
		filemenu.add(open);
		filemenu.add(exit);
		
		JOptionPane.showMessageDialog(getContentPane(), "If the interface is not complete, try to resize it or send feedback to me at yank.tenyond@gmail.com");

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
				str=readText.getText()+"$";
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
		headerRedundancyReaderButton.addMouseListener(new MouseAdapter()
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
