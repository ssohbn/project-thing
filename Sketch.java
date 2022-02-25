import processing.core.PApplet;
import java.util.ArrayList;
import java.util.List;
import stuff.*;
import java.awt.Color;
// hsv red to yellow is a range of 0-60

public class Sketch extends PApplet {
  public int screenWidth = XD.screenWidth;
  public int screenHeight = XD.screenHeight;

  public int hueRange = XD.hueRange;

  public int hueOffset = 0;

  public int backR = XD.backR;
  public int backG = XD.backG;
  public int backB = XD.backB;

  public void settings() {
    size(screenWidth, screenHeight);
  }
  public void setup() {
    background(backR, backG, backB);
    System.out.println("ono the scren is burn");
  }

  public void draw() {
    background(backR, backG, backB);
    
    fillColor(hueOffset);

    fireman(3);

    // the other shape requirements incase i dont get fire finished (spoiler, i didnt get it working)
    triangle(5F,6F,8F,23F,200F,20F);
    ellipse(50,200,30,30);
    semicircle(50, 60, 30, 20);

    // this ploygonk will draw
    ploygonk(  
      Util.point(2,3),
      Util.point(20,30),
      Util.point(40,60),
      Util.point(100,200),
      Util.point(20,100)
      // i just learned that point is in PApplet and i didnt actually need to make my own method
    );
  
    // this ploygonk will not draw because of my if thingy
    ploygonk(
      Util.point(2,3)
    );

  }
  

  public void semicircle(int x, int y, int w, int h) {
    arc(x, y, w, h, 0, PI);
  }

  public void ploygonk(int[] ... args) {
    // wonky polygon
    
    if (!(args.length<3)) {
      beginShape();
      for (int[] vtexPair: args) {
        vertex(vtexPair[0], (vtexPair[1]));
      }
      endShape();
    }
    
  }

public void fillColor(int offset) {
  // fancy fill or something idk maybe less fancy
  Color color = Util.mouseYColor(mouseY, offset);
    fill(
      color.getRed(),
      color.getGreen(),
      color.getBlue()
    );
}
public void mouseClicked() {
  hueOffset += 60;
  
}
  
  // fireman but also firemanager
  // will determine fire order + movement factors and whatever else i feel like :)

  public void fireman(int count) {
    List<Fire> fires = new ArrayList<Fire>();
    
    for (int i=count-1; i>=0; i--) { // counts backwards coz layer
      
      int xOffset = (mouseX-(screenWidth/2))/5*i; 
      int yOffset = i*30;
      int magnitude =  5 * i;
      double sensitivity = 0.01 * i;
      fires.add(new Fire(xOffset, yOffset, magnitude, sensitivity));
    }

    fires.forEach(fire -> {
      fire.draw(this);
    });
    fires.clear(); 
    // this functino should problay be a class xd
  }


}