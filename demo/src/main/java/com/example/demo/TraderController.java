package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class TraderController {
    @Autowired
    private TraderRepository traderRepository;

    @GetMapping("/traders")
    public List<Trader> getAllTraders() {
        return traderRepository.findAll();
    }

    @GetMapping("/traders/{id}")
    public ResponseEntity<Trader> getTraderById(@PathVariable(value = "id") Long traderId)
            throws Exception {
        Trader trader = traderRepository.findById(traderId)
                .orElseThrow(() -> new Exception("Trader " + traderId + " not found"));
        return ResponseEntity.ok().body(trader);
    }

    @PostMapping("/traders")
    public Trader createTrader(@RequestBody Trader trader) {
        return traderRepository.save(trader);
    }
}