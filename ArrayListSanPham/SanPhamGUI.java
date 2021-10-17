package ArrayListSanPham;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class SanPhamGUI {
		private JFrame mainFrame;
		private JTextField txtMa;
		private JTextField txtTen;
		private JTextField txtGia;
		JLabel lblMaSP;
		JLabel lblTenSP;
		JLabel lblDonGiaSP;
		JButton btnThem;
		JButton btnTimSP;
		JButton btnXoaSP;
		JButton btnSua;
		JTextArea textAreaProdList;
		
		List<SanPham> prodList;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SanPhamGUI window = new SanPhamGUI();
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
		public SanPhamGUI() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			mainFrame = new JFrame();
			mainFrame.setBounds(100, 100, 826, 530);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.getContentPane().setLayout(null);
			
			lblMaSP = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m");
			lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblMaSP.setBounds(35, 38, 114, 36);
			mainFrame.getContentPane().add(lblMaSP);
			
			txtMa = new JTextField();
			txtMa.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtMa.setBounds(159, 38, 623, 36);
			mainFrame.getContentPane().add(txtMa);
			txtMa.setColumns(10);
			
			txtTen = new JTextField();
			txtTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtTen.setColumns(10);
			txtTen.setBounds(159, 85, 623, 36);
			mainFrame.getContentPane().add(txtTen);
			
			lblTenSP = new JLabel("T\u00EAn S\u1EA3n Ph\u1EA9m");
			lblTenSP.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTenSP.setBounds(35, 85, 114, 36);
			mainFrame.getContentPane().add(lblTenSP);
			
			txtGia = new JTextField();
			txtGia.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtGia.setColumns(10);
			txtGia.setBounds(159, 132, 623, 36);
			mainFrame.getContentPane().add(txtGia);
			
			lblDonGiaSP = new JLabel("Gi\u00E1 S\u1EA3n Ph\u1EA9m");
			lblDonGiaSP.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblDonGiaSP.setBounds(35, 132, 114, 36);
			mainFrame.getContentPane().add(lblDonGiaSP);
			
			prodList = new ArrayList<SanPham>();
			
			btnThem = new JButton("Th\u00EAm S\u1EA3n Ph\u1EA9m");
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToList(prodList);
				}
			});
			btnThem.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnThem.setBounds(35, 193, 170, 36);
			mainFrame.getContentPane().add(btnThem);
			
			btnTimSP = new JButton("T\u00ECm S\u1EA3n Ph\u1EA9m");
			btnTimSP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TimSanPham(prodList);
				}
			});
			btnTimSP.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnTimSP.setBounds(229, 193, 170, 36);
			mainFrame.getContentPane().add(btnTimSP);
			
			btnXoaSP = new JButton("X\u00F3a S\u1EA3n Ph\u1EA9m");
			btnXoaSP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					XoaSanPham(prodList);
				}
			});
			btnXoaSP.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnXoaSP.setBounds(422, 193, 170, 36);
			mainFrame.getContentPane().add(btnXoaSP);
			
			btnSua = new JButton("S\u1EEDa Th\u00F4ng Tin");
			btnSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SuaSanPham(prodList);
				}
			});
			btnSua.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnSua.setBounds(614, 193, 170, 36);
			mainFrame.getContentPane().add(btnSua);
			
			textAreaProdList = new JTextArea();
			textAreaProdList.setBorder(new LineBorder(new Color(0, 0, 0)));
			textAreaProdList.setFont(new Font("Monospaced", Font.PLAIN, 14));
			textAreaProdList.setBounds(35, 240, 747, 242);
			textAreaProdList.setText("Mã sản phẩm --- Tên sản phẩm--- Giá sản phẩm\n");
			
			mainFrame.getContentPane().add(textAreaProdList);
		}

		protected void addToList(List<SanPham> arr) {
			String id = txtMa.getText();
			String Ten = txtTen.getText();
			String Gia_text = txtGia.getText();
			
			int Gia;
			
			try {
				Gia = Integer.parseInt(Gia_text);
			} catch (Exception ex) {
				Gia = 0;
				txtGia.setText("");
			}
			
			if(!(KiemTraMaSP(id)) || (id.equals("")) || (id.contains(" ")))
				showDialog("Sai Mã Sản Phẩm!", "Error!", JOptionPane.ERROR_MESSAGE);
			else
				arr.add(new SanPham(id, Ten, Gia));
			
			HienThiDS(arr);
			
			txtMa.setText("");
			txtTen.setText("");
			txtGia.setText("");
		}

		protected void TimSanPham(List<SanPham> arr) {
			String toSearch = txtMa.getText();

			for (SanPham element : arr) {
				if (element.getMaSP().contains(toSearch)) {
					showDialog("Mã Sản Phẩm: " + element.getMaSP() + 
							"\nTên Sản Phẩm: " + element.getTenSP() + 
							"\nGiá Sản Phẩm: " + element.getDonGia(),
							"Tìm Thấy Sản Phẩm!", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}

		protected void XoaSanPham(List<SanPham> arr) {
			String toDelete = txtMa.getText();

			for (SanPham element : arr) {
				if (element.getMaSP().equals(toDelete)) {
					arr.remove(arr.indexOf(element));
					break;
				}
			}
			
			HienThiDS(arr);
		}
		
		protected void SuaSanPham(List<SanPham> arr) {
			String toEdit = txtMa.getText();

			for (SanPham element : arr) {
				if (element.getMaSP().equals(toEdit)) {
					arr.remove(arr.indexOf(element));
					addToList(arr);
					break;
				}
			}
			
			HienThiDS(arr);
		}

		private void HienThiDS(List<SanPham> arr) {
			textAreaProdList.setText("ID --- Ten --- Gia\n");

			for (SanPham element : arr) {
				textAreaProdList.append(element.getMaSP() + " --- " + element.getTenSP() + " --- " + element.getDonGia() + "\n");
			}
		}
		
		private boolean KiemTraMaSP(String id) {
			for (SanPham element : prodList) {
				if(element.getMaSP().equals(id))
					return false;
			}		
			return true;
		}
		
		private void showDialog(String msg, String title, int msgType) {
			JFrame frame = new JFrame("JDialog");
			JOptionPane.showMessageDialog(frame, msg, title, msgType);
		}
	}
