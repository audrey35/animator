package view;

import model.IAnimatorModel;

public class VisualView implements IView {
  final IAnimatorModel model;

  public VisualView(IAnimatorModel model) {
    this.model = model;
  }

  @Override
  public void render() {

  }

  @Override
  public void render(String outputPath) {

  }
}
