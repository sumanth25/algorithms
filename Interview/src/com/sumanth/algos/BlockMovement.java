// Salesforce LLD+Coding interview
//Move a onto b, where a and b are block numbers, puts a on top of block b after
//returning all blocks on top of a and b to their original positions.
//If a and b are in the same position, ignore the movement
// N=8
//move 3 onto 5
import java.util.*;

public class BlockMovement {

    // Array to represent the positions of blocks
    private static int[] blocks;
    // List of stacks, each stack represents a position of a block
    private static List<List<Integer>> blockStacks;

    public static void main(String[] args) {
        int numBlocks = 8; // Example: 10 blocks
        initialize(numBlocks);

        move(3, 5); // Example: Move block 3 onto block 5
        printPositions(); // Print the current position of each block
    }

    // Initialize the block positions
    private static void initialize(int numBlocks) {
        blocks = new int[numBlocks];
        blockStacks = new ArrayList<>();

        // Create a stack for each block
        for (int i = 0; i < numBlocks; i++) {
            List<Integer> stack = new ArrayList<>();
            stack.add(i); // Each block initially is on its own stack
            blockStacks.add(stack);
        }

        // Set the block position array to point to its initial position (itself)
        for (int i = 0; i < numBlocks; i++) {
            blocks[i] = i;
        }
    }

    // Move block a onto block b
    private static void move(int a, int b) {
        if (a == b) return; // If a and b are the same, ignore the movement

        // Step 1: Return any blocks on top of a to their original positions
        returnToOriginalPosition(a);

        // Step 2: Return any blocks on top of b to their original positions
        returnToOriginalPosition(b);

        // Step 3: Move block a onto block b
        List<Integer> stackB = blockStacks.get(b);
        List<Integer> stackA = blockStacks.get(a);

        // Remove block a from its current position stack
        stackA.remove(Integer.valueOf(a));

        // Add block a on top of block b's stack
        stackB.add(a);
        blocks[a] = b; // Update the block's position
    }

    // Return all blocks from a given stack to their original positions
    private static void returnToOriginalPosition(int block) {
        List<Integer> stack = blockStacks.get(block);
        while (stack.size() > 1) {
            int topBlock = stack.remove(stack.size() - 1);
            int originalPosition = blocks[topBlock];
            blockStacks.get(originalPosition).add(topBlock);
            blocks[topBlock] = originalPosition; // Update the block's position
        }
    }

    // Print the current position of each block
    private static void printPositions() {
        for (int i = 0; i < blocks.length; i++) {
            System.out.println("Block " + i + " is at position " + blocks[i] + " with stack: ");
            List<Integer> stack = blockStacks.get(i);
            for (int block : stack) {
                System.out.println(block + " ");
            }
            System.out.println();
        }
    }
}
