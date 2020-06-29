package model.transformation;

public class ScaleTransformation extends ATransformation {
  public ScaleTransformation(String shapeName,
                             int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                             int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    super(shapeName, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ScaleTransformation)) {
      return false;
    }
    ScaleTransformation other = (ScaleTransformation) o;
    return this.getInitialTime() == other.getInitialTime()
            && this.getInitialX() == other.getInitialX()
            && this.getInitialY() == other.getInitialY()
            && this.getInitialWidth() == other.getInitialWidth()
            && this.getInitialHeight() == other.getInitialHeight()
            && this.getInitialRed() == other.getInitialRed()
            && this.getInitialGreen() == other.getInitialGreen()
            && this.getInitialBlue() == other.getInitialBlue()
            && this.getFinalTime() == other.getFinalTime()
            && this.getFinalX() == other.getFinalX()
            && this.getFinalY() == other.getFinalY()
            && this.getFinalWidth() == other.getFinalWidth()
            && this.getFinalHeight() == other.getFinalHeight()
            && this.getFinalRed() == other.getFinalRed()
            && this.getFinalGreen() == other.getFinalGreen()
            && this.getFinalBlue() == other.getFinalBlue();
  }
}
