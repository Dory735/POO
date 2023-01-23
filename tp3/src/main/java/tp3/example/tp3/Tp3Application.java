package tp3.example.tp3;

import java.net.Proxy;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class Tp3Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp3Application.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
	    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

	    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("proxy.univ-lemans.fr", 3128));
	    requestFactory.setProxy(proxy);

	    return new RestTemplate(requestFactory);
	}

}
