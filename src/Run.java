import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Run {

	private JFrame renderedFrm;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Run window = new Run();
					window.renderedFrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Run() {
		initialize();
	}

	private void initialize() {
		renderedFrm = new JFrame();
		renderedFrm.setTitle("kaptur");
		renderedFrm.setBounds(100, 100, 266, 144);
		renderedFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		renderedFrm.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Render");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.init();
			}
		});
		btnNewButton.setBounds(63, 34, 138, 48);
		renderedFrm.getContentPane().add(btnNewButton);
	}
}
