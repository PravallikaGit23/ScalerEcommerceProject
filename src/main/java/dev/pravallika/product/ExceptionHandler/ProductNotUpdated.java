package dev.pravallika.product.ExceptionHandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotUpdated extends Exception {
    private String message;

    public ProductNotUpdated(String message) {
        this.message = message;
    }
}
