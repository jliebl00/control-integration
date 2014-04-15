package es.unileon.assets;

import java.io.File;
import java.io.IOException;

import jxl.*;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

/**
 * Class that allow to create a xls documment to present the time table about
 * fees
 * 
 * @author CarlitosMayo
 * 
 */
public class CreateDocument {
	private WritableWorkbook workbook;
	private WritableSheet sheet;
	private int counter1, counter2, counter3, counter4, counter5;

	@SuppressWarnings("deprecation")
	public CreateDocument(String path) {
		counter1 = counter2 = counter3 = counter4 = counter5 = 7; // Se empiezan
																	// a�adir
																	// datos a
																	// partir de
																	// la fila 8
																	// del
																	// excel.

		try {
			// Create excell workbook
			workbook = Workbook.createWorkbook(new File(path));

			// Create a sheet inside the workbook
			sheet = workbook.createSheet("Pagina", 0);

			// Asignamos un formato a las celdas y al texto que van a contener.
			WritableCellFormat format = new WritableCellFormat(
					new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD));
			format.setBackground(Colour.ICE_BLUE);
			format.setBorder(Border.ALL, BorderLineStyle.MEDIUM);

			WritableCellFormat format2 = new WritableCellFormat(
					new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD));
			format2.setBackground(Colour.ICE_BLUE);
			format2.setBorder(Border.ALL, BorderLineStyle.MEDIUM);

			WritableCellFormat format3 = new WritableCellFormat(
					new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD));

			// Write in the excell cells
			sheet.mergeCells(2, 0, 7, 0);
			sheet.addCell(new Label(2, 0, "PLAN DE AMORTIZACI�N PR�STAMO",
					format));
			sheet.addCell(new Label(
					0,
					2,
					"Anexo al Contrato de Financiaci�n a comprador de bienes inmuebles, impreso n�:"));
			sheet.addCell(new Label(0, 3, "Celebrado:"));
			sheet.addCell(new Label(
					0,
					5,
					"--------------------------------------------------------------------------------------------------------------------------------------------------------------------"));

			// Group some cells
			sheet.mergeCells(0, 6, 1, 6);
			sheet.mergeCells(2, 6, 3, 6);
			sheet.mergeCells(4, 6, 5, 6);
			sheet.mergeCells(6, 6, 7, 6);
			sheet.mergeCells(8, 6, 9, 6);

			sheet.addCell(new Label(0, 6, "VENCIMIENTO", format2));
			sheet.addCell(new Label(2, 6, "IMPORTE PLAZO", format2));
			sheet.addCell(new Label(4, 6, "AMORT.CAPITAL", format2));
			sheet.addCell(new Label(6, 6, "INTERESES", format2));
			sheet.addCell(new Label(8, 6, "CAPITAL PENDIENTE", format2));
			sheet.addCell(new Label(
					0,
					10,
					"En prueba de conformidad, firman las partes el presente contrato en ..... hojas y tantos ejemplares como partes intervienen."));
			sheet.addCell(new Label(
					0,
					12,
					"En .................................. a ..... de .................. de ........"));
			sheet.addCell(new Label(0, 14, "El/Los Prestatario/s", format3));
			sheet.addCell(new Label(2, 14, "El/Los Fiador/es", format3));
			sheet.addCell(new Label(4, 14, "El Financiador", format3));
			sheet.addCell(new Label(6, 14, "El Fedatario", format3));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	// Add the contract number
	public void addNumContract(String num) {
		try {
			sheet.addCell(new Label(8, 2, "" + num));

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	// Add the start and finish dates
	public void addStartFinishDates(String startDate, String finishDate) {
		try {
			sheet.addCell(new Label(0, 3, "Celebrado entre: " + startDate
					+ " y " + finishDate));

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	// Add expiration date
	public void addExpiration(String date) {
		try {
			sheet.addCell(new Label(0, counter1, date));

			counter1++;
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	// Add data to some cells.
	public void addFeeAmount(double number) {
		try {
			sheet.addCell(new Number(2, counter2, number));

			counter2++;
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	// Add the money that are been payed.
	public void addAmortizedCapital(double number) {
		try {
			sheet.addCell(new Number(4, counter3, number));

			counter3++;
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	// Add data to interes colummns.
	public void addInteres(double number) {
		try {
			sheet.addCell(new Number(6, counter4, number));

			counter4++;
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	// Add data to the money that the owner do not pay.
	public void addPendingCapital(double number) {
		try {
			sheet.addCell(new Number(8, counter5, number));

			counter5++;
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	// Generate the Excell file
	public void export() {
		// Write the results in the excell file
		try {
			workbook.write();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
