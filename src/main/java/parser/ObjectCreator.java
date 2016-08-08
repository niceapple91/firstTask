package parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ObjectCreator {

	public <T> Collection<Object[]> createObjectService(T object, String fileAdress) {
		return parse(object, fileAdress);
	}

	private <T> Collection<Object[]> parse(T object, String name) {
		InputStream in = null;
		HSSFWorkbook wb = null;
		Collection<Object[]> objectsList = new ArrayList<Object[]>();
		Class<?> clas = object.getClass();
		Field[] fields = clas.getDeclaredFields();
		try {
			in = new FileInputStream(name);
			wb = new HSSFWorkbook(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		Row header = it.next();
		Iterator<Cell> iteratorCellHeader = header.cellIterator();
		Cell cellHeader;
		Cell cellBody;
		while (it.hasNext()) {
			Iterator<Row> iteratorHeader = sheet.iterator();
			header = iteratorHeader.next();
			iteratorCellHeader = header.cellIterator();

			Row rowBody = it.next();
			Iterator<Cell> cellIteratorBody = rowBody.cellIterator();

			T element = null;
			try {
				element = (T) object.getClass().getDeclaredConstructor().newInstance();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			while (cellIteratorBody.hasNext() && iteratorCellHeader.hasNext()) {

				cellHeader = (Cell) iteratorCellHeader.next();
				cellBody = (Cell) cellIteratorBody.next();
				for (Field field : fields) {
					if (cellHeader.getStringCellValue().equals(field.getName())) {
						try {

							field.setAccessible(true);
							field.set(element, cellBody.getStringCellValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}

			objectsList.add(new Object[] { element });
		}

		return objectsList;
	}
}
