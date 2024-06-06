package com.targetindia.arrays;

import com.targetindia.utils.KeyboardUtil;

import java.util.Arrays;

public class Main {

    static Array array = new Array();


    public static void main(String[] args) {
        for (int i : Arrays.asList(19, 40, 29, 58, 55, 38, 31)) {
            array.append(i);
        }

        int choice;
        int data;
        int index;

        do {
            array.display();
            System.out.println("*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Append");
            System.out.println("2. Prepend");
            System.out.println("3. Delete at a given index");
            // Assignment tasks:
            System.out.println("4. Delete a given value");
            System.out.println("5. Insert at a given index");
            System.out.println("6. Reverse");
            System.out.println("7. Rotate"); // first element is removed and appended to the end
            choice = KeyboardUtil.getInt("Enter your choice: ");

            switch (choice) {
                case 0:
                    System.out.println("exiting...");
                    break;
                case 1:
                    data = KeyboardUtil.getInt("Enter data to append: ");
                    array.append(data);
                    break;
                case 2:
                    data = KeyboardUtil.getInt("Enter data to prepend: ");
                    array.prepend(data);
                    break;
                case 3:
                    index = KeyboardUtil.getInt("Enter index to delete value at: ");
                    try {
                        array.deleteAtIndex(index);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 4:
                    data = KeyboardUtil.getInt("Enter value to be deleted: ");
                    try{
                        array.deleteValue(data);
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 5:
                    index = KeyboardUtil.getInt("Enter index at which element to be inserted : ");
                    data = KeyboardUtil.getInt("Enter value to be inserted : ");
                    try{
                        array.insertAtIndex(index, data);
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 6: //REVERSE
                    try {
                        array.reverse();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 7: //ROTATE
                    int pivot = KeyboardUtil.getInt("Enter the index of the pivot : ");
                    try{
                        array.rotate(pivot);
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }
}


