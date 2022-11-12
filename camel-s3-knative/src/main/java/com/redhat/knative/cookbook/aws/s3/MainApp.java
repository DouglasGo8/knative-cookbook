package com.redhat.knative.cookbook.aws.s3;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

@QuarkusMain
public class MainApp {
  public static void main(String... args) {
    Quarkus.run(CamelMainApplication.class, args);
  }
}
