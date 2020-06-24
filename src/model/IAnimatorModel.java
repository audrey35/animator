package model;

import java.util.HashMap;
import java.util.List;

public interface IAnimatorModel {
  void addShape(ShapeType type, String name, int t, int x, int y, int w, int h,
                int r, int g, int b);

  void addKeyFrames(String name, List<IKeyframe> keyframes);

  void addTransformations(String name, List<ITransformation> transformations);

  void setBounds(int x, int y, int width, int height);

  List<String> getShapeOrder();

  HashMap<String, IShape> getShapes();

  HashMap<String, List<ITransformation>> getTransformations();

  HashMap<String, List<IKeyframe>> getKeyframes();

  int getBoundLeft();

  int getBoundTop();

  int getBoundWidth();

  int getBoundHeight();

  void addSpeed(int speed);
}
