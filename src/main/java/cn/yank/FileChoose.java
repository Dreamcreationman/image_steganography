package cn.yank;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;


public class FileChoose extends JFrame{
	private static final long serialVersionUID = -5957681917403551823L;
	String imageChoosePath = "res/image/4_1.bmp";
	String imageOutputPath = null;
	String str;
			//C:\\Users\\john\\Desktop\\original_5MV1_7216000155f2118f.jpg";
	JFrame jf=new JFrame("LSB Steganography");
	Container container=jf.getContentPane();
	JLabel showpic=new JLabel("Image Previewer",JLabel.CENTER);
	JLabel readTipsText=new JLabel("Path of output file: ");
	JLabel pathtip=new JLabel("Image Previewer");
	JButton headerRedundancyButton=new JButton("Header Redundancy Writer");
	JButton tailAppendButton=new JButton("Tail Append Writer");
	JButton dataCoverageButton=new JButton("Data Coverage Writer");
	JButton choose=new JButton("Choose Image");
	JButton headerRedundancyReaderButton=new JButton("Header Redundancy Reader");
	private final JLabel lblWarningThe = new JLabel("WARNING : The path of image should not contains CHINESE CHARACTERS !!!");
	private JTextField inputPath;
	private JTextField outputPath;
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
		choose.setBounds(170, 57,142,30);
		pathtip.setBounds(112, 7, 262, 45);
		showpic.setIcon(new ImageIcon("res/default.jpg"));
		showpic.setHorizontalTextPosition(JLabel.CENTER);
		showpic.setVerticalTextPosition(JLabel.BOTTOM);
		readTipsText.setBounds(501, 397, 157,30);
		
		jf.getContentPane().add(showpic);
		showpic.setBounds(43, 124, 400,430);
		
		JButton tailAppendReaderButton = new JButton("Tail Append Reader");
		tailAppendReaderButton.setBounds(736, 264, 200, 30);
		jf.getContentPane().add(tailAppendReaderButton);
		
		JButton btnDataCoverageReader = new JButton("Data Coverage Reader");
		btnDataCoverageReader.setBounds(736, 334, 200, 30);
		jf.getContentPane().add(btnDataCoverageReader);
		
		JLabel writeTipsText = new JLabel("Path of Input file: ");
		writeTipsText.setHorizontalAlignment(SwingConstants.CENTER);
		writeTipsText.setBounds(501, 32, 157, 30);
		jf.getContentPane().add(writeTipsText);
		lblWarningThe.setForeground(Color.RED);
		lblWarningThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningThe.setBounds(26, 98, 432, 15);
		
		jf.getContentPane().add(lblWarningThe);
		
		inputPath = new JTextField();
		inputPath.setEditable(false);
		inputPath.setBounds(509, 83, 409, 45);
		jf.getContentPane().add(inputPath);
		inputPath.setColumns(10);
		
		outputPath = new JTextField();
		outputPath.setEditable(false);
		outputPath.setColumns(10);
		outputPath.setBounds(509, 449, 409, 45);
		jf.getContentPane().add(outputPath);
		
		JButton chooseInputButton = new JButton("Choose Input File");
		chooseInputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechoose = new JFileChooser();
				int returnval=filechoose.showOpenDialog(null);//getContentPane());
				if(returnval==JFileChooser.APPROVE_OPTION)
				{
					File pic = filechoose.getSelectedFile();
					inputPath.setText(pic.getAbsolutePath());
				}
			}
		});
		chooseInputButton.setBounds(776, 32, 142, 30);
		jf.getContentPane().add(chooseInputButton);
		
		JButton btnChoosePath = new JButton("Choose Path");
		btnChoosePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechoose = new JFileChooser();
				filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnval=filechoose.showOpenDialog(null);//getContentPane());
				if(returnval==JFileChooser.APPROVE_OPTION)
				{
					String filePath = filechoose.getSelectedFile().getAbsolutePath();
					outputPath.setText(filePath);
				}
			}
		});
		btnChoosePath.setBounds(776, 401, 142, 30);
		jf.getContentPane().add(btnChoosePath);
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
				
			}
		});
		
		choose.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked (MouseEvent arg0)//throws Throwable
			{
				inputPath.setText(null);
				outputPath.setText(null);
				imageOutputPath = null;
				JFileChooser filechoose = new JFileChooser();
				int returnval=filechoose.showOpenDialog(null);//getContentPane());
				if(returnval==JFileChooser.APPROVE_OPTION)
				{
					File pic = filechoose.getSelectedFile();
					imageChoosePath=pic.getAbsolutePath();
					Image myimage =null;
					try{
						ImageIO.write(ImageUtils.resizeImage(imageChoosePath, ImageUtils.IMAGE_GIF, 400, 400), "BMP", new FileOutputStream("res/temp.bmp"));  
						myimage=ImageIO.read(new File("res/temp.bmp"));
					}catch(IOException ex){}
					showpic.setIcon(new ImageIcon(myimage));
					showpic.setText("Current File Path "+imageChoosePath);
			
				}
			}
		});

		dataCoverageButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if (inputPath.getText().toString().trim().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "Please specify a input file! ");
				}else{
					jiami first = new jiami();
					Date date = new Date() ;
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss") ;
					String outputImagePath = "res/target/WriterOutput_"+ dateFormat.format(date)+ ".bmp";
					imageOutputPath = outputImagePath;
					first.setname(imageChoosePath, outputImagePath);
					String data = "";
					data = getFileContent(inputPath.getText());
					str= data + "$";
					System.out.println(str);
					try {
						first.write(str);
						JOptionPane.showMessageDialog(getContentPane(), "Image steganography sucess, save target file in target_img folder");
					} catch (Throwable e1) {
						JOptionPane.showMessageDialog(getContentPane(), "Failed to open file");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnDataCoverageReader.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if (outputPath.getText().toString().trim().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "Please specify a output location! ");
				}else if(imageOutputPath == null){
					JOptionPane.showMessageDialog(getContentPane(), "Please specify a preprocessed file! ");
				}else{
					String text;
					jiemi second = new jiemi();
					try {
						text=second.gettext(imageOutputPath);
						Date date = new Date() ;
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss") ;
						String dataOuputPath = outputPath.getText() + "/"+ dateFormat.format(date) + ".txt";
						writeFile(text.substring(0, text.length()-1), dataOuputPath);
						JOptionPane.showMessageDialog(getContentPane(), "Successfully read data :" + text.substring(0, text.length()-1)+"! And Write it to"+dataOuputPath);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(getContentPane(), "An Error occurs when read data");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		headerRedundancyReaderButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked (MouseEvent arg0)//throws Throwable
			{
				
			}
			});

		}

		public String getFileContent(String path){
			StringBuilder dataContent = new StringBuilder();
			try {
				BufferedReader in = new BufferedReader(new FileReader(path));
				String str= "";
				while ((str = in.readLine()) != null) {
					dataContent.append(str);
				}
				in.close();
			} catch (FileNotFoundException e) {
				//TODO: handle exception
			} catch (IOException e1){
				System.err.println("An IO Error occurs");
			}
			return dataContent.toString();
		}

		public void writeFile(String data, String path){
			try {
				File writename = new File(path); // 相对路径，如果没有则要建立一个新的output。txt文件
				writename.createNewFile(); // 创建新文件
				BufferedWriter out = new BufferedWriter(new FileWriter(writename));
				out.write(data); // \r\n即为换行
				out.flush(); // 把缓存区内容压入文件
				out.close(); // 最后记得关闭文件
			} catch (FileNotFoundException e) {
				//TODO: handle exception
			} catch (IOException e1){}
		}
}
