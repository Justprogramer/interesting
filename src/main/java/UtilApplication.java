import com.tao.springaop.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>
 * </p>
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan({"com.tao"})
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class UtilApplication {
    private final Person person;

    @Autowired
    public UtilApplication(Person person) {
        this.person = person;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(UtilApplication.class, args);
        String testBean = (String) run.getBean("testBean");
        System.out.println(testBean);
    }

    @Bean
    public String testBean() {
        person.name("hello aop");
        return person.getClass().toString();
    }

}
