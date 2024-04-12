package Reader;

import java.io.FileReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	// Json File, JsonNode name, POJO classes.
	static String PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\RequestTestDataPayload\\";

	public static <T> T readJsonNodeTestData(String fileName, String JsonNodeName, Class<T> pojoName) throws Exception {

		FileReader file = new FileReader(PATH + fileName);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(file);

		T t = mapper.treeToValue(jsonNode.get(JsonNodeName), pojoName);

		return t;
	}

}
