package model;

public enum ShapeType {
  RECTANGLE("rectangle"), ELLIPSE("ellipse");

  private String shapeType;

  ShapeType(String type) {
    this.shapeType = type;
  }

  @Override
  public String toString() {
    return shapeType;
  }

  public static ShapeType fromString(String type) {
    if (type.equalsIgnoreCase(RECTANGLE.shapeType)) {
      return RECTANGLE;
    }
    else if (type.equalsIgnoreCase(ELLIPSE.shapeType)) {
      return ELLIPSE;
    }
    return null;
  }
}
