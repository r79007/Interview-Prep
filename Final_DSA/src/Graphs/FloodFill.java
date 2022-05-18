package Graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startPixel = image[sr][sc];
        colorPixel(image,sr,sc,newColor,startPixel);
        return image;
    }

    public void colorPixel(int[][] image, int sr, int sc, int newColor,int startPixel){

        if(image[sr][sc] == newColor)
            return;

        int[] directions = {0,-1,0,1,0};

        image[sr][sc] = newColor;

        for(int i=0;i<4;i++){
            int dr = directions[i] + sr;
            int dc = directions[i+1] + sc;
            if(dr>=0 && dr<image.length && dc>=0 && dc<image[0].length){
                if(startPixel == image[dr][dc])
                    colorPixel(image,dr,dc,newColor,startPixel);
            }
        }

    }
}
