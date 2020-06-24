package model;

public class ATransformation implements ITransformation {
  final String shapeName;
  final int t1;
  final int x1;
  final int y1;
  final int w1;
  final int h1;
  final int r1;
  final int g1;
  final int b1;
  final int t2;
  final int x2;
  final int y2;
  final int w2;
  final int h2;
  final int r2;
  final int g2;
  final int b2;

  public ATransformation(String shapeName,
                         int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                         int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    this.shapeName = shapeName;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t2;
    this.x2 = x2;
    this.y2 = y2;
    this.w2 = w2;
    this.h2 = h2;
    this.r2 = r2;
    this.g2 = g2;
    this.b2 = b2;
  }

  @Override
  public int getInitialTime() {
    return this.t1;
  }

  @Override
  public int getInitialX() {
    return this.x1;
  }

  @Override
  public int getInitialY() {
    return this.y1;
  }

  @Override
  public int getInitialWidth() {
    return this.w1;
  }

  @Override
  public int getInitialHeight() {
    return this.h1;
  }

  @Override
  public int getInitialRed() {
    return this.r1;
  }

  @Override
  public int getInitialGreen() {
    return this.g1;
  }

  @Override
  public int getInitialBlue() {
    return this.b1;
  }

  @Override
  public int getFinalTime() {
    return this.t2;
  }

  @Override
  public int getFinalX() {
    return this.x2;
  }

  @Override
  public int getFinalY() {
    return this.y2;
  }

  @Override
  public int getFinalWidth() {
    return this.w2;
  }

  @Override
  public int getFinalHeight() {
    return this.h2;
  }

  @Override
  public int getFinalRed() {
    return this.r2;
  }

  @Override
  public int getFinalGreen() {
    return this.g2;
  }

  @Override
  public int getFinalBlue() {
    return this.b2;
  }

  @Override
  public int compareTo(ITransformation o) {
    return Integer.compare(this.getInitialTime(), o.getInitialTime());
  }
}
