/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeanscba;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author user
 */

public class knncoba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        koneksi kon = new koneksi();
        ArrayList arr = kon.getname();
        int[][] data = kon.matrix();
        int[] caracter = {45,66,57,100};
        double[] rank = euclidiean(caracter,data);
        int k=5;
        double[] nbhr = new double[rank.length];
        System.arraycopy(rank, 0, nbhr, 0, nbhr.length);
        Arrays.sort(nbhr);
        for(int i=0;i<k;i++){
            for(int j=0;j<rank.length;j++){
                if(nbhr[i]==rank[j]){
                    System.out.println(arr.get(j)+" :"+Arrays.toString(data[j])+" Distance :"+rank[j]);
                }
            }
        }
        
        
        
        
    }
   public static double[] euclidiean(int[] caracter,int[][] data){
       double[] distance = new double[data.length];
        for(int i=0;i<data.length;i++){
            double sum=0;
             for(int j=0;j<caracter.length;j++){
                 sum+=Math.pow((data[i][j]-caracter[j]),2);
             }
             distance[i]=Math.sqrt(sum);
             //System.out.println(Math.sqrt(sum));
        }
        return distance;
   }
    
}
