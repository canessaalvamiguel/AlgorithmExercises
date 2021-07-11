package algoexpert;

public class BSTConstruction {

    public static void main(String[] args){
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        root.insert_algoexpert(12);
        System.out.println("root.right.left.left.value: "+root.right.left.left.value);
        //Utils.assertTrue(root.right.left.left.value == 12);

        root.remove_algoexpert(10);
        System.out.println("root.contains(10): "+root.contains_algoexpert(10));
        System.out.println("root.value: "+root.value);
        //Utils.assertTrue(root.contains(10) == false);
        //Utils.assertTrue(root.value == 12);

        System.out.println("root.contains(15): "+root.contains_algoexpert(15));
        //Utils.assertTrue(root.contains(15));
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert_algoexpert(int value) {
            BST currentNode = this;
            while(true){
                if( value < currentNode.value){
                    if(currentNode.left == null){
                        BST newNode = new BST(value);
                        currentNode.left = newNode;
                        break;
                    }else{
                        currentNode = currentNode.left;
                    }
                }else{
                    if(currentNode.right == null){
                        BST newNode = new BST(value);
                        currentNode.right = newNode;
                        break;
                    }else{
                        currentNode = currentNode.right;
                    }
                }
            }

            return this;
        }

        public boolean contains_algoexpert(int value) {

            BST currentNode = this;

            while (currentNode != null){
                if( currentNode.value > value){
                    currentNode = currentNode.left;
                }else if( value > currentNode.value){
                    currentNode = currentNode.right;
                }else{
                    return true;
                }
            }

            return false;
        }

        public BST remove_algoexpert(int value){
            remove_algoexpert(value, null);
            return this;
        }

        public void remove_algoexpert(int value, BST parentNode) {
            BST currentNode = this;
            while(currentNode != null){
                if(value < currentNode.value){
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                }else if(value > currentNode.value){
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                }else{
                    if(currentNode.left != null && currentNode.right != null){
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove_algoexpert(currentNode.value, currentNode);
                    }else if(parentNode == null){
                        if(currentNode.left != null){
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        }else if(currentNode.right != null){
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        }else{

                        }
                    }else if(parentNode.left == currentNode){
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    }else if(parentNode.right == currentNode){
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
        }

        public int getMinValue(){
            if(left == null){
                return value;
            }else{
                return left.getMinValue();
            }
        }


    }
}
