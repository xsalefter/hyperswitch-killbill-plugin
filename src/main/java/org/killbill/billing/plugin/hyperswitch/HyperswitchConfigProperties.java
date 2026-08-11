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

import java.util.Map;
import java.util.Properties;

public class HyperswitchConfigProperties {

    private static final String PROPERTY_PREFIX = "org.killbill.billing.plugin.hyperswitch.";

	private final String hyperswitchApikey;
	private final String environment;
	private final String profileId;
    

	public enum Environment {
		PRODUCTION, 
		SANDBOX
	}
	
	public HyperswitchConfigProperties(final Properties properties, final String region) {
		this.hyperswitchApikey = properties.getProperty(PROPERTY_PREFIX + "hyperswitchApikey");
		this.profileId = properties.getProperty(PROPERTY_PREFIX + "profileId");
		this.environment = properties.getProperty(PROPERTY_PREFIX + "environment", "sandbox"); // defaults to sandbox
	}
	

	public String getHSApiKey() {
		if (hyperswitchApikey == null || hyperswitchApikey.isEmpty()) {
			return getClient(hyperswitchApikey, null);
		}
		return hyperswitchApikey;
	}
	
	public String getEnvironment() {
		if (environment == null || environment.isEmpty()) {
			return getClient(environment, null);
		}
		return environment;
	}
	
	public String getProfileId(){
		if (profileId == null || profileId.isEmpty()) {
			return getClient(profileId, null);
		}
		return profileId;
	}
	
	private String getClient(String envKey, String defaultValue) {
		Map<String, String> env = System.getenv();

		String value = env.get(envKey);

		if (value == null || value.isEmpty()) {
			return defaultValue;
		}

		return value;
	}	

}