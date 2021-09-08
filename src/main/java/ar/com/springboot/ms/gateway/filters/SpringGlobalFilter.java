package ar.com.springboot.ms.gateway.filters;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SpringGlobalFilter  implements GlobalFilter, Ordered{

	private final Logger logger = LoggerFactory.getLogger(SpringGlobalFilter.class);	
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		logger.info("Ejecutando PRE-Filter");
		exchange.getRequest().mutate().headers(h -> h.add("token", "123456"));
		
		
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
						
			logger.info("Ejecutando POST-Filter");
			
			Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(valor -> {
				exchange.getResponse().getHeaders().add("token", valor);
			});
			
			exchange.getResponse().getCookies().add("color", ResponseCookie.from("color","rojo").build());
//			exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
			
		}));
	}

	@Override
	public int getOrder() {
		// Le asigna el orden al filtro, si tenemos mas de uno, esta conf indica cual se ejecurta primero
		return 0;
	}

}
