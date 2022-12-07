package Park;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CarManage extends JFrame {

	private JPanel contentPane;
	private JTextField carnum;
	private JTextField outtime;
	private JTextField intime;
	private JTextField pslot;
	private JTextField money;
	private JTextField lasttime;
    public static String car;
	public static CarManage frame;

    public static Connection getConnection() throws ClassNotFoundException, SQLException  {
        
        String url = "jdbc:mysql://localhost:3306/parking";
        String user = "root";
        String pwd = "aa9509481";	//1234
        Connection conn = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pwd);
            
        return conn;
    }

    public static void update(String carnum, String pkslot, String pktime, String outtime, String pmoney, String car) throws ClassNotFoundException, SQLException {
        //수정 기능
        Connection conn = getConnection();
        
        String sql = "update pkuser set carnum = ?, pkslot = ?, pktime = ?, outtime = ?, pmoney = ?  where carnum = " + "'" + car + "'";
        String sql2 = "update pklot set pklotnum = ?, carnum = ? where carnum = " + "'" + car + "'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
        
        pstmt.setString(1, carnum);
        pstmt.setString(2, pkslot);
        pstmt.setString(3, pktime);
        pstmt.setString(4, outtime);
        pstmt.setInt(5, Integer.parseInt(pmoney));

        pstmt2.setString(1, pkslot);
        pstmt2.setString(2, carnum);
        
        int res2 = pstmt2.executeUpdate();
        int res = pstmt.executeUpdate();
        if(res > 0 & res2 > 0){
			JOptionPane.showMessageDialog(null, "Updated");
        } else {
            System.out.println("Update Failed");
		}
        
        if(pstmt != null) 
			pstmt.close();
        if(pstmt2 != null) 
			pstmt2.close();
        if(conn != null) 
			conn.close();
    }
    
	public CarManage(String car) throws ClassNotFoundException, SQLException {
		setResizable(false);
        Connection conn = getConnection();
        String sql = "SELECT * FROM pkuser WHERE carnum = " + "'" + car + "'";
        ResultSet rs = null;
        Statement stmt = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		lblNewLabel_1.setBounds(12, 32, 81, 20);
		panel.add(lblNewLabel_1);
		
		carnum = new JTextField();
		carnum.setBounds(12, 64, 134, 21);
		panel.add(carnum);
		carnum.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uC785\uCC28 \uC2DC\uAC04");
		lblNewLabel_4.setBounds(12, 287, 57, 15);
		panel.add(lblNewLabel_4);
		
		outtime = new JTextField();
		outtime.setBounds(165, 312, 134, 21);
		panel.add(outtime);
		outtime.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uCD9C\uCC28 \uC2DC\uAC04");
		lblNewLabel_5.setBounds(165, 287, 57, 15);
		panel.add(lblNewLabel_5);
		
		intime = new JTextField();
		intime.setBounds(12, 312, 134, 21);
		panel.add(intime);
		intime.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(354, 61, 210, 153);
		panel.add(panel_1);
		
		JLabel lblNewLabel_6 = new JLabel("\uC774\uBBF8\uC9C0");
		lblNewLabel_6.setBounds(438, 35, 50, 15);
		panel.add(lblNewLabel_6);
		
		JButton confirm = new JButton("\uC218\uC815");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					update(carnum.getText(), pslot.getText(), intime.getText(), outtime.getText(), money.getText(), car);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		confirm.setBounds(354, 265, 91, 23);
		panel.add(confirm);
		
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setBounds(473, 265, 91, 23);
		panel.add(cancel);
		
		JLabel lblNewLabel_7 = new JLabel("\uC2AC\uB86F");
		lblNewLabel_7.setBounds(12, 116, 50, 15);
		panel.add(lblNewLabel_7);
		
		pslot = new JTextField();
		pslot.setBounds(12, 141, 134, 21);
		panel.add(pslot);
		pslot.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\uC694\uAE08");
		lblNewLabel_8.setBounds(165, 116, 50, 15);
		panel.add(lblNewLabel_8);
		
		money = new JTextField();
		money.setBounds(165, 141, 134, 21);
		panel.add(money);
		money.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\uB9C8\uC9C0\uB9C9 \uC774\uC6A9 \uB0A0\uC9DC");
		lblNewLabel_9.setBounds(165, 35, 104, 15);
		panel.add(lblNewLabel_9);
		
		lasttime = new JTextField();
		lasttime.setBounds(165, 64, 134, 21);
		panel.add(lasttime);
		lasttime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uCC28\uB7C9 \uAD00\uB9AC");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
        
        while(rs.next()) {
    		carnum.setText(rs.getString("carnum"));
    		pslot.setText(rs.getString("pkslot"));
    		outtime.setText(rs.getString("outtime"));
    		intime.setText(rs.getString("pktime"));
    		money.setText(rs.getString("pmoney"));
    		lasttime.setText(rs.getString("outtime"));
        }
        
        if(rs != null) 
			rs.close();
        if(stmt != null) 
			stmt.close();
        if(conn != null) 
			conn.close();
	}
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CarManage(car);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
