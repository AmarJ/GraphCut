import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Run {
	
	private JFrame renderedFrm;

	public static void main(String[] args) {
		try {
		       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    }catch(Exception ex) {
		        ex.printStackTrace();
		}
		
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
		renderedFrm.setTitle("Kaptur - Amar Jasarbasic");
		renderedFrm.setBounds(0, 0, 400, 340);
		ImageIcon img = new ImageIcon("Kaptur.png");
		renderedFrm.setIconImage(img.getImage());
		renderedFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		renderedFrm.getContentPane().setLayout(null);
		renderedFrm.setLocationRelativeTo(null);
		renderedFrm.setResizable(false);
		
		String[] colors = {"black", "white", "red", "blue", "green", "yellow", "gray", "cyan"};
		
		JLabel shadePick = new JLabel("Pick shade:");
		
		JSlider shadeSlider = new JSlider(JSlider.HORIZONTAL,0,255,190);
		JLabel shadeValue = new JLabel(Integer.toString(shadeSlider.getValue()));
		shadeSlider.setMajorTickSpacing(10);
		shadeSlider.setPaintTicks(true);
		
		shadeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				Window.changeShade(shadeSlider.getValue());
				shadeValue.setText(Integer.toString(shadeSlider.getValue()));
			}
		});
		
		JLabel backGroundLabel = new JLabel("Background:");
		
		JComboBox backGround = new JComboBox();
		backGround.addItem(colors[1]);
		backGround.addItem(colors[0]);
		for (int i=2;i<colors.length;i++){
			backGround.addItem(colors[i]);
			backGround.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window.changeBGColor(backGround.getSelectedItem().toString());
				}
			});
		}
		
		JLabel foreGroundLabel = new JLabel("Foreground:");
		
		JComboBox foreGround = new JComboBox();
		for (int i=0;i<colors.length;i++){
			foreGround.addItem(colors[i]);
			foreGround.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window.changeImgColor(foreGround.getSelectedItem().toString());
				}
			});
		}
		JLabel fileLocationPreview = new JLabel("");
		JButton fileFind = new JButton("Choose Image");
		fileFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog file = new FileDialog(renderedFrm, "Choose", FileDialog.LOAD);
				file.setVisible(true);
				fileLocationPreview.setText("Image file selected: "+file.getFile());
				Window.changeImage(file.getFile());
				Window.changeFileLocation(file.getDirectory() + file.getFile());
			}	
		});
		
		JButton btnNewButton = new JButton("Render");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.init();
			}
		});
		
		shadePick.setBounds(55, 15, 100, 10);
		shadeValue.setBounds(125, 15, 50, 10);
		shadeSlider.setBounds(50, 30, 300, 50);
		backGroundLabel.setBounds(55, 95, 150, 15);
		backGround.setBounds(55, 120, 125, 20);
		foreGround.setBounds(220, 120, 125, 20);
		foreGroundLabel.setBounds(220, 95, 90, 15);
		fileLocationPreview.setBounds(50, 155, 300, 15);
		fileFind.setBounds(50, 175, 300, 50);
		btnNewButton.setBounds(50, 240, 300, 50);
		
		renderedFrm.getContentPane().add(shadePick);
		renderedFrm.getContentPane().add(shadeValue);
		renderedFrm.getContentPane().add(shadeSlider);
		renderedFrm.getContentPane().add(backGroundLabel);
		renderedFrm.getContentPane().add(backGround);
		renderedFrm.getContentPane().add(foreGround);
		renderedFrm.getContentPane().add(foreGroundLabel);
		renderedFrm.getContentPane().add(fileLocationPreview);
		renderedFrm.getContentPane().add(fileFind);
		renderedFrm.getContentPane().add(btnNewButton);
	}
	
	
}
