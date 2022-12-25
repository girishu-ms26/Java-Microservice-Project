package com.at0m.productmanagement.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductServiceTest {

    /*@InjectMocks
    private ProductService productService;

    @Mock
    private MongoTemplate mongoTemplate;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllProductsListTest() {
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("Iphone", 6000);
        Product p2 = new Product("Nokia", 7000);
        products.add(p1);
        products.add(p2);

        when(mongoTemplate.findAll(Product.class, "products")).thenReturn(products);
        assertThat(productService.getAllProductsList().size()).isEqualTo(2);
    }
    
    @Test
    public void getProductByIdTest(){
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<String> notFound = new ArrayList<>();
        notFound.add("Iphone Not Found");
        when(mongoTemplate.find(query(where("productName").is("Iphone")),Product.class)).thenReturn(products);
        assertThat(productService.getProductByproductName("Iphone")).isEqualTo(notFound);
    }

    @Test
    public void saveProductTest(){
        List<Product> products = new ArrayList<>();
        Product p1 = new Product("Iphone", 6000);
        when(mongoTemplate.find(query(where("productName").is(p1.getproductName())), Product.class)).thenReturn(products);
        assertThat(productService.saveProduct(p1)).isEqualTo("Saved");
    }

    @Test
    public void saveProductTest_1(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(false);
        assertThat(productService.saveProduct(p1)).isEqualTo("Saved");
    }

    /*@Test
    public void saveListOfProductsTest(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("1","Iphone",1,20);
        Product p2 = new Product("2","Nokia",2,30);
        products.add(p1);
        products.add(p2);
        assertThat(productService.saveListOfProducts(products)).isEqualTo("Saved/Updated all products in the List");
    }

    @Test
    public void updateProductTest(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(true);
        assertThat(productService.updateProduct(p1)).isEqualTo("Updated");
    }

    @Test
    public void updateProductTest_1(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(false);
        assertThat(productService.updateProduct(p1)).isEqualTo("Product with ID " + p1.getId() + " not found");
    }

    @Test
    public void deleteProductTest(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(true);
        assertThat(productService.deleteProduct(p1.getId())).isEqualTo("Deleted product with ID "+p1.getId());
    }

    @Test
    public void deleteProductTest_1(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(false);
        assertThat(productService.deleteProduct(p1.getId())).isEqualTo("Product with " +p1.getId()+" not found");
    }*/
}
