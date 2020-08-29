package com.portfolio.animator.generator.model.keyframe;

public interface IKeyframe extends Comparable<IKeyframe> {
  int getTime();

  int getX();

  int getY();

  int getWidth();

  int getHeight();

  int getRed();

  int getGreen();

  int getBlue();
}
