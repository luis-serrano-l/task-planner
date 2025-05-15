# Task Planner

A task planning system that allows users to organize and manage tasks in both sequential and tree-based structures. This system provides flexible ways to organize tasks, set priorities, and manage dependencies between tasks.

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

- **Multiple Task Organization Methods**
  - Sequential task planning for linear task management
  - Tree-based task planning for hierarchical task organization
  - Support for task dependencies and relationships

- **Task Management**
  - Priority levels for task importance
  - Task status tracking
  - Task metadata management

- **Architecture**
  - Interface-based design for extensibility
  - Clean separation of concerns
  - Modular and maintainable code structure

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (recommended) or text editor
- Basic understanding of Java programming
- Bash shell (for running test scripts)

### Building and Running

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```bash
   cd task-planner
   ```

3. Compile the Java files:
   ```bash
   javac src/es/uned/lsi/eped/pract2024_2025/*.java
   ```

4. Run the application:
   ```bash
   java -cp src es.uned.lsi.eped.pract2024_2025.Main
   ```

### Testing

The project includes a test script `Compile_Run_Test_2025_EST_V.01.sh` that automates the compilation, execution, and testing of the application. To run the tests:

1. Make the script executable:
   ```bash
   chmod +x Compile_Run_Test_2025_EST_V.01.sh
   ```

2. Execute the test script:
   ```bash
   ./Compile_Run_Test_2025_EST_V.01.sh
   ```

The script will:
- Compile all Java source files
- Run the application with test cases
- Verify the output against expected results
- Report any errors or issues found

## Task Planner Implementations

The system provides two different implementations for task planning:

1. **Sequential Task Planner (TaskPlannerSequence)**
   - Organizes tasks in a linear sequence
   - Suitable for simple, step-by-step task management
   - Tasks are processed in order of addition

2. **Tree-based Task Planner (TaskPlannerTree)**
   - Organizes tasks in a hierarchical structure
   - Supports parent-child relationships between tasks
   - Ideal for complex projects with multiple subtasks

## Input/Output Format

The program can be executed using the following command:
```bash
java -jar eped2025.jar <implementation> <input> <output>
```

Parameters:
- `<implementation>`: Choose between `SEQUENCE` or `TREE`
- `<input>`: Path to the input file containing task operations
- `<output>`: Path where the results will be saved

### Input File Format
The input file should contain task operations in a specific format. Each line represents an operation to be performed on the task planner.

### Output File Format
The output file will contain the results of the operations performed, including task status, relationships, and any error messages.

## License

This project is part of the EPED course at UNED. All rights reserved.

## Contributing

This is a course project and contributions are not currently being accepted.