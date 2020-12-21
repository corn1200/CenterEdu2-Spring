package com.kimhs.apis.datamodel.dto;

import com.kimhs.apis.datamodel.enumModel.SaleStatusEnum;
import com.kimhs.apis.model.Sale;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
public class SaleDTO {
    private int saleId;
    private int userId;
    private int productId;
    private int paidPrice;
    private int listPrice;
    private int amount;
    private SaleStatusEnum status = SaleStatusEnum.NON_PAID;

    public SaleDTO(Sale sale) {
        this.saleId = sale.getSaleId();
        this.userId = sale.getUserId();
        this.paidPrice = sale.getPaidPrice();
        this.listPrice = sale.getListPrice();
        this.amount = sale.getAmount();
        this.status = sale.getStatus();
    }

    @Override
    public String toString() {
        return String.format(
                "Sale[saleId=%d, userId=%d, productId=%d, paidPrice=%d, listPrice=%d, amount=%d, status='%s']",
                this.saleId, this.userId, this.productId, this.paidPrice, this.listPrice, this.amount, this.status
        );
    }
}
