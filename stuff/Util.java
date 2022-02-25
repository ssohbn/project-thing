package stuff; 


import java.awt.Color;
import java.lang.Math;

public class Util {
  // this class contains very cool math things aka stuff i dont wnana look at

  public static int bottomAlign(int screenHeight, 
  int objectHeight) {
    // aligns a shape to bottom ( wow! )
    return (screenHeight - objectHeight);
  }

  public static int rightAlign(int screenWidth, int objectWidth) {
    // aligns shape to right ( never used !! )
    return (screenWidth - objectWidth);
  }

  public static double mouseXSin(int mouseX, int magnitude, double sensitivity) {
    // make the shapeys go uppy downy with mouse :)
    return (double) magnitude*(Math.abs(Math.sin(sensitivity*mouseX)));
  }

  public static Color mouseYColor(int mouseY, int HSVOffset) {
    // use mouse position and an hsv offset to get an rgb color

    float thing = (mouseY / ((float)400/60));
    float hue = (60-thing-HSVOffset) /360;
    // gets valid hue from mouse thing AS A VALUE BTWN 0 AND 1
    
    int rgb = Color.HSBtoRGB(hue, .4F,  1.0F);
    // rgb colorey thingy from hsv (whoa)
    return new Color(rgb, false);
  }

  public static int[] point(int x, int y) {
    // makes it less tedious to write new int stuff for the polygonks
    return new int[]{x, y}; 
  }
}