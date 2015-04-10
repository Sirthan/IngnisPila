package ignispila;

import static org.lwjgl.opengl.GL11.*;

public class Draw {
	public static void Rect(int x, int y, int width, int height){
		Rect(x, y, width, height, 0, new Color(0, 0, 0));
	}
	
	public static void Rect(int x, int y, int width, int height, Color color){
		Rect(x, y, width, height, 0, color);
	}
	
	public static void Rect(int x, int y, int width, int height, int rot){
		Rect(x, y, width, height, rot, new Color(0, 0, 0));
	}
	
	
	public static void Rect(int x, int y, int width, int height, int rot, Color color){
		glColor4ub(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
		glPushMatrix();
		
		glRotatef(rot, 0, 0, 1);
		glTranslatef(x, y, 0);
		
		glBegin(GL_QUADS);
        {
        	glVertex2f(0, 0);
        	glVertex2f(0, height);
        	glVertex2f(width, height);
        	glVertex2f(width, 0);
        }
        glEnd();
        glPopMatrix();
	}
	
	public static void Tri(int x, int y, int width, int height, int rot, Color color, float scaling){
		glPushMatrix();
		
		glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	    
		glColor4ub(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
		glTranslatef((float)((x * 3 + width * 1.5)/ 3), (float)((y * 3 + height) / 3), 0f);
		glRotatef(rot, 0, 0, 1);
		glScalef((float)scaling, (float)scaling, 0.0f);
		glTranslatef((float)-((x * 3 + width * 1.5)/ 3), (float)-((y * 3 + height) / 3), 0f);
		glTranslatef(x, y, 0);
		
		glBegin(GL_TRIANGLES);
        {
        	glVertex2f(0, 0);
        	glVertex2f(width / 2, height);
        	glVertex2f(width, 0);
        }
        glEnd();
        glPopMatrix();
	}
	
	public static void Tri(int x, int y, int width, int height){
		Tri(x, y, width, height, 0, new Color(255, 255, 255), 1);
	}
	
	public static void Tri(int x, int y, int width, int height, Color color){
		Tri(x, y, width, height, 0, color, 1);
	}
	
	public static void Tri(int x, int y, int width, int height, int rot, Color color, int scaling){
		Tri(x, y, width, height, rot, color, (float) scaling);
	}
}
