package model.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.transformation.ITransformation;

public class Rectangle extends AShape {
  public Rectangle(ShapeType shapeType, String name, int t, int x, int y, int w, int h,
                   int r, int g, int b) {
    super(shapeType, name, t, x, y, w, h, r, g, b);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Rectangle)) {
      return false;
    }
    Rectangle other = (Rectangle) o;
    return this.getTime() == other.getTime()
            && this.getX() == other.getX()
            && this.getY() == other.getY()
            && this.getWidth() == other.getWidth()
            && this.getHeight() == other.getHeight()
            && this.getRed() == other.getRed()
            && this.getGreen() == other.getGreen()
            && this.getBlue() == other.getBlue();
  }

  @Override
  public void draw(Graphics g) {
    //Graphics2D g2d = (Graphics2D) g;
    Color color = new Color(this.getRed(), this.getGreen(), this.getBlue());
    g.setColor(color);
    g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
  }

  @Override
  public IShape getShapeAt(int tick) {
    if (tick == 0) {
      return this;
    }
    IShape s;
    int t1; int t2; int x1; int x2; int y1; int y2; int w1; int w2;
    int h1; int h2; int r1; int r2; int g1; int g2; int b1; int b2;
    float tdiff;
    for (ITransformation t : this.transformations) {
      t1 = t.getInitialTime();
      x1 = t.getInitialX();
      y1 = t.getInitialY();
      w1 = t.getInitialWidth();
      h1 = t.getInitialHeight();
      r1 = t.getInitialRed();
      g1 = t.getInitialGreen();
      b1 = t.getInitialBlue();
      t2 = t.getFinalTime();
      x2 = t.getFinalX();
      y2 = t.getFinalY();
      w2 = t.getFinalWidth();
      h2 = t.getFinalHeight();
      r2 = t.getFinalRed();
      g2 = t.getFinalGreen();
      b2 = t.getFinalBlue();
      if (t1 == tick) {
        s = new Rectangle(ShapeType.RECTANGLE, name, t1, x1, y1, w1, h1, r1, g1, b1);
        return s;
      }
      else if (t2 == tick) {
        s = new Rectangle(ShapeType.RECTANGLE, this.name, t2, x2, y2, w2, h2, r2, g2, b2);
        return s;
      }
      else if (tick > t1 && tick < t2) {
        tdiff = t2 - t1;
        s = new Rectangle(ShapeType.RECTANGLE, this.name, tick, tweening(x2, x1, tdiff),
                tweening(y2, y1, tdiff), tweening(w2, w1, tdiff), tweening(h2, h1, tdiff),
                tweening(r2, r1, tdiff), tweening(g2, g1, tdiff), tweening(b2, b1, tdiff));
        return s;
      }
    }
    return null;
  }
}
