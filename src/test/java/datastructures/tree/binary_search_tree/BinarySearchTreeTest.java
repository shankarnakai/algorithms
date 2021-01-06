package datastructures.tree.binary_search_tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
       bst = new BinarySearchTree();
    }

    @Test
    @DisplayName("Should add in the left numbers lower or equal to parent node")
    void shouldAddInTheLeftNumbersLowerOrEqualToParentNode() {
        int[] values = new int[]{5, 5, 8, 1};
        addMultipleValues(bst, values);

        assertEquals(5, bst.root.value);
        assertEquals(5, bst.root.left.value);
        assertEquals(1, bst.root.left.left.value);
        assertEquals(8, bst.root.right.value);
    }

    @Test
    @DisplayName("Should add in the right numbers bigger to parent node")
    void shouldAddInTheRightNumbersBiggerToParentNode() {
        int[] values = new int[]{5, 5, 8, 10};
        addMultipleValues(bst, values);

        assertEquals(5, bst.root.value);
        assertEquals(5, bst.root.left.value);
        assertEquals(8, bst.root.right.value);
        assertEquals(10, bst.root.right.right.value);
    }

    @Test
    @DisplayName("Should add values in the right order")
    void shouldAddValuesInRightOrder() {
        int[] values = new int[]{5, 5, 2, 8, 1, 6, 3};
        addMultipleValues(bst, values);

        assertEquals(5, bst.root.value);
        assertEquals(5, bst.root.left.value);
        assertEquals(2, bst.root.left.left.value);
        assertEquals(8, bst.root.right.value);
        assertEquals(1, bst.root.left.left.left.value);
        assertEquals(6, bst.root.right.left.value);
        assertEquals(3, bst.root.left.left.right.value);
    }

    @Test
    void shouldReturnList() {
        int[] values = new int[]{5, 2, 10, 8, 4,1, 6, 7};
        addMultipleValues(bst, values);

        List<Integer> expected = Arrays.asList(1, 2, 4, 5, 6, 7, 8, 10);
        List<Integer> result = bst.toList();
        assertIterableEquals(result, expected);
    }

    @Test
    void shouldReturnNoneForEmptyBST() {
        Optional<Node> removed = bst.remove(5);

        assertTrue(removed.isEmpty());
    }

    @Test
    void shouldReturnRootElement() {
        bst.add(5);
        Optional<Node> removed = bst.remove(5);

        assertFalse(removed.isEmpty());
        assertNull(bst.root);
    }

    @Test
    void shouldRemoveTheRootElement() {
        int[] values = new int[]{5, 2, 10, 8, 4,1, 6, 7};
        addMultipleValues(bst, values);
        Optional<Node> removed = bst.remove(5);

        assertEquals(6, bst.root.value);
        assertFalse(removed.isEmpty());
        assertEquals(5, removed.orElse(new Node(-1)).value);
    }

    @Test
    void shouldRemoveChildElement() {
        int[] values = new int[]{5, 2, 10, 8, 4,1, 6, 7};
        addMultipleValues(bst, values);
        Optional<Node> removed = bst.remove(2);

        assertFalse(removed.isEmpty());
        assertEquals(2, removed.orElse(new Node(-1)).value);

        assertEquals(5, bst.root.value);
        assertEquals(10, bst.root.right.value);
        assertEquals(4, bst.root.left.value);
        assertEquals(1, bst.root.left.left.value);
    }

    private void addMultipleValues(BinarySearchTree tree, int[] numbers) {
        for(int n: numbers) {
            tree.add(n);
        }
    }

}
