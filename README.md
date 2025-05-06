# Task Planner

A task planning system that allows users to organize and manage tasks in both sequential and tree-based structures.

## Project Structure

The project is organized as follows:

```
src/
└── es/
    └── uned/
        └── lsi/
            └── eped/
                └── pract2024_2025/
                    ├── Main.java                 # Main application entry point
                    ├── Task.java                 # Task implementation
                    ├── TaskIF.java               # Task interface
                    ├── TaskPlannerIF.java        # Task planner interface
                    ├── TaskPlannerSequence.java  # Sequential task planner implementation
                    └── TaskPlannerTree.java      # Tree-based task planner implementation
```

## Features

- Support for both sequential and tree-based task organization
- Task management with priority levels
- Interface-based design for extensibility
- Flexible task planning structures

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (recommended) or text editor

### Building and Running

1. Clone the repository
2. Navigate to the project directory
3. Compile the Java files:
   ```bash
   javac src/es/uned/lsi/eped/pract2024_2025/*.java
   ```
4. Run the application:
   ```bash
   java -cp src es.uned.lsi.eped.pract2024_2025.Main
   ```

## Execution and Test Cases

To run the program, open a terminal and execute:
```bash
java -jar eped2025.jar <implementation> <input> <output>
```

Where:
- `<implementation>`: Either `SEQUENCE` or `TREE` depending on the implementation type to use
- `<input>`: Name of the input file containing the operations to perform
- `<output>`: Name of the output file