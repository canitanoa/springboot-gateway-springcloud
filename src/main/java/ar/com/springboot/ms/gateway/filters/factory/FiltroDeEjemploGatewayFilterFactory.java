package ar.com.springboot.ms.gateway.filters.factory;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class FiltroDeEjemploGatewayFilterFactory extends AbstractGatewayFilterFactory<FiltroDeEjemploGatewayFilterFactory.Configuracion>{

	private final Logger logger = LoggerFactory.getLogger(FiltroDeEjemploGatewayFilterFactory.class);	
	
	public FiltroDeEjemploGatewayFilterFactory() {
		super(Configuracion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public GatewayFilter apply(Configuracion config) {

		logger.info("Ejecutando PRE-GatewayFilterFactory: " + config.messaje);
		
		return new OrderedGatewayFilter((exchange, chain) -> {
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				
				Optional.ofNullable(config.cookieValue).ifPresent(valor -> {
					exchange.getResponse().addCookie(ResponseCookie.from(config.cookieName, valor).build());
				});
				
				logger.info("Ejecutando POST-GatewayFilterFactory");
				
			}));
		}, 2 );
	}
	
	public static class Configuracion {

		private String messaje;
		private String cookieValue;
		private String cookieName;
		
		public String getMessaje() {
			return messaje;
		}
		public void setMessaje(String messaje) {
			this.messaje = messaje;
		}
		public String getCookieValue() {
			return cookieValue;
		}
		public void setCookieValue(String cookieValue) {
			this.cookieValue = cookieValue;
		}
		public String getCookieName() {
			return cookieName;
		}
		public void setCookieName(String cookieName) {
			this.cookieName = cookieName;
		}
	}

}
