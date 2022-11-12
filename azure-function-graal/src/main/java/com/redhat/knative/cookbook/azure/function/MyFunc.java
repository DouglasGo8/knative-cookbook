package com.redhat.knative.cookbook.azure.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.BlobTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.StorageAccount;

/**
 * Azure Functions with HTTP Trigger.
 */
public class MyFunc {
  /**
   * This function listens at endpoint "/api/MyFunc". Two ways to invoke it using "curl" command in bash:
   * 1. curl -d "HTTP Body" {your host}/api/MyFunc
   * 2. curl {your host}/api/MyFunc?name=HTTP%20Query
   */
  @FunctionName("MyFunc")
  @StorageAccount("glengatesteventgridblob_STORAGE")
  public void run(
          @BlobTrigger(name = "content", path = "samples-workitems/{name}", dataType = "binary"
                  , connection = "AzureWebJobsStorage") byte[] content,
          @BindingName("name") String name,
          final ExecutionContext context) {
    context.getLogger().info("Java HTTP trigger processed a request.");

    // Parse query parameter

  }
}
