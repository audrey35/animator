package model;

import java.util.HashMap;
import java.util.List;

import model.shape.IReadOnlyShape;

public interface IReadOnlyAnimatorModel {
  List<String> getShapeOrder();

  HashMap<String, IReadOnlyShape> getShapes();

  List<IReadOnlyShape> getShapesAt(int tick);

  int getBoundLeft();

  int getBoundTop();

  int getBoundWidth();

  int getBoundHeight();

  int getSpeed();
}
