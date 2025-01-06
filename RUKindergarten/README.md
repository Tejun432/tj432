
---

# RUKindergarten Management System

This repository implements a **Kindergarten Management System** using a **hash table structure** to manage the distribution of children across various classrooms. Each classroom is represented by a **priority queue** where children are sorted based on specific attributes like age and behavior.

### Key Features:

1. **Hash Table Structure**:
   The kindergarten is organized into 10 classrooms, each acting as a bucket in the hash table. Children are assigned to classrooms based on their age and certain preferences.

2. **Priority Queue**:
   Each classroom uses a priority queue (min-heap) to manage children, where the child with the least preference (e.g., youngest or least well-behaved) is at the root. This structure helps maintain an efficient order when adding, evicting, or modifying children in a classroom.

3. **Child Operations**:
   - **Add Child**: Children are added to a classroom based on their age and preferences, and are placed into the appropriate classroom using their assigned ID.
   - **Transfer Child**: Children can be transferred between classrooms if necessary, such as if a child needs a different type of care or attention.
   - **Delete Child**: A child can be removed from the classroom, and the priority queue will adjust accordingly.
   - **Attend Class**: Simulates a child's attendance in class and updates their participation or performance.
   - **Eviction**: If a classroom exceeds its capacity (e.g., 10 children per classroom), the least prioritized child is evicted to make space for new enrollments.
   - **Better Add Child**: Attempts to add children more efficiently by prioritizing filling classrooms that have vacancies, instead of adding to overcrowded classrooms.

### Files:
- **Kindergarten.java**: The main class that handles child operations, classroom assignments, and priority queue maintenance.
- **Classroom.java**: A helper class that manages a priority queue of children within each classroom.
- **Child.java**: Represents individual children with attributes such as ID, name, age, behavior, and preferences.

### How it Works:
- Children are added based on their ID and other attributes, which determine which classroom they will be assigned to.
- Each classroom has a priority queue to manage children efficiently, evicting the least prioritized children if space is needed.
- The system maintains a fixed number of classrooms (10), and operates with basic priority operations on children, ensuring efficient classroom management.

### Usage:
- This system simulates real-world operations of adding, transferring, and evicting children, while keeping classrooms at optimal capacity and ensuring that children are prioritized based on their individual needs.

---
