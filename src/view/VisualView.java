package view;

import model.IReadOnlyAnimatorModel;

public class VisualView implements IView {
  final IReadOnlyAnimatorModel model;

  public VisualView(IReadOnlyAnimatorModel model) {
    this.model = model;
  }

  @Override
  public void render() {

  }

  @Override
  public void render(String outputPath) {

  }
}
