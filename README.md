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

    Line 90     <a th:href="@{/about}" class="btn btn-primary btn-sm mb-3">About us</a>

ADDED TO - MainScreenControllerr.java

    Line 56     @GetMapping("/about")
                public String about(Model theModel){
                return "about";
                }

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

ADDED TO - BootStrapData.java

    Lines 36-76
        if (outsourcedPartRepository.count() == 0) {
               OutsourcedPart rubberDisk = new OutsourcedPart();
               rubberDisk.setCompanyName("JirehSynthetics");
               rubberDisk.setName("Rubber Disk");
               rubberDisk.setInv(15);
               rubberDisk.setPrice(15.0);
               rubberDisk.setId(100L);
               outsourcedPartRepository.save(rubberDisk);
    
               OutsourcedPart metalDisk = new OutsourcedPart();
               metalDisk.setCompanyName("JAMIronWorks");
               metalDisk.setName("Metal Disk");
               metalDisk.setInv(15);
               metalDisk.setPrice(15.0);
               metalDisk.setId(100L);
               outsourcedPartRepository.save(metalDisk);
    
               OutsourcedPart steelDisk = new OutsourcedPart();
               steelDisk.setCompanyName("JAMIronWorks");
               steelDisk.setName("Steel Disk");
               steelDisk.setInv(15);
               steelDisk.setPrice(30.0);
               steelDisk.setId(100L);
               outsourcedPartRepository.save(steelDisk);
    
               OutsourcedPart rubberHead = new OutsourcedPart();
               rubberHead.setCompanyName("JirehSynthetics");
               rubberHead.setName("Rubber Head");
               rubberHead.setInv(30);
               rubberHead.setPrice(20.0);
               rubberHead.setId(100L);
               outsourcedPartRepository.save(rubberHead);
    
               OutsourcedPart metalHead = new OutsourcedPart();
               metalHead.setCompanyName("JAMIronWorks");
               metalHead.setName("Metal Head");
               metalHead.setInv(30);
               metalHead.setPrice(20.0);
               metalHead.setId(100L);
               outsourcedPartRepository.save(metalHead);
           }

    Lines 91-102
        if (productRepository.count() == 0) {
            Product rubberPlate = new Product("Rubber Plate", 90.0, 15);
            Product metalPlate = new Product("Metal Plate", 90.0, 15);
            Product calibratedPlate = new Product("Calibrated Plate", 135.0, 15);
            Product rubberDumbbell = new Product("Rubber Dumbbell", 100.0, 15);
            Product metalDumbbell = new Product("Metal Dumbbell", 100.0, 15);
            productRepository.save(rubberPlate);
            productRepository.save(metalPlate);
            productRepository.save(calibratedPlate);
            productRepository.save(rubberDumbbell);
            productRepository.save(metalDumbbell);
        }


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:\
•  The “Buy Now” button must be next to the buttons that update and delete products.\
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.\
•  Display a message that indicates the success or failure of a purchase.

ADDED TO - mainscreen.html
    
    Line 85 <a th:href="@{/buyproduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>

CREATED - confirmationbuyproduct.html

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Product Order Confirmation Page</title>
    </head>
    <body>
    <h1>Congratulations! Your order has been processed. </h1>
    <a href="http://localhost:8080/" class="btn btn-primary btn-sm mb-3"> Back to Main Screen </a>
    </body>
    </html>

CREATED - confirmationerrorbuyproduct.html

    <<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Product Order Error Page</title>
    </head>
    <body>
    <h1>Uh oh! There was an error processing your purchase.</h1>
    <a href="http://localhost:8080/" class="btn btn-primary btn-sm mb-3"> Back to Main Screen </a>
    </body>
    </html>

ADDED TO - Product.java

    Lines 108-117
    //used by buyProduct function. Checks inventory to see if there is at least one product before decrementing.
    public boolean buyProduct() {
        if (this.inv >= 1) {
            this.inv--;
            return true;
        }
        else {
            return false;
        }
    }

ADDED TO - AddProductController.java

    Lines 176-189
    @GetMapping("/buyproduct")
    public String buyproduct(@RequestParam("productID") int theID, Model theModel){
        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product product2=productService.findById(theID);

        boolean purchaseConfirmation = product2.buyProduct();
        if (purchaseConfirmation) {
            productService.save(product2);
            return "confirmationbuyproduct";
        }
        else {
            return "confirmationerrorbuyproduct";
        }
    }

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.\
ADDED TO - mainscreen.html

    Lines 38,39
        <th>Minimum</th>
        <th>Maximum</th>

    Lines 48,49
        <td th:text="${tempPart.minimum}">1</td>
        <td th:text="${tempPart.maximum}">1</td>

•  Modify the sample inventory to include the maximum and minimum fields.\
ADDED TO -Part.java

    Lines 31-33
        @Min(value = 0, message = "Inventory must be greater than 0")
        int minimum;
        int maximum;

    Lines 108 - 112 Setters and Getters for maximum and minimum
        public void setMinimum(int minimum) {this.minimum = minimum;}
        public int getMinimum() {return this.minimum;}
    
        public void setMaximum(int maximum) {this.maximum = maximum;}
        public int getMaximum() {return this.maximum;}

    Lines 47,48 Added default values to minimum and maximum
        this.minimum = 0;
        this.maximum = 100;
    Lines 56,57
        this.minimum = 0;
        this.maximum = 100;
