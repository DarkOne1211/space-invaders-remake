import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import com.brackeen.javagamebook.graphics.*;
import com.brackeen.javagamebook.input.*;
import com.brackeen.javagamebook.test.GameCore;
import javax.management.relation.*;


public class Invader extends Sprite {	
	
	public Invader(float x, float y, Animation anim){
		super(anim);
		setVelocityX(SelectFeatures.INVADER_MOVE_RATE);
		setVelocityY(0);
		setX(x);
		setY(y);
	}
	
	public void draw(Graphics g){
		g.drawImage(anim.getImage(), Math.round(getX()), Math.round(getY()), null);
	}
	
	public boolean hitEdge(){
		if( getX() < 0 ){
			setX(0);
			return true;
		}
		else if( getX() + getWidth() > SpaceInvadersTest.SCREEN_WIDTH){
			setX(800-84);
			return true;
		}
		return false;
	}
	
	public void update(long elapsedTime, boolean hitEdge){
		if(hitEdge){
			//drop down and switch X velocity
			setY(getY() + SelectFeatures.INVADER_DROP_RATE * getHeight());
			setVelocityX(-1 * getVelocityX());
			//System.out.println("HIT EDGE");
			//System.out.println(getY());
		}
		super.update(elapsedTime);
	}
	
}
