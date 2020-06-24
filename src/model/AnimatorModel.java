package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AnimatorModel implements IAnimatorModel {
  List<String> shapeOrder;
  HashMap<String, IShape> shapes;
  HashMap<String, List<ITransformation>> transformations;
  HashMap<String, List<IKeyframe>> keyframes;
  int x;
  int y;
  int width;
  int height;

  public AnimatorModel() {
    this.shapeOrder = new ArrayList<>();
    this.shapes = new HashMap<>();
    this.transformations = new HashMap<>();
    this.keyframes = new HashMap<>();
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
  }

  @Override
  public void addShape(ShapeType type, String name, int t, int x, int y, int w, int h,
                       int r, int g, int b) {
    if (!this.shapeOrder.contains(name)) {
      this.shapeOrder.add(name);
      IShape shape = ShapeFactory.createShape(type, name, t, x, y, w, h, r, g, b);
      this.shapes.put(name, shape);
    }
  }

  @Override
  public void addKeyFrames(String name, List<IKeyframe> keyframes) {
    if (this.shapeOrder.contains(name)) {
      if (this.keyframes.containsKey(name)) {
        List<IKeyframe> keys = this.keyframes.get(name);
        for (IKeyframe k : keyframes) {
          if (!keys.contains(k)) {
            keys.add(k);
          }
        }
        Collections.sort(keys);
        this.keyframes.replace(name, keys);
      }
      else {
        Collections.sort(keyframes);
        this.keyframes.put(name, keyframes);
      }
    }
  }

  @Override
  public void addTransformations(String name, List<ITransformation> transformations) {
    List<ITransformation> trans;
    if (this.shapeOrder.contains(name)) {
      if (this.transformations.containsKey(name)) {
        trans = this.transformations.get(name);
        for (ITransformation t : transformations) {
          if (!trans.contains(t)) {
            trans.add(t);
          }
        }
        Collections.sort(trans);
        this.transformations.replace(name, trans);
      }
      else {
        Collections.sort(transformations);
        this.transformations.put(name, transformations);
      }
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
  public List<String> getShapeOrder() {
    return this.shapeOrder;
  }

  @Override
  public HashMap<String, IShape> getShapes() {
    return this.shapes;
  }

  @Override
  public HashMap<String, List<ITransformation>> getTransformations() {
    return this.transformations;
  }

  @Override
  public HashMap<String, List<IKeyframe>> getKeyframes() {
    return this.keyframes;
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
}
