import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import com.brackeen.javagamebook.graphics.*;
import com.brackeen.javagamebook.input.*;
import com.brackeen.javagamebook.test.GameCore;


public class Physics {
	
	public static boolean collision(Sprite s1, Sprite s2){ 
		if (s1.getBounds().intersects(s2.getBounds())){
			return true;
		}	
		return false;
	}
}
