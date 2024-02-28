import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // 상품 클래스를 생성하여 상품 목록에 넣는다.
        Product product1 = new Product("11", "우유", 2000);
        Product product2 = new Product("12", "사과", 1000);
        productSet.add(product1);
        productSet.add(product2);

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        myCart.addProduct(product1, 2);
        myCart.addProduct(product2, 1);

        myCart.showItems();

        // 상품을 장바구니에서 제거
        myCart.removeProduct(product1,1);
        myCart.showItems();

        // exception
        myCart.addProduct(product1,3);
        myCart.showItems();

//        myCart.removeProduct(product1,100);

        System.out.println(myCart.showItemsStream());
    }
}