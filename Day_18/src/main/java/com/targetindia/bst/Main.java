package com.targetindia.bst;

import com.targetindia.utils.KeyboardUtil;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.RandomAccess;

public class Main {
    public static void main(String[] args) {
        int choice;
        int data;
        BinarySearchTree bst = new BinarySearchTree();

        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            bst.insert(r.nextInt(500));
        }


        while ((choice = menu()) != 0) {

            switch (choice) {
                case 1:
                    data = KeyboardUtil.getInt("Enter data to insert: ");
                    bst.insert(data);
                    break;
                case 2:
                    bst.display();
                    break;
                case 3:
                    bst.preorderDisplay();
                    break;
                case 4:
                    bst.inorderDisplay();
                    break;
                case 5:
                    bst.postorderDisplay();
                    break;
                case 6:
                    try {
                        data = KeyboardUtil.getInt("Enter data to delete: ");
                        bst.delete(data);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid type for data. Please try with integers only.");
                    }

                case 7: //Find the smallest value
                    try {
                        int smallest = bst.findSmallest();
                        System.out.println("Smallest element = "+smallest);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());;
                    }
                    break;

                case 8: //Find the largest value
                    try {
                        int largest = bst.findLargest();
                        System.out.println("Largest element = "+largest);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 9: //Find the depth of a value
                    try {
                        int value = KeyboardUtil.getInt("Enter the value of tree node: ");
                        int depth = bst.getDepth(value);
                        System.out.println("Depth of the value " + value + "= " + depth);
                    } catch (Exception e) {
                        System.out.println("Element does not exist!");
                    }
                    break;

                case 10: //Find the length of the tree
                    try {
                        int length = bst.height(bst.root);
                        System.out.println("Length of the Tree = "+length);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

        System.out.println("Exiting...");
    }

    private static int menu() {
        System.out.println("*** Main menu ***");
        System.out.println("0. Exit");
        System.out.println("1, Insert");
        System.out.println("2. Display");
        System.out.println("3. Preorder traversal");
        System.out.println("4. Inorder traversal");
        System.out.println("5. Postorder traversal");
        System.out.println("6. Delete");
        // TODO: tasks for assignment
        System.out.println("7. Find the smallest value");
        System.out.println("8. Find the largest value");
        System.out.println("9. Find the depth of a value");
        System.out.println("10. Find the length of the tree");

        try {
            return KeyboardUtil.getInt("Enter your choice: ");
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}