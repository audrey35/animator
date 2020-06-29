package model.shape;

import java.util.List;

import model.keyframe.IKeyframe;
import model.transformation.ITransformation;

public interface IShape {
  void addTransformations(List<ITransformation> transformations);

  void addKeyframe(IKeyframe keyframe);

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
}
