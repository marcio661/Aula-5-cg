
package algpreevarred;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Marcio
 */
public class Janela extends JFrame {
 private int pixels[][];
    public Janela() {
        
        
        pixels = new int[300][300];
        
     
        
        
        this.setTitle("Algoritmo de Preenchiento - Varredura");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
        public void paint(Graphics g){
    geraPoligono(g);
    g.setColor(Color.red);
    algVarred(g,39,39,226,226);
    
    }
      private void algVarred(Graphics g, int xmin, int ymin, int xmax, int ymax){
      
          boolean liga;
          
          for(int y=ymin; y<ymax;y++){
          liga = false;
          for (int x=xmin;x<xmax;x++){
             
          
          if (liga)putPixel(g,x,y);
          if((getPixel(x+1, y)>0)&(getPixel(x+2,y))<1) liga=!liga;
          }
              }
      
      
      }  
        private void geraPoligono(Graphics g){
            algBres(g,40,40,225,40);
            algBres(g,225,40,225,225);
            algBres(g,225,225,40,225);
            algBres(g,40,225,40,40);
        }
    private void putPixel(Graphics g, int x, int y){
    g.drawLine(x, y, x, y);
    pixels[x-1][y-1]=1;
    }
    private int getPixel(int x, int y){
    return pixels[x-1][y-1];
            }
        private void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        
       int x = xi, y = yi, d=0, dx = xf-xi, dy = yf-yi, c, m, incX=1, incY=1;
       
       if(dx < 0) {incX = -1; dx = -dx;}
       if(dy < 0) {incY = -1; dy = -dy;}
        System.out.println(dx+"-"+dy+"-"+incX+"-"+incY);
       
       if(dy <= dx) {
           c = 2 * dx; m = 2 * dy;
           System.out.println(c+"-"+m);
           //if(incX < 0) dx++;
           for(;;) {
               putPixel(g,x,y);
               if (x == xf) break;
               x += incX;
               d += m;
               if(d >= dx) {y += incY; d -= c;}
               System.out.println(x+"-"+y);
           }
       } else {
           c = 2 * dy; m = 2 * dx;
           System.out.println(c+"-"+m);
           //if(incY < 0) dy++;
           for(;;) {
               putPixel(g,x,y);
               if (y == yf) break;
               y += incY;
               d += m;
               if(d >= dy) {x += incX; d -= c;}
               System.out.println(x+"-"+y);
       }
       
    }
    }

}
    

