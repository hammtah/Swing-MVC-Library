## Library Management Application (Java Swing, MVC, DAO, Hibernate)

This project is a **desktop library management application** built with **Java Swing** using a clean separation of layers:

- **UI (View)**: Swing forms and frames in `ma.ilisi2.library.ui`
- **Controller layer (Controller)**: Classes in `ma.ilisi2.library.controller`
- **Service & business layer (Model – services)**: Interfaces and implementations in `ma.ilisi2.library.models.service`
- **DAO layer (Data Access Object)**: Interfaces and Hibernate implementations in `ma.ilisi2.library.models.dao`
- **Domain/BO layer (Business Objects)**: Entities in `ma.ilisi2.library.models.bo`
- **Persistence**: **Hibernate** + **SQLite** configured via `hibernate.cfg.xml` and `HibernateUtil`

The goal is to demonstrate **MVC architecture**, **DAO pattern**, and **Hibernate ORM** in a small but complete CRUD application for managing books, users, and borrow operations.

---

## Technologies Used

- **Language**: Java 17
- **Build tool**: Maven
- **UI**:
  - Java Swing
  - `FlatLaf` for a modern look and feel
  - IntelliJ GUI Designer (`forms_rt`)
- **Persistence**:
  - Hibernate 6 (`hibernate-core`, `hibernate-community-dialects`)
  - SQLite JDBC driver

All dependencies are declared in `pom.xml`.

---

## Project Structure and Architecture

- **Entry point**
  - `Main` (in `src/Main.java`)
  - Sets the FlatLaf look and feel and shows the main `Home` window.

- **UI / View (`ma.ilisi2.library.ui`)**
  - `Home` – main navigation window.
  - `BookCreate`, `BookUpdate`, `BookList`, `BookPanel` – screens for creating, updating and listing books.
  - `BorrowForm`, `BorrowList` – screens for managing borrow operations.
  - `UserCreate` – screen for creating users.
  - `.form` files are IntelliJ GUI Designer forms; `.java` files contain the event logic.

- **Controllers (`ma.ilisi2.library.controller`)**
  - Example: `BookController`, `BorrowController`, `UserController`.
  - **Responsibility**: receive data from the UI, create domain objects, and call the service layer.
  - Controllers hide the details of services/DAOs from the Swing forms.

- **Business Objects / Entities (`ma.ilisi2.library.models.bo`)**
  - `Book`, `User`, `Borrow`.
  - Represent the core domain of the library (books, users and borrow records).
  - These are mapped by Hibernate (see `hibernate.cfg.xml`).

- **DAO Layer (`ma.ilisi2.library.models.dao`)**
  - Example interfaces:
    - `IBookDao`, `IUserDao`, `IBorrowDao`
  - Example implementations:
    - `BookDaoHibernate`, `UserDaoHibernate`, `BorrowDaoHibernate`
  - **Responsibility**: low‑level CRUD operations (save, update, delete, find, list) using Hibernate sessions.
  - In some cases you can also see a non‑Hibernate implementation (e.g. `BookDao`) to contrast JDBC vs Hibernate.

- **Service Layer (`ma.ilisi2.library.models.service`)**
  - Interfaces: `IBookService`, `IUserService`, `IBorrowService`
  - Implementations: `BookService`, `UserService`, `BorrowService`
  - **Responsibility**:
    - Contain business rules and validation.
    - Call the DAOs and translate `DaoException` / technical errors into service‑level exceptions (`BookServiceException`, `UserServiceException`, `BorrowServiceException`).
    - Expose simple methods such as `save`, `get`, `getAll`, `update`, etc. for the controllers.

- **Utility (`ma.ilisi2.library.utility`)**
  - `HibernateUtil` – provides a singleton `SessionFactory`:
    - Reads configuration from `src/main/resources/hibernate.cfg.xml`.
    - Central place for creating Hibernate sessions.
  - `Connection` – (if present) shows an alternative manual JDBC connection (for comparison with Hibernate).

- **Exceptions (`ma.ilisi2.library.exception`)**
  - `DaoException`, `BookServiceException`, `UserServiceException`, `BorrowServiceException`
  - Used to separate technical errors from business‑level errors and keep each layer responsible for its own concern.

---

## MVC, DAO and Hibernate in Practice

- **Model**
  - Domain classes: `Book`, `User`, `Borrow`.
  - Service interfaces/implementations: `IBookService`/`BookService`, etc.
  - Hibernate mappings and configuration (entities + `hibernate.cfg.xml`).

- **View**
  - Swing UI classes in `ma.ilisi2.library.ui` (IntelliJ GUI forms).
  - They only know about controllers and do not talk directly to DAOs.

- **Controller**
  - Classes in `ma.ilisi2.library.controller`.
  - Receive user input from the forms, create or update BOs, and call service methods.

- **DAO pattern**
  - Interfaces in `ma.ilisi2.library.models.dao.*` allow swapping implementations (e.g. JDBC vs Hibernate).
  - Controllers/services depend on DAO **interfaces**, not concrete classes.

- **Hibernate integration**
  - `HibernateUtil.getSessionFactory()` builds a `SessionFactory` from `hibernate.cfg.xml`.
  - DAO Hibernate implementations use this `SessionFactory` to open sessions and perform CRUD.
  - Dialect and SQLite configuration are defined in `src/main/resources/hibernate.cfg.xml`.

---

## How to Build and Run

**Prerequisites**

- Java 17 installed (`java -version`)
- Maven installed (`mvn -version`)

**Steps**

1. **Clean and build the project**
   - Run:
     - `mvn clean package`
2. **Run the application**
   - From the project root:
     - `mvn exec:java -Dexec.mainClass=Main`
   - Or, in your IDE, run the `Main` class directly.

On startup, the app:

- Sets the FlatLaf light look and feel.
- Opens the `Home` window (main menu), from which you can navigate to book, user, and borrow screens.

---

## Example User Flows (What the App Can Do)

- **Books**
  - Create a new book (title, author, year, ISBN, genre, price, description, image path).
  - List all books.
  - Select and update an existing book.

- **Users**
  - Create a new library user.
  - (Depending on UI) list or update users.

- **Borrowing**
  - Create a borrow record linking a user and a book.
  - List existing borrow records.

Each of these flows goes through **UI → Controller → Service → DAO → Hibernate → SQLite**, illustrating the layered architecture.


