package Park;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CarList extends JFrame implements Runnable, MouseListener{

	private JPanel contentPane;
	private JTable table;
    static DefaultTableModel model;
    static String check[][];
    public static String car;

    public static Connection getConnection() throws ClassNotFoundException, SQLException  {
        
        String url = "jdbc:mysql://localhost:3306/parking";
        String user = "root";
        String pwd = "aa9509481";	//1234
        Connection conn = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pwd);
            
        return conn;
    }

	public CarList() throws ClassNotFoundException, SQLException {
		setResizable(false);
        Connection conn = getConnection();
        String sql = "SELECT * FROM pkuser";
        ResultSet rs = null;
        Statement stmt = null;
        int count = 0;
        Object items[][] = null;
        String contents[] = new String[50];
        check = new String[5000][5];
		String header[] = {"차량 번호", "최근 이용 날짜"};
		model = new DefaultTableModel(items, header) {
			public boolean isCellEditable(int row, int column) {	//선택 가능, 수정 불가
		      //all cells false
		      return false;
		    }
		};
        
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
        	check[count][0] = rs.getString("carnum");
            contents[0] = rs.getString("carnum");
        	
        	check[count][1] = rs.getString("outtime");
        	contents[1] = rs.getString("outtime");
        	
            count++;
        	model.addRow(contents);
        }
        
        if(rs != null) 
			rs.close();
        if(stmt != null) 
			stmt.close();
        if(conn != null) 
			conn.close();
        
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setBounds(395, 434, 97, 23);
		panel.add(cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 480, 414);
		panel.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\uCC28\uB7C9 \uBAA9\uB85D");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		startEvent();
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			new CarList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 public void startEvent(){
		 table.addMouseListener(this);
	 }
	
	@Override
	public void run() {
		CarList frame;
		try {
			frame = new CarList();
			frame.setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @Override
    public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		CarManage frame;
		try {
			frame = new CarManage((table.getModel().getValueAt(row, 0)).toString());
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
