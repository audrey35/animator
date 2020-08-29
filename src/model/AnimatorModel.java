package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.keyframe.IKeyframe;
import model.shape.IReadOnlyShape;
import model.shape.IShape;
import model.shape.ShapeFactory;
import model.shape.ShapeType;
import model.transformation.ITransformation;

public class AnimatorModel implements IAnimatorModel, IReadOnlyAnimatorModel {
  final List<String> shapeOrder;
  final HashMap<String, IShape> shapes;
  int x;
  int y;
  int width;
  int height;
  int speed;

  public AnimatorModel() {
    this.shapeOrder = new ArrayList<>();
    this.shapes = new HashMap<>();
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
    this.speed = 1;
  }

  private boolean shapeExists(String shapeName) {
    return this.shapeOrder.contains(shapeName);
  }

  private IShape getShape(String shapeName) {
    if (this.shapeExists(shapeName)) {
      return this.shapes.get(shapeName);
    }
    return null;
  }

  private boolean replaceShape(String shapeName, IShape shape) {
    if (this.shapeExists(shapeName)) {
      this.shapes.replace(shapeName, shape);
      return true;
    }
    return false;
  }

  @Override
  public void addShape(ShapeType type, String name, int t, int x, int y, int w, int h,
                       int r, int g, int b) {
    if (!this.shapeExists(name)) {
      this.shapeOrder.add(name);
      IShape shape = ShapeFactory.createShape(type, name, t, x, y, w, h, r, g, b);
      this.shapes.put(name, shape);
    }
  }

  @Override
  public void addKeyFrame(String name, IKeyframe keyframe) {
    IShape shape = this.getShape(name);
    if (shape != null) {
      shape.addKeyframe(keyframe);
      this.replaceShape(name, shape);
    }
  }

  @Override
  public void addKeyFrames(String name, List<IKeyframe> keyframes) {
    IShape shape = this.getShape(name);
    if (shape != null) {
      for (IKeyframe keyframe : keyframes) {
        shape.addKeyframe(keyframe);
      }
      this.replaceShape(name, shape);
    }
  }

  @Override
  public void addTransformations(String name, List<ITransformation> transformations) {
    IShape shape = this.getShape(name);
    if (shape != null) {
      shape.addTransformations(transformations);
      this.replaceShape(name, shape);
    }
  }

  @Override
  public void setBounds(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  @Override
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  @Override
  public List<String> getShapeOrder() {
    return this.shapeOrder;
  }

  @Override
  public HashMap<String, IReadOnlyShape> getShapes() {
    IReadOnlyShape shape;
    HashMap<String, IReadOnlyShape> newShapes = new HashMap<>();
    for (String name : this.shapeOrder) {
      shape = (IReadOnlyShape) this.shapes.get(name);
      newShapes.put(name, shape);
    }
    return newShapes;
  }

  @Override
  public List<IReadOnlyShape> getShapesAt(int tick) {
    List<IReadOnlyShape> newShapes = new ArrayList<>();
    IReadOnlyShape shape;
    for (String name : this.shapeOrder) {
      shape = (IReadOnlyShape) this.shapes.get(name);
      shape = (IReadOnlyShape) shape.getShapeAt(tick);
      newShapes.add(shape);
    }
    return newShapes;
  }

  @Override
  public int getBoundLeft() {
    return this.x;
  }

  @Override
  public int getBoundTop() {
    return this.y;
  }

  @Override
  public int getBoundWidth() {
    return this.width;
  }

  @Override
  public int getBoundHeight() {
    return this.height;
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }
}
