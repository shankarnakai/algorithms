// Node class
class Node 
{
    constructor(data)
    {
        this.data = data; 
        this.left = null;
        this.right = null;
    }
}

// Binary Search tree class 
class BinarySearchTree 
{ 
    constructor() 
    { 
        // root of a binary seach tree 
        this.root = null; 
    } 
  
    // functions to be implemented 
    insert(num) {
        if (this.root === null) {
            this.root = new Node(num);
        }

        // TODO: Implement rest of BST.
    }

    toList() {}

    findMin(node) {}

    remove(num) {}
}

module.exports = {
    BinarySearchTree
}