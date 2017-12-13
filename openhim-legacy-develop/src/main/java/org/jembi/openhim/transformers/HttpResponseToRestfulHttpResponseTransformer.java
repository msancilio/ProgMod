/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package org.jembi.openhim.transformers;

import java.util.Map;

import org.jembi.openhim.RestfulHttpResponse;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

public class HttpResponseToRestfulHttpResponseTransformer extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage msg, String enc) throws TransformerException {
		
		RestfulHttpResponse restRes = new RestfulHttpResponse();
		
		try {
			int status = Integer.valueOf((String) msg.getProperty("http.status", PropertyScope.INBOUND));
			restRes.setHttpStatus(status);
			String body = msg.getPayloadAsString();
			restRes.setBody(body);
			String uuid = msg.getProperty("uuid", PropertyScope.SESSION);
			restRes.setUuid(uuid);
			restRes.setHttpHeaders((Map<String, Object>) msg.getProperty("http.headers", PropertyScope.INBOUND));
		} catch (Exception e) {
			throw new TransformerException(this, e);
		}
		
		return restRes;
	}

}
