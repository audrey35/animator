package com.portfolio.animator.generator.model;

import com.portfolio.animator.generator.model.shape.IReadOnlyShape;

import java.util.HashMap;
import java.util.List;

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
