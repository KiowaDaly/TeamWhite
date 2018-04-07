import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class Log extends JPanel{

	
	private JTextArea textArea = new JTextArea(800, 250);
	
	public Log() {
		JScrollPane scrollPane = new JScrollPane(textArea);
//        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        textArea.setEditable(false);
        
        textArea.setFont(new Font("monospaced", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ((DefaultCaret) textArea.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
	}
	
	public void addText(String string) {
		textArea.append(string);
	}
	
}
