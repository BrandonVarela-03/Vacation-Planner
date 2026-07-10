# Miner Vacation Planner

A console-based Java application that lets a user browse, order, and check out vacation packages across several categories.

## Features

- **Order tickets** from six categories: Resort, Experience, Activity, Travel, Event, and Cruise.
- **View cart** — see total tickets and running subtotal.
- **Manage order** — clear the cart at any time.
- **Checkout** — calculates tax, offers an optional Gold Pass upgrade (adds a flat fee), and validates a 16-digit card number before printing a receipt.
- **Vacation price summary** — reports the lowest-priced option(s), highest-priced option(s), and the average price across all packages.

## Project Structure

```
VacationPlan/
├── src/
│   └── Planner.java        # Main program (menu, ordering, checkout logic)
├── Vacation_Planner.txt    # Vacation package data (name, category, price)
├── out/                    # Compiled .class files (not tracked in git)
└── .idea/                  # IntelliJ project settings
```

## Data File Format

`Vacation_Planner.txt` holds one vacation package per line, space-separated:

```
<name> <category> <price>
```

Example:
```
Cancun_Beach Resort 50
Paris_City_Tour Experience 55
```

Category must be one of: `Resort`, `Experience`, `Activity`, `Travel`, `Event`, `Cruise`.

## How to Run

**In IntelliJ:**
1. Open the `VacationPlan` folder as a project.
2. Make sure `src/` is marked as the Sources Root.
3. Run `Planner.java` (right-click → Run 'Planner.main()').

**From the command line** (run from the project root, so the program can find `Vacation_Planner.txt`):
```bash
javac -d out src/Planner.java
java -cp out Planner
```

## Menu Reference

```
1. Order                       - browse and add a package to your cart
2. View Cart                   - see tickets and subtotal
3. Manage Order                - clear the cart
4. Checkout                    - pay, with optional Gold Pass upgrade
5. Exit
6. Vacation Price Summary      - lowest, highest, and average prices
```

## Author

Brandon Varela
