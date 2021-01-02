import { expect, test } from '@jest/globals';
import { assert } from 'console';
import { BinarySearchTree } from './bst';

const bst = new BinarySearchTree();

test('inserts root node into BST', () => {
    bst.insert(3);
    expect(bst.root.data).toEqual(3);
});