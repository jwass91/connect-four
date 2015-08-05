package connectfour;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;


public class ConnectFour extends PApplet {
	
	PImage photo, photo2;
	PFont word, myFont;
	public int cy = 160;
	public float cw = 640 / 7;
	public int height = 480;
	public int[][] arr = new int[7][6];
	public ArrayList<Integer> elements = new ArrayList<>();
//	public int[][] arr_win = new int[7][6];
	public int current_player = 1;
	public int current_col = 0;
	public int current_i = 0;
	public int current_pla = 0;
	public boolean winner = false;
	public int current = 0;
	public String color = "na";
	public int color2 = 0;
	public int rscore = 0;
	public int yscore = 0;
	public boolean falling = false;
	public boolean tie = false;
	public int turn_count = 0;
	public int x = 0;
	public int y = 0;
	public float regy = 160;
	public int color_of = 0;
	public String dir_of_win = "na";
	
	public void setup() {
		size(1280, 700);
		  // Uncomment the following two lines to see the available fonts 
		  //String[] fontList = PFont.list();
		  ////println(fontList);
		  myFont = createFont("Georgia", 32);
		  textFont(myFont);
		  textAlign(CENTER, CENTER);
		  text("!@#$%", width/2, height/2);
		photo = loadImage("Connect4Board.png");
		photo2 = loadImage("connect-4-logo.png");
//		word = loadFont("Ozone.ttf");
		imageMode(CENTER);
		rectMode(CENTER);
		ellipseMode(CENTER);
//		textMode(CENTER);
		frameRate(60);
		for(int g = 0;g < 7;g++){
			for(int p = 0;p < 6;p++){
				arr[g][p] = 0;
			}	
		}
		
	}

	public void draw() {
		
		if(winner == false){
			background	(192);
		}
		
		if(winner == true){
			flash(current);
		}
		
		
		if(tie == true){
			flash_tie();
		}
		
		if(current_player == 2){
			color_of = 0;
		}
		else if(current_player == 1){
			color_of = 237;
		}
		

		
		
//		drop(current_col, current_i, current_pla);
		
		who_is_playing(current_player);
//		if(winner) {
//		for(int z = 0; z < elements.size(); z+=4){
//			line(elements.get(z),elements.get(z+1),elements.get(z+2),elements.get(z+3));
//		}
//		}
			
		
		for(int z = 0;z < 7;z++){
			for(int j = 0; j < 6;j++){
			if(arr[z][j] == 1){
				fill(255,0,0);
				int x = 371 + (z*76) + (14*z);
				float y = 600 - (j*76) - (4*j);
//				float regy = 160;
				ellipse(x, y, 74, 74);
//				regy = lerp(regy,y,.2f);
			}
			else if(arr[z][j] == 2){
				fill(255,237,0);
				int x = 371 + (z*76) + (14*z);
				float y = 600 - (j*76) - (4*j);
//				float regy = 160;
				ellipse(x, y, 74, 74);	
//				regy = lerp(regy,y,.2f);
			}
		}
		}
		
		if(falling != true){
			fill(192);
			int x = 371 + (current_col*76) + (current_col*14);
			float y = 600 - (current_i*76) - (4*current_i);
//			float regy = 160;
			ellipse(x, y, 74, 74);
//			regy = lerp(regy,y,.2f);
	}
		
		regy = lerp(regy,y,.2f);
		falling = true;
		if(y - regy > 0.1f) {
		fill(255,color_of,0);
		strokeWeight(0);
		ellipse(x, regy, 74, 74);
		falling = false;
		//println(falling);
		}
		
		
		image(photo, 640, 400);
		image(photo2, 640, 70);
//		fill(255,0,0);
//		textFont(myFont, 45);
//		text("Yellow:", 640, 70);
		fill(255,255,255);
		rect(160,640,250,65);
		fill(0,0,0);
		textFont(myFont, 35);
		text("Restart", 160, 640);
		fill(255,255,255);
		rect(200,70,300,100);
		fill(255,0,0);
		textFont(myFont, 45);
		text("Red:", 120, 70);
		textFont(myFont, 100);
		text(rscore, 220, 53);
		fill(255,255,255);
		rect(1080,70,300,100);
		fill(255,237,0);
		textFont(myFont, 45);
		text("Yellow:", 1030, 70);
		textFont(myFont, 100);
		text(yscore, 1150, 53);	
		fill(255,255,255);
		rect(640,665,500,35);
		fill(0,0,0);
		textFont(myFont, 12);
		text("To drop: click in the column you want to drop the checker in. Restart clears the score.", 640, 655);
		text("Play Again starts a new round but keeps the score. WARNING: flashing lights!", 640, 670);
		if(winner) {
		for(int z = 0; z < elements.size(); z+=4){
			strokeWeight(5);

			line(elements.get(z),elements.get(z+1),elements.get(z+2),elements.get(z+3));
			strokeWeight(1);

		}
		}	
//		if(winner == true){
//		scoreboard(current);
//		}
		
		
	}
	
private void strokeWieght() {
		// TODO Auto-generated method stub
		
	}

//	public void scoreboard(int current){
//		if(current == 1){
//			fill(255,0,0);
//
//		}
//		else if(current == 2){
//			fill(255,237,0);
//			
//		}
//		
//	}
	
