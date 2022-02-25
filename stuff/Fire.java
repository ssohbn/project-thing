package stuff;

import processing.core.PApplet;

public class Fire {
  
  public int xOffset;
  public int yOffset;
  public int screenWidth = XD.screenWidth;
  public int screenHeight = XD.screenHeight;
  
  public int magnitude;
  public double sensitivity;

  public Fire(int xOffset, int yOffset, int magnitude, double sensitivity) {
    this.xOffset = xOffset;
    this.yOffset = yOffset;
    this.sensitivity = sensitivity;
    this.magnitude = magnitude;

  
  }

  public void draw(PApplet sketch) { // kevin helped on this
    int fireWidth = screenWidth+ 300;
    int fireHeight = 100;

    sketch.pushMatrix();        
    // the actual shape
    sketch.rect(
      // x, y
      -this.xOffset-150,
      (-this.yOffset) + (float) (Util.bottomAlign(screenHeight, fireHeight)+(Util.mouseXSin(sketch.mouseX, this.magnitude, this.sensitivity))),
      
      // width, height 
      fireWidth, fireHeight);
    sketch.popMatrix();
  }

  public int getYOffset() {
    return this.yOffset;
  }
}