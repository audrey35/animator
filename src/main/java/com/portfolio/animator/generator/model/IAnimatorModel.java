package com.portfolio.animator.generator.model;
import com.portfolio.animator.generator.model.keyframe.IKeyframe;
import com.portfolio.animator.generator.model.shape.IReadOnlyShape;
import com.portfolio.animator.generator.model.shape.ShapeType;
import com.portfolio.animator.generator.model.transformation.ITransformation;

import java.util.HashMap;
import java.util.List;

public interface IAnimatorModel {
  void addShape(ShapeType type, String name, int t, int x, int y, int w, int h,
                int r, int g, int b);

  void addKeyFrame(String name, IKeyframe keyframe);

  void addKeyFrames(String name, List<IKeyframe> keyframes);

  void addTransformations(String name, List<ITransformation> transformations);

  void setBounds(int x, int y, int width, int height);

  void setSpeed(int speed);

  List<String> getShapeOrder();

  HashMap<String, IReadOnlyShape> getShapes();

  List<IReadOnlyShape> getShapesAt(int tick);

  int getBoundLeft();

  int getBoundTop();

  int getBoundWidth();

  int getBoundHeight();

  int getSpeed();
}
