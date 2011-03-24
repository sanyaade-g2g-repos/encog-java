package org.encog.persist;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.encog.Encog;
import org.encog.util.csv.CSVFormat;
import org.encog.util.csv.NumberList;

public class EncogWriteHelper {
	
	public final static char QUOTE = '\"';
	public final static char COMMA = ',';
	
	private PrintWriter out;
	private StringBuilder line = new StringBuilder();
	private String currentSection;

	public EncogWriteHelper(OutputStream stream)
	{
		this.out = new PrintWriter(stream);		
	}
	
	public void writeLine()
	{
		this.out.println(line.toString());
		line.setLength(0);
	}
	
	public void addColumn(String str)
	{
		if( line.length()>0 )
		{
			line.append(COMMA);
		}
		
		line.append(QUOTE);
		line.append(str);
		line.append(QUOTE);
	}
	
	public void addColumn(boolean b)
	{
		if( line.length()>0 )
		{
			line.append(COMMA);
		}
		
		line.append(b?1:0);
	}
	
	public void addColumn(int i)
	{
		if( line.length()>0 )
		{
			line.append(COMMA);
		}
		
		line.append(i);
	}
	
	public void addColumn(double d)
	{
		if( line.length()>0 )
		{
			line.append(COMMA);
		}
		
		line.append(CSVFormat.ENGLISH.format(d, Encog.DEFAULT_PRECISION));
	}

	public void flush()
	{
		out.flush();
	}

	public void addColumns(List<String> cols) {
		for(String str: cols) {
			addColumn(str);
		}
		
	}

	public void addSection(String str) {
		this.currentSection = str;
		out.println("["+str+"]");		
	}
	
	public void addSubSection(String str) {
		out.println("["+this.currentSection+":"+str+"]");		
	}
	
	public void writeProperty(String name, double value) {
		out.println(name+"="+ CSVFormat.EG_FORMAT.format(value,Encog.DEFAULT_PRECISION));		
	}

	public void writeProperty(String name, int value) {
		out.println(name+"="+value);		
	}

	public void writeProperty(String name, String value) {
		out.println(name+"="+value);	
		
	}

	public void writeProperty(String name, boolean value) {
		out.println(name+"="+(value?'t':'f'));		
	}

	public void writeProperty(String name, CSVFormat csvFormat) {
		String fmt;
		if( csvFormat==CSVFormat.ENGLISH || csvFormat==CSVFormat.ENGLISH || csvFormat==CSVFormat.DECIMAL_POINT) {
			fmt = "decpnt";
		} else if( csvFormat==CSVFormat.DECIMAL_COMMA ) {
			fmt = "deccomma";
		} else {
			fmt = "decpnt";
		}
		out.println(name+"="+fmt);
	}
	public void addLine(String l) {
		if( this.line.length()>0)
			this.writeLine();
		out.println(l);		
	}

	public String getCurrentSection() {
		return this.currentSection;
	}

	public void addProperties(Map<String, String> properties) {
		for(String key: properties.keySet() ) {
			String value = properties.get(key);
			this.writeProperty(key, value);
		}		
	}

	public void writeProperty(String name, double[] d) {
		StringBuilder result = new StringBuilder();
		NumberList.toList(CSVFormat.EG_FORMAT, result, d);
		writeProperty(name,result.toString());
	}
}
