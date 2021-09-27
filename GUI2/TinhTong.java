package MinhTri;

import java.awt.*;
import java.awt.event.*;

public class TinhTong extends Frame {
	Label txtA;
	Label txtB;
	Label txtSum;
	Label lblA, lblB, lblSum;
	Button btnAdd;

	public TinhTong() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setTitle("Sum Calculator");

		lblA = new Label("A = ");
		lblB = new Label("B = ");
		lblSum = new Label("A + B = ");

		TextField txtA = new TextField();
		TextField txtB = new TextField();
		TextField txtSum = new TextField();

		txtSum.setEditable(false);

		btnAdd = new Button("A + B");

		add(lblA); add(txtA);
		add(lblB); add(txtB);
		add(lblSum); add(txtSum);
		add(btnAdd);

		lblA.setLocation(200, 80);
		lblA.setSize(20, 20);
		txtA.setLocation(200, 80);
		txtA.setSize(160, 20);

		lblB.setLocation(200, 140);
		lblB.setSize(20, 20);
		txtB.setLocation(230, 140);
		txtB.setSize(160, 20);

		btnAdd.setLocation(275, 220);
		btnAdd.setSize(80, 30);

		lblSum.setLocation(160, 300);
		lblSum.setSize(50, 20);
		txtSum.setLocation(230, 300);
		txtSum.setSize(160, 20);

		btnAdd.addActionListener(new BtnAddActionListener());

		addWindowListener(new CloseWindowListener());

		setVisible(true);
	}
	
	private void add(Button btnAdd2) {
		// TODO Auto-generated method stub
		
	}

	private void add(TextField txtA2) {
		// TODO Auto-generated method stub
		
	}

	private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setLayout(Object object) {
		// TODO Auto-generated method stub
		
	}

	private void setLocationRelativeTo(Object object) {
		// TODO Auto-generated method stub
		
	}

	private void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void add(Label lblA2) {
		// TODO Auto-generated method stub
		
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void addWindowListener(CloseWindowListener closeWindowListener) {
		// TODO Auto-generated method stub
		
	}

	class BtnAddActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String strA = txtA.getText();
			String strB = txtB.getText();

			double a, b, sum;

			try {
				a = Double.parseDouble(strA);
			} catch (Exception ex) {
				a = 0;
				txtA.setText(String.valueOf(a));
			}

			try {
				b = Double.parseDouble(strB);
			} catch (Exception ex) {
				b = 0;
				txtB.setText(String.valueOf(b));
			}

			sum = a + b;
			txtSum.setText(String.valueOf(sum));
		}

	}

	class CloseWindowListener implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

