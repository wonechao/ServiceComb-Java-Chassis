/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.core.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.servicecomb.core.Invocation;
import io.servicecomb.core.Transport;
import io.servicecomb.swagger.invocation.AsyncResponse;

public class TransportClientHandler extends AbstractHandler {

  private static final Logger log = LoggerFactory.getLogger(TransportClientHandler.class);

  public static final TransportClientHandler INSTANCE = new TransportClientHandler();

  @Override
  public void handle(Invocation invocation, AsyncResponse asyncResp) throws Exception {
    Transport transport = invocation.getTransport();

    log.debug(
        "Sending request {} to end point {}",
        invocation.getOperationName(),
        transport.getEndpoint().getEndpoint());

    transport.send(invocation, asyncResp);
  }
}
