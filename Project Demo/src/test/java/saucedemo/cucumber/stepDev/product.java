package saucedemo.cucumber.stepDev;
public class product extends env {

    int prev_amount;
    public int duration = 10;
    WebDriverWait wait = new WebDriverWait(driver, duration); //create object
    pageProduct elementProduct = new pageProduct();

    @When("user add first product to cart")
    public void user_add_first_product_to_cart() {
        List<WebElement> btn_addToCart = driver.findElements(elementProduct.getBtn_addToCart());
        btn_addToCart.get(0).click();
        Assert.assertTrue(btn_addToCart.size() == 6);
    }

    @And("user see initial amount")
    public void user_see_initial_amount() {
        WebElement text_amountInCart = driver.findElement(elementProduct.getBadge_amountProduct());
        prev_amount = Integer.valueOf(text_amountInCart.getText());
    }

    @When("user add second product to cart")
    public void user_add_second_product_to_cart() {
        driver.findElement(elementProduct.getBtn_addToCart()).click();
    }

    @Then("user verify amount of product in cart incremented")
    public void user_verify_amount_of_product_in_cart_incremented() {
        WebElement text_amountInCart = driver.findElement(elementProduct.getBadge_amountProduct());
        int curr_amount = Integer.valueOf(text_amountInCart.getText());
        Assert.assertTrue(curr_amount - prev_amount == 1);
    }

    @When("user click products")
    public void userClickProducts() {
        driver.findElement(elementProduct.getProduct_image()).click();
    }

    @And("user go to page detail")
    public void userGoToPageDetail() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(elementProduct.getPage_detailProduct())
        );
    }

    @And("user click button back to products")
    public void userClickButtonBackToProducts() {
        driver.findElement(elementProduct.getBtn_backToProduct()).click();
    }

    @Then("user back to page products")
    public void userBackToPageProducts() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(elementProduct.getTittle_product())
        );
    }
}