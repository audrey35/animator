# Animator

Objective is to create an animator that can read from a text file and generate an svg or an animation.

## How to run the program from the command line
1. Create animator.jar file by
- go to File -> Project Structure
- go to Artifacts
- add a JAR -> From modules with dependencies...
- choose Animator as the Main Class -> OK
- check Include in Project Build -> OK
2. From the command line, navigate to out/artifacts/animator_jar or the folder containing the jar file created.
3. Run the commands below to create svg files:
- java -jar animator.jar -in smalldemo.txt -view svg -out smalldemo.svg
- java -jar animator.jar -in buildings.txt -view svg -out buildings.svg
- java -jar animator.jar -in hanoi.txt -view svg -out hanoi.svg
- java -jar animator.jar -in toh-3.txt -view svg -out toh-3.svg
- java -jar animator.jar -in toh-5.txt -view svg -out toh-5.svg
- java -jar animator.jar -in toh-8.txt -view svg -out toh-8.svg
- java -jar animator.jar -in toh-12.txt -view svg -out toh-12.svg
- java -jar animator.jar -in big-bang-big-crunch.txt -view svg -out big-bang-big-crunch.svg
4. Run the commands below to see an animation:
- java -jar animator.jar -in smalldemo.txt -view visual
- java -jar animator.jar -in buildings.txt -view visual
- java -jar animator.jar -in hanoi.txt -view visual
- java -jar animator.jar -in toh-3.txt -view visual
- java -jar animator.jar -in toh-5.txt -view visual
- java -jar animator.jar -in toh-8.txt -view visual
- java -jar animator.jar -in toh-12.txt -view visual
- java -jar animator.jar -in big-bang-big-crunch.txt -view visual