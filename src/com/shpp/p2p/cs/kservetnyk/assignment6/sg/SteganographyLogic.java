package com.shpp.p2p.cs.kservetnyk.assignment6.sg;

import acm.graphics.GImage;

public class SteganographyLogic {
    /**
     * Given a GImage containing a hidden message, finds the hidden message
     * contained within it and returns a boolean array containing that message.
     * <p/>
     * A message has been hidden in the input image as follows.  For each pixel
     * in the image, if that pixel has a red component that is an even number,
     * the message value at that pixel is false.  If the red component is an odd
     * number, the message value at that pixel is true.
     *
     * @param source The image containing the hidden message.
     * @return The hidden message, expressed as a boolean array.
     */
    public static boolean[][] findMessage(GImage source) {

        int[][] pixel = source.getPixelArray();
        int width = pixel.length;
        int height = pixel[0].length;
        boolean[][] message = new boolean[width][height];

        // Goes through the array and check if the pixel from red chanel is odd return true to the message
        for (int row = 0; row < pixel.length; row++) {
            for (int col = 0; col < pixel[row].length; col++) {
                message[row][col] = GImage.getRed(pixel[row][col]) % 2 != 0;
            }
        }
        return message;
    }

    /**
     * Hides the given message inside the specified image.
     * <p/>
     * The image will be given to you as a GImage of some size, and the message will
     * be specified as a boolean array of pixels, where each white pixel is denoted
     * false and each black pixel is denoted true.
     * <p/>
     * The message should be hidden in the image by adjusting the red channel of all
     * the pixels in the original image.  For each pixel in the original image, you
     * should make the red channel an even number if the message color is white at
     * that position, and odd otherwise.
     * <p/>
     * You can assume that the dimensions of the message and the image are the same.
     * <p/>
     *
     * @param message The message to hide.
     * @param source  The source image.
     * @return A GImage whose pixels have the message hidden within it.
     */
    public static GImage hideMessage(boolean[][] message, GImage source) {

        int[][] pixel = source.getPixelArray();
        GImage hiddenMessage;


        for (int row = 0; row < pixel.length; row++) {
            for (int col = 0; col < pixel[row].length; col++) {
                creatingNewPixel(row, col, pixel, message);
            }
        }

        hiddenMessage = new GImage(pixel);

        return hiddenMessage;
    }

    /**
     * Method that creates new pixels. If the pixel of the secret image is black,
     * it makes the red value of the pixel of the color image odd. If the pixel is white, makes it even.
     *
     * @param row  - number of current row.
     * @param col - number of current column.
     * @param pixel - array of pixels of our picture.
     * @param message - the secret image.
     */
    private static void creatingNewPixel(int row, int col, int[][] pixel, boolean[][] message){

        int red = GImage.getRed(pixel[row][col]);
        int green = GImage.getGreen(pixel[row][col]);
        int blue = GImage.getBlue(pixel[row][col]);

        // If the secret image is true, makes the red value odd
        if (red % 2 == 0 && message[row][col]) red += 1;

        // If the secret image is false, makes the red value even
        else if (red % 2 != 0 && !message[row][col]) {

            // Check borders 255 and 0
            if (red == 255) red -= 1;
            else if (red >= 0) red += 1;
        }

        pixel[row][col] = GImage.createRGBPixel(red, green, blue);
    }
}
