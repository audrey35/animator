package com.portfolio.animator.generator.model.shape;
import com.portfolio.animator.generator.model.keyframe.IKeyframe;
import com.portfolio.animator.generator.model.transformation.ITransformation;

import java.awt.*;
import java.util.List;

public interface IReadOnlyShape {
  List<ITransformation> getTransformations();

  List<IKeyframe> getKeyframes();

  String getName();

  ShapeType getType();

  int getTime();

  int getX();

  int getY();

  int getWidth();

  int getHeight();

  int getRed();

  int getGreen();

  int getBlue();

  void draw(Graphics g);

  IShape getShapeAt(int tick);

  Point getPointAt(int tick);
}
