package com.portfolio.animator.generator.util;

import com.portfolio.animator.generator.model.IAnimatorModel;
import com.portfolio.animator.generator.model.AnimatorModel;
import com.portfolio.animator.generator.model.keyframe.IKeyframe;
import com.portfolio.animator.generator.model.keyframe.Keyframe;
import com.portfolio.animator.generator.model.shape.ShapeType;
import com.portfolio.animator.generator.model.transformation.ITransformation;
import com.portfolio.animator.generator.model.transformation.TransformationFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ModelAdapter implements AnimationBuilder<IAnimatorModel> {

  final IAnimatorModel model;
  final List<String> shapeOrder;
  final HashMap<String, ShapeType> shapes;
  final HashMap<String, List<ITransformation>> transformations;
  final HashMap<String, List<IKeyframe>> keyframes;

  public ModelAdapter() {
    this.model = new AnimatorModel();
    this.shapeOrder = new ArrayList<>();
    this.shapes = new HashMap<>();
    this.transformations = new HashMap<>();
    this.keyframes = new HashMap<>();
  }

  @Override
  public IAnimatorModel build() {
    ShapeType type;
    ITransformation shapeState;
    IKeyframe shapeStateKey;
    List<ITransformation> trans;
    List<IKeyframe> keys;
    int t; int x; int y; int w; int h; int r; int g; int b;
    for (String name : this.shapeOrder) {
      trans = new ArrayList<>();
      keys = new ArrayList<>();
      type = this.shapes.get(name);
      if (this.transformations.containsKey(name)) {
        trans = this.transformations.get(name);
      }
      if (this.keyframes.containsKey(name)) {
        keys = this.keyframes.get(name);
      }
      if (trans.size() > 0 && keys.size() > 0) {
        if (trans.get(0).getInitialTime() <= keys.get(0).getTime()) {
          shapeState = trans.get(0);
          t = shapeState.getInitialTime();
          x = shapeState.getInitialX();
          y = shapeState.getInitialY();
          w = shapeState.getInitialWidth();
          h = shapeState.getInitialHeight();
          r = shapeState.getInitialRed();
          g = shapeState.getInitialGreen();
          b = shapeState.getInitialBlue();
          trans.remove(0);
        }
        else {
          shapeStateKey = keys.get(0);
          t = shapeStateKey.getTime();
          x = shapeStateKey.getX();
          y = shapeStateKey.getY();
          w = shapeStateKey.getWidth();
          h = shapeStateKey.getHeight();
          r = shapeStateKey.getRed();
          g = shapeStateKey.getGreen();
          b = shapeStateKey.getBlue();
          keys.remove(0);
        }
        model.addShape(type, name, t, x, y, w, h, r, g, b);
        model.addTransformations(name, trans);
        model.addKeyFrames(name, keys);
      }
      else if (trans.size() > 0) {
        shapeState = trans.get(0);
        t = shapeState.getInitialTime();
        x = shapeState.getInitialX();
        y = shapeState.getInitialY();
        w = shapeState.getInitialWidth();
        h = shapeState.getInitialHeight();
        r = shapeState.getInitialRed();
        g = shapeState.getInitialGreen();
        b = shapeState.getInitialBlue();
        trans.remove(0);
        model.addShape(type, name, t, x, y, w, h, r, g, b);
        model.addTransformations(name, trans);
      }
      else if (keys.size() > 0) {
        shapeStateKey = keys.get(0);
        t = shapeStateKey.getTime();
        x = shapeStateKey.getX();
        y = shapeStateKey.getY();
        w = shapeStateKey.getWidth();
        h = shapeStateKey.getHeight();
        r = shapeStateKey.getRed();
        g = shapeStateKey.getGreen();
        b = shapeStateKey.getBlue();
        keys.remove(0);
        model.addShape(type, name, t, x, y, w, h, r, g, b);
        model.addKeyFrames(name, keys);
      }
    }
    return model;
  }

  @Override
  public AnimationBuilder<IAnimatorModel> setBounds(int x, int y, int width, int height) {
    model.setBounds(x, y, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<IAnimatorModel> declareShape(String name, String type) {
    ShapeType shapeType = ShapeType.fromString(type);
    if (shapeType != null) {
      if (!this.shapeOrder.contains(name)) {
        this.shapeOrder.add(name);
        this.shapes.put(name, shapeType);
      }
    }
    return this;
  }

  @Override
  public AnimationBuilder<IAnimatorModel> addMotion(String name, int t1, int x1, int y1,
                                                    int w1, int h1, int r1, int g1, int b1,
                                                    int t2, int x2, int y2, int w2, int h2,
                                                    int r2, int g2, int b2) {
    if (t1 == t2) {
      this.addKeyframe(name, t1, x1, y1, w1, h1, r1, g1, b1);
      return this;
    }
    List<ITransformation> trans = TransformationFactory.createTransformation(name,
            t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);

    if (!this.transformations.containsKey(name)) {
      this.transformations.put(name, trans);
    }
    else {
      List<ITransformation> current = this.transformations.get(name);
      for (ITransformation t : trans) {
        if (!current.contains(t)) {
          current.add(t);
        }
      }
      this.transformations.replace(name, current);
    }
    return this;
  }

  @Override
  public AnimationBuilder<IAnimatorModel> addKeyframe(String name, int t, int x, int y,
                                                      int w, int h, int r, int g, int b) {
    IKeyframe keyframe = new Keyframe(name, t, x, y, w, h, r, g, b);

    List<IKeyframe> temp = new ArrayList<>();
    if (!this.keyframes.containsKey(name)) {
      temp.add(keyframe);
      this.keyframes.put(name, temp);
    }
    else {
      temp = this.keyframes.get(name);
      temp.add(keyframe);
      Collections.sort(temp);
      this.keyframes.replace(name, temp);
    }
    return this;
  }
}
