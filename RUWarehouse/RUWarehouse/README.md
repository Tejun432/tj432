# Warehouse Management System

This repository implements a **Warehouse Management System** based on a **hash table structure** where each entry in the table stores a **priority queue**. The system simulates a product warehouse where various operations can be performed to manage products, such as adding, deleting, restocking, and simulating purchases.

### Key Features:

1. **Hash Table Structure**: 
   The warehouse is organized into 10 sectors, each acting as a bucket in the hash table. Products are distributed across these sectors based on their product IDs.

2. **Priority Queue**:
   Each sector uses a priority queue (min-heap) to manage product data, where the product with the lowest popularity is at the root. This structure helps in maintaining efficient operations when adding, evicting, and modifying products.

3. **Product Operations**:
   - **Add Product**: Products are added to the warehouse and are placed into the appropriate sector based on the product ID.
   - **Restock Product**: The stock of a product is updated based on demand or additional stock.
   - **Delete Product**: A specific product can be deleted while maintaining the heap structure.
   - **Purchase Product**: Simulates a purchase and updates stock and demand accordingly.
   - **Eviction**: If a sector exceeds its capacity (5 products), the least popular product is evicted to make room for new ones.
   - **Better Add Product**: Attempts to add products more efficiently by filling up empty spaces in other sectors first, before adding new products in a full sector.

### File Structure:
- **Warehouse.java**: The main class that manages product operations, the warehouse structure, and heap maintenance.
- **Sector.java**: A helper class that manages a priority queue of products within each sector.
- **Product.java**: Represents individual products with attributes like ID, name, stock, demand, and popularity.

### How it Works:
- Products are added based on their ID, which determines the sector they belong to.
- Each sector has a priority queue where the least popular products are evicted if space is needed.
- The warehouse maintains a constant size (10 sectors) and tries to efficiently manage product data while respecting the heap structure for optimal operations.

### Usage:
- This system is designed to simulate real-world operations of adding, deleting, and purchasing products while ensuring that the warehouse remains within its space limits.

---

### Note:
This system assumes the use of a **Priority Queue (min-heap)** for efficient product management, and basic operations to maintain product data like **popularity** and **stock levels**.

