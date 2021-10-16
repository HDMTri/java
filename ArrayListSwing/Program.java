package ArrayListSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class Program {

	private JFrame mainFrame;
	private JTextField txtName;
	JLabel lblNhapTen;
	JButton btnThemTen;
	JTextArea textDSHienThi;
	JButton btnHienThi;
	JLabel lblStatusLabel;
	JButton btnXoa;

	ArrayList<String> nameList;
	
	private JLabel lblTimTen;
	private JTextField txtToSearch;
	private JButton btnTimTen;
	private JTextArea textDSThem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("ArrayList Example");
		mainFrame.setBounds(100, 100, 805, 475);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);

		lblNhapTen = new JLabel("Nhập Tên");
		lblNhapTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNhapTen.setBounds(69, 26, 109, 25);
		mainFrame.getContentPane().add(lblNhapTen);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblStatusLabel.setText("Đang chờ nhập tên...");
				lblStatusLabel.setVisible(true);
			}
		});
		txtName.setBounds(204, 26, 396, 27);
		mainFrame.getContentPane().add(txtName);
		txtName.setColumns(10);

		nameList = new ArrayList<String>();

		btnThemTen = new JButton("Thêm Tên");
		btnThemTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnThemTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemVaoDS(nameList);
			}
		});
		btnThemTen.setBounds(610, 21, 126, 35);
		mainFrame.getContentPane().add(btnThemTen);

		textDSHienThi = new JTextArea();
		textDSHienThi.setBorder(new LineBorder(new Color(0, 0, 0)));
		textDSHienThi.setBounds(69, 213, 297, 203);
		mainFrame.getContentPane().add(textDSHienThi);

		btnHienThi = new JButton("Hiển thị Danh Sách");
		btnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HienThiDS(nameList);
			}
		});
		btnHienThi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHienThi.setBounds(124, 151, 195, 41);
		mainFrame.getContentPane().add(btnHienThi);

		lblStatusLabel = new JLabel("Status");
		lblStatusLabel.setVisible(false);
		lblStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusLabel.setForeground(Color.BLUE);
		lblStatusLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblStatusLabel.setBounds(438, 53, 162, 19);
		mainFrame.getContentPane().add(lblStatusLabel);

		btnXoa = new JButton("Xóa Danh Sách");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaDS(nameList);
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnXoa.setBounds(467, 151, 195, 41);
		mainFrame.getContentPane().add(btnXoa);

		lblTimTen = new JLabel("Tìm Tên");
		lblTimTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTimTen.setBounds(69, 99, 109, 25);
		mainFrame.getContentPane().add(lblTimTen);

		txtToSearch = new JTextField();
		txtToSearch.setColumns(10);
		txtToSearch.setBounds(204, 94, 396, 32);
		mainFrame.getContentPane().add(txtToSearch);

		btnTimTen = new JButton("Tìm Tên");
		btnTimTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimTen(nameList);
			}
		});
		btnTimTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnTimTen.setBounds(610, 94, 126, 35);
		mainFrame.getContentPane().add(btnTimTen);

		textDSThem = new JTextArea();
		textDSThem.setBorder(new LineBorder(new Color(0, 0, 0)));
		textDSThem.setBounds(413, 213, 306, 203);
		mainFrame.getContentPane().add(textDSThem);
	}

	void ThemVaoDS(ArrayList<String> arr) {
		String name = txtName.getText();

		arr.add(name);
		txtName.setText("");

		lblStatusLabel.setText("Thêm tên thành công!");
		lblStatusLabel.setVisible(true);

		textDSThem.setText("");

		for (int i = 0; i < arr.size(); i++) {
			String element = arr.get(i);

			textDSThem.append(element + "\n");
		}
	}

	void HienThiDS(ArrayList<String> arr) {
		textDSHienThi.setText("");

		// For loop iteration
		for (int i = 0; i < arr.size(); i++) {
			String element = arr.get(i);

			textDSHienThi.append(element + "\n");
		}
	}

	void XoaDS(ArrayList<String> arr) {
		textDSHienThi.setText("");
		textDSThem.setText("");
		arr.clear();
	}

	void TimTen(ArrayList<String> arr) {
		String toSearch = txtToSearch.getText();
		String nameFound = "";
		int count = 0;

		for (String element : arr) {
			if (element.contains(toSearch)) {
				nameFound += element + "\n";
				count++;
			}
		}

		if (count == 0)
			ThongBaoLoi("Tên không được tìm thấy!", "Không tìm được trong danh sách!", JOptionPane.ERROR_MESSAGE);
		else
			ThongBaoLoi(nameFound," Tìm được tên trong danh sách!", JOptionPane.INFORMATION_MESSAGE);

	}
	
	void ThongBaoLoi(String msg, String title, int msgType) {
		JFrame frame = new JFrame("JDialog");
		JOptionPane.showMessageDialog(frame, msg, title, msgType);
	}
}