package hu.deposoft.allergy.config;

// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
// import io.swagger.v3.oas.annotations.info.Info;
// import io.swagger.v3.oas.annotations.security.*;
// import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
// @OpenAPIDefinition(
//    info = @Info(title = "Allergy app", version = "0.0.1", description = "Allergy app"),
//    servers = {@Server(url = "http://localhost:8080")})
// @SecuritySchemes({
//  @SecurityScheme(
//      name = "oauth2",
//      type = SecuritySchemeType.OAUTH2,
//      flows =
//          @OAuthFlows(
//              authorizationCode =
//                  @OAuthFlow(
//                      authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}",
//                      tokenUrl = "${springdoc.oAuthFlow.tokenUrl}",
//                      scopes = {
//                        @OAuthScope(name = "openid", description = "OpenID"),
//                        @OAuthScope(name = "profile", description = "Profile")
//                      })))
// })
public class OpenAPIConfig {}
