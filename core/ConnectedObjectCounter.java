package core;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.function.Predicate;


/**
 * A class that counts connected objects in an image by providing a color predicate
 */
public abstract class ConnectedObjectCounter implements ImageObjectCounter {

    private final Predicate<Integer> colorPredicate;

    public ConnectedObjectCounter(Predicate<Integer> colorPredicate) {
        this.colorPredicate = colorPredicate;
    }

    public abstract boolean isValidObject(ImageObject imageObject);

    /**
     * Returns number of connected objects in an image from an image path
     * @param bufferedImage
     * @return number of connected objects in an image
     */
    @Override
    public int count(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth(), m = bufferedImage.getHeight();
        
        boolean[][] visited = new boolean[m][n];
        
        int numberOfObjects = 0;
        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                if(!visited[row][col] && colorPredicate.test(bufferedImage.getRGB(col, row))) {
                    numberOfObjects++;
                    dfs(bufferedImage, col, row, n, m, visited);
                }
            }
        }
        return numberOfObjects;
    }

    /**
     * An iterative depth-first-search (DFS) algorithm that visits all connected colored pixels
     * @param image - buffered image
     * @param x - x coordinate of the pixel
     * @param y - y coordinate of the pixel
     * @param n - width of an image
     * @param m - height of an image
     * @param visited - 2d array representation of visited pixels
     */
    private void dfs(BufferedImage image, int x, int y, int n, int m, boolean[][] visited) {

        // potential neighbours directions
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        // stack to keep track of the unvisited-connected pixels
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y});

        while(!stack.isEmpty()) {
            int[] curr = stack.pop();
            int currX = curr[0];
            int currY = curr[1];

            // mark pixel as visited
            visited[currY][currX] = true;

            // explore 4 neighbours
            for(int[] dir : dirs) {
                
                int newX = currX + dir[0];
                int newY = currY + dir[1];

                // ignore visited, not-same-color, or out-of-boundary neighbours
                if((newX < 0 || newX >= n || newY < 0 || newY >= m) || visited[newY][newX] || !colorPredicate.test(image.getRGB(newX, newY))) {
                    continue;
                }

                stack.push(new int[]{newX, newY}); 
            }
        }
    }

}