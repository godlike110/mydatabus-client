package com.godlike.databus.client;

import java.util.Map;

import com.godlike.databus.consumer.PersonConsumer;
import com.linkedin.databus.client.DatabusHttpClientImpl;
import com.linkedin.databus.client.pub.ServerInfo.ServerInfoBuilder;

public class PersonClient {

	static final String PERSON_SOURCE = "com.linkedin.events.or_test.Person";

	public static void main(String[] args) throws Exception {
		DatabusHttpClientImpl.Config configBuilder = new DatabusHttpClientImpl.Config();

		// Try to connect to a relay on localhost
		// configBuilder.getRuntime().getRelay("2").setHost("localhost");
		// configBuilder.getRuntime().getRelay("2").setPort(11115);
		// configBuilder.getRuntime().getRelay("2").setSources(PERSON_SOURCE);
		// Map<String, ServerInfoBuilder> servers =
		// configBuilder.getRuntime().getRelays();
		configBuilder.getRuntime().getRelay("1").setHost("localhost");
		configBuilder.getRuntime().getRelay("1").setConsumers("personConsumer");
		configBuilder.getRuntime().getRelay("1").setPort(11115);
		configBuilder.getRuntime().getRelay("1").setSources(PERSON_SOURCE);
		System.out.println("a");

		// Instantiate a client using command-line parameters if any
		DatabusHttpClientImpl client = DatabusHttpClientImpl.createFromCli(
				args, configBuilder);

		// register callbacks
		PersonConsumer personConsumer = new PersonConsumer();
		client.registerDatabusStreamListener(personConsumer, null,
				PERSON_SOURCE);
		client.registerDatabusBootstrapListener(personConsumer, null,
				PERSON_SOURCE);

		// fire off the Databus client
		client.startAndBlock();
	}

}
