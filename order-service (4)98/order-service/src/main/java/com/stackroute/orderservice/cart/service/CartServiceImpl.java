package com.stackroute.orderservice.cart.service;

import com.stackroute.orderservice.cart.exception.CartDoesnotExist;
import com.stackroute.orderservice.cart.exception.NoProductsHere;
import com.stackroute.orderservice.cart.model.Cart;
import com.stackroute.orderservice.cart.repo.CartRepository;
import com.stackroute.orderservice.cart.model.Product;
import com.stackroute.orderservice.cart.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

//    @Override
//    public Cart saveCart(Cart cart){
//        if (cartRepository.existsByEmail(cart.getEmail())){
//            throw new CartAlreadyExists("Cart Already Exists");
//        }else {
//            return cartRepository.save(cart);
//        }
//    }

    @Override
    public Cart addProduct(Product product, String email){
        if (!cartRepository.existsByEmail(email)){
            Cart newCart = new Cart();
            List prods=new ArrayList<Product>();
            prods.add(product);
            newCart.setCartItems(prods);
            newCart.setEmail(email);
            cartRepository.save(newCart);
            return newCart;

        } else {
            Cart cart = cartRepository.findByEmail(email);
            List<Product> cartItems = cart.getCartItems();
            if (cartItems.size()==0){

                List<Product> prods=new ArrayList<>();
                prods.addAll(cart.getCartItems());
                prods.add(product);
                cart.setCartItems(prods);
                return cartRepository.save(cart);

            }
            else{
                System.out.println("else block");
                System.out.println(cartItems);
                for(Product p: cartItems){
                    System.out.println(
                            p
                    );
                    if (p.getProductId().equals(product.getProductId())){
                        p.setQuantity(p.getQuantity()+1);
                        return cartRepository.save(cart);
                    }



                }
                List<Product> prods=new ArrayList<>();
                prods.addAll(cart.getCartItems());
                prods.add(product);
                cart.setCartItems(prods);
                return cartRepository.save(cart);


            }

        }

    }

    @Override
    public Cart deleteProduct(Product product, String email) {
        Cart cart = cartRepository.findByEmail(email);
        List<Product> cartItems = cart.getCartItems();
        boolean productFound = false;


        for (Product p : cartItems) {
            System.out.println(p);
            if (p.getProductId().equals(product.getProductId())) {
                cart.getCartItems().remove(p);
                productFound = true;
                break;
            }
        }
        if (!productFound) {
            throw new NoProductsHere("Product not found in the cart.");
        }
        return cartRepository.save(cart);
    }

    @Override
    public Cart increaseQuantity(String productId, String email){
        Cart cart = cartRepository.findByEmail(email);
        List<Product> cartItems = cart.getCartItems();
        boolean productFound = false;

        for (Product p : cartItems) {
            System.out.println(p);
            if (p.getProductId().equals(productId)) {
                p.setQuantity(p.getQuantity()+1);
                productFound=true;
                break;
            }
        }
        if (!productFound) {
            throw new NoProductsHere("Product not found in the cart.");
        }
        return cartRepository.save(cart);
    }

    @Override
    public Cart decreaseQuantity(String productId, String email){
        Cart cart = cartRepository.findByEmail(email);
        List<Product> cartItems = cart.getCartItems();
        boolean productFound = false;


        for (Product p : cartItems) {
            System.out.println(p);
            if (p.getProductId().equals(productId)) {
                if(p.getQuantity()==1){
                    deleteProduct(p,email);
                }else {
                    p.setQuantity(p.getQuantity() - 1);
                    productFound = true;
                    break;
                }
            }
        }
        if (!productFound) {
            throw new NoProductsHere("Product not found in the cart.");
        }
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(String email){
        Cart cart = cartRepository.findByEmail(email);
        if (cart==null){
            throw new CartDoesnotExist("Cart Doesnot exist");
        }
        return cart;
    }

    @Override
    public Cart setTotalPrice(Cart cart){

        if (!cartRepository.existsByEmail(cart.getEmail())){
            throw new CartDoesnotExist("Cart Doesnot exist");
        }
        Cart update = cartRepository.findByEmail(cart.getEmail());
        update.setTotalPrice(cart.getTotalPrice());
        return cartRepository.save(update);

    }

    @Override
    public String deleteCart(String email){
        Cart cart = cartRepository.findByEmail(email);
        if (cart==null){
            throw new CartDoesnotExist("Cart Doesnot exist");
        }
        cartRepository.delete(cart);
        return "Cart deleted";
    }






}
