import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

import com.brackeen.javagamebook.graphics.*;
import com.brackeen.javagamebook.input.*;
import com.brackeen.javagamebook.test.GameCore;

public class Barrier {	
	
	private ArrayList<Quarter> dunnno = new ArrayList<Quarter>();
	public float x;
	public float y;
	
	public Barrier(float x, float y, Animation qAnim){
		x = x;
		y = y;
		
		dunnno.add( new Quarter(x, y, qAnim) );
		dunnno.add( new Quarter(x + 50, y, qAnim) );
		dunnno.add( new Quarter(x, y + 50, qAnim) );
		dunnno.add( new Quarter(x + 50, y + 50, qAnim) );	
	}
	
	public void draw(Graphics g){
		for (int q = 0; q<dunnno.size(); q++){
			dunnno.get(q).draw(g);
		}
	}
	
	public void removeQuarter(int i){
		dunnno.remove(i);
	}
		
	
	
	public class Quarter extends Sprite {
		
		public Quarter(float x, float y, Animation anim) {
			super(anim);
			setX(x);
			setY(y);
		}
		
		public void draw(Graphics g){
			g.drawImage(anim.getImage(), Math.round(getX()), Math.round(getY()), null);
		}
		
	}	
	
}

