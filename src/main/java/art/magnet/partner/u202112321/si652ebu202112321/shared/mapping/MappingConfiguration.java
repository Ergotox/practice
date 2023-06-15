package art.magnet.partner.u202112321.si652ebu202112321.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhanceModelMapper modelMapper(){
        return new EnhanceModelMapper();
    }
}
