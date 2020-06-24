package model;

public class AShape implements IShape {
  String name;
  ShapeType type;
  int t;
  int x;
  int y;
  int w;
  int h;
  int r;
  int g;
  int b;

  public AShape(ShapeType shapeType, String name, int t, int x, int y, int w, int h,
                int r, int g, int b) {
    this.name = name;
    this.type = shapeType;
    this.t = t;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public String getName() {
    return this.name;
  }

  public ShapeType getType() {
    return this.type;
  }

  public int getTime() {
    return this.t;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getWidth() {
    return this.w;
  }

  public int getHeight() {
    return this.h;
  }

  public int getRed() {
    return this.r;
  }

  public int getGreen() {
    return this.g;
  }

  public int getBlue() {
    return this.b;
  }
}
