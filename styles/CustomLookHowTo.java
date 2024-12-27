package styles;


import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
/*
 *    This file is mostly created for testing and using different  
 * 	  design and customization styles for all kinds of elements.
 *    The application is going to look a lot better, when it has
 * 	  the customization options. The ways to customize different
 *    components vary a little bit, so here are examples of a few.
 *    More will be added in the future.
 */
public class CustomLookHowTo /* (extends JFrame || implements WindowEvent, ActionEvent, ) */ {

    /**
     * Creates a visually styled JTextField.
     *
     * @param string     Placeholder text to display when empty.
     * @param font            Font for the text.
     * @param textColor       Color of the text.
     * @param placeholderColor Color of the placeholder text.
     * @param backgroundColor Background color of the text field.
     * @param caretColor      Color of the blinking caret.
     * @param borderColor     Color of the border.
     * @return A customized JTextField.
     */
	
    public static JTextField createVisualTextField
    (
            String string, Font font, Color textColor, Color placeholderColor,
            Color backgroundColor, Color caretColor, Color borderColor)
    {
        JTextField textField = new JTextField(string);
        textField.setFont(font);
        textField.setForeground(placeholderColor);
        textField.setBackground(backgroundColor);
        textField.setCaretColor(caretColor);
        textField.setHorizontalAlignment(SwingConstants.LEFT);

        // Border
        Border border = BorderFactory.createLineBorder(borderColor, 2);
        textField.setBorder(border);

        // Placeholder Behavior
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (textField.getText().equals(string)) {
                    textField.setText("");
                    textField.setForeground(textColor);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
            	
            	
            	
                if(textField.getText().equals(string)) {
                	textField.setText(string);
                	textField.setForeground(null);
                } 
                else {
                	
                    textField.setSelectedTextColor(placeholderColor);
                    textField.setForeground(placeholderColor);
                }
            }});
        return textField;
        }
    	

    /**
     * Creates a styled JTextArea with rounded corners.
     *
     * @param text            Initial text in the text area.
     * @param font            Font for the text.
     * @param textColor       Color of the text.
     * @param backgroundColor Background color of the text area.
     * @param borderColor     Border color of the text area.
     * @param cornerRadius    Radius for the rounded corners.
     * @return A customized JTextArea.
     */
    public static JTextArea createRoundedTextArea(
            String text, Font font, Color textColor, Color backgroundColor, Color borderColor, int cornerRadius) {
        JTextArea textArea = new JTextArea(text);
        textArea.setText("Test Text line 87");
        textArea.setFont(font);
        textArea.setForeground(textColor);
        textArea.setBackground(backgroundColor);
        
        // Creating a JLabel for displaying the caret location
        JLabel caretPositionLabel = new JLabel();
        
        caretPositionLabel.setText("Caret Position : 0");
        
        // Adding the previously created CaretListener to the JTextArea
        textArea.addCaretListener(new CaretListener() {
        	@Override
        	public void caretUpdate(CaretEvent e) {
        		// Get the current caret position
        		int caretPos = e.getMark();
        	}
        });

        // Custom Border for Rounded Corners
        textArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        textArea.setOpaque(false);

        textArea.setUI(new javax.swing.plaf.basic.BasicTextAreaUI() {
            @Override
            protected void paintSafely(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(backgroundColor);
                g2d.fillRoundRect(0, 0, textArea.getWidth(), textArea.getHeight(), cornerRadius, cornerRadius);
                super.paintSafely(g);
            }
        });

        return textArea;
    }

    /**
     * Creates a glowing JLabel.
     *
     * @param text      Text to display in the label.
     * @param font      Font for the label.
     * @param textColor Color of the text.
     * @param glowColor Color of the glow effect.
     * @return A glowing JLabel.
     */
    public static JLabel createGlowingLabel(String text, Font font, Color textColor, Color glowColor) {
        JLabel label = new JLabel(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw glow effect
                g2d.setColor(glowColor);
                for (int i = 1; i <= 6; i++) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f * (6 - i)));
                    g2d.setStroke(new BasicStroke(i * 2));
                    g2d.drawRoundRect(
                            i - 1, i - 1, getWidth() - i * 2 + 1, getHeight() - i * 2 + 1, 20, 20
                    );
                }

                // Draw text
                g2d.setColor(textColor);
                super.paintComponent(g2d);
            }
        };

        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(false);

        return label;
    }

    /**
     * Example for the advanced components.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Advanced Visual Swing Components");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 600);
            frame.setLayout(new GridLayout(4, 1, 10, 10));
            frame.getContentPane().setBackground(Color.DARK_GRAY);

            // Visual TextField
            JTextField styledTextField = createVisualTextField(
                    "Enter your text...",
                    new Font("Arial", Font.PLAIN, 16),
                    Color.WHITE, Color.GRAY, new Color(30, 30, 30),
                    Color.CYAN, Color.LIGHT_GRAY
            );
            frame.add(styledTextField);

            // Rounded TextArea
            JTextArea roundedTextArea = createRoundedTextArea(
                    "Rounded text area content...",
                    new Font("SansSerif", Font.PLAIN, 14),
                    Color.BLACK, Color.LIGHT_GRAY, Color.CYAN, 15
            );
            frame.add(roundedTextArea);

            // Glowing Label
            JLabel glowingLabel = createGlowingLabel(
                    "Glowing Label",
                    new Font("Serif", Font.BOLD, 24),
                    Color.WHITE, Color.CYAN
            );
            frame.add(glowingLabel);

            // Additional Button Example
            JButton customButton = new JButton("Click Me");
            customButton.setFont(new Font("Arial", Font.BOLD, 16));
            customButton.setBackground(Color.BLUE);
            customButton.setForeground(Color.WHITE);
            customButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            frame.add(customButton);

            frame.setVisible(true);
        });
    }
}

/*
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class ActionListenerExample {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("ActionListener Example");
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("Click me!");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button clicked!");
			}
		});
		
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                    frame,
                    "Are you sure you want to exit?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else if (confirm == JOptionPane.NO_OPTION) {
                	frame.setSize(400,300);
                	frame.setVisible(true);
                	System.out.println(frame.getContentPane());
                	System.out.println("That was the correct choice!");
                	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                	frame.setAlwaysOnTop(true);
                	frame.setForeground(new Color(128, 221, 87));
                	frame.setOpacity(1);
                	frame.setBackground(new Color(64, 64, 64));
                }
            }
        });
		System.out.println(frame.getContentPane());
		frame.getContentPane().add(btn);
		frame.setVisible(true);
	}
}
*/