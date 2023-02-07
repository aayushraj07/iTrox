package com.example.commons.configurations;

// import com.amazonaws.services.secretsmanager.AWSSecretsManager;
// import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
// import com.amazonaws.services.secretsmanager.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Slf4j
@Component("PropertiesListener")
public class PropertiesListener implements ApplicationListener<ApplicationPreparedEvent> {

  private static final String DEFAULT_AWS_SECRETS_KEY_NAME = "test-secret";
  private static final String DEFAULT_AWS_REGION = "us-east-2";

  private static final String SPRING_DATASOURCE_USERNAME = "spring.datasource.username";
  private static final String SPRING_DATASOURCE_URI = "spring.datasource.url";
  private static final String SPRING_DATASOURCE_PASSWORD = "spring.datasource.password";

  private static final String SPRING_JPA_DDL_AUTO = "spring.jpa.hibernate.ddl-auto";
  private static final String SPRING_JPA_SHOW_SQL = "spring.jpa.show-sql";
  private static final String LOGGING_LEVEL_SPRING = "logging.level.org.springframework.data";
  private static final String LOGGING_LEVEL_SQL = "logging.level.org.hibernate.SQL";
  private static final String JWT_SECRET = "jwt.secret";
  private static final String JWT_TOKEN_EXPIRATION_IN_SECONDS = "jwt.token.expiration.in.seconds";
  private static final String AWS_S3_REGION = "aws.s3.region";
  private static final String AWS_S3_BUCKET = "aws.s3.bucket";
  private ObjectMapper mapper = new ObjectMapper();

  //  @Override
  //  public void onApplicationEvent(ApplicationPreparedEvent event) {
  //    ConfigurableEnvironment environment = event.getApplicationContext().getEnvironment();
  //
  //    if (environment.getActiveProfiles().length != 0
  //        && !environment.getActiveProfiles()[0].equals("default")) {
  //
  //      String secretKey =
  //          resolveValue(environment, "AWS_SECRETS_KEY_NAME", DEFAULT_AWS_SECRETS_KEY_NAME);
  //      String region = resolveValue(environment, "AWS_SECRETS_REGION", DEFAULT_AWS_REGION);
  //
  //      String secretJson = getSecretJson(secretKey, region);
  //
  //      if (secretJson == null) return;
  //
  //      Properties props = new Properties();
  //
  //      String[] keys = {
  //        SPRING_DATASOURCE_USERNAME,
  //        SPRING_DATASOURCE_URI,
  //        SPRING_DATASOURCE_PASSWORD,
  //        SPRING_JPA_DDL_AUTO,
  //        SPRING_JPA_SHOW_SQL,
  //        LOGGING_LEVEL_SPRING,
  //        LOGGING_LEVEL_SQL,
  //        JWT_SECRET,
  //        JWT_TOKEN_EXPIRATION_IN_SECONDS,
  //        AWS_S3_REGION,
  //        AWS_S3_BUCKET
  //      };
  //
  //      for (String key : keys) {
  //        props.put(key, getString(secretJson, key));
  //      }
  //      environment
  //          .getPropertySources()
  //          .addFirst(new PropertiesPropertySource("aws.secret.manager", props));
  //    }
  //  }

  /*
   * function to fetch value of key from environment variable,
   * returns default value of not present or null
   * */
  private String resolveValue(ConfigurableEnvironment env, String key, String defaultValue) {
    String fromEnv = env.getProperty(key);
    if (fromEnv == null) {
      return defaultValue;
    }
    return fromEnv;
  }

  @Override
  public void onApplicationEvent(ApplicationPreparedEvent event) {}

  /*
   * The function will fetch json secret from aws secrets with the key specified
   * */
  //  private String getSecretJson(String secretKey, String region) {
  //
  //    AWSSecretsManager client =
  // AWSSecretsManagerClientBuilder.standard().withRegion(region).build();
  //    String secret = null;
  //    GetSecretValueRequest getSecretValueRequest =
  //        new GetSecretValueRequest().withSecretId(secretKey);
  //    GetSecretValueResult getSecretValueResult;
  //
  //    try {
  //      getSecretValueResult = client.getSecretValue(getSecretValueRequest);
  //
  //      if (getSecretValueResult != null && getSecretValueResult.getSecretString() != null) {
  //        secret = getSecretValueResult.getSecretString();
  //      }
  //
  //    } catch (DecryptionFailureException
  //        | InternalServiceErrorException
  //        | InvalidParameterException
  //        | InvalidRequestException
  //        | ResourceNotFoundException e) {
  //      LOGGER.error(e.getMessage(), e);
  //      return null;
  //    }
  //    return secret;
  //  }

  /*
   * Function to fetch value of key from json as string.
   * @param json json string
   * @param path key to find
   * @return string value for specific key
   **/
  //  private String getString(String json, String path) {
  //
  //    try {
  //      JsonNode root = mapper.readTree(json);
  //      return root.path(path).asText();
  //    } catch (IOException e) {
  //      LOGGER.error(e.getMessage(), e);
  //      return null;
  //    }
  //  }
}
