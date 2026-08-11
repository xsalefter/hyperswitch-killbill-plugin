/*
 * Copyright 2026 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.killbill.billing.plugin.hyperswitch;

import java.util.HashMap;
import java.util.Map;
import com.hyperswitch.client.model.PaymentsResponse;
import com.hyperswitch.client.model.RefundResponse;

public abstract class HyperswitchPluginProperties {
    public static Map<String, Object> toAdditionalDataMap(final PaymentsResponse hyperswitchPaymentResponse) {
        final Map<String, Object> additionalDataMap = new HashMap<>();

        additionalDataMap.put("amount", hyperswitchPaymentResponse.getAmount());
        additionalDataMap.put("payment_id", hyperswitchPaymentResponse.getPaymentId());
        additionalDataMap.put("status", hyperswitchPaymentResponse.getStatus());
        additionalDataMap.put("customer_id", hyperswitchPaymentResponse.getCustomerId());
        additionalDataMap.put("reference_id",hyperswitchPaymentResponse.getReferenceId());
        additionalDataMap.put("profile_id", hyperswitchPaymentResponse.getProfileId());
        return additionalDataMap;
    }

    public static Map<String, Object> toAdditionalDataMap(final RefundResponse hyperswitchPaymentResponse) {
        final Map<String, Object> additionalDataMap = new HashMap<>();

        additionalDataMap.put("amount", hyperswitchPaymentResponse.getAmount());
        additionalDataMap.put("payment_id", hyperswitchPaymentResponse.getPaymentId());
        additionalDataMap.put("refund_id",hyperswitchPaymentResponse.getRefundId());
        additionalDataMap.put("status", hyperswitchPaymentResponse.getStatus());
        additionalDataMap.put("profile_id", hyperswitchPaymentResponse.getProfileId());
        return additionalDataMap;
    }
}