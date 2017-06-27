package tools;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * The CSVGenerator class
 *
 * CSVGenerator create CSV file following data passing into it
 *
 * @code
     // example: the following code will generate a small csv file
	 CSVGenerator mycsv = new CSVGenerator("myFilename.csv","title", "2016-07-12 13:37");
	 
	 mycsv.addLine("a new row", "with several column", 42, 23.4);
	 mycsv.addLine("a new row", "with several column", 44, 22.4);
	 mycsv.lineBreak(); // add empty row
	 mycsv.addLine("a new row after line break", 44, 22.4, 1, 2, 3, 4, 5, 6);
	 
	 try {
		mycsv.save(); // save file
	} catch (IOException e) {
		e.printStackTrace();
	} 
 * @endcode
 * 
 * @author Antoine
 *
 */
public class CSVGenerator {

	private ArrayList<String> lines;
	private String title;
	private String filepath;
	private String date;
	private boolean addTitle;
	private boolean addDate;
    static String SEPARATOR = ";";///< separator separate data into the csv file by default it's ','
	
	
	public CSVGenerator() {
		lines = new ArrayList<>();
		addTitle = true;
		addDate = true;
		
		filepath = "default.csv";
		title = "Report";
		date = new SimpleDateFormat("dd-MM-yyyy H:m:s").format(new Date());
	}
	
	/**
	 * Create new CSV report with specific date
	 * @param filepath
	 * @param title
	 * @param date
	 */
	public CSVGenerator(String filepath, String title, String date) {
		this.filepath = filepath;
		this.title = title;
		this.date = date;
		lines = new ArrayList<>();
		addTitle = true;
		addDate = true;
		
	}
	
	/**
	 * Create new CSV report with current date
	 * @param filepath
	 * @param title
	 */
	public CSVGenerator(String filepath, String title) {
		this.filepath = filepath;
		this.title = title;
		this.date = new SimpleDateFormat("dd-MM-yyyy H:m:s").format(new Date());
		lines = new ArrayList<>();
		addTitle = true;
		addDate = true;
		
	}
	
	 /**
     *  addColumn add new column to the last line
     * @param val value to add at the end of the line
     */
	public void addColumn(String val){
        if (lines.isEmpty()) {
            lines.add(val);
        } else {
            lines.set(lines.size()-1,lines.get(lines.size()-1) + val + SEPARATOR);
        }
    }
    public void addToLastLine(String val){
    	addColumn(val);
    }

    /**
     *  addColumn add new element at line specified by 'line'
     * @param val value to add at the end of the line
     * @param line first line start at 0
     */
    public void addColumn(String val, int line){
        if (!lines.isEmpty() && line < lines.size()) {
            lines.set(line,lines.get(line) + val + SEPARATOR);
        }
    }

    /**
     *  addLineBreak
     *
     * Use this method to add space between lines. Do the same thing like lineBreak()
     */
    public void addLineBreak(){
    	addLine("");
    }

    /**
     *  lineBreak
     * Use this method to add space between lines. Do the same thing like addLineBreak()
     */
    public void lineBreak(){
    	addLine("");
    }
    
    /**
     * addLine(Object ... rest)
     * Add new line to CSV which contains all arguments separated by CSVGenerator::SEPARATOR
     */
    public void addLine(Object... values) {
        String line = "";
    	for (Object ob: values) {
        	line += ob.toString() + SEPARATOR;
        }
    	lines.add(line);
    }

    /**
     * Merge csv
     * @param csv
     * @param addTitle add csv title
     * @param addDate add csv date
     */
    public void merge(CSVGenerator csv, boolean addTitle, boolean addDate) {
    	if (addTitle) lines.add(csv.getTitle());
    	if (addDate) lines.add(csv.getDate());
    	lines.addAll(csv.getLines());
    }

    /**
     *  save data in "filename".csv
     * @return true
     * @throws IOException 
     */
    public void save() throws IOException{
    	ArrayList<String> tmp = new ArrayList<>(lines);
    	if (addDate) tmp.add(0, date);
    	if (addTitle) tmp.add(0, title);
    	FileTools.write(filepath, false, tmp);
    }

    /**
     * setSeparator change separator if your csv reader except specific separator like ';' or ';;'
     * @param sep
     */
    public static void setSeparator(String sep) { SEPARATOR = sep; }

    //getters
    public String getTitle() { return title;}
    public String getFilename() { return filepath;}
    public String getDate() { return date;}
    public ArrayList<String> getLines() { return lines;}

    //setters
    public void setTitle(String val) { title = val;}
    public void setFilename(String val) { filepath = val;}
    public void setDate(String val) { date = val;}
    public void setAddTitle(boolean val) { addTitle = val; }
    public void setAddDate(boolean val) { addDate = val;}
    	
}
