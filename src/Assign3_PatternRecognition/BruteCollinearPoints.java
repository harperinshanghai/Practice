package Assign3_PatternRecognition;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BruteCollinearPoints {

    private int num = 0;
    private LineSegment[] segmentsArray;

    /**
     * finds all line segments containing 4 points
     * @param points
     */
    public BruteCollinearPoints(Point[] points){
        validate(points);
        int N = points.length;

        Arrays.sort(points);


        for (int i = 0; i < N - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0)
                throw new IllegalArgumentException("contain a repeated point");
        }

        segmentsArray = new LineSegment[4 * N];

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    for (int t = k + 1; t < N; t++) {

                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) &&
                                points[i].slopeTo(points[j]) == points[i].slopeTo(points[t])) {

                            LineSegment lineSegment = new LineSegment(points[i], points[t]);
                            segmentsArray[num] = lineSegment;
                            num++;
                        }

                    }
                }
            }
        }
    }

    private void validate(Point[] points){
        if (points == null)
            throw new IllegalArgumentException("array is null");
        for (int i = 0; i < points.length; i++){
            if (points[i] == null)
                throw new IllegalArgumentException("point is null");
        }
    }

    /**
     * the number of line segments
     * @return
     */
    public int numberOfSegments(){
        return num;
    }

    /**
     * the line segments
     * @return
     */
    public LineSegment[] segments(){
        LineSegment[] lineSegments = new LineSegment[num];
        if(num > 0) {
            System.arraycopy(segmentsArray, 0, lineSegments, 0, num);
            return lineSegments;
        }
        return null;
    }


    public static void main(String[] args){
        In in =  new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++){
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x,y);
        }

        //  draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0 ,32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points){
            p.draw();
        }
        StdDraw.show();

        //  print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        if (collinear.segments() != null) {
            for (LineSegment segment : collinear.segments()) {
                StdOut.println(segment);
                segment.draw();
            }
            StdDraw.show();
        }

    }
}
