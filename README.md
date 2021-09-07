# springboot-gateway-springcloud
## Gateway de Spring Cloud	

> Gateway Spring Cloud: 
- Spring Cloud Gateway puede considerarse un sucesor del proyecto Spring Cloud Netflix Zuul. Ambos proyectos se encargan de proporcionar un punto de entrada a nuestro ecosistema de microservicios, proporcionando capacidades de enrutamiento dinámico, seguridad y monitorización de las llamadas que se realicen.Por medio de este podemos gestionar el acceso a diferentes microservicios en vez de que cada uno tenga un punto de acceso único.
- Spring Cloud Gateway se basa en Spring Framework 5, Project Reactor (permitiendo la integración con Spring WebFlux) y Spring Boot 2 utilizando API sin bloqueo. Esto hace que sea compatible con conexiones de larga duración (Websockets) y tiene una mejor integración con Spring.

> ¿Qué características y funcionalidades nos proporciona Spring Cloud Gateway?
- Todas las características y funciones que vamos a nombrar a continuación se pueden configurar mediante una clase Java o mediante un archivo de properties (.yml).

- Routing Handler	Spring Cloud Gateway envía las solicitudes al Gateway Handler Mapping que determina qué se debe hacer con las solicitudes que coinciden con una ruta específica
- Dynamic Routing	Al igual que Zuul , Spring Cloud Gateway proporciona medios para enrutar solicitudes a diferentes servicios
- Routing Factories	Spring Cloud Gateway combina las rutas usando la infraestructura Spring WebFlux HandlerMapping. Incluye muchas built-in Route Predicate Factories. Todos estos Predicates coinciden con diferentes atributos de la solicitud HTTP pudiéndolos combinarlos.
- WebFilter Factories	Los filtros de enrutamiento hacen posible la modificación de la solicitud HTTP entrante o de la respuesta HTTP saliente
- Spring Cloud DiscoveryClient Support	Spring Cloud Gateway se puede integrar fácilmente con las bibliotecas Service Discovery y Registry, como Eureka Server y Consul
- Monitoring	Spring Cloud Gateway hace uso de la API Actuator, una conocida biblioteca Spring-Boot que proporciona varios servicios listos para monitorear la aplicación