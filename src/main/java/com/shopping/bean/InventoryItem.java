

package com.shopping.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {
    private Long id;
    private String productCode;
    private int availableQuantity;

    public InventoryItem(String productCode, int availableQuantity){
        this.productCode = productCode;
        this.availableQuantity = availableQuantity;
    }


}
