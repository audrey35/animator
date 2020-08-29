package com.portfolio.animator.generator;

import com.portfolio.animator.generator.model.IAnimatorModel;
import com.portfolio.animator.generator.model.IReadOnlyAnimatorModel;
import com.portfolio.animator.generator.util.AnimationReader;
import com.portfolio.animator.generator.util.ModelAdapter;
import com.portfolio.animator.generator.view.SVGView;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorService {

    public List<String> getAnimationNames() {
        List<String> options = new ArrayList<>();
        options.add("City At Night");
        options.add("Big Bang");
        options.add("Simple Shapes");
        options.add("Towers of Hanoi");
        options.add("3 Towers of Hanoi");
        options.add("5 Towers of Hanoi");
        options.add("8 Towers of Hanoi");
        options.add("12 Towers of Hanoi");
        return options;
    }

    public List<String> getAnimations() {
        List<String> animations = new ArrayList<>();
        animations.add(this.getAnimation("buildings.txt"));
        animations.add(this.getAnimation("big-bang-big-crunch.txt"));
        animations.add(this.getAnimation("smalldemo.txt"));
        animations.add(this.getAnimation("hanoi.txt"));
        animations.add(this.getAnimation("toh-3.txt"));
        animations.add(this.getAnimation("toh-5.txt"));
        animations.add(this.getAnimation("toh-8.txt"));
        animations.add(this.getAnimation("toh-12.txt"));
        return animations;
    }

    private String getAnimation(String filename) {
        try {
            String filepath = "src/main/java/com/portfolio/animator/generator/data/" + filename;
            Readable animationFile = new FileReader(new File(filepath));
            IAnimatorModel model = AnimationReader.parseFile(animationFile, new ModelAdapter());
            model.setSpeed(1);
            IReadOnlyAnimatorModel rModel = (IReadOnlyAnimatorModel) model;
            SVGView view = new SVGView(rModel);
            return view.toString();
        } catch (
                FileNotFoundException f) {
            throw new IllegalArgumentException("The file was not found.");
        }
    }
}
