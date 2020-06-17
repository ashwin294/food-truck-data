# food-truck-data

This module shows food truck details from San Francisco government’s website (https://data.sfgov.org/Economy-and-Community/Mobile-Food-Schedule/jjew-r69b) for the current hour and day.

## Installation
These are the prerequisites needed to compile & run the module:

1. Java - [Guide](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_HowTo.html)
2. Maven - [Guide](https://www.baeldung.com/install-maven-on-windows-linux-mac)
    
## Usage
- Checkout the code onto your local machine.
- Go to {checkout_dir}/food-truck-data and run the following. This will build the application.
```bash
mvn clean install
```
- Once the application is build, to run the food-truck-data application go to {checkout_dir}/food-truck-data and run the following.
```bash
java -cp target/*:target/lib/* org.assignment.runner.Main
```

## Command line overrides

    TABLE_WIDTH <number> : Set the width of the output table.
    ITEMS_PER_PAGE <number> : Set the # of items to be displayed per page.
    JSON_URL <String> : Set the URL to GET the truck details from.
    
## Example

```bash
bash-3.2$ java -DTABLE_WIDTH=100 -DITEMS_PER_PAGE=12 -cp target/*:target/lib/* org.assignment.runner.Main
```
