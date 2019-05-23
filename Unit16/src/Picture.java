
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  private static int offset =5;
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void encode(Picture messagePict)
  {
	 
  }
  /**
  * Method to decode a message hidden in the
  * red value of the current picture
  * @return the picture with the hidden message
  */
  public Picture decode()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int height = this.getHeight();
	  int width = this.getWidth();
	  Pixel currPixel = null;
	
	  Pixel messagePixel = null;
	  Picture messagePicture = new Picture(height,width);
	  Pixel[][] messagePixels = messagePicture.getPixels2D();
	  int count = 0;
	  for (int row = 0; row < this.getHeight(); row++){
		  for (int col = 0; col < this.getWidth(); col++){
			  currPixel = pixels[row][col];
			  messagePixel = messagePixels[row][col];
			  if (currPixel.getRed() % 2 == 1)
			  {
			  messagePixel.setColor(Color.BLACK);
			  count++;
			  }
		  }
	  }
	  System.out.println(count);
	  return messagePicture;
  }  
  
  public void encodeFives(Picture messagePic) {
	  Pixel[][] messagePixels = messagePic.getPixels2D();
	  Pixel[][] currPixels = this.getPixels2D();
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  int count = 0;
	  for (int row = 0; row < this.getHeight(); row++){
		  for (int col = 0; col < this.getWidth(); col++){
			  // if the ending digit of the R G or B value is 5 make it not 5
			  currPixel = currPixels[row][col];
			  messagePixel = messagePixels[row][col];
			  
			  if (currPixel.getRed() % 5 == 0 || currPixel.getRed() % 10 == 0 || currPixel.getRed() == 5)
				  currPixel.setRed(currPixel.getRed() - 1);
			  if (currPixel.getGreen() % 5 == 0 || currPixel.getGreen() % 10 == 0 || currPixel.getGreen() == 5)
				  currPixel.setGreen(currPixel.getGreen() - 1);
			  if (currPixel.getBlue() % 5 == 0 || currPixel.getBlue() % 10 == 0 || currPixel.getBlue() == 5)
				  currPixel.setBlue(currPixel.getBlue() - 1);
			  if (currPixel.getRed() == 0)
				  currPixel.setRed(1);
			  if (currPixel.getBlue() == 0)
				  currPixel.setBlue(1);
			  if (currPixel.getGreen() == 0)
				  currPixel.setGreen(1);
			  
			  if (messagePixel.colorDistance(Color.black) < 50)
			  {
				  int origVal; 
				  int one, two;
				  int closest = 0;
				  origVal = currPixel.getRed();
				  one = origVal;
				  two = origVal;
				  while (currPixel.getRed() % 5 != 0) {
					  one++;
					  if (one % 5 == 0) {
						  closest = one;
						  break;
					  }
					  two--;
					  if (two % 5 == 0) {
						  closest = two;
						  break;
					  }
				  }
				  currPixel.setRed(closest);
				  
				  origVal = currPixel.getBlue();
				  one = origVal;
				  two = origVal;
				  while (currPixel.getBlue() % 5 != 0) {
					  one++;
					  if (one % 5 == 0) {
						  closest = one;
						  break;
					  }
					  two--;
					  if (two % 5 == 0) {
						  closest = two;
						  break;
					  }
				  }
				  currPixel.setBlue(closest);
				  
				  origVal = currPixel.getGreen();
				  one = origVal;
				  two = origVal;
				  while (currPixel.getGreen() % 5 != 0) {
					  one++;
					  if (one % 5 == 0) {
						  closest = one;
						  break;
					  }
					  two--;
					  if (two % 5 == 0) {
						  closest = two;
						  break;
					  }
				  }
				  currPixel.setGreen(closest);
				  
				  
				  count++;
			  }
		  }
	  }
	  System.out.println(count);
  }
  
  public Picture decodeFives() {
	  Pixel[][] pixels = this.getPixels2D();
	  int height = this.getHeight();
	  int width = this.getWidth();
	  Pixel currPixel = null;
	
	  Pixel messagePixel = null;
	  Picture messagePicture = new Picture(height,width);
	  Pixel[][] messagePixels = messagePicture.getPixels2D();
	  int count = 0;
	  for (int row = 0; row < this.getHeight(); row++){
		  for (int col = 0; col < this.getWidth(); col++){
			  currPixel = pixels[row][col];
			  messagePixel = messagePixels[row][col];
			  if (currPixel.getRed() % 5 == 0)
			  {
			  messagePixel.setColor(Color.BLACK);
			  count++;
			  }
		  }
	  }
	  System.out.println(count);
	  return messagePicture;
  }
  /** Method to keep only blue value and set others to 0 */
  public void keepOnlyBlue() {
	  Pixel[][]pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels) {
		  for (Pixel pixelObj : rowArray) {
			  pixelObj.setGreen(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  /** Method to keep only red value and set others to 0 */
  public void keepOnlyRed() {
	  Pixel[][]pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels) {
		  for (Pixel pixelObj : rowArray) {
			  pixelObj.setGreen(0);
			  pixelObj.setBlue(0);
		  }
	  }
  }
  
  /** Method to keep only green value and set others to 0 */
  public void keepOnlyGreen() {
	  Pixel[][]pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels ) {
		  for (Pixel pixelObj : rowArray) {
			  pixelObj.setRed(0);
			  pixelObj.setBlue(0);
		  }
	  }
  }
  
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels ) {
		  for (Pixel pixelObj : rowArray) {
			  pixelObj.setRed(255-pixelObj.getRed());
			  pixelObj.setBlue(255-pixelObj.getBlue());
			  pixelObj.setGreen(255-pixelObj.getGreen());
		  }
	  }
  }
  
  public void grayscale() {
	  Pixel[][]pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels) {
		  for(Pixel pixelObj: rowArray) {
			  int avg = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed())/3;
			  pixelObj.setRed(avg);
			  pixelObj.setGreen(avg);
			  pixelObj.setBlue(avg);
		  }
	  }
  }
  
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels ) {
		  for(Pixel pixelObj : rowArray) {
			  if (pixelObj.getRed() <= 20 && (pixelObj.getBlue() >= 155 && pixelObj.getBlue() <= 175)) {
				  pixelObj.setBlue((int)(pixelObj.getBlue()/3));
			  }
			  if (pixelObj.getRed() <= 20 && (pixelObj.getBlue() >=176 && pixelObj.getBlue()<=200) ) {
				  pixelObj.setGreen((int)(pixelObj.getGreen()/3));
			  }
			  
		  }
	  }
  }
  

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** Mirror just the snowmen's arm */
  public void mirrorArms() {
	int rowTop = 160;
	int rowBot = 192;
	  
	int colLeft = 106;
	int colRight = 171;
	
	int widthBetween = 70 + (colRight-colLeft);

	mirrorSquare(colLeft,colRight,rowTop,rowBot,-8,68);
	mirrorSquare(colLeft+widthBetween,colRight + widthBetween, rowTop,rowBot,4,68);
  }
  
  /**Method that duplicates a seagull in a picture
   * so that there are two seagulls near eachother */
  public void mirrorGull() {
	int rowTop = 236;
	int rowBot = 325;	  
	int colLeft = 239;
	int colRight = 345;
	int width = colRight-colLeft;
		
	mirrorSquare(colLeft, colRight, rowTop, rowBot, -5 -width,0); 
  }
  public void blueTinge() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] row: pixels ) {
		  for(Pixel col: row) {
			  if(col.getBlue() != 255) {
				  col.setBlue(col.getBlue()+150);
				  col.setGreen((int)(col.getGreen()/2));
				  col.setRed((int)(col.getRed()/2));
			  }
		  }
	  }
  }
  public void mirrorSquare(int x1, int x2, int y1, int y2, int xShift, int yShift) {
  
	int colLeft = x1;
	int colRight = x2;
	int rowTop = y1;
	int rowBot = y2;


	Pixel pixelOne = null;
	Pixel pixelTwo = null;
	Pixel[][] pixels = this.getPixels2D();
		  
	for(int col = colLeft ; col < colRight; col++) {
		for (int row = rowTop; row < rowBot; row++) {
			pixelOne = pixels[row][col];
			pixelTwo = pixels[row + yShift][col+xShift];
			pixelTwo.setColor(pixelOne.getColor());
		}
	}
  }
  /** Method that mirrors the picture around a 
   * vertical mirror in the center of the picture
   * from left to right */
 public void mirrorVertical()
 {
   Pixel[][] pixels = this.getPixels2D();
   Pixel leftPixel = null;
   Pixel rightPixel = null;
   int width = pixels[0].length;
   for (int row = 0; row < pixels.length; row++)
   {
     for (int col = 0; col < width / 2; col++)
     {
       leftPixel = pixels[row][col];
       rightPixel = pixels[row][width - 1 - col];
       rightPixel.setColor(leftPixel.getColor());
     }
   } 
 }
 
 /** Method that mirrors the picture around a
  * vertical mirror in the center of the picture
  * from right to left */
 public void mirrorVerticalRightToLeft() {
	 Pixel[][] pixels = this.getPixels2D();
	 Pixel leftPixel = null;
	 Pixel rightPixel = null;
	 int width = pixels[0].length;
	 for(int row = 0; row < pixels.length; row++) {
		 for(int col = 0; col < width /2; col++) {
			 leftPixel = pixels[row][col];
			 rightPixel = pixels[row][width - 1 - col];
			 leftPixel.setColor(rightPixel.getColor());
		 }
	 }
 }
  
 /** Method that mirrors the picture around a
  * horizontal mirror in the center of the picture
  * from top to bottom */
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for (int col = 0; col < pixels[0].length; col++) {
		  for(int row = 0; row < height /2; row++) {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - 1 - row][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  /** Method that mirrors the picture around a
   * horizontal mirror in the center of the picture
   * from top to bottom */
   public void mirrorHorizontalBotToTop() {
 	  Pixel[][] pixels = this.getPixels2D();
 	  Pixel topPixel = null;
 	  Pixel bottomPixel = null;
 	  int height = pixels.length;
 	  for (int col = 0; col < pixels[0].length; col++) {
 		  for(int row = 0; row < height /2; row++) {
 			  topPixel = pixels[row][col];
 			  bottomPixel = pixels[height - 1 - row][col];
 			  topPixel.setColor(bottomPixel.getColor());
 		  }
 	  }
   }
 /**Method that mirrors diagonal
  * 
  */
   public void mirrorDiagonal() {
	   Pixel[][]pixels = this.getPixels2D();
	   Pixel bottomPixel = null;
	   Pixel topPixel = null;
	   int height = pixels.length;
	   if (pixels.length > pixels[0].length) {
		   height = pixels[0].length;
	   }
	   for(int col = 0; col < height; col++) {
		   for (int row = 0; row < height; row++) {
			   bottomPixel = pixels[row][col];
			   topPixel = pixels[col][row];
			   topPixel.setColor(bottomPixel.getColor());
		   }
	   }
   }
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, int startRow, int startCol)
   {
	 Pixel fromPixel = null;
	 Pixel toPixel = null;
	 Pixel[][] toPixels = this.getPixels2D();
	 Pixel[][] fromPixels = fromPic.getPixels2D();
     
     for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++){
       for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++){
         fromPixel = fromPixels[fromRow][fromCol];
         toPixel = toPixels[toRow][toCol];
         toPixel.setColor(fromPixel.getColor());
       }
     }   
   }
  
  public void copy(Picture fromPic, int startRow, int startCol, int startX, int endX, int startY, int endY)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    
    for (int fromRow = startY, toRow = startRow; fromRow < endY && toRow < toPixels.length; fromRow++, toRow++){
      for (int fromCol = startX, toCol = startCol; fromCol < endX && toCol < toPixels[0].length; fromCol++, toCol++){
    	fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  /**Method to create my collage of several pictures */
  public void myCollage() {
	  
	  int width = 294-99;
	  Picture snowman1 = new Picture("snowman.jpg");
	  snowman1.keepOnlyRed();
	  Picture snowman2 = new Picture("snowman.jpg");
	  snowman2.mirrorArms();
	  snowman2.keepOnlyGreen();
	  snowman2.mirrorVertical();
	  Picture snowman3 = new Picture("snowman.jpg");
	  snowman3.keepOnlyBlue();
	  this.copy(snowman1, offset, offset, 99, 294, 79, 298);
	  this.copy(snowman2, offset, 5-offset+ width, 99, 294, 79, 298);
	  this.copy(snowman3, offset, 10+offset+ width+width, 99, 294, 79, 298);
	  this.mirrorHorizontal();
	  this.negate();
	  this.write("C:\\Users\\candelal0514\\Pictures\\New folder\\myCollage.jpg");
	  offset += 5;
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int edgeDist){
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel bottomPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  Color bottomColor = null;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; 
	           col < pixels[0].length-1; col++)
	      {
	    	if(row != pixels.length-1) {
	    		bottomPixel = pixels[row+1][col];
	    	}
	    	else {
	    		bottomPixel = pixels[row][col];
	    	}
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][col+1];
	        bottomColor = bottomPixel.getColor();
	        rightColor = rightPixel.getColor();
	        if (leftPixel.colorDistance(rightColor) > 
	            edgeDist || (leftPixel.colorDistance(bottomColor)  > edgeDist))
	          leftPixel.setColor(Color.BLACK);
	        else
	          leftPixel.setColor(new Color(179, 236, 255));
	      }
	    }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("snowman.jpg");
    beach.explore();
    beach.mirrorArms();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
