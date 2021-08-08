package com.example.demo;

//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Currency-exchange-service",url = "localhost:8000")
//@LoadBalancerClient(name="CURRENCY-EXCHANGE-SERVICE")
//@FeignClient(name="CURRENCY-EXCHANGE-SERVICE")
//@RibbonClient(name="CURRENCY-EXCHANGE-SERVICE")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConvesionBean retriveExchangeValue(@PathVariable String from, @PathVariable String to) ;
}
