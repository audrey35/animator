package model.transformation;

import java.util.ArrayList;
import java.util.List;

public class TransformationFactory {
  public static List<ITransformation> createTransformation(String shapeName, int t1, int x1, int y1,
                                                           int w1, int h1, int r1, int g1, int b1,
                                                           int t2, int x2, int y2, int w2, int h2,
                                                           int r2, int g2, int b2) {
    ITransformation t;
    List<ITransformation> trans = new ArrayList<>();
    if (x1 != x2 || y1 != y2) {
      t = new MoveTransformation(shapeName, t1, x1, y1, w1, h1, r1, g1, b1,
              t2, x2, y2, w1, h1, r1, g1, b1);
      trans.add(t);
    }
    if (w1 != w2 || h1 != h2) {
      t = new ScaleTransformation(shapeName, t1, x1, y1, w1, h1, r1, g1, b1,
              t2, x1, y1, w2, h2, r1, g1, b1);
      trans.add(t);
    }
    if (r1 != r2 || g1 != g2 || b1 != b2) {
      t = new ColorTransformation(shapeName, t1, x1, y1, w1, h1, r1, g1, b1,
              t2, x1, y1, w1, h1, r2, g2, b2);
      trans.add(t);
    }
    t = new MoveTransformation(shapeName, t1, x1, y1, w1, h1, r1, g1, b1,
            t2, x2, y2, w2, h2, r2, g2, b2);
    trans.add(t);
    return trans;
  }
}
