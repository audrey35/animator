package model.shape;

public class Ellipse extends AShape {
  public Ellipse(ShapeType shapeType, String name, int t, int x, int y, int w, int h,
                 int r, int g, int b) {
    super(shapeType, name, t, x, y, w, h, r, g, b);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Ellipse)) {
      return false;
    }
    Ellipse other = (Ellipse) o;
    return this.getTime() == other.getTime()
            && this.getX() == other.getX()
            && this.getY() == other.getY()
            && this.getWidth() == other.getWidth()
            && this.getHeight() == other.getHeight()
            && this.getRed() == other.getRed()
            && this.getGreen() == other.getGreen()
            && this.getBlue() == other.getBlue();
  }
}
