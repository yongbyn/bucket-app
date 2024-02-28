import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {


        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // 상품 클래스를 생성하여 상품 목록에 넣는다.
//        Product product1 = new Product("11", "우유", 2000);
//        Product product2 = new Product("12", "사과", 1000);
//        productSet.add(product1);
//        productSet.add(product2);
        // csv read
        BufferedReader br = null;
        String path = Main2.class.getResource("").getPath() + "/data.csv";

        List<Product> myProducts = new ArrayList<>(); // 장바구니에 추가할 때 접근이 필요하므로 임의로 배열을 선언해서 쓴다.
        try{
            br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null){
                String[] values = line.split(","); //csv

                Product p = new Product(values[0], values[1], Integer.parseInt(values[2]));
                productSet.add(p);
                myProducts.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        myCart.addProduct(myProducts.get(0), 2);
        myCart.addProduct(myProducts.get(1), 1);

        myCart.showItems();

        // 상품을 장바구니에서 제거
        myCart.removeProduct(myProducts.get(0),1);
        myCart.showItems();

        // exception
        myCart.addProduct(myProducts.get(0),3);
        myCart.showItems();

//        myCart.removeProduct(product1,100);

        System.out.println(myCart.showItemsStream());

    }
}
