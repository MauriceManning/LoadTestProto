/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.berkeley.path.next.CTMEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class JmsPublish {

    /**
     * Autowired annotation denotes member to be conncted by Spring's dependency injection
     * facilities Fields are injected right after construction of a bean, before any
     * config methods are invoked.
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendLinkList(List<LinkDataRaw> links) {
        jmsTemplate.convertAndSend(links);
    }
}
