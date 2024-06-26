import processing.core.PApplet;

public class Sketch extends PApplet {

  int intredCount = 0;
  int intblueCount = 0;

  public void settings() {
    size(800, 800); 
  }

  public void setup() {
    background(210, 255, 173);
    drawGrid();
  }

  public void drawGrid() {

   noLoop();

    int intsmileyWidth = width / 10; 
    int intsmileyHeight = height / 10; 

    int intgapX = intsmileyWidth / 5; 
    int intgapY = intsmileyHeight / 5; 

    // rows of smiley faces
    for (double i = 0.2; i < 8; i++) {
      for (double j = 0.2; j < 8; j++) {
        int x = (int)(i * (intsmileyWidth + intgapX) + intsmileyWidth / 2);
        int y = (int)(j * (intsmileyHeight + intgapY) + intsmileyHeight / 2);

        // Drawing the smiley faces
        drawSmileyFace(x, y, intsmileyWidth, intsmileyHeight);

        // Drawing the circles
        if (i < 10) {
          int circleX = x + (intsmileyWidth + intgapX) / 2;
          int circleY = y;
          
          // Randomize color to be either red or blue (Columns)
          float[] color = getRandomColor();
          drawCircle(circleX, circleY, intgapX / 2, color[0], color[1], color[2]);
          if (color[0] == 255) {
            intredCount++;
          } else {
            intblueCount++;
          }
        }
        if (j < 10) {
          int circleX = x;
          int circleY = y + (intsmileyHeight + intgapY) / 2;

          // Randomize color to be either red or blue (Rows)
          float[] color = getRandomColor();
          drawCircle(circleX, circleY, intgapY / 2, color[0], color[1], color[2]);
          if (color[0] == 255) {
            intredCount++;
          } else {
            intblueCount++;
          }
        }
      }
    }

    // Depending on how the amount of red or blue circles, the smiley face changes
    if (intredCount > intblueCount) {
      fill(0, 255, 0); // Green
    } else if (intblueCount > intredCount) {
      fill(255, 0, 0); // Red
    } else {
      fill(139, 69, 19); // Brown (very rare)
    }

    // Draw arcs for each smiley face
    for (double i = 0.2; i < 8; i++) {
      for (double j = 0.2; j < 8; j++) {
        int x = (int)(i * (intsmileyWidth + intgapX) + intsmileyWidth / 2);
        int y = (int)(j * (intsmileyHeight + intgapY) + intsmileyHeight / 2);

        int arcX = x;
        int arcY = y + intsmileyHeight / 10;
        int arcWidth = intsmileyWidth / 2;
        int arcHeight = intsmileyHeight / 4;
        arc(arcX, arcY, arcWidth, arcHeight, 0, PI);
      }
    }
  }

  public void drawSmileyFace(int x, int y, int width, int height) {

    // Drawing the smiley face
    fill(255, 255, 0);
    ellipse(x, y, width, height);
    fill(0);
    ellipse(x - width / 4, y - height / 6, width / 6, width / 6);
    ellipse(x + width / 4, y - height / 6, width / 6, width / 6);
  }

  public void drawCircle(int x, int y, int diameter, float r, float g, float b) {

    // Drawing the circles
    fill(r, g, b);
    ellipse(x, y, diameter, diameter);
  }

  public float[] getRandomColor() {
    float[] color = new float[3];
    // Randomly choose between red and blue
    if (random(1) > 0.5) {
      color[0] = 255; // Red
      color[1] = 0;
      color[2] = 0;
    } else {
      color[0] = 0; // Blue
      color[1] = 0;
      color[2] = 255;
    }
    return color;
  }
}
