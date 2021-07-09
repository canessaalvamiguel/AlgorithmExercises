/*
* Write a function that takes in a "special" array and returns its product sum.

  A "special" array is a non-empty array that contains either integers or other
  "special" arrays. The product sum of a "special" array is the sum of its
  elements, where "special" arrays inside it are summed themselves and then
  multiplied by their level of depth.

  The depth of a "special" array is how far nested it is. For instance, the
  depth of [] is 1; the depth of the inner array in
  [[]] is 2; the depth of the innermost array in
  [[[]]] is 3.
</p>
<p>
  Therefore, the product sum of [x, y] is x + y; the
  product sum of [x, [y, z]] is x + 2 * (y + z); the
  product sum of [x, [y, [z]]] is x + 2 * (y + 3z).
</p>
Sample Input
<span class="CodeEditor-promptParameter">array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]

Sample Output
12 // calculated as: 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)*/

package algoexpert;

import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static void main(String[] args){
        List<Object> l1 = new ArrayList<>();
        l1.add(7);
        l1.add(-1);

        List<Object> l2 = new ArrayList<>();
        l2.add(-13);
        l2.add(8);

        List<Object> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(l2);
        l3.add(4);

        List<Object> l4 = new ArrayList<>();
        l4.add(5);
        l4.add(2);
        l4.add(l1);
        l4.add(3);
        l4.add(l3);

        System.out.println(productSum(l4));
    }

    public static int productHelper(List<Object> array, int multiplier){
        int sum = 0;
        for (Object obj : array){
            if( obj instanceof ArrayList){
                ArrayList<Object> ls = (ArrayList<Object>) obj;
                sum += productHelper(ls, multiplier + 1);
            }else{
                sum += (int) obj;
            }
        }
        return sum * multiplier;
    }

    public static int productSum(List<Object> array) {
        return productHelper(array, 1);
    }
}