	public void flash(int current){
		if(current == 1){
			color = "Red";
			color2 = 0;
		} else if(current == 2){
			color = "Yellow";
			color2 = 237;
		}
		
		fill(255,255,255);
		rect(160,400,300,350);
		fill(255,color2,0);
		textFont(myFont, 70);
		String words = "Player " + current + " wins!!!";
		String words2 = color;
//		ellipse(160, 300, 70, 70);
//		ellipse(160, 500, 70, 70);
		text(words2, 160, 400);
		
		fill(255,255,255);
		rect(1120,400,300,350);
		fill(255,color2,0);
		textFont(myFont, 70);
		text("Wins!!!", 1120, 400);
		
		fill(255,255,255);
		rect(640,400,640,480);
//		fill(0,0,0);
//		textFont(myFont, 60);
//		text("Play Again", 1120, 640);
		
		fill(255,255,255);
		rect(1120,640,250,65);
		fill(0,0,0);
		textFont(myFont, 35);
		text("Play Again", 1120, 640);
		if(frameCount%6 == 0){
			float r = random(0,255);
			float gr = random(0,255);
			float b = random(0,255);
			background(r, gr, b);
		}
	}
	
	public void flash_tie(){
		
		fill(255,255,255);
		rect(160,400,300,350);
		fill(0,0,0);
		textFont(myFont, 70);
		String words = "Tie";
		String words2 = color;
//		ellipse(160, 300, 70, 70);
//		ellipse(160, 500, 70, 70);
		text(words, 160, 400);
		
		fill(255,255,255);
		rect(1120,400,300,350);
		fill(0,0,0);
		textFont(myFont, 70);
		text("Game", 1120, 400);
		
		fill(255,255,255);
		rect(640,400,640,480);
//		fill(0,0,0);
//		textFont(myFont, 60);
//		text("Play Again", 1120, 640);
		
		fill(255,255,255);
		rect(1120,640,250,65);
		fill(0,0,0);
		textFont(myFont, 35);
		text("Play Again", 1120, 640);
		if(frameCount%7 == 0){
			float r = random(0,255);
			float gr = random(0,255);
			float b = random(0,255);
			background(r);
		}
	}
	
//	int x = 371 + (columin*76) + (14*columin);
//	float y = 600 - (row*76) - (4*row);
	
	public void draw_win(int x, int y, String dir){
		if(dir.equals("up")){
			draw_win(x, y, 1, 1);
			draw_win(x, y, -1, -1);
		}
		else if(dir.equals("y")){
			draw_win(x, y, 0, 1);
			draw_win(x, y, 0, -1);
		}
		else if(dir.equals("x")){
			draw_win(x, y, 1, 0);
			draw_win(x, y, -1, 0);
		}
		else if(dir.equals("down")){
			draw_win(x, y, -1, 1);
			draw_win(x, y, 1, -1);
		}
	}
		
		public void who_is_playing(int currents){
			if(currents == 1){
				color = "Red";
				color2 = 0;
			} else if(currents == 2){
				color = "Yellow";
				color2 = 237;
			}
			fill(255,255,255);
			rect(640,140,290,32);
			fill(255,color2,0);
			textFont(myFont, 30);
			text("It is " + color + "'s turn", 640, 137);
		}

		public void drop(int col, int i, int player){
				x = 371 + (col*76) + (14*col);
				y = 600 - (i*76) - (4*i);
				regy = 160;
			
		}


