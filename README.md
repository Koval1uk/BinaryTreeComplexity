# BinaryTreeComplexity
BinaryTreeComplexity is a Java-based library designed to implement and test various data structures, including hash maps (with chaining and closed hashing strategies) and trees (AVL and Splay trees). The project aims to provide a comprehensive set of data structures with performance testing and analysis tools, making it ideal for educational purposes, algorithmic challenges, and software development projects requiring efficient data handling.

# Features
## Hash Maps:

-  Chaining for collision resolution (HashMapChaining).
Closed hashing (Open Addressing) for collision resolution (HashTableClosedHashing).
Trees:

* AVL Trees (AVLTree) with self-balancing properties.
* Splay Trees (SplayTree) with splay operation for access optimization.

- Performance Testing:

Frameworks for evaluating the performance (HMapTester, TreeTester) of hash maps and trees.
Automated tests to analyze insert, search, and delete operations.
### Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or newer.
###Installation
Clone the repository to your local machine:

   - git clone https://github.com/Koval1uk/BinaryTreeComplexity.git
- Navigate to the project directory:

- cd BinaryTreeComplexity
- Compile the Java files (ensure your JAVA_HOME environment variable is set):

- javac -d bin src/*.java
- Run the main class to execute performance tests (example command, adjust paths as needed):

- java -cp bin Main
# Usage
- The project includes a Main class that demonstrates how to perform performance tests on the included data structures. You can modify this class to customize the tests or integrate the data structures into your own projects.

## Example usage in your Java code:

- // Initialize a HashMapChaining instance with a predefined size
- HashMapChaining<Integer, Integer> hashMapChaining = new HashMapChaining<>(1024);

- // Perform operations
- hashMapChaining.put(1, 100);
- Integer value = hashMapChaining.get(1);
- System.out.println("Value: " + value);

- // Similarly, initialize and use AVLTree, SplayTree, and HashTableClosedHashing
## Contributing
- We welcome contributions to the BinaryTreeComplexity! Please feel free to submit pull requests, report bugs, or suggest features through the repository's issues section.

#### License
- This project is licensed under the MIT License - see the LICENSE file for details.

#### Acknowledgments
- This project is intended for educational purposes and as a foundation for more complex data structure implementations and analyses.