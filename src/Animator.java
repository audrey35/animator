import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import model.IAnimatorModel;
import model.IReadOnlyAnimatorModel;
import util.AnimationReader;
import util.ModelAdapter;
import view.SVGView;

public final class Animator {
  public static void main(String[] args) {
    //Parse inputs.
    String inPath = "";
    String viewType = "";
    String outPath = "System.out";
    int speed = 1;
    for (int i = 0; i < args.length; i += 2) {
      if (args[i].equalsIgnoreCase("-in")) {
        inPath = args[i + 1];
      } else if (args[i].equalsIgnoreCase("-view")) {
        viewType = args[i + 1];
      } else if (args[i].equalsIgnoreCase("-out")) {
        outPath = args[i + 1];
      } else if (args[i].equalsIgnoreCase("-speed")) {
        speed = Integer.parseInt(args[i + 1]);
      }
    }
    if (inPath.equalsIgnoreCase("")) {
      throw new IllegalArgumentException("Invalid command. The animation file name must be "
              + "defined.");
    }
    if (viewType.equalsIgnoreCase("")) {
      throw new IllegalArgumentException("Invalid command. The view type must be defined.");
    }

    //Start the Program.
    try {
      Readable animationFile = new FileReader(new File(inPath));
      IAnimatorModel model = AnimationReader.parseFile(animationFile, new ModelAdapter());
      model.setSpeed(speed);
      IReadOnlyAnimatorModel rModel = (IReadOnlyAnimatorModel) model;
      SVGView view = new SVGView(rModel, outPath);
      if (outPath.equals("System.out")) {
        view.render(outPath);
      } else {
        view.render(outPath);
      }
    } catch (FileNotFoundException f) {
      throw new IllegalArgumentException("The file was not found.");
    }
  }
}
