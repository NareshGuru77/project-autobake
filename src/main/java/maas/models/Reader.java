package maas.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import maas.agents.Bakery;
import maas.agents.Customer;
import maas.agents.KneadingMachineController;

public class Reader {

	Meta meta;
	Bakery[] bakeries;
	Customer[] customers;
	Order[] orders;
	StreetNetwork[] street_network;

	public Meta getMeta() {
		return meta;
	}

	public Bakery[] getBakeries() {
		return bakeries;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public Order[] getOrders() {
		return orders;
	}

	public StreetNetwork[] getStreetNetwork() {
		return street_network;
	}

	public void readJsonFile(String path) {
		Logger log = LogManager.getLogger(Reader.class);
		
		InputStream stream = null;
		
		JsonReader reader = null;
		
		try {
			stream = new FileInputStream(path);

			reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));

			Gson gson = new GsonBuilder().create();

			reader.beginObject();

			while (reader.hasNext()) {
				String name = reader.nextName();

				switch (name) {
				case "meta":
					meta = gson.fromJson(reader, Meta.class);
					break;
				case "bakeries":
					bakeries = gson.fromJson(reader, Bakery[].class);
					break;
				case "customers":
					customers = gson.fromJson(reader, Customer[].class);
					break;
				case "orders":
					parseOrders(gson, reader);
					break;
				case "street_network":
					street_network = gson.fromJson(reader, StreetNetwork[].class);
					break;
				default:
					reader.skipValue();
					break;
				}
			}
			log.info("Successfully read json file!");
		} catch (UnsupportedEncodingException e) {
			log.error("Unsupported Encoding for Json file", e);
		} catch (IOException e) {
			log.error("Error in reading Json File", e);
		} finally {
			try {
				reader.close();
				stream.close();
			} catch (IOException e) {
				log.error("Error in closing Json File", e);
			}
		}
	}

	private void parseOrders(Gson gson, JsonReader reader) {
		Order[] orders = new Order[meta.orders];

		try {
			reader.beginArray();

			for (int i = 0; i < meta.orders; ++i) {
				reader.beginObject();
				
				reader.nextName();
				
				Date order_date = gson.fromJson(reader, Date.class);
				
				reader.nextName();
				
				String customer_id = gson.fromJson(reader, String.class);
				
				reader.nextName();
				
				reader.beginObject();
				
				ArrayList<ProductsToOrder> list = new ArrayList<ProductsToOrder>();
				
				while(reader.peek() != JsonToken.END_OBJECT) {
					String product_name = reader.nextName();
					int quantity = reader.nextInt();
					ProductsToOrder productsToOrder = new ProductsToOrder(product_name, quantity);
					list.add(productsToOrder);
				}
				
				reader.endObject();
				
				reader.nextName();
				
				String guid = gson.fromJson(reader, String.class);
				
				reader.nextName();
				
				Date delivery_date = gson.fromJson(reader, Date.class);
				
				orders[i] = new Order(guid, customer_id, order_date, delivery_date, list);
				
				reader.endObject();
			}
			
		} catch (IOException e) {
			Logger log = LogManager.getLogger(Reader.class);
			log.error("Error in processing orders from Json File", e);
		}

		this.orders = orders;
	}
}
