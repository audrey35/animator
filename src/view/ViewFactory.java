package view;

import model.IAnimatorModel;

public class ViewFactory {
  /**
   * Constructs a View based on the view type.
   *
   * @param viewType enum for views.
   * @param model    model of the program.
   * @param outPath  path to resulting text file.
   * @return appropriate view.
   */

  public static IView createView(ViewType viewType, IAnimatorModel model, String outPath) {
    if (viewType == ViewType.SVG) {
      return new SVGView(model, outPath);
    } else if (viewType == ViewType.VISUAL) {
      return new VisualView(model);
    } else {
      return null;
    }
  }
}
