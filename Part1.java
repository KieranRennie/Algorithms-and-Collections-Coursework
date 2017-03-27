package part1;
import java.util.*;
/**
 * Student - B00278559
 *
 * @author Richard Beeby
 * 
 */
public class Part1 {

    /**
     * An application that tests some of the methods of the BinarySearchTree
     * class using integer elements
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        List<Item> dataSet = new LinkedList<>();
        Random ran = new Random();
        
        /**
         * This is the original testing of the program.
         */
        
        System.out.print("Please enter the size of the data set: ");
        try (Scanner keyboard = new Scanner(System.in)) {
            int size = keyboard.nextInt();
            final int N = size*2; // to ensure duplicates generated on most runs
            System.out.printf("The size of the dataSet for this run is %d \n",
                    size);
            int count = 0;
            while (bst.size() < size) {
                int candidate = ran.nextInt(N)*2+1;  // add odd values only
                count++;
                if (bst.add(new Item(candidate))) {
                    dataSet.add(new Item(candidate));
                }
            }
            System.out.printf("Added %d elements from %d random numbers.\n",
                    size, count);
            int errorCount = 0;
            System.out.println("Testing contains() method:");
            for (Item d : dataSet) {
                if (!bst.contains(d)) {
                    errorCount++;
                    System.out.printf(
                            "Error %d: contains(%d) returns false.\n",
                            errorCount, d);
                }
                if (bst.contains(new Item((d.value()/2)*2))) { // even number tests for absence
                    errorCount++;
                    System.out.printf(
                            "Error %d: contains(%d) returns true.\n",
                            errorCount, (d.value()/2)*2);
                }
            }
            System.out.printf("Testing contents complete with %d errors ",
                    errorCount);
            System.out.println();
            System.out.println("Testing enumerator throws an exception " +
                    "if tree is modified while in use.");
            try {
                for (Item i : bst) {
                    bst.add(i = new Item(-1));
                }
                errorCount++;
            }
            catch (ConcurrentModificationException e) {}
            System.out.println("Testing exception throwing complete.");
            System.out.printf( "Errors now %d.\n", errorCount);
            System.out.println();
            bst.remove(new Item(-1));
            if (bst.size() <= 25) {
                int counter = 1;
                System.out.println("Tree contents are:");
                for (Item i : bst) {
                    System.out.printf("Item number %d is: %d\n", counter++, i.value());
                }
            }
            
            
            if (bst.size() <= 25) {
                System.out.println("\nDisplaying Breadth First Insertion:");
                System.out.println(bst.BreadthFirst());
                }
            
            System.out.println("Tree Height = " + bst.TreeHeight(bst.root));
            
            System.out.println("Removing tree contents:");
            count = bst.size();
            errorCount = 0;
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            System.out.printf("%d items removed with %d errors.\n", 
                    size, errorCount);
            System.out.printf("Tree size = %d\n", bst.size());
            System.out.println("Any remaining contents listed below:");
            for (Item i : bst) {
                System.out.println(i);
            }
            System.out.println("Testing complete....\n");
            
            System.out.println("Starting Experimentation...\n");
            
            /**
             * This is the testing of the 100 range
             */
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding numbers 1 through 100 in order...\n");
            
            int counter = 0 ;
            
            while(bst.size < 100){
            	int order =  counter + 1;
            	counter ++;
                if (bst.add(new Item(order))) {
                    dataSet.add(new Item(order));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding numbers 1 through 100 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 100){
            	int random = ran.nextInt(100);
            	counter ++;
                if (bst.add(new Item(random))) {
                    dataSet.add(new Item(random));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            } 
            
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            /**
             * This is the testing of the 1000 range
             */
            
            System.out.println("Adding numbers 1 through 1000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 1000){
            	int order =  counter + 1;
            	counter ++;
                if (bst.add(new Item(order))) {
                    dataSet.add(new Item(order));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding numbers 1 through 1000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 1000){
            	int random = ran.nextInt(1000);
            	counter ++;
                if (bst.add(new Item(random))) {
                    dataSet.add(new Item(random));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            /**
             * This is the testing of the 10000 range
             */
            
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding numbers 1 through 10000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 10000){
            	int order =  counter + 1;
            	counter ++;
                if (bst.add(new Item(order))) {
                    dataSet.add(new Item(order));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding numbers 1 through 10000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 10000){
            	int random = ran.nextInt(10000);
            	counter ++;
                if (bst.add(new Item(random))) {
                    dataSet.add(new Item(random));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            /**
             * This is the testing of the 100000 range
             */
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding numbers 1 through 100000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 100000){
            	int order =  counter + 1;
            	counter ++;
                if (bst.add(new Item(order))) {
                    dataSet.add(new Item(order));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding numbers 1 through 100000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 100000){
            	int random = ran.nextInt(100000);
            	counter ++;
                if (bst.add(new Item(random))) {
                    dataSet.add(new Item(random));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            /**
             * This is the testing of the 200 range with only odd numbers
             */
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 200 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 100){
            	int order =  counter + 1;
            	counter ++;
            	
            	int in = order *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 200 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 100){
            	int random = ran.nextInt(200);
            	counter ++;
            	
            	int in = random *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            } 
            
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            /**
             * This is the testing of the 2000 range with only odd numbers
             */
            
            System.out.println("Adding odd numbers 1 through 2000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 1000){
            	int order =  counter + 1;
            	counter ++;
            	
            	int in = order *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 2000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 1000){
            	int random = ran.nextInt(2000);
            	counter ++;
            	
            	int in = random *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            /**
             * This is the testing of the 20000 range odd numbers only
             */
            
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 20000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 10000){
            	int order =  counter + 1;
            	counter ++;
            	
            	int in = order *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 20000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 10000){
            	int random = ran.nextInt(20000);
            	counter ++;
            	
            	int in = random *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            /**
             * This is the odd numbers testing of the 200000 range
             */
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 200000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 100000){
            	int order =  counter + 1;
            	counter ++;
            	
            	int in = order *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 200000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 100000){
            	int random = ran.nextInt(200000);
            	counter ++;
            	
            	int in = random *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            System.out.println("Number of Comparisons: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            /**
             * This is the testing of the 200 range with only odd numbers with failed searches
             */
            
            dataSet.clear();
            
            System.out.println("Adding odd numbers 1 through 200 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 100){
            	int order =  counter + 1;
            	counter ++;
            	
            	int in = order *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            Item.resetCompCount();
            
            for (Item d : dataSet) {
            	bst.contains(new Item((d.value()*2)));
            }
            
            System.out.println("Number of Comparisons for Failed Searches: " + Item.getCompCount() + "\n");
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            System.out.println("Adding odd numbers 1 through 200 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 100){
            	int random = ran.nextInt(200);
            	counter ++;
            	
            	int in = random *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            Item.resetCompCount();
            
            for (Item d : dataSet) {
            	bst.contains(new Item((d.value()*2)));
            }
            
            System.out.println("Number of Comparisons for Failed Searches: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            } 
            
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            /**
             * This is the testing of the 2000 range with only odd numbers
             */
            
            System.out.println("Adding odd numbers 1 through 2000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 1000){
            	int order =  counter + 1;
            	counter ++;
            	
            	int in = order *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            Item.resetCompCount();
            
            for (Item d : dataSet) {
            	bst.contains(new Item((d.value()*2)));
            }
            
            System.out.println("Number of Comparisons for Failed Searches: " + Item.getCompCount() + "\n");
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            System.out.println("Adding odd numbers 1 through 2000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 1000){
            	int random = ran.nextInt(2000);
            	counter ++;
            	
            	int in = random *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            Item.resetCompCount();
            
            for (Item d : dataSet) {
            	bst.contains(new Item((d.value()*2)));
            }
            
            System.out.println("Number of Comparisons for Failed Searches: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            } 
            
            
            dataSet.clear();
            
            /**
             * This is the testing of the 20000 range odd numbers only
             */
            
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 20000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 10000){
            	int order =  counter + 1;
            	counter ++;
            	
            	int in = order *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            Item.resetCompCount();
            
            for (Item d : dataSet) {
            	bst.contains(new Item((d.value()*2)));
            }
            
            System.out.println("Number of Comparisons for Failed Searches: " + Item.getCompCount() + "\n");
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 20000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 10000){
            	int random = ran.nextInt(20000);
            	counter ++;
            	
            	int in = random *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            Item.resetCompCount();
            
            for (Item d : dataSet) {
            	bst.contains(new Item((d.value()*2)));
            }
            
            System.out.println("Number of Comparisons for Failed Searches: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            } 
            
            
            dataSet.clear();
            
            /**
             * This is the odd numbers testing of the 200000 range
             */
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 200000 in order...\n");
            
            counter = 0 ;
            
            while(bst.size < 100000){
            	int order =  counter + 1;
            	counter ++;
            	
            	int in = order *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            Item.resetCompCount();
            
            for (Item d : dataSet) {
            	bst.contains(new Item((d.value()*2)));
            }
            
            System.out.println("Number of Comparisons for Failed Searches: " + Item.getCompCount() + "\n");
            
            System.out.println("\n Clearing Tree...\n");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            }
            
            System.out.println("Complete....\n");
            
            dataSet.clear();
            
            Item.resetCompCount();
            
            System.out.println("Adding odd numbers 1 through 200000 randomly...\n");
            
            counter = 0 ;
            
            while(bst.size < 100000){
            	int random = ran.nextInt(200000);
            	counter ++;
            	
            	int in = random *2 + 1;
            	
                if (bst.add(new Item(in))) {
                    dataSet.add(new Item(in));
                }
            }
            
            Item.resetCompCount();
            
            for (Item d : dataSet) {
            	bst.contains(new Item((d.value()*2)));
            }
            
            System.out.println("Number of Comparisons for Failed Searches: " + Item.getCompCount() + "\n");
            
            System.out.println("Tree Height: " + bst.TreeHeight(bst.root));
            
            System.out.println("\n Clearing Tree...");
            
            for (Item d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                }
                else  { // d was not removed
                    errorCount++;
                }
            } 
            
            
            dataSet.clear();
            
        }

    }
    
}
