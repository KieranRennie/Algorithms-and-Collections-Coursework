package package1;
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
	
    /**
     * This method is used to calculate the height of a red-black tree
     * and was taken from the handout provided.
     */
    private static float height (TreeSet<Item> tree) {
    	long maxComp = 0;
    	for (Item current : tree) {
    	Item.resetCompCount();
    	tree.contains(current);
    	if (maxComp < Item.getCompCount()) {
    	maxComp = Item.getCompCount();
    	}
    	}
    	return maxComp-1;
    	}
	
    /**
     * Main method of program
     */
    public static void main(String[] args) {
    	
    	//Set-up of the containers used
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        HashSet<Item> hash = new HashSet<>();
        TreeSet<Item> rbt = new TreeSet<>();
        
        //Creation of Linked List that will hold the data set used by
        //the containers. The complete data set is necessary to hold
        //a copy of the data set.
        LinkedList<Item> dataSet = new LinkedList<>();
        LinkedList<Item> completeDataSet = new LinkedList<>();
        
        LinkedList<Integer> DeletedItems = new LinkedList<>();
        LinkedList<Integer> DeletedItemsCopy = new LinkedList<>();
        
        Random ran = new Random();
        int errorCount = 0;
        int count = 0;


            
            System.out.println("Starting Experimentation...\n");
            
            
            for (int dataSize=100;
            		dataSize<=100000;
            		dataSize*=10) {
            	
            dataSet.clear();
            
            Item.resetCompCount();
            
            int counter = 0 ;
            
            /**
             * Filling of data set with all numbers from one to dataSize.
             */
            
            while(dataSet.size() < dataSize){
            	int order =  counter + 1;
            	counter ++;
                    dataSet.add(new Item(order));
            }
            
            /**
             * Creating copy of data set
             */
            completeDataSet = (LinkedList) dataSet.clone();
            
            /**
             * This part of the program takes the data in the data set and adds it to the various
             * containers. It does this by removing each item randomly from the data set to ensure
             * there are no duplicates. Once all of the data has been added to a container, the
             * data set is refreshed from the copy that was created.
             */
            
            System.out.printf("Adding numbers 1 through %d randomly...\n" , dataSize);
            
            counter = 0 ;
            
            // Adding to Linked List
            while(bst.size < dataSize){
            	int random = ran.nextInt(dataSet.size());
            	counter ++;
            	bst.add(dataSet.remove(random));
            	}
            
            dataSet = (LinkedList) completeDataSet.clone();
            
            //Adding to Red-Black tree.
            while(rbt.size() < dataSize){
            	int random = ran.nextInt(dataSet.size());
            	counter ++;
            	rbt.add(dataSet.remove(random));
            	}
            
            dataSet = (LinkedList) completeDataSet.clone();
            
            //Adding to Hash-Map
            while(hash.size() < dataSize){
            	int random = ran.nextInt(dataSet.size());
            	counter ++;
            	hash.add(dataSet.remove(random));
            	}
            
            /**
             * The following are the successful searches for ten random items
             * for each container type.
             */
            
            //Binary Search Tree
            System.out.println("Binary Search Tree Successful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = ran.nextInt(dataSize);
            	
            	bst.getEntry(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
            
            //Red-Black Tree
            System.out.println("Red-Black Tree Successful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = ran.nextInt(dataSize);
            	
            	rbt.contains(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
            
            //Hash-Map
            System.out.println("Hash Map Successful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = ran.nextInt(dataSize);	
            	
            	hash.contains(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
            
            /**
             * Displaying the various details of each container.
             */
            
            System.out.printf("Binary Search Tree Height: %d \n" , bst.treeHeight());
            
            System.out.println("Red-Black Tree Tree Height: " + height(rbt));
            
            System.out.printf("Binary Search Tree Leaves: %d \n" , bst.leaves());
            
            /**
             * Removing the contents of each container.
             */
            
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
            
            rbt.removeAll(rbt);
            
            hash.removeAll(hash);
            
            dataSet.clear();
            
            /**
             * This part of the program adds only odd numbers to the containers so that
             * the program can conduct searches that are unsuccessful. This is done by
             * searching for only even search terms.
             */
            
            System.out.printf("Adding odd numbers 1 through %d randomly...\n\n" , dataSize * 2);
            
            counter = 0 ;
            
            //Binary Search Tree
            
            while(bst.size < dataSize){
            	int random = ran.nextInt(dataSet.size());
            	counter ++;
            	bst.add(new Item(dataSet.remove(random).value() * 2 + 1));
            	}
            
            dataSet = (LinkedList) completeDataSet.clone();
            
            //Red-Black Tree
            
            while(rbt.size() < dataSize){
            	int random = ran.nextInt(dataSet.size());
            	counter ++;
            	rbt.add(new Item(dataSet.remove(random).value() * 2 + 1));
            	}
            
            dataSet = (LinkedList) completeDataSet.clone();
            
            //Hash-Map
            
            while(hash.size() < dataSize){
            	int random = ran.nextInt(dataSet.size());
            	counter ++;
            	hash.add(new Item(dataSet.remove(random).value() * 2 + 1));
            	}
            
            Item.resetCompCount();
            
            /**
             * Conducting unsuccessful searches.
             */
            
            //Binary Search Tree
            
            System.out.println("Binary Search Tree Unsuccessful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = (ran.nextInt(dataSize) * 2);
            	
            	bst.getEntry(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
            
            //Red-Black Tree
            
            System.out.println("Red-Black Tree Unsuccessful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = (ran.nextInt(dataSize) * 2);
            	
            	rbt.contains(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
            
            //Hash-MAp
            
            System.out.println("Hash Map Unsuccessful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = (ran.nextInt(dataSize) * 2);	
            	
            	hash.contains(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
   

            
            /**
             * This part of the program will test whether repeatedly deleting and reinserting data
             * will have an effect on searching. I am repeating the creating the containers
             * with random numbers from 1 to dataSize once again.
             */
            
            System.out.println("\n Conducting Deletion and Reinsertion Tests");
            
            for (int i = 0; i < 10; i++){
            	
            	for (int x = 0; x<(dataSize/5);x++){
            		
            		Integer CurrentDelete = new Integer(ran.nextInt(dataSize));
            		
            		DeletedItems.add(CurrentDelete);
            		
            		bst.remove(new Item(CurrentDelete));
            		rbt.remove(new Item(CurrentDelete));
            		hash.remove(new Item(CurrentDelete));
            		
            	}
            
            	DeletedItemsCopy = (LinkedList)DeletedItems.clone();
            	
                while(bst.size() < dataSize){
                	int random = ran.nextInt(DeletedItems.size());
                	counter ++;
                	bst.add(new Item(DeletedItems.remove(random)));
                	}
            	
                DeletedItems = (LinkedList)DeletedItemsCopy.clone();
                
                while(rbt.size() < dataSize){
                	int random = ran.nextInt(DeletedItems.size());
                	counter ++;
                	rbt.add(new Item(DeletedItems.remove(random)));
                	}
                
                DeletedItems = (LinkedList)DeletedItemsCopy.clone();
                
                while(hash.size() < dataSize){
                	int random = ran.nextInt(DeletedItems.size());
                	counter ++;
                	hash.add(new Item(DeletedItems.remove(random)));
                	}
                
                
            	
            }
            
            /**
             * The following are the successful searches for ten random items
             * for each container type.
             */
            
            //Binary Search Tree
            System.out.println("Binary Search Tree Successful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = ran.nextInt(dataSize);
            	
            	bst.getEntry(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
            
            //Red-Black Tree
            System.out.println("Red-Black Tree Successful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = ran.nextInt(dataSize);
            	
            	rbt.contains(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
            
            //Hash-Map
            System.out.println("Hash Map Successful Search Results:");
            
            for (int i = 0; i < 10 ; i++){
            	
                Item.resetCompCount();
            	
            	int search = ran.nextInt(dataSize);	
            	
            	hash.contains(new Item(search));
            	
            	System.out.printf("Searched For: %d\n" , search);
            	System.out.printf("Number of Comparisons: %d\n\n" , Item.getCompCount());
            	
            	
            }
            
            Item.resetCompCount();
            
            /**
             * Displaying the various details of each container.
             */
            
            System.out.printf("Binary Search Tree Height: %d \n" , bst.treeHeight());
            
            System.out.println("Red-Black Tree Tree Height: " + height(rbt));
            
            System.out.printf("Binary Search Tree Leaves: %d \n" , bst.leaves());
            
            
            
            /**
             * Removing the contents of each container.
             */
            
            System.out.println("\n Clearing Containers...");
            
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
            
            rbt.removeAll(rbt);
            
            hash.removeAll(hash);
            
            dataSet.clear();
            
            }
            
            

    }

}