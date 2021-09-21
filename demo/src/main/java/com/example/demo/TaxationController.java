package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TaxationController {
    @Autowired
    private TraderRepository traderRepository;

    @GetMapping("/taxation/{id}")
    public ResponseEntity<Map<String, Float>> getTraderById(@PathVariable(value = "id") Long traderId, @RequestParam(value = "purchaseAmount") float purchaseAmount)
            throws Exception {
        Trader trader = traderRepository.findById(traderId)
                .orElseThrow(() -> new Exception("Trader " + traderId + " not found"));
        HashMap<String, Float> map = new HashMap<>();
        map.put("taxRate", trader.getTaxRate());
        map.put("taxAmount", purchaseAmount * trader.getTaxRate());
        map.put("netSales", purchaseAmount - purchaseAmount * trader.getTaxRate());
        return ResponseEntity.ok().body(map);
    }
}
