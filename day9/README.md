
# Level Order Traversal of BST

Given an array of unique integers, construct a **Binary Search Tree** and print its **level order traversal** (breadth-first search by levels).

- Each level of the tree is printed on a separate line.
- For multiple test cases, separate each tree's output with an extra newline.

---

## Examples

**Example 1:**

Input:
T = 3
N = 5
Nodes: 1 2 3 4 5

text
Output:
1
2
3
4
5

text

**Example 2:**

Input:
N = 5
Nodes: 3 2 4 1 5

text
Output:
3
2 4
1 5

text

**Example 3:**

Input:
N = 7
Nodes: 4 5 15 0 1 7 17

text
Output:
4
0 5
1 15
7 17

text

---

## Constraints

- \(1 \leq T \leq 1000\) — Number of test cases
- \(1 \leq N \leq 1000\) — Nodes in each test case (all unique)
- \(0 \leq \text{Node value} \leq 10000\)

---

## Approach

- For each test case:
  - Construct the BST by inserting given nodes in order.
  - Traverse the tree in **level order** using a queue.
  - Print each level's values space-separated on its own line.
  - Print an extra newline between test cases.

---

## Java Solution

import java.io.;
import java.util.;

public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int t = sc.nextInt();
while(t-- > 0){
BST tree = new BST();
int n = sc.nextInt();
for(int i = 0 ; i < n ; i++) tree.insert(sc.nextInt());
tree.order();
System.out.println(); // For extra newline between testcases
}
}
}

class BST{
Node root;
public BST(){ root = null; }
public void insert(int x){ root = insertHelper(root, x); }
public Node insertHelper(Node root, int x){
if(root == null) return new Node(x);
else if(x < root.data) root.left = insertHelper(root.left, x);
else if(x > root.data) root.right = insertHelper(root.right, x);
return root;
}
public void order(){
Queue<Node> queue = new LinkedList<>();
if(root == null) return;
queue.offer(root);
while(!queue.isEmpty()){
int size = queue.size();
for(int i = 0 ; i < size ; i++){
Node curr = queue.poll();
System.out.print(curr.data + " ");
if(curr.left != null) queue.offer(curr.left);
if(curr.right != null) queue.offer(curr.right);
}
System.out.println();
}
}
}

class Node{
int data;
Node left, right;
public Node(int data){
this.data = data;
left = null;
right = null;
}
}

text

---

## Dry Run

### Testcase 1

Input:  
Nodes: 1 2 3 4 5

| Step | Queue   | Printed | Comments |
|------|---------|---------|----------|
| 1    | 1       | 1       | Root     |
| 2    | 2       | 2       | Next     |
| 3    | 3       | 3       | Next     |
| 4    | 4       | 4       | Next     |
| 5    | 5       | 5       | Next     |

Output:
1
2
3
4
5

text

---

### Testcase 2

Input:  
Nodes: 3 2 4 1 5

| Step | Queue   | Printed | Comments |
|------|---------|---------|----------|
| 1    | 3       | 3       | Root     |
| 2    | 2 4     | 2 4     | Next     |
| 3    | 1 5     | 1 5     | Next     |

Output:
3
2 4
1 5

text

---

### Testcase 3

Input:  
Nodes: 4 5 15 0 1 7 17

| Step | Queue   | Printed | Comments    |
|------|---------|---------|-------------|
| 1    | 4       | 4       | Root        |
| 2    | 0 5     | 0 5     | Next level  |
| 3    | 1 15    | 1 15    | Next level  |
| 4    | 7 17    | 7 17    | Next level  |

Output:
4
0 5
1 15
7 17

text

---

## Time Complexity

- **O(N)** for building BST + level order traversal (per test case)

## Space Complexity

- **O(N)** for queue during traversal
