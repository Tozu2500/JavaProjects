package start;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements ActionListener {
	
	// Creating constants for the window size.
	private static final int WINDOW_HEIGHT = 720;
	private static final int WINDOW_WIDTH = 1080;
	
	public Main() {
		createAndShowGUI();
	}
	
	private void createAndShowGUI() {
		// Here we create and set up the window
		JFrame frame = new JFrame();
		frame.setTitle("Welcome to the bank! | Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// TODO: Create the gradient background
		JPanel panel = new JPanel();
		frame.setContentPane(panel);
		
		// Using GridBagLayout
		panel.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		
		// Create and style components here (no method)
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("Welcome to the bank - Login page!");
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
		
		JButton loginButton = new JButton();
		loginButton.setText("Login");
		loginButton.setFont(new Font("Sans-Serif", Font.TRUETYPE_FONT, 20));
		
		// Custom JLabel which adds Font2D rendering
		class CustomLabel extends JLabel {
			public CustomLabel(String text) {
				super(text);
				setFont(new Font("Arial", Font.BOLD, 32));
				setForeground(Color.white);
				setOpaque(true);
				setBackground(Color.black);
			}
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, loginButton);
				g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, loginButton);
				FontRenderContext frc = g2d.getFontRenderContext()
			}
		}
		
		frame.add(loginButton, g);
		JButton registerButton = new JButton();
		registerButton.setText("Register");
		frame.add(registerButton, g);
		JButton adminLoginbutton = new JButton();
		adminLoginbutton.setText("Admin Login");
		frame.add(adminLoginbutton, g);
		JButton exitButton = new JButton();
		exitButton.setText("Exit the application");
		frame.add(exitButton, g);
		JButton backButton = new JButton();
		backButton.setText("Previous Page");
		frame.add(backButton, g);
		JButton nextButton = new JButton();
		nextButton.setText("Next Page (Terms of Use)");
		frame.add(nextButton, g);
		
		JLabel registerLabel = new JLabel();
		registerLabel.setText("Would you like to register?");
		
		// Add actionlisteners
		loginButton.addActionListener(e -> navigateTo("LoginPage"));
		adminLoginbutton.addActionListener(e -> navigateTo("AdminLoginPage"));
		registerButton.addActionListener(e -> navigateTo("RegisterPage"));
		exitButton.addActionListener(e -> System.exit(0));
		backButton.addActionListener(e -> navigateTo("PrevPage"));
		nextButton.addActionListener(e -> navigateTo("NextPage"));
		
		// Setting the layout constraints and adding components
		g.insets = new Insets(20, 20, 20, 20);
		
		// Welcome label
		g.gridx = GridBagConstraints.RELATIVE;
		g.gridy = 0; //Specifies the cell at the top of the component's display area, where the topmost cell has grid = 0. 
		g.gridwidth = 0; //Specifies the number of cells in a row for the component's display area.  
		g.gridheight = GridBagConstraints.BOTH;
		g.gridwidth = 2;
		g.ipadx = 1;
		g.ipady = 1;
		g.anchor = GridBagConstraints.NORTH;
		g.insets = new Insets(20, 0, 50, 0);
		panel.add(welcomeLabel, g);
		
		// Login & Admin login buttons
		g.gridy = 1;
		g.gridx = 0;
		g.gridwidth = 1;
		g.anchor = GridBagConstraints.PAGE_START;
		panel.add(loginButton, g);
		g.gridx = 1;
		g.gridwidth = 1;
		g.anchor = GridBagConstraints.EAST; 
		panel.add(adminLoginbutton, g);
		
		// Register label
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 2;
		g.anchor = GridBagConstraints.CENTER;
		panel.add(registerLabel, g);
		
		// Register button
		g.gridy = 3;
		panel.add(registerButton, g);
		
		// Exit button
		g.gridy = 4;
		panel.add(exitButton, g);
		
		// Previous page button
		g.gridx = 0;
		g.gridy = 5;
		g.gridwidth = 1;
		g.anchor = GridBagConstraints.LINE_START;
		panel.add(backButton, g);
		
		// Next page button
		g.gridx = 1;
		g.anchor = GridBagConstraints.LINE_END;
		panel.add(nextButton, g);
		/*
		this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
        this.fill = fill;
        this.ipadx = ipadx;
        this.ipady = ipady;
        this.insets = insets;
        this.anchor  = anchor;
        this.weightx = weightx;
        this.weighty = weighty;
		*/
		// Display the window
		frame.setVisible(true);
		
	}
	
	private void addWelcomeLabel(JFrame frame, GridBagConstraints g) {
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("Welcome to the bank!");
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 2;
		g.insets = new Insets(20, 0, 20, 0);
		g.anchor = GridBagConstraints.CENTER;
		frame.add(welcomeLabel, g);
	}
	
	private static void navigateTo(String page) {
		// Add the navigation logic here
		System.out.println("Opening page" +page);
		
	}
	
	public static void main(String[] args) {
		// Schedule a job for the Event Dispatching Thread, EDT:
		// Create and show the application's GUI.
		SwingUtilities.invokeLater(() -> {
			new Main();
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Handle action events here
		
	}
	
	// Custom JPanel with a gradient background
	class GradientPanel extends JPanel {

		protected void paintComponent(Graphics g) {
			super.paintComponent(getGraphics());
			Graphics2D g2d = (Graphics2D) g;
			int width = getWidth();
			int height = getHeight();
			// Creating two Colors to be used in the gradient background
			Color color11 = new Color(0, 0, 170);
			Color color22 = new Color(0, 0, 220);
			GradientPaint gp = new GradientPaint(0, 0, color11, 0, height, color22);
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, width, height);
			
		}
		
	}
	
}






















