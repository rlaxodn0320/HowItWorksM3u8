package m3u8;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

public class TestProgram {
	public static void main(String[]args) {
		Dimension dim = new Dimension(400,200);
		
		JFrame frame = new JFrame("TestURL");
		frame.setLocation(200,400);
		frame.setPreferredSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JTextArea textarea = new JTextArea();
		textarea.setBounds(5,5,300,200);
		textarea.setSize(360,200);
			
		JLabel label = new JLabel("URL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//label.setText(textfield.getText());
				
				String url = textarea.getText();
				
				String m3u8url[] = url.split("/");
				for(int i=0 ; i<m3u8url.length ; i++);

				String result = "https://vod-secure.twitch.tv/"+m3u8url[3]+"/chunked/index-dvr.m3u8";
				
				label.setText(result);

				try {
					Desktop.getDesktop().browse(new URI(result));
				} catch (IOException a) {
					a.printStackTrace();
				} catch (URISyntaxException a) {
					a.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		
		frame.add(textarea, BorderLayout.CENTER);
		frame.add(label, BorderLayout.NORTH);
		frame.add(button, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
}