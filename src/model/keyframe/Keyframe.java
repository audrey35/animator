package model.keyframe;

public class Keyframe implements IKeyframe {
  final String shapeName;
  final int t;
  final int x;
  final int y;
  final int w;
  final int h;
  final int r;
  final int g;
  final int b;
  public Keyframe(String shapeName, int t, int x, int y, int w, int h, int r, int g, int b) {
    this.shapeName = shapeName;
    this.t = t;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  @Override
  public int getTime() {
    return this.t;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getWidth() {
    return this.w;
  }

  @Override
  public int getHeight() {
    return this.h;
  }

  @Override
  public int getRed() {
    return this.r;
  }

  @Override
  public int getGreen() {
    return this.g;
  }

  @Override
  public int getBlue() {
    return this.b;
  }

  @Override
  public int compareTo(IKeyframe o) {
    return Integer.compare(this.getTime(), o.getTime());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Keyframe)) {
      return false;
    }
    Keyframe other = (Keyframe) o;
    return this.getTime() == other.getTime()
            && this.getX() == other.getX()
            && this.getY() == other.getY()
            && this.getWidth() == other.getWidth()
            && this.getHeight() == other.getHeight()
            && this.getRed() == other.getRed()
            && this.getGreen() == other.getGreen()
            && this.getBlue() == other.getBlue();
  }
}