ADDED TO - InhousePart.java

    Lines 18,19 Added default values to minimum and maximum
        this.minimum = 0;
        this.maximum = 100;
ADDED TO - OutsourcedPart.java

    Lines 18,19 Added default values to minimum and maximum
        this.minimum = 0;
        this.maximum = 100;
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.\
ADDED TO - InhousePartForm.html

    Lines 24-26
        <p><input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/></p>

        <p><input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/></p>
    Lines 30-34
        <p>
        <div th:if="${#fields.hasAnyErrors()}">
            <ul><li th:each="err: ${#fields.allErrors()}" th:text="${err}"></li></ul>
        </div>
        </p>
ADDED TO - OutsourcedPartForm.html

    Lines 25-27
        <p><input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/></p>

        <p><input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/></p>
    Lines 31-35
        <p>
        <div th:if="${#fields.hasAnyErrors()}">
            <ul><li th:each="err: ${#fields.allErrors()}" th:text="${err}"></li></ul>
        </div>
        </p>

•  Rename the file the persistent storage is saved to.\
CHANGED - application.properties

    Old line 6 spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102
    New line 6 spring.datasource.url=jdbc:h2:file:~/newdatabase

•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
ADDED TO - Part.java

    Lines 92-102
        /* function isInvVal is called by save function before saving part changes. 
        (See InhousePartServiceImpl.java and OutsourcedPartServiceImpl.java)
        if value is higher/lower than set boundary the inv variable is set to the limit.
         */
        public void isInvVal() {
            if (this.inv < this.minimum) {
                this.inv = this.minimum;
            } else if (this.inv > this.maximum ) {
                this.inv = this.maximum;
            }
        }

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:\
ADDED TO - Part.java
    
    Lines 19,20
        @ValidPartInvMax
        @ValidPartInvMin
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.\
CREATED - PartInvMinValidator.java
    
    package com.example.demo.validators;
    
    import com.example.demo.domain.Part;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.ApplicationContext;
    
    import javax.validation.ConstraintValidator;
    import javax.validation.ConstraintValidatorContext;
    
    /**
    *
      *
      *
      *
    */
    public class PartInvMinValidator implements ConstraintValidator <ValidPartInvMin, Part> {
    @Autowired
    private ApplicationContext applicationContext;
    
        public static ApplicationContext myContext;
    
        @Override
        public void initialize(ValidPartInvMin constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }
    
        @Override
        public boolean isValid(Part part, ConstraintValidatorContext context) {
            return part.getInv() > part.getMinimum();
        }
    }

CREATED - ValidPartInvMin.java
    
    package com.example.demo.validators;

    import javax.validation.Constraint;
    import javax.validation.Payload;
    import java.lang.annotation.ElementType;
    import java.lang.annotation.Retention;
    import java.lang.annotation.RetentionPolicy;
    import java.lang.annotation.Target;
    
    /**
    *
      *
      *
      *
    */
    @Constraint(validatedBy = {PartInvMinValidator.class})
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidPartInvMin {
    String message() default "Inventory cannot fall below minimum required parts";
    Class[] groups() default {};
    Class [] payload() default {};
    }

•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.\
CHANGED - EnufPartsValidator.java

    Old Line 36 if (p.getInv()<(product.getInv()-myProduct.getInv())) return false;
    Added an OR operator to the if statement to include inventory falling below maximum
    New Line 36 if ((p.getInv()<(product.getInv()-myProduct.getInv())) || (p.getInv() - 1 < p.getMinimum())) return false;
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.\
CREATED - PartInvMaxValidator.java

    package com.example.demo.validators;

    import com.example.demo.domain.Part;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.ApplicationContext;
    
    import javax.validation.ConstraintValidator;
    import javax.validation.ConstraintValidatorContext;
    
    /**
    *
      *
      *
      *
    */
    public class PartInvMaxValidator implements ConstraintValidator <ValidPartInvMax, Part> {
    @Autowired
    private ApplicationContext applicationContext;
    
        public static ApplicationContext myContext;
    
        @Override
        public void initialize(ValidPartInvMax constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }
    
        @Override
        public boolean isValid(Part part, ConstraintValidatorContext context) {
            return part.getInv() <= part.getMaximum();
        }
    }
CREATED - ValidPartInvMax.java

    package com.example.demo.validators;

    import javax.validation.Constraint;
    import javax.validation.Payload;
    import java.lang.annotation.ElementType;
    import java.lang.annotation.Retention;
    import java.lang.annotation.RetentionPolicy;
    import java.lang.annotation.Target;
    
    /**
    *
      *
      *
      *
    */
    @Constraint(validatedBy = {PartInvMaxValidator.class})
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidPartInvMax {
    String message() default "Inventory cannot exceed maximum required parts";
    Class[] groups() default {};
    Class [] payload() default {};
    }


I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
ADDED TO - PartTest.java
    
    Lines 160 - 176
    @Test
    void getMinimum() {
        int minimum=10;
        partIn.setMinimum(minimum);
        assertEquals(minimum, partIn.getMinimum());
        partOut.setMinimum(minimum);
        assertEquals(minimum, partOut.getMinimum());
    }

    @Test
    void getMaximum() {
        int maximum=150;
        partIn.setMaximum(maximum);
        assertEquals(maximum, partIn.getMaximum());
        partOut.setMaximum(maximum);
        assertEquals(maximum, partOut.getMaximum());
    }

J.  Remove the class files for any unused validators in order to clean your code.