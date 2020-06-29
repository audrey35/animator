import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.keyframe.IKeyframe;
import model.transformation.ITransformation;
import model.keyframe.Keyframe;
import model.transformation.MoveTransformation;

public class AnimatorModelTest {
  @Test
  public void testCompareTo() {
    IKeyframe keyframe = new Keyframe("test", 1, 1, 1, 1, 1, 1, 1, 1);
    IKeyframe compared = new Keyframe("test2", 10, 10, 10, 10, 10, 10, 10, 10);
    IKeyframe compared2 = new Keyframe("test2", 100, 100, 100, 100, 100, 100, 100, 100);
    List<IKeyframe> keyframes = new ArrayList<>();
    keyframes.add(compared);
    keyframes.add(compared2);
    keyframes.add(keyframe);
    System.out.printf("%d %d %d\n", keyframes.get(0).getTime(), keyframes.get(1).getTime(),
            keyframes.get(2).getTime());
    Collections.sort(keyframes);
    System.out.printf("%d %d %d\n", keyframes.get(0).getTime(), keyframes.get(1).getTime(),
            keyframes.get(2).getTime());
  }

  @Test
  public void testTransformationCompareTo() {
    ITransformation transformation = new MoveTransformation("test", 1, 1, 1, 1, 1, 1, 1, 1,
            2, 2, 2, 1, 1, 1, 1, 1);
    ITransformation compared = new MoveTransformation("test2", 10, 10, 10, 10, 10, 10, 10, 10,
            2, 2, 2, 1, 1, 1, 1, 1);
    ITransformation compared2 = new MoveTransformation("test2", 100, 100, 100, 100, 100, 100, 100,
            100, 2, 2, 2, 1, 1, 1, 1, 1);
    List<ITransformation> transformations = new ArrayList<>();
    transformations.add(compared);
    transformations.add(compared2);
    transformations.add(transformation);
    System.out.printf("%d %d %d\n", transformations.get(0).getInitialTime(),
            transformations.get(1).getInitialTime(), transformations.get(2).getInitialTime());
    Collections.sort(transformations);
    System.out.printf("%d %d %d\n", transformations.get(0).getInitialTime(),
            transformations.get(1).getInitialTime(), transformations.get(2).getInitialTime());
  }
}