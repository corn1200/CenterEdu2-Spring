package com.kimhs.apis.route;

import com.kimhs.apis.datamodel.dto.SaleDTO;
import com.kimhs.apis.model.Sale;
import com.kimhs.apis.model.User;
import com.kimhs.apis.service.SaleService;
import com.kimhs.apis.datamodel.vo.SalePurchaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleRoute {
    private final SaleService saleService;

    @Autowired
    public SaleRoute(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("")
    @ResponseBody
    public List<SaleDTO> getSales() {
        return this.saleService.sales();
    }

    @GetMapping("/{sale_id}")
    @ResponseBody
    public SaleDTO getSale(@PathVariable(value="sale_id") String saleId) throws Exception {
        return this.saleService.saleById(Integer.parseInt(saleId));
    }

    @GetMapping("/initialize")
    public void initializeSales() {
        this.saleService.initializeSales();
    }

    @PostMapping("/purchase")
    public void purchase(SalePurchaseVO salePurchaseVO) throws Exception {
        int saleId = this.saleService.createSale(salePurchaseVO);
        this.saleService.purchase(saleId);
    }

    @PostMapping("/{sale_id}/refund")
    public void refund(@PathVariable(value = "sale_id") String saleId) throws Exception {
        this.saleService.refund(Integer.parseInt(saleId));
    }
}
