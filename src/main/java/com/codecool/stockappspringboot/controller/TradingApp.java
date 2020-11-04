package com.codecool.stockappspringboot.controller;

import java.io.IOException;
import com.codecool.stockappspringboot.model.Logger;
import com.codecool.stockappspringboot.model.RemoteURLReader;
import com.codecool.stockappspringboot.model.StockAPIService;
import com.codecool.stockappspringboot.model.Trader;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides a command line interface for stock trading.
 **/
@RestController
public class TradingApp {
	@Autowired
	private Logger logger;
	@Autowired
	private RemoteURLReader remoteURLReader;
	@Autowired
	private StockAPIService stockAPIService;
	@Autowired
	private Trader trader;

	@GetMapping("/buy/{stock}/{price}")
	public String buyStock(@PathVariable("stock") String stock, @PathVariable("price")double price) {
		boolean result = false;
		String message;
		try {
			result = trader.buy(stock, price);
			message = (result) ? "Purchased Stock." : "Couldn't purchase stock at that price.";
		} catch (JSONException | IOException e) {
			message = "There was an error while attempting to buy stock.";
			e.printStackTrace();
		}

		return message;
	}
}