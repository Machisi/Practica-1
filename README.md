# Clothing Store Management — First-Year Java Project

A console-based Java application for managing a small clothing store's inventory, shopping cart, and sales records.

Developed during my **first year at university**, this project documents an early stage of my development as a programmer. It forms part of my learning journey: applying object-oriented programming and fundamental data structures to a practical problem, before moving toward more robust software design and engineering practices.

## Overview

The application models a simple retail workflow through a text-based menu. The emphasis is on implementing the underlying logic directly in Java rather than using frameworks, a database, or a graphical interface.

The original console interface and many source comments are in Spanish; this README provides an English overview.

## Features

- **Inventory management:** add and display clothing items, check stock by name and size, and remove or extract individual items.
- **Clothing model:** represent each item with a name, price, and size (`S`, `M`, or `L`).
- **Shopping cart:** add and remove quantities, and display a cost breakdown.
- **Checkout:** confirm the cart, record the corresponding sales, and print an order summary.
- **Sales tracking:** display units sold and accumulated sales amount during the current session.
- **Educational checks:** exercise the main classes through the included console-based test routines.

Adding items to the cart removes them from available inventory. Removing them from the cart returns them to inventory; confirming the cart records them as sales.

## Technical Foundations

| Area | Implementation |
| --- | --- |
| Language | Java |
| Interface | Interactive command-line menu |
| Inventory | Fixed-capacity array of clothing items |
| Cart | Custom singly linked list |
| Organization | Separate application, inventory, cart, sales, and test packages |
| Storage | In-memory state only |
| Dependencies | Java standard library; no external dependencies |

## Repository Structure

```text
Practica11 copy/
├── src/
│   ├── app/             # Entry point and console interaction
│   ├── shop/            # ClothingItem and Inventory
│   ├── cart/            # Cart items and linked-list implementation
│   ├── sales/           # Sales and shopping-cart workflows
│   ├── test/            # Educational validation routines
│   └── module-info.java
└── bin/                 # Compiled classes included in the original project
```

Build from `src/` rather than relying on the bundled compiled classes.

## Getting Started

### Requirements

- A Java Development Kit (JDK) **11 or later**.
- A terminal with `java` and `javac` available on the `PATH`.

No Maven or Gradle setup is required. Run the following commands from the repository root.

### Windows (PowerShell)

```powershell
$sources = Get-ChildItem "Practica11 copy/src" -Recurse -Filter *.java |
    ForEach-Object { $_.FullName }
javac -encoding UTF-8 -d out $sources
java -cp out app.Main
```

### macOS / Linux

```bash
find "Practica11 copy/src" -name '*.java' -print0 |
  xargs -0 javac -encoding UTF-8 -d out
java -cp out app.Main
```

### Example Workflow

1. Choose **1** to add an item, such as `Shirt`, with a price and size `M`.
2. Choose **2** to inspect the inventory.
3. Choose **5** to add that item to the cart with quantity `1`.
4. Choose **8** to view the cart and its total.
5. Choose **7** to confirm the purchase.
6. Choose **4** to view updated sales totals, or **9** to exit.

Use single-word item names: the current console input reads names as individual tokens. Initialize the cart by adding an available item before viewing, removing, or confirming it.

## Validation

Enter **0** at the main menu to run the included checks, even though this option is not listed in the displayed menu. These cover `ClothingItem`, `Inventory`, `SalesRegister`, `LinkedCart`, and `ShoppingRegister`.

The checks print results and scores to the console. They are educational validation routines, not a comprehensive automated test suite; some primarily exercise workflows rather than assert their correctness. Run them in a fresh session, since they share static cart and sales state with the application.

## Learning Outcomes

This assignment provided practice in:

- Translating a small problem domain into collaborating Java classes.
- Using constructors, accessors, and methods to represent and manipulate state.
- Working with array capacity, searching, and element removal.
- Implementing linked-list insertion, lookup, and removal.
- Coordinating inventory changes with cart operations and sales accounting.
- Exploring program behavior through class-level checks and console output.

## Scope and Further Development

This repository is presented as a **first-year academic project**, not a production-ready retail system. Its value is as a record of foundational learning and a starting point for further development.

The current implementation has modest scope and some unfinished areas: data is lost on exit, the main inventory is limited to 100 items, input validation and error handling are limited, and some methods remain placeholders. Cart operations assume initialization, and monetary values use `double` rather than a dedicated decimal representation.

Potential next steps include stronger validation, explicit handling of empty-cart operations, removal of placeholder methods, isolated automated tests, decimal-based monetary calculations, persistent storage, and clearer separation of console interaction from business logic. These are improvement opportunities, not features already implemented.

