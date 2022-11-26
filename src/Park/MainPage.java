package Park;

import com.github.sarxos.webcam.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import net.sourceforge.tess4j.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;


public class MainPage extends JFrame{

	private JPanel contentPane;
	
	static Tesseract instance = Tesseract.getInstance();
	
	public static String process(String filename) throws IOException {
		File inputFile = new File(filename);
		String result = "";
		try {
			result = instance.doOCR(inputFile);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	
	public static void imageproc() throws IOException {
		
		try {

			File inputFile = new File("input.jpg");
			BufferedImage image = ImageIO.read(inputFile);

			for(int y = 0; y < image.getHeight(); y++) {
			   for(int x = 0; x < image.getWidth(); x++) {
			       Color colour = new Color(image.getRGB(x, y));
			       int Y = (int) (0.2126 * colour.getRed() + 0.7152 * colour.getGreen() + 0.0722 * colour.getBlue());
			       image.setRGB(x, y, new Color(Y, Y, Y).getRGB());
			   }
			}
			ImageIO.write(image, "png", new File("output.png"));
		    Mat imgGray = new Mat();
			String inputFile2 = "output.png";
			Mat matGray = Imgcodecs.imread(inputFile2);
			Imgproc.GaussianBlur(matGray, imgGray, new Size(5,5),1);;
			ImageIO.write(Mat2BufferedImage(imgGray), "png", new File("output2.png"));

		    Mat imgEdge = new Mat();
			String inputFile3 = "output2.png";
			Mat matEdge = Imgcodecs.imread(inputFile3);
			Imgproc.Canny(matEdge, imgEdge, 30, 30*2.5, 3);
			ImageIO.write(Mat2BufferedImage(imgEdge), "png", new File("output3.png"));
			
			System.out.println(instance.doOCR(new File("output3.png")));
			
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
	
	static{ 
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
	}
	
	public static void main(String[] args) throws IOException{
		imageproc();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//process("output.png");
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel cam = new WebcamPanel(Webcam.getWebcamByName("Full HD webcam 2"));
		cam.setBounds(0, 0, 351, 253);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(253, 55, 351, 253);
		panel_1.setLayout(null);
		panel_1.add(cam);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uCE74\uBA54\uB77C");
		lblNewLabel_1.setBounds(403, 30, 50, 15);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\uCC28\uB7C9 \uAD00\uB9AC");
		btnNewButton.setBounds(31, 237, 180, 71);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC8FC\uCC28\uC7A5 \uD604\uD669");
		btnNewButton_1.setBounds(31, 141, 180, 71);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC8FC\uCC28\uC7A5 \uAD00\uB9AC");
		btnNewButton_2.setBounds(31, 55, 180, 71);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uC778");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
}
