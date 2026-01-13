class Solution {
    public double separateSquares(int[][] squares) {
        // Find the range of y values
        double minY = 0;
        double maxY = 0;
        
        for (int[] square : squares) {
            minY = Math.min(minY, square[1]);
            maxY = Math.max(maxY, square[1] + square[2]);
        }
        
        // Binary search for the line position
        double left = minY;
        double right = maxY;
        
        while (right - left > 1e-5) {
            double mid = (left + right) / 2;
            
            // Calculate area below and above the line
            double areaBelow = 0;
            double areaAbove = 0;
            
            for (int[] square : squares) {
                int x = square[0];
                int y = square[1];
                int l = square[2];
                
                double squareBottom = y;
                double squareTop = y + l;
                
                if (squareTop <= mid) {
                    // Entire square is below the line
                    areaBelow += (long) l * l;
                } else if (squareBottom >= mid) {
                    // Entire square is above the line
                    areaAbove += (long) l * l;
                } else {
                    // Square is split by the line
                    double heightBelow = mid - squareBottom;
                    double heightAbove = squareTop - mid;
                    
                    areaBelow += heightBelow * l;
                    areaAbove += heightAbove * l;
                }
            }
            
            if (areaBelow < areaAbove) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return (left + right) / 2;
    }
}