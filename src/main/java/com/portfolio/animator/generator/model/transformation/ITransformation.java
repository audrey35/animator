package com.portfolio.animator.generator.model.transformation;

public interface ITransformation extends Comparable<ITransformation> {
  int getInitialTime();

  int getInitialX();

  int getInitialY();

  int getInitialWidth();

  int getInitialHeight();

  int getInitialRed();

  int getInitialGreen();

  int getInitialBlue();

  int getFinalTime();

  int getFinalX();

  int getFinalY();

  int getFinalWidth();

  int getFinalHeight();

  int getFinalRed();

  int getFinalGreen();

  int getFinalBlue();
}
