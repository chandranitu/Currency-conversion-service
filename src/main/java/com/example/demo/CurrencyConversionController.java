package com.example.demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvesionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVarible = new HashMap<String, String>();
		uriVarible.put("from", from);
		uriVarible.put("to", to);

		ResponseEntity<CurrencyConvesionBean> resEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConvesionBean.class, uriVarible);
		CurrencyConvesionBean res = resEntity.getBody();
		return new CurrencyConvesionBean(res.getId(), from, to, quantity, res.getConversionMultiple(),
				quantity.multiply(res.getConversionMultiple()), res.getPort());
	}
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvesionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConvesionBean res=proxy.retriveExchangeValue(from, to);
		return new CurrencyConvesionBean(res.getId(), from, to, quantity, res.getConversionMultiple(),
				quantity.multiply(res.getConversionMultiple()), res.getPort());
	}
}
