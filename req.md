# Project Requirements & Tooling

This file lists the required software, versions, and tools for our Java and Spring Boot project.

## Software Versions

*   **Java:** JDK 21 (Long-Term Support version).
*   **Spring Boot:** 3.3.x (Latest stable version).
*   **Build Tool:** Apache Maven 3.9.x.
*   **Database:** A local installation of PostgreSQL. We will configure our application to connect to it.

## IDE: IntelliJ IDEA

We will use **IntelliJ IDEA Community Edition**. It is a powerful and popular IDE for Java development with excellent support for Spring Boot.

### Getting Started with IntelliJ IDEA

To help you adapt, here are some key areas and shortcuts:

*   **Project View:** The "Project" tool window on the left shows your file structure.
*   **Creating a Spring Boot Project:** We will use the official Spring Initializr website, as the integrated generator is only available in the paid version of IntelliJ.
    1.  Go to [start.spring.io](https://start.spring.io).
    2.  Fill in the project details (Project: Maven, Language: Java, Java Version: 21).
    3.  Enter the project metadata (e.g., Group: `com.example`, Artifact: `ecommerce`).
    4.  Add the necessary dependencies on the right side: "Spring Web", "Spring Data JPA", and "PostgreSQL Driver".
    5.  Click "Generate" to download the project `.zip` file.
    6.  Unzip the file to your workspace.
    7.  In IntelliJ, go to `File > Open...` and select the unzipped project folder. IntelliJ will automatically set it up as a Maven project.
*   **Maven Integration:**
    *   The "Maven" tool window on the right allows you to see dependencies and run Maven goals (like `clean`, `install`).
    *   Your project's dependencies are managed in the `pom.xml` file.
*   **Running Your Application:** Find your main application class (the one with `@SpringBootApplication`) and click the green play button next to the `main` method.
*   **Useful Shortcuts:**
    *   `Alt + Insert` (or `Cmd + N` on Mac): Generate code (constructors, getters, etc.).
    *   `Ctrl + N` (or `Cmd + O` on Mac): Find a class by name.
    *   `Ctrl + Shift + F` (or `Cmd + Shift + F` on Mac): Find in all files.
    *   `Shift + Shift`: Search Everywhere (for files, actions, classes, etc.).

## Installing Maven (Optional but Recommended)

IntelliJ bundles its own Maven. However, it's good practice to have a system-wide installation.

1.  **Download:** Go to the [Apache Maven Project website](https://maven.apache.org/download.cgi) and download the "Binary zip archive".
2.  **Extract:** Unzip the file to a permanent location (e.g., `C:\Program Files\Maven`).
3.  **Set Environment Variables:**
    *   Add the `bin` directory of your Maven installation to the `PATH` system variable.
    *   Create a new `MAVEN_HOME` system variable pointing to the installation directory.
4.  **Verify:** Open a new terminal and run `mvn -v` to confirm the installation.
5.  **Configure IntelliJ:**
    *   Go to `File > Settings > Build, Execution, Deployment > Build Tools > Maven`.
    *   Change the "Maven home path" to point to your system-wide installation.

## Other Essential Tools

*   **Git:** For version control.
*   **REST Client:** A tool for testing our REST APIs, such as Postman or Insomnia.
