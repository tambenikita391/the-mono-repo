package org.cases.common;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class CustomIdGenerator implements IdentifierGenerator {

  @Override
  public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
    // Configuration code if needed
  }

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object) {
    // Logic to generate a custom ID
    return "PAT" + RandomStringGenerator.generateRandomString(5);
  }
}
