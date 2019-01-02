import java.util.LinkedList;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import com.brackeen.javagamebook.graphics.*;
import com.brackeen.javagamebook.input.*;
import com.brackeen.javagamebook.test.GameCore;
import java.util.Random;
import java.util.*;

public class Controller {
	
	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	private LinkedList<Bomb> bombs = new LinkedList<Bomb>();
	private ArrayList<ArrayList<Invader>> e = new ArrayList<ArrayList<Invader>>(); 
	Barrier[] barriers = new Barrier[3];
	//public Defender d;
	
	Random r = new Random();
	
	Bullet bull;
	Bomb buob;
	Invader invTem;
	private int BobVounter = 0;
	public int score = 0;
	public int lives = 0;
	
	
	public void createInvaders(){
		//Create the invaders		
		int x,y;
		x = y = 0;
		for( int cols = 0; cols < SelectFeatures.INVADER_COLUMNS; cols++) {
			e.add(new ArrayList<Invader>());
			y = 0;
			for( int rows = 0; rows < SelectFeatures.INVADER_ROWS; rows++) {
				Image invaderImg = loadImage("images/invader.png");
				Animation invaderAnim = new Animation();
				invaderAnim.addFrame(invaderImg, 750);
				e.get(cols).add(new Invader(x,y,invaderAnim));
				y += e.get(0).get(0).getHeight();
				//System.out.println("INVADER CREATED");
			}
			x += e.get(0).get(0).getWidth();
		}
	}
	
	
	public void update(long elapsedTime, Defender defender){
		//TODO: CREATE BOMB IF THE RATE IS MET
		BobVounter++;
		int col = r.nextInt(e.size());
		if (BobVounter % (500/SelectFeatures.INVADER_FIRE_RATE) == 0 && e.get(col).size() != 0){
			System.out.println("" + SelectFeatures.INVADER_FIRE_RATE);
			Image bombImg = loadImage("images/bomb.png");
			Animation bombAnim = new Animation();
			bombAnim.addFrame(bombImg, 750);
			invTem = e.get(col).get(e.get(col).size()-1);
			bombs.add(new Bomb(invTem.getX() + 40,invTem.getY() + 60,bombAnim));
			
			new Thread(new SimpleSoundPlayer("bomb.wav")).start();
		}
		
		//If bombs hit bottom of screen delete them
		//Otherwise update bomb
		for(int i = 0; i < bombs.size(); i++){
			buob = bombs.get(i);
			
			if(buob.getY() > SpaceInvadersTest.SCREEN_HEIGHT){
				removeBomb(buob);
				//System.out.println("Bomb Removed");
			}
			else{
				buob.update(elapsedTime);
			}
		}
		
		
		//If bullets hit top of screen delete them
		//Otherwise update bullet
		for(int i = 0; i < b.size(); i++){
			bull = b.get(i);
			
			if(bull.getY() < 0){
				removeBullet(bull);
			}
			else{
				bull.update(elapsedTime);
			}		
		}

	}
	
	public void draw(Graphics g){
		//draw bullets
		for(int i = 0; i < b.size(); i++){
			bull = b.get(i);
			
			bull.draw(g);
		}
		
		//draw barriers
		barriers[0].draw(g);
		barriers[1].draw(g);
		barriers[2].draw(g);
		
		//draw invaders
		for(int r = 0; r < e.size(); r++){
			for(int c = 0; c < e.get(r).size(); c++){
				e.get(r).get(c).draw(g);
				//System.out.println(r + " " + c);
			}
		}
		
		//draw bullets
		for(int i = 0; i < bombs.size(); i++){
			buob = bombs.get(i);
			
			buob.draw(g);
		}
		
		//draw score and lives
		g.setColor(Color.white);
		g.drawString("SCORE: "+score,10,30);
		
	}
	
	public void addBullet(Bullet block){
		b.add(block);
	}
	
	public void removeBullet(Bullet block){
		b.remove(block);
	}
	
	public Image loadImage(String fileName) {
		return new ImageIcon(fileName).getImage();
	}
	
	public void addBomb(Bomb block){
		bombs.add(block);
	}
		
	public void removeBomb(Bomb block){
		bombs.remove(block);
	}
	
	public int defenderHit(Defender d){
		for (int i = 0; i < bombs.size(); i++){
			if (Physics.collision(d,bombs.get(i))){
				removeBomb(bombs.get(i));
				return --d.lives;
			}

		}
		return d.lives; //TODO: HOW DOES INVADER HIT AND THEN RESET??
	}
	
}





