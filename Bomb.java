import java.awt.*;
import java.awt.event.KeyEvent;

import com.brackeen.javagamebook.graphics.*;
import com.brackeen.javagamebook.input.*;
import com.brackeen.javagamebook.test.GameCore;

public class Bomb extends Sprite{	
	
	public Bomb(float x, float y, Animation animation){
		super(animation);
		setVelocityY(.2f);
		setX(x);
		setY(y);
	}
	
	public void draw(Graphics g){
		g.drawImage(animation.getImage(), Math.round(getX()), Math.round(getY()), null);
	}
	
	public void update(long elapsedTime) {
		setY( getY() + ( getVelocityY() * elapsedTime ) );
	}
	
}
