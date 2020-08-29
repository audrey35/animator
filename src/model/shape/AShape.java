package model.shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.keyframe.IKeyframe;
import model.keyframe.Keyframe;
import model.transformation.ITransformation;

public abstract class AShape implements IShape, IReadOnlyShape {
  final String name;
  final ShapeType type;
  final int t;
  final int x;
  final int y;
  final int w;
  final int h;
  final int r;
  final int g;
  final int b;
  List<ITransformation> transformations;
  List<IKeyframe> keyframes;

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
    this.transformations = new ArrayList<>();
    this.keyframes = new ArrayList<>();
  }

  @Override
  public void addTransformations(List<ITransformation> transformations) {
    for (ITransformation t : transformations) {
      if (!this.transformations.contains(t)) {
        this.transformations.add(t);
      }
    }
    Collections.sort(this.transformations);
  }

  @Override
  public void addKeyframe(IKeyframe keyframe) {
    if (!this.keyframes.contains(keyframe)) {
      this.keyframes.add(keyframe);
    }
    Collections.sort(this.keyframes);
  }

  @Override
  public List<ITransformation> getTransformations() {
    return this.transformations;
  }

  @Override
  public List<IKeyframe> getKeyframes() {
    return this.keyframes;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeType getType() {
    return this.type;
  }

  @Override
  public int getTime() {
    return this.t;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getWidth() {
    return this.w;
  }

  @Override
  public int getHeight() {
    return this.h;
  }

  @Override
  public int getRed() {
    return this.r;
  }

  @Override
  public int getGreen() {
    return this.g;
  }

  @Override
  public int getBlue() {
    return this.b;
  }

  int tweening(int initialValue, int finalValue, float timeDiff) {
    return Math.round((finalValue - initialValue) / timeDiff);
  }

  @Override
  public Point getPointAt(int tick) {
    return new Point(this.getX(), this.getY());
  }
}
