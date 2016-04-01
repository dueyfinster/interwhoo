package com.ngrogan.array_flatten;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayFlattererTest {

     @Test
     public void flatArray(){
         int[] flatArray = {1};
         List<Object> objList = new ArrayList<>();
         objList.add(flatArray);
         
         ArrayFlatterer arrayFlatterer = new ArrayFlatterer();
         List<Integer> allIntegersInArrays = arrayFlatterer.flattenNestedArrays(objList);
         
         assertEquals(allIntegersInArrays.get(0).intValue(), flatArray[0]);
     }

     @Test
     public void twoDimesionalArray(){
         int[][] twoDArray = {{2}, {3, 4}};
         List<Object> objList = new ArrayList<>();
         objList.add(twoDArray);
         
         ArrayFlatterer arrayFlatterer = new ArrayFlatterer();
         List<Integer> allIntegersInArrays = arrayFlatterer.flattenNestedArrays(objList);
         
         assertEquals(allIntegersInArrays.get(0).intValue(), twoDArray[0][0]);
         assertEquals(allIntegersInArrays.get(1).intValue(), twoDArray[1][0]);
         assertEquals(allIntegersInArrays.get(2).intValue(), twoDArray[1][1]);
     }
     
     
     @Test
     public void threeNestedArray(){
         Object[][] multiDArray = {{5}, {6, 7, new Object[] {new int[] {8, 9}}}};
         List<Object> objList = new ArrayList<>();
         objList.add(multiDArray);
         
         ArrayFlatterer arrayFlatterer = new ArrayFlatterer();
         List<Integer> allIntegersInArrays = arrayFlatterer.flattenNestedArrays(objList);

         assertEquals(allIntegersInArrays.get(0).intValue(), multiDArray[0][0]);
         assertEquals(allIntegersInArrays.get(1).intValue(), multiDArray[1][0]);
         assertEquals(allIntegersInArrays.get(2).intValue(), multiDArray[1][1]);

         Object[] nestedArray = (Object[]) multiDArray[1][2];
         int[] integerArray = (int[]) nestedArray[0];
         assertEquals(allIntegersInArrays.get(3).intValue(), integerArray[0]);
         assertEquals(allIntegersInArrays.get(4).intValue(), integerArray[1]);
     }
}
