# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

README.md - Below will include notes that track the changes made to this project \

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

CHANGED - mainscreen.html

    Old Line 14 <title> My Bicycle Shop </title> 
    New Line 14 <title> JushyGyms One Stop Weight Shop </title> 

    Old Line 19 <h1> Shop </h1>
    New Line 19 <h1> Shop Plates and Dumbbells </h1>

    Old Line 21 <h2> Parts </h2>
    New Line 21 <h2> Rubber/Metal Plate and Dumbbell Parts </h2>

    Old Line 53 <h2> Products </h2>
    New Line 53 <h2> Rubber/Metal Plates and Dumbbells </h2>

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

CREATED - about.html

    <!DOCTYPE html>
    <html lang="en" xmlns:th="http://www.thymeleaf.org">
    <head>
    <meta charset="UTF-8">

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>JushyGyms One Stop Weight Shop About Page</title>
    </head>
    <body>

    <div class="container">
    <h1>About Us</h1>
    <hr>
    <p>Fitness and health is our main priority. We believe that every person should have access to affordable, quality weights they can use in their own homes. That is why we have created
    the one stop shop for all of your weightlifting needs. Our products are made in America, built to last, and delivered straight to your door. Order your weights today!</p>

    <a href="http://localhost:8080/" class="btn btn-primary btn-sm mb-3"> Back to Main Screen </a>
    </div>
    </body>
    </html>

ADDED TO  - mainscreen.html

    Line 89     <a th:href="@{/about}" class="btn btn-primary btn-sm mb-3">About us</a>

ADDED TO - MainScreenControllerr

    Line 56     @GetMapping("/about")
                public String about(Model theModel){
                return "about";
                }

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

J.  Remove the class files for any unused validators in order to clean your code.