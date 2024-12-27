package styles;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SwingCustomizationUtils {

    /**
     * Creates a custom JPanel with specified background color, opacity, and padding.
     *
     * @param backgroundColor The background color for the panel.
     * @param isOpaque        Whether the panel should be opaque.
     * @param padding         Padding inside the panel (in pixels).
     * @return A customized JPanel.
     */
	// MAKE MODERN GUI COMPONENTS
	// textField.setCaretColor(Color.CYAN); to set caret
	// Border border = BorderFactory.createLineBorder(new Color(70, 130, 180), 2);
	// textField.setBorder(border);

	
    public static JPanel createCustomPanel(Color backgroundColor, boolean isOpaque, int padding) {
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setOpaque(isOpaque);
        panel.setBorder(new EmptyBorder(padding, padding, padding, padding));
        return panel;
    }
    // Customized textfield
		public static JTextField createStyledTextField(String placeholder, Font font, Color textColor, 
		            Color backgroundColor, Color caretColor, 
		            Color borderColor, int borderThickness) {
		JTextField textField = new JTextField(placeholder);
		
		// Set the font and colors
		textField.setFont(font);
		textField.setForeground(Color.GRAY); // Placeholder color initially
		textField.setBackground(backgroundColor);
		textField.setCaretColor(caretColor);
		
		// Set custom border
		Border border = BorderFactory.createLineBorder(borderColor, borderThickness);
		textField.setBorder(border);
		
		// Center-align text
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Placeholder text logic
		textField.addFocusListener(new java.awt.event.FocusAdapter() {
		@Override
		public void focusGained(java.awt.event.FocusEvent e) {
		if (textField.getText().equals(placeholder)) {
		textField.setText("");
		textField.setForeground(textColor);
		}
		}
		
		@Override
		public void focusLost(java.awt.event.FocusEvent e) {
		if (textField.getText().isEmpty()) {
		textField.setText(placeholder);
		textField.setForeground(Color.GRAY);
		}
	}
});
		
		return textField;
		
		}

    /**
     * Creates a custom JButton with specified properties, including hover and tooltip.
     *
     * @param text             The text displayed on the button.
     * @param font             The font for the button text.
     * @param backgroundColor  The background color of the button.
     * @param foregroundColor  The foreground (text) color of the button.
     * @param hoverColor       The background color when hovered.
     * @param tooltip          Tooltip text to display on hover.
     * @return A customized JButton.
     */
    public static JButton createCustomButton(
        String text, Font font, Color backgroundColor, Color foregroundColor, Color hoverColor, String tooltip) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(backgroundColor);
        button.setForeground(foregroundColor);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(backgroundColor.darker(), 2));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setToolTipText(tooltip);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        return button;
    }

    /**
     * Creates a custom JTextField with placeholder text, caret color, and focus border.
     *
     * @param placeholderText The placeholder text to display.
     * @param font            The font for the text field.
     * @param backgroundColor The background color of the text field.
     * @param foregroundColor The text color.
     * @param caretColor      The caret (cursor) color.
     * @param focusBorder     The border color when focused.
     * @return A customized JTextField.
     */
    public static JTextField createCustomTextField(
            String placeholderText, Font font, Color backgroundColor, Color foregroundColor, Color caretColor, Color focusBorder) {
        JTextField textField = new JTextField(placeholderText);
        textField.setFont(font);
        textField.setForeground(foregroundColor);
        textField.setBackground(backgroundColor);
        textField.setCaretColor(caretColor);
        textField.setBorder(BorderFactory.createLineBorder(backgroundColor.darker(), 2));

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createLineBorder(focusBorder, 2));
                if (textField.getText().equals(placeholderText)) {
                    textField.setText("");
                    textField.setForeground(foregroundColor);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createLineBorder(backgroundColor.darker(), 2));
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholderText);
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        return textField;
    }

    /**
     * Sets margins for a component.
     *
     * @param component The Swing component to customize.
     * @param top       Top margin (in pixels).
     * @param left      Left margin (in pixels).
     * @param bottom    Bottom margin (in pixels).
     * @param right     Right margin (in pixels).
     */
    public static void setMargins(JComponent component, int top, int left, int bottom, int right) {
        component.setBorder(new EmptyBorder(top, left, bottom, right));
    }

    /**
     * Sets alignment for a JLabel.
     *
     * @param label       The JLabel to customize.
     * @param horizontal  Horizontal alignment (e.g., SwingConstants.CENTER).
     * @param vertical    Vertical alignment (e.g., SwingConstants.TOP).
     */
    public static void setAlignment(JLabel label, int horizontal, int vertical) {
        label.setHorizontalAlignment(horizontal);
        label.setVerticalAlignment(vertical);
    }

    /**
     * Creates a custom JLabel with text, font, foreground color, and alignment.
     *
     * @param text            The text to display on the label.
     * @param font            The font for the label text.
     * @param foregroundColor The color of the text.
     * @param horizontalAlign Horizontal alignment (e.g., SwingConstants.CENTER).
     * @return A customized JLabel.
     */
    public static JLabel createCustomLabel(String text, Font font, Color foregroundColor, int horizontalAlign) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(foregroundColor);
        label.setHorizontalAlignment(horizontalAlign);
        return label;
    }
    
    // Custom Styled TextField
    JTextField styledTextField = createStyledTextField(
            "Enter your text...",
            new Font("Arial", Font.BOLD, 16),
            Color.WHITE,
            new Color(50, 50, 50),
            Color.CYAN,
            new Color(70, 130, 180),
            2
    );


    // Another example with different styles
    JTextField anotherStyledTextField = createStyledTextField(
            "Another text field...",
            new Font("Serif", Font.ITALIC, 14),
            Color.BLACK,
            Color.LIGHT_GRAY,
            Color.RED,
            new Color(30, 144, 255),
            3
    );

    /**
     * Example frame to showcase the utilities.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Comprehensive Swing Customization");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.setLayout(new GridLayout(4, 1, 10, 10));
            frame.getContentPane().setBackground(Color.DARK_GRAY);

            // Custom Panel
            JPanel panel = createCustomPanel(new Color(50, 50, 50), true, 20);
            panel.add(new JLabel("Custom JPanel with Padding"));
            frame.add(panel);

            // Custom Button
            JButton button = createCustomButton(
                    "Hover Me",
                    new Font("Arial", Font.BOLD, 16),
                    new Color(30, 144, 255),
                    Color.WHITE,
                    new Color(70, 130, 180),
                    "This is a custom button"
            );
            frame.add(button);

            // Custom TextField
            JTextField textField = createCustomTextField(
                    "Enter your name...",
                    new Font("Arial", Font.PLAIN, 14),
                    new Color(40, 40, 40),
                    Color.WHITE,
                    Color.CYAN,
                    new Color(30, 144, 255)
            );
            frame.add(textField);

            // Custom Label
            JLabel label = createCustomLabel(
                    "Styled JLabel",
                    new Font("Serif", Font.ITALIC, 18),
                    Color.CYAN,
                    SwingConstants.CENTER
            );
            frame.add(label);

            frame.setVisible(true);
        });
    }
}
