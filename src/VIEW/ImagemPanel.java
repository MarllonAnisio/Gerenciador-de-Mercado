package VIEW;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagemPanel extends JPanel{
	private BufferedImage image;
	
	public ImagemPanel(String imagePath) {
		try {
			image = ImageIO.read(new File(imagePath));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image != null) {
			g.drawImage(image, 0,0, this);
		}
	}
}
