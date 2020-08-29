package model;

import java.util.HashMap;
import java.util.List;

import model.keyframe.IKeyframe;
import model.shape.IReadOnlyShape;
import model.shape.ShapeType;
import model.transformation.ITransformation;

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
