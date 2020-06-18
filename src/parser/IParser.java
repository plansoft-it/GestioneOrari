package parser;

import java.io.IOException;
import java.util.List;

import row.Row;

public interface IParser {
	public List<Row> parse() throws IOException;
}
