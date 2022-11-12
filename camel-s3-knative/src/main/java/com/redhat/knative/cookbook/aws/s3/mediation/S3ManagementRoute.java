package com.redhat.knative.cookbook.aws.s3.mediation;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.s3.AWS2S3Constants;
import org.apache.camel.support.processor.idempotent.MemoryIdempotentRepository;

import javax.enterprise.context.ApplicationScoped;


@NoArgsConstructor
@ApplicationScoped
public class S3ManagementRoute extends RouteBuilder {
  @Override
  public void configure() {

    onException(Exception.class)
            .log("${body}");

    final var s3endPoint = "aws2-s3://mycamelquarkusbucket?useDefaultCredentialsProvider=true" +
            "&deleteAfterRead=false&operation=getObject";


    from("timer://myTimer?fixedRate=true&period=30s&delay=5s")
            .transform(constant("critic_udemy_bpm.txt"))
            //.to("controlbus:route?routeId=myRouteId&action=start");
            .to("direct:foo");




    //
    from("direct:foo")//.routeId("myRouteId").autoStartup(false)
            //.idempotentConsumer(simple("${header.CamelAwsS3Key}"),
            //        MemoryIdempotentRepository.memoryIdempotentRepository())

            //.log("${header.CamelAwsS3Key}")
            //.transform(simple(s3endPoint))
            //.log("${body}")
            .setHeader(AWS2S3Constants.KEY, simple("${body}"))
            .toD(s3endPoint)
            .log("${header.CamelAwsS3Key}")
            .log("${body}")
            //.toD("http://kserving-dougdb.kn-serving-projects.127.0.0.1.sslip.io/serving/my-bucket/${header.CamelAwsS3Key}")
            .end();
  }
}
