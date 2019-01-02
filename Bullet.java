import java.awt.*;
import java.awt.event.KeyEvent;

import com.brackeen.javagamebook.graphics.*;
import com.brackeen.javagamebook.input.*;
import com.brackeen.javagamebook.test.GameCore;

public class Bullet extends Sprite{	
	
	public Bullet(float veloxy, float x, float y, Animation anim){
		super(anim);
		setVelocityY(veloxy);
		setX(x);
		setY(y);
	}
	
	public void draw(Graphics g){
		g.drawImage(anim.getImage(), Math.round(getX()), Math.round(getY()), null);
	}
	
	public void update(long elapsedTime) {
		setY( getY() + ( getVelocityY() * elapsedTime ) );
	}
	
}
