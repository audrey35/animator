package model;

import java.util.HashMap;
import java.util.List;

import model.shape.IReadOnlyShape;

public interface IReadOnlyAnimatorModel {
  List<String> getShapeOrder();

  HashMap<String, IReadOnlyShape> getShapes();

  int getBoundLeft();

  int getBoundTop();

  int getBoundWidth();

  int getBoundHeight();
}
