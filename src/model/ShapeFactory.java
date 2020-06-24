package model;

public class ShapeFactory {
  public static IShape createShape(ShapeType shapeType, String name, int t, int x, int y,
                                   int w, int h, int r, int g, int b) {
    if (shapeType == ShapeType.RECTANGLE) {
      return new Rectangle(shapeType, name, t, x, y, w, h, r, g, b);
    } else {
      return new Ellipse(shapeType, name, t, x, y, w, h, r, g, b);
    }
  }
}
