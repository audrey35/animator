package view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import model.ColorTransformation;
import model.IAnimatorModel;
import model.IShape;
import model.ITransformation;
import model.MoveTransformation;
import model.ScaleTransformation;
import model.ShapeType;

public class SVGView implements IView {
  final IAnimatorModel model;
  final String outputPath;
  String svg;

  public SVGView(IAnimatorModel model, String outputPath) {
    this.model = model;
    this.outputPath = outputPath;
    this.svg = "";
  }

  @Override
  public void render() {

  }

  @Override
  public void render(String outputPath) {
    try {
      FileWriter writer = new FileWriter(this.outputPath, true);
      writer.write(this.toString());
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    this.createSVG();
    return this.svg;
  }

  private void createSVG() {
    this.addHeader();
    List<String> shapeOrder = this.model.getShapeOrder();
    HashMap<String, IShape> shapes = this.model.getShapes();
    HashMap<String, List<ITransformation>> transformations = this.model.getTransformations();
    IShape shape;
    List<ITransformation> trans;
    for (String name : shapeOrder) {
      shape = shapes.get(name);
      if (transformations.containsKey(name)) {
        trans = transformations.get(name);
        this.addShapeSVG(shape, trans);
      }
    }
    this.svg += "</svg>";
  }

  private void addHeader() {
    this.svg = String.format("<svg width=\"%d\" height=\"%d\" viewBox=\"%d %d %d %d\" version=\"1.1\""
                    + "\n     xmlns=\"http://www.w3.org/2000/svg\">\n",
            this.model.getBoundWidth(), this.model.getBoundHeight(),
            this.model.getBoundLeft(), this.model.getBoundTop(),
            this.model.getBoundWidth(), this.model.getBoundHeight());
  }

  private void addShapeSVG(IShape shape, List<ITransformation> transformations) {
    String svg;
    String end = "";
    if (shape.getType() == ShapeType.RECTANGLE) {
      svg = String.format("<rect id=\"%s\" x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" "
                      + "fill=\"rgb(%d,%d,%d)\" visibility=\"visible\" >\n",
              shape.getName(), shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight(),
              shape.getRed(), shape.getGreen(), shape.getBlue());
      this.svg += svg;
      end = "</rect>\n";
    }
    else if (shape.getType() == ShapeType.ELLIPSE) {
      svg = String.format("<ellipse id=\"%s\" cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" "
                      + "fill=\"rgb(%d,%d,%d)\" visibility=\"visible\" >\n",
              shape.getName(), shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight(),
              shape.getRed(), shape.getGreen(), shape.getBlue());
      this.svg += svg;
      end = "</ellipse>\n";
    }

    for (ITransformation t : transformations) {
      this.addTransformationSVG(shape.getType(), t);
    }

    this.svg += end;
  }

  private void addTransformationSVG(ShapeType shapeType, ITransformation t) {
    if (t instanceof MoveTransformation) {
      if (shapeType == ShapeType.RECTANGLE) {
        this.addRectangleMoveSVG(t);
      }
      else if (shapeType == ShapeType.ELLIPSE) {
        this.addEllipseMoveSVG(t);
      }
    }
    else if (t instanceof ScaleTransformation) {
      this.addScaleSVG(t);
    }
    else if (t instanceof ColorTransformation) {
      this.addColorSVG(t);
    }
  }

  private void addRectangleMoveSVG(ITransformation t) {
    String result = "";
    if (t.getInitialX() != t.getFinalX()) {
      result += String.format("    <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
                      + "attributeName=\"x\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
              t.getInitialTime() * 10, (t.getFinalTime() - t.getInitialTime()) * 50,
              t.getInitialX(), t.getFinalX());
    }
    if (t.getInitialY() != t.getFinalY()) {
      result += String.format("    <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
                      + "attributeName=\"y\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
              t.getInitialTime() * 10, (t.getFinalTime() - t.getInitialTime()) * 50,
              t.getInitialY(), t.getFinalY());
    }
    this.svg += result;
  }

  private void addEllipseMoveSVG(ITransformation t) {
    String result = "";
    if (t.getInitialX() != t.getFinalX()) {
      result += String.format("    <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
                      + "attributeName=\"cx\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
              t.getInitialTime() * 10, (t.getFinalTime() - t.getInitialTime()) * 50,
              t.getInitialX(), t.getFinalX());
    }
    if (t.getInitialY() != t.getFinalY()) {
      result += String.format("    <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
                      + "attributeName=\"cy\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
              t.getInitialTime() * 10, (t.getFinalTime() - t.getInitialTime()) * 50,
              t.getInitialY(), t.getFinalY());
    }
    this.svg += result;
  }

  private void addScaleSVG(ITransformation t) {
    String result = "";
    if (Double.compare(t.getInitialWidth(), t.getFinalWidth()) != 0) {
      result = String.format("    <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
                      + "attributeName=\"width\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
              t.getInitialTime() * 10, (t.getFinalTime() - t.getInitialTime()) * 50,
              t.getInitialWidth(), t.getFinalWidth());
    }
    if (Double.compare(t.getInitialHeight(), t.getFinalHeight()) != 0) {
      result += String.format("    <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
                      + "attributeName=\"height\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
              t.getInitialTime() * 10, (t.getFinalTime() - t.getInitialTime()) * 50,
              t.getInitialHeight(), t.getFinalHeight());
    }
    this.svg += result;
  }

  private void addColorSVG(ITransformation t) {
    String result = "";
    if (t.getInitialRed() != t.getFinalRed() || t.getInitialGreen() != t.getFinalGreen()
            || t.getInitialBlue() != t.getFinalBlue()) {
      result = String.format("    <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
                      + "attributeName=\"fill\" from=\"rgb(%d,%d,%d)\" to=\"rgb(%d,%d,%d)\" "
                      + "fill=\"freeze\" />\n",
              t.getInitialTime() * 10, (t.getFinalTime() - t.getInitialTime()) * 50,
              t.getInitialRed(), t.getInitialGreen(), t.getInitialBlue(),
              t.getFinalRed(), t.getFinalGreen(), t.getFinalBlue());
    }
    this.svg += result;
  }
}