	public void mousePressed(){
	
		if(winner != true){
		if(mouseY > cy && mouseY < cy + height && mouseX > 320 && mouseX < 320 + 640){
		int columnin = ((int)((mouseX-320)/cw));	
			for(int i = 0;i < 6;i++){
				if(arr[columnin][i] == 0){
					current_col = columnin;
					current_i = i;
					current_pla = current_player;
					drop(columnin,i,current_player);
					arr[columnin][i] = current_player;
					checkWin(columnin, i);
					current_player = (current_player%2) + 1;
					turn_count++;
					////println(turn_count);
					checkTie();
					break;
				}	
			}
		}
	}
		if(mouseY > 607.5  && mouseY < 672.5 && mouseX > 35 && mouseX < 285 ){
			//println("Restart");
			elements.clear();
			for(int g = 0;g < 7;g++){
				for(int p = 0;p < 6;p++){
					arr[g][p] = 0;
				}	
			}
			winner = false;
			tie = false;
			background(192, 192, 192);
			current_player = 1;
			 rscore = 0;
			 yscore = 0;
			 turn_count = 0;
			
		}
		
		if(winner == true || tie == true){
		if(mouseY > 607.5  && mouseY < 672.5 && mouseX > 995 && mouseX < 1245 ){
			//println("Play Again");
			elements.clear();
			for(int g = 0;g < 7;g++){
				for(int p = 0;p < 6;p++){
					arr[g][p] = 0;
				}	
			}
			winner = false;
			tie = false;
			background(192, 192, 192);
			current_player = 1;
			turn_count = 0;
			
			
		}
		}	
		
}
	
	int draw_win(int x,int y,int xstep,int ystep){
		if(x + xstep < 0 || x + xstep > 6 || y + ystep < 0 || y + ystep > 5){
			return 0;
		}
			if(arr[x + xstep][y + ystep] == current_player){
				int xc = 371 + (x*76) + (14*x);
				int yc = 600 - (y*76) - (4*y);
				int xd = 371 + ((x + xstep)*76) + (14*(x + xstep));
				int yd = 600 - ((y + ystep)*76) - (4*(y + ystep));
				elements.add(xc);
				elements.add(yc);	
				elements.add(xd);
				elements.add(yd);
				draw_win(x + xstep,y + ystep,xstep,ystep);
		}
			return 0;
	}
				
		int win(int x,int y,int xstep,int ystep){
			if(x < 0 || x > 6 || y < 0 || y > 5){
				return 0;
			}
				if(arr[x][y] == current_player){
					return win(x + xstep,y + ystep,xstep,ystep) + 1;
			}
				return 0;
			
		}

		public void checkTie(){
			if(turn_count == 42){
				tie = true;
				}
		}
		
		public void checkWin(int x, int y){
			int fx = x;
			int fy = y;
//			//println(current_player);
			int count = 1;
			count += win(x + 1, y + 1, 1, 1);
			count += win(x - 1, y - 1, -1, -1);
//			//println(count);
			if(count >= 4){
//				//println(current_player + " wins!!");
				winner = true;
				dir_of_win = "up";
				draw_win(fx, fy, dir_of_win);
				current = current_player;
				if(current == 1){
					rscore++;
				}
				else if(current == 2){
					yscore++;
				}
				return;
			}	
			count = 1;
			count += win(x + 1, y, 1, 0);
			count += win(x - 1, y, -1, 0);
//			//println(count);
			if(count >= 4){
//				//println(current_player + " wins!!");
				winner = true;
				dir_of_win = "x";
				draw_win(fx, fy, dir_of_win);
				current = current_player;
				if(current == 1){
					rscore++;
				}
				else if(current == 2){
					yscore++;
				}
				return;
			}	
			count = 1;
			count += win(x, y + 1, 0, 1);
			count += win(x, y - 1, 0, -1);
//			//println(count);
			if(count >= 4){
//				//println(current_player + " wins!!");
				winner = true;
				dir_of_win = "y";
				draw_win(fx, fy, dir_of_win);
				current = current_player;
				if(current == 1){
					rscore++;
				}
				else if(current == 2){
					yscore++;
				}
				return;
			}	
			count = 1;
			count += win(x - 1, y + 1, -1, 1);
			count += win(x + 1, y - 1, 1, -1);
//			//println(count);
			if(count >= 4){
//				//println(current_player + " wins!!");
				winner = true;
				dir_of_win = "down";
				draw_win(fx, fy, dir_of_win);
				current = current_player;
				if(current == 1){
					rscore++;
				}
				else if(current == 2){
					yscore++;
				}
				return;
			}	
			}
		
			
		}


