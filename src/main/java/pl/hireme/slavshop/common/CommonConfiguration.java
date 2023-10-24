package pl.hireme.slavshop.common;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.hireme.slavshop.common.profiler.Profiler;

@Configuration
public class CommonConfiguration {

    @Bean
    public LoggingBeanPostProcessor loggingBeanPostProcessor() {
        return new LoggingBeanPostProcessor();
    }

    @Bean
    public Profiler profiler() {
        return new Profiler();
    }

}
