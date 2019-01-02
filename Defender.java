import java.awt.*;
import java.awt.event.KeyEvent;

import com.brackeen.javagamebook.graphics.*;
import com.brackeen.javagamebook.input.*;
import com.brackeen.javagamebook.test.GameCore;


public class Defender extends Sprite {

	public static final int ALIVE = 0;
	public static final int DEAD = 1;

	public static final float SPEED = .3f;

	private int floorY;
	private int state;
	public int lives = SelectFeatures.DEFENDER_LIVES;

	
		super.update(elapsedTime);	
	}
	
	public void draw(Graphics g){
			this.lives-=1;
		}
		g.drawImage(getImage(),Math.round(getX()),Math.round(getY()),null);
	}
}







