
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue() {
	  Picture p = new Picture("beach.jpg");
	  p.explore();
	  p.keepOnlyBlue();
	  p.explore();
  }
  
  /**Method to test keepOnlyRed */
  public static void testKeepOnlyRed() {
	  Picture p = new Picture("beach.jpg");
	  p.explore();
	  p.keepOnlyRed();
	  p.explore();
  }
  
  /**Method to test keepOnlyGreen */
  public static void testKeepOnlyGreen() {
	  Picture p = new Picture("beach.jpg");
	  p.explore();
	  p.keepOnlyGreen();
	  p.explore();
  }
  
  /**Method to test negate */
  public static void testNegate() {
	  Picture p = new Picture ("beach.jpg");
	  p.explore();
	  p.negate();
	  p.explore();
  }
  
  /**Method to test grayscale */
   public static void testGrayscale() {
	   Picture p = new Picture ("beach.jpg");
	   p.explore();
	   p.grayscale();
	   p.explore();
   }
  
  /**Method to test fixUnderwater */
   public static void testFixUnderwater() {
	   Picture p = new Picture ("water.jpg");
	   p.explore();
	   p.fixUnderwater();
	   p.explore();
   }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /**Method to test mirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft() {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorVerticalRightToLeft();
	  caterpillar.explore();
  }
  
  /** Method to test mirrorHorizontal() */
  public static void testMirrorHorizontal() {
	  Picture m = new Picture("redMotorcycle.jpg");
	  m.explore();
	  m.mirrorHorizontal();
	  m.explore();
  }
  
  /** Method to test mirrorHorizontalBotToTop() */
  public static void testMirrorHorizontalBotToTop() {
	  Picture m = new Picture("redMotorcycle.jpg");
	  m.explore();
	  m.mirrorHorizontalBotToTop();
	  m.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test mirrorArms */
  public static void testMirrorArms() {
	  Picture s = new Picture("snowman.jpg");
	  s.explore();
	  s.mirrorArms();
	  s.explore();
  }
  
  /** Method to test mirrorGull */
  public static void testMirrorGull() {
	  Picture s = new Picture("seagull.jpg");
	  s.explore();
	  s.mirrorGull();
	  s.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test copy portion */
  public static void testCopy() {
	  Picture canvas = new Picture("640x480.jpg");
	  Picture other = new Picture("seagull.jpg");
	  canvas.copy(other, 20, 20, 237, 345, 234, 320);
	  canvas.explore();
  }
  /** Method to test myCollage */
  public static void testMyCollage() {
	  Picture canvas = new Picture("640x480.jpg");
	  canvas.myCollage();
	  canvas.explore();
	  
	  for(int i = 0; i < 5; i++) {
		  canvas = new Picture("C:\\Users\\candelal0514\\Pictures\\New folder\\myCollage.jpg");
		  canvas.myCollage();
	  }
	  canvas.explore();
	  
  }
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(20);
    swan.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection(20);
    swan.explore();
    swan = new Picture("swan.jpg");
    swan.edgeDetection2(20);
    swan.explore();
  }
  
  public static void testMirrorDiagonal() {
	  Picture beach = new Picture("wall.jpg");
	  beach.explore();
	  beach.mirrorDiagonal();
	  beach.explore();
  }
  
  public static void test() {
	  Picture mj = new Picture("wall.jpg");
	  mj.explore();
	  mj.mirrorDiagonal();
	  mj.mirrorHorizontal();
	  mj.mirrorVertical();
	  mj.explore();
	  mj.edgeDetection2(20);
	  mj.negate();
	  mj.blueTinge();
	  mj.explore();
	  mj.write("H:\\michael.jpg");
  }
  
  public static void testEncoding() {
	  Picture beach = new Picture("beach.jpg");
	  beach.setTitle("original image");
	  beach.explore();
	  
	  Picture hiddenMsg = new Picture ("pika.jpg");
	  hiddenMsg.setTitle("original Message");
	  hiddenMsg.explore();
	  
	  
	  beach.encodeFives(hiddenMsg);
	  Picture encoded = beach;
	  encoded.setTitle("encoded image");
	   
	  encoded.explore();
	  Picture decoded = beach.decodeFives();
	  decoded.setTitle("decoded image");
	  decoded.explore();
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	testEncoding();
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
	//testMirrorTemple();
    //testMirrorArms();
	//testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testMyCollage();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}