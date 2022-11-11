package com.shpp.p2p.cs.kservetnyk.assignment6.tm;

public class ToneMatrixLogic {
    /**
     * Given the contents of the tone matrix, returns a string of notes that should be played
     * to represent that matrix.
     *
     * @param toneMatrix The contents of the tone matrix.
     * @param column     The column number that is currently being played.
     * @param samples    The sound samples associated with each row.
     * @return A sound sample corresponding to all notes currently being played.
     */
    public static double[] matrixToMusic(boolean[][] toneMatrix, int column, double[][] samples) {
        double[] result = new double[ToneMatrixConstants.sampleSize()];

        // Iterating through the array
        for (int i = 0; i < toneMatrix.length; i++){
            // Checks which column plays
            if (toneMatrix[i][column]) {
                for (int k = 0; k < result.length; k++) {
                    // Pass in the sound to the result array
                    result[k] += samples[i][k];
                }
            }
        }

        double intensiveValue = mostIntensive(result);
        for (int i = 0; i < result.length; i++) {
            // Normalizing the array between -1 and 1
            if (result[i] > 0 || result[i] < 0) {
                result[i] = result[i] / intensiveValue;
            }
        }

        return result;
    }

    /**
     * Method that goes through the whole array and look for the most intensive value
     *
     * @param array which shall be checked
     * @return the most intensive value
     */
    public static double mostIntensive(double[] array) {
        double intensive = array[0];

        for (double num : array) {
            if (Math.abs(intensive) < Math.abs(num))
                intensive = num;
        }

        return intensive;
    }
}
