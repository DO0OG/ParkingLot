package Park;

import com.github.sarxos.webcam.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import net.sourceforge.tess4j.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainPage extends JFrame implements Runnable{

	private static final long serialVersionUID = -585739158170333370L;

	private JPanel contentPane;
	public static JPanel cam;
	public static Webcam camPic = Webcam.getDefault();
	public static int flag = 0;
	public static Long time;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    static String car;
    static String check;
    static String timec;
    static String statc;
    static String slotc;
    static long minute;
	static int a = 1;
	static int b = 1;
	static Tesseract instance = Tesseract.getInstance();
	
	static{ 
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
	}

    public static Connection getConnection() throws ClassNotFoundException, SQLException  {
        
        String url = "jdbc:mysql://localhost:3306/parking";
        String user = "root";
        String pwd = "aa9509481";	//1234
        Connection conn = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pwd);
            
        return conn;
    }
    
    //차량 등록(입고)
    public static void insert(String car2, String slot, String pktime, String pkstate) throws ClassNotFoundException, SQLException {
        //입력하는 메소드
        Connection conn = getConnection();
        String sql = "insert into pkuser(carnum, pkslot, pktime, pkstate) values(?,?,?,?)";
        String sql2 = "insert into pklot(pklotnum, carnum, pkinfo) values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
        
        pstmt.setString(1, car2);
        pstmt.setString(2, slot);
        pstmt.setString(3, pktime);
        pstmt.setString(4, pkstate);
        
        pstmt2.setString(1, slot);
        pstmt2.setString(2, car2);
        pstmt2.setString(3, pkstate);

        int res2 = pstmt2.executeUpdate();
        int res = pstmt.executeUpdate();
        if(res > 0 & res2 > 0){
			JOptionPane.showMessageDialog(null, "차량 입고");
        }
        else JOptionPane.showMessageDialog(null, "차량 입고");
        
        if(pstmt != null) 
			pstmt.close();
        if(pstmt2 != null) 
			pstmt2.close();
        if(conn != null) 
			conn.close();
    }
    
    //차량 등록(출고)
    public static void insert2(String slot, String outtime, int pmoney, String pkstate, String car2) throws ClassNotFoundException, SQLException {
        //입력하는 메소드
        Connection conn = getConnection();
        String sql = "update pkuser set pkslot = ?, outtime = ?, pmoney = ?, pkstate = ? where carnum = " + "'" + car2 + "'";
        String sql2 = "update pklot set carnum = ?, pkinfo = ? where carnum = " + "'" + car2 + "'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        PreparedStatement pstmt2 = conn.prepareStatement(sql2);

        pstmt.setString(1, null);
        pstmt.setString(2, outtime);
        pstmt.setInt(3, pmoney);
        pstmt.setString(4, pkstate);
        
        pstmt2.setString(1, null);
        pstmt2.setString(2, pkstate);

        int res2 = pstmt2.executeUpdate();
        int res = pstmt.executeUpdate();
        if(res > 0 & res2 > 0){
			JOptionPane.showMessageDialog(null, "차량 출고");
        }
        else JOptionPane.showMessageDialog(null, "차량 출고");
        
        if(pstmt != null) 
			pstmt.close();
        if(pstmt2 != null) 
			pstmt2.close();
        if(conn != null) 
			conn.close();
    }
    
    //차량 등록(재등록)
    public static void reinsert(String slot, String pktime, String pkstate, String car2) throws ClassNotFoundException, SQLException {
        //입력하는 메소드
        Connection conn = getConnection();
        String sql = "update pkuser set pkslot = ?, pktime = ?, outtime = ?, pmoney = ?, pkstate = ? where carnum = " + "'" + car2 + "'";
        String sql2 = "update pklot set carnum = ?, pkinfo = ? where pklotnum = " + "'" + slot + "'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        PreparedStatement pstmt2 = conn.prepareStatement(sql2);


        pstmt.setString(1, slot);
        pstmt.setString(2, pktime);
        pstmt.setString(3, null);
        pstmt.setInt(4, 0);
        pstmt.setString(5, pkstate);
        
        pstmt2.setString(1, car2);
        pstmt2.setString(2, pkstate);

        int res2 = pstmt2.executeUpdate();
        int res = pstmt.executeUpdate();
        if(res > 0 & res2 > 0){
			JOptionPane.showMessageDialog(null, "차량 재입고");
        }
        else JOptionPane.showMessageDialog(null, "차량 재입고");
        
        if(pstmt != null) 
			pstmt.close();
        if(pstmt2 != null) 
			pstmt2.close();
        if(conn != null) 
			conn.close();
    } 
    
    //이미지 프로세싱 및 OCR
	public static void imageproc() throws IOException {
		try {
			//이미지 입력
		    //String inputFile = "input2.jpg";
		    BufferedImage camIn = camPic.getImage();
		    Mat test = img2Mat(camIn);
			Mat imgGray = new Mat();
		    //Mat matGray = Imgcodecs.imread(inputFile);
		    //Mat main = Imgcodecs.imread(inputFile);
		    Mat re = new Mat();
		    
		    Imgproc.resize(test, re, new Size(960, 720));
		    
		    //그레이스케일
		    Imgproc.cvtColor(re, imgGray, Imgproc.COLOR_RGB2GRAY);
		    ImageIO.write(Mat2BufferedImage(imgGray), "png", new File("output.png"));
		    
		    //그레이스케일
			/*for(int y = 0; y < test.getHeight(); y++) {
			   for(int x = 0; x < test.getWidth(); x++) {
			       Color colour = new Color(test.getRGB(x, y));
			       int Y = (int) (0.2126 * colour.getRed() + 0.7152 * colour.getGreen() + 0.0722 * colour.getBlue());
			       test.setRGB(x, y, new Color(Y, Y, Y).getRGB());
			   }
			}
			ImageIO.write(test, "png", new File("output.png"));*/
			
		    //가우시안 블러
		    Mat imgBlur = new Mat();
			//String inputFile2 = "output.png";
			Mat matBlur = imgGray;	//Imgcodecs.imread(inputFile2)
			Imgproc.GaussianBlur(matBlur, imgBlur, new Size(3,3), 100);
			ImageIO.write(Mat2BufferedImage(imgBlur), "png", new File("output2.png"));
			
			//Adaptive Thresholding
			Mat imgThr = new Mat();
			//String inputFile3 = "output2.png";
			Mat matThr = imgBlur;
			Imgproc.adaptiveThreshold(matThr, imgThr, 255.0, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY_INV, 99, 4);
			ImageIO.write(Mat2BufferedImage(imgThr), "png", new File("output3.png"));
			
			//캐내엣지
		    /*Mat imgEdge = new Mat();
			//String inputFile3 = "output2.png";
			Mat matEdge = imgBlur;	//Imgcodecs.imread(inputFile3)
			Imgproc.Canny(matEdge, imgEdge, 100, 300, 3);
			//ImageIO.write(Mat2BufferedImage(imgEdge), "png", new File("output3.png"));*/
			
			//컨투어 추출
	        //String inputFile4 = "output3.png";
			Mat matCont = imgThr;	//Imgcodecs.imread(inputFile4, CvType.CV_8UC1)
			Mat hierarchy = new Mat();
			List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
			Imgproc.findContours(matCont, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
			
			//컨투어 바탕으로 번호판 글자 특정
			for (int i=0; i<contours.size(); i++) {
				Rect rects = Imgproc.boundingRect(contours.get(i));
				//Imgproc.drawContours(main2, contours, i, new Scalar(255, 0, 0), 1);
                if(((rects.height > 100 & rects.width > 500) & (rects.height < 130 & rects.width < 800)) == true) {
                	String car;
                	Imgproc.rectangle(re, new Point(rects.x, rects.y), new Point(rects.x + rects.width, rects.y + rects.height), new Scalar(0, 255, 0, 255), 1);
        			ImageIO.write(Mat2BufferedImage(re), "png", new File("output4.png"));
                    Mat subimage = imgThr.submat(rects.y, rects.y + rects.height, rects.x + 10, (rects.x + rects.width) - 8);
                    Imgcodecs.imwrite("output5.png",subimage);
                    //System.out.println(instance.doOCR(new File("output5.png")));
                    String res = instance.doOCR(Mat2BufferedImage(subimage));
                    car = res.replaceAll(" ", "").trim();
                    System.out.println(car);
                    if(car.length() <= 8 & car.length() >= 7) {
            		    String check[] = new String[5];
            		    String timec = null;
            		    String statc[] = new String[80];
            		    String slotc[] = new String[80];
            		    String slott[] = new String[80];
            	        int count = 0;
            			int a;
            			int b;
            			long time;
                		a = 1;
                		b = 1;
                        Connection conn = getConnection();
                        String sql = "SELECT * FROM pkuser WHERE carnum = " + "'" + car + "'";
                        String sql2 = "SELECT * FROM pklot";
                        ResultSet rs = null;
                        Statement stmt = null;
                        ResultSet rs2 = null;
                        Statement stmt2 = null;
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(sql);
                        stmt2 = conn.createStatement();
                        rs2 = stmt2.executeQuery(sql2);
                        
                        while(rs.next()) {
                        	check[0] = rs.getString("carnum");
                        	timec = rs.getString("pktime");
                        	if(rs.getString("pkslot") == null) slotc[0] = null;
                        	else if(rs.getString("pkslot") != null & !rs.getString("pkslot").equals("0")) {
                            	slotc[0] = rs.getString("pkslot");
                            }
                        	if((rs.getString("pkstate") == null)) statc[0] = null;
                        	else if(rs.getString("pkstate") != null) {
                        		statc[0] = rs.getString("pkstate");
                        	}
                        }
                        while(rs2.next()) {
                        	
                        	slott[count] = rs2.getString("pklotnum");
                        	
                        	count++;
                        }
                        
                    	
                        if(rs != null) 
                			rs.close();
                        if(stmt != null) 
                			stmt.close();
                        if(rs2 != null) 
                			rs2.close();
                        if(stmt2 != null) 
                			stmt2.close();
                        if(conn != null) 
                			conn.close();
                        
            			slotc[1] = Integer.toString(a) + "F" + Integer.toString(b);
            			for(int q=0; q<slott.length; q++) {
	                		if(slotc[0] == null) {
	                			if((slotc[1].equals(slotc[0]))) b += 1;
	                			else if ((slotc[1].equals(slott[q]))) b += 1;
	                			else if (!slotc[1].equals(slott[0])) {
	                				if(statc[b] != null) {
	                					if(statc[b].equals("park_out")) b = 1;
	                					else if (statc[b].equals("park_in")) b += 1;
	                				}
	                			}
	                		}
	                		if(b == 20) {
	        					a += 1;
	        					b = 1;
	        					slotc[1] = Integer.toString(a) + "F" + Integer.toString(b);
	                		}
	                		else if(!(slotc[1].equals(slotc[0]))) {
	                			slotc[1] = Integer.toString(a) + "F" + Integer.toString(b);
	                		}
            			}
                    	
                    	//시간 추출 및 계산
                    	time = System.currentTimeMillis();
                    	int fee = 1000;
                    	String t1;
                    	String t2;
                    	String t3;
                    	long t4 = 0;
                    	//- : 제거
                    	if (timec != null) {
	                    	t1 = timec.replaceAll("-", "");
	                    	t2 = t1.replaceAll(":", "");
	                    	t3 = t2.replaceAll(" ", "");
	                    	t4 = Long.parseLong(t3);
                    	}
                    	
                		String pattern = "yyyyMMddhhmmss";
                		SimpleDateFormat fmt = new SimpleDateFormat(pattern);
                		long curr = Long.parseLong(fmt.format(time));
                		minute = (curr - t4) / 60; //출고시간 - 입고시간
                		
                		//가격 계산 : 기본 1000 + 5분당 200
                		if(minute > 10) {
                			fee = (int) (fee + (((minute - 10)/5)*200));
                		}
                		else if(minute < 10) {
                			fee = 0;
                		}
                		
                    	//System.out.println(car + " " + check[0] + " " + slotc[0] + " " + sdf.format(time) + " " + slott[0] + " " + slott[1] + " test");
                        
                        //차량 입고 & 출고 & 재입고
                        if((check[0] == null) & (statc[0] == null) & flag == 1) {
                        	System.out.println("insert");
                        	insert(car, slotc[1].toString(), sdf.format(time), "park_in");
                        	flag = 0;
                        }
                        else if((check[0] != null) & (check[0].equals(car)) & (statc[0].equals("park_in")) & flag == 1) {
                        	System.out.println("insert2");
                        	insert2(slotc[1].toString(), sdf.format(time), fee, "park_out", car);
                        	flag = 0;
                        }
                        else if((check[0] != null) & (check[0].equals(car)) & (!statc[0].equals("park_in")) & flag == 1) {
                        	System.out.println("re");
                        	reinsert(slotc[1].toString(), sdf.format(time), "park_in", car);
                        	flag = 0;
                        }
                    	//System.out.println(res);
                    }
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static BufferedImage Mat2BufferedImage(Mat matrix) throws Exception {
	    MatOfByte mob = new MatOfByte();
	    Imgcodecs.imencode(".jpg", matrix, mob);
	    byte ba[] = mob.toArray();

	    BufferedImage bi = ImageIO.read(new ByteArrayInputStream(ba));
	    return bi;
	}
	
	public static Mat img2Mat(BufferedImage image) {
		byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
		mat.put(0, 0, data);
		
		return mat;
     }
	
	public MainPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		cam = new WebcamPanel(camPic);
		cam.setBounds(0, 0, 351, 253);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(253, 55, 351, 253);
		panel_1.setLayout(null);
		panel_1.add(cam);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uCE74\uBA54\uB77C");
		lblNewLabel_1.setBounds(403, 30, 50, 15);
		panel.add(lblNewLabel_1);
		
		JButton carManage = new JButton("\uCC28\uB7C9 \uAD00\uB9AC");
		carManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==carManage) {
					CarList frame = null;
					try {
						frame = new CarList();
						frame.setTitle("주차장 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		carManage.setBounds(31, 237, 180, 71);
		panel.add(carManage);
		
		JButton lotStatus = new JButton("\uCC28\uB7C9 \uD604\uD669");
		lotStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==lotStatus) {
					CarStatus frame = null;
					try {
						frame = new CarStatus();
						frame.setTitle("차량 현황");
						frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		lotStatus.setBounds(31, 141, 180, 71);
		panel.add(lotStatus);
		
		JButton lotManage = new JButton("\uC8FC\uCC28\uC7A5 \uAD00\uB9AC");
		lotManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==lotManage) {
					PklotManage frame = null;
					try {
						frame = new PklotManage();
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		lotManage.setBounds(31, 55, 180, 71);
		panel.add(lotManage);
		
		JLabel title = new JLabel("\uBA54\uC778");
		title.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(title, BorderLayout.NORTH);

		Thread updater = new Thread(this, "updater-thread");
		updater.setDaemon(true);
		updater.start();
		
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException{
		new MainPage();
	}
	
	@Override
	public void run() {
		WebcamMotionDetector detector = new WebcamMotionDetector(camPic);
		detector.setInterval(100);
		detector.start();

		while (true) {
			if (detector.isMotion()) {
				try {
					System.out.println("Motion detected");
					imageproc();
					flag = 1;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Motion not detected");
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
