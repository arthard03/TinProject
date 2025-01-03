    package tin.tinproject.Config;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
    import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
    import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

    @Configuration
    @EnableMethodSecurity
    public class RoleHierarchyConfig {
        @Bean
        public RoleHierarchy roleHierarchy() {
            RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
            String hierarchy =
                    "ROLE_ADMIN > ROLE_USER";
            roleHierarchy.setHierarchy(hierarchy);
            return roleHierarchy;
        }
    }