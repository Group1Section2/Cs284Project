package UuploadFileAndFillScore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FillPointPanal extends JPanel {
	private JButton uploadBtn, addBtn, deleteBtn, updateBtn, calculateBtn, saveBtn, exitBtn;
	private JFileChooser jfc;
	private File file;
	private StudentControl stc;
	private JTable studentInfoTable;
	private ArrayList<String> columnName;
	private String[][] rows;
	private String newColumnName;
	private ArrayList<Score> scores;
	private ArrayList<Double> NetScore;

	public FillPointPanal() {

		JPanel controlPanel = new JPanel(); /// เอาไว้ใส่ พวกปุ่ม
		JPanel tablepanel = new JPanel();
		JPanel btnPanel = new JPanel();

		jfc = new JFileChooser(".");
		stc = new StudentControl();

		scores = new ArrayList<>();
		NetScore = new ArrayList<>();

		addBtn = new JButton("Add Exam Score");
		///// หัวข้อ //////////////////////////
		columnName = new ArrayList<>();
		columnName.add("Index");
		columnName.add("ID.");
		columnName.add("Name");
		///////////////////////////////////
		rows = new String[0][3];

		studentInfoTable = new JTable(rows, columnName.toArray());

		JScrollPane tableScroll = new JScrollPane(studentInfoTable);
		tableScroll.setPreferredSize(new Dimension(800, 460));
		tablepanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "Untitled"));
		tablepanel.add(tableScroll);

		uploadBtn = new JButton("Upload File");// ปุ่มเปิดไฟล์
		uploadBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jfc.showOpenDialog(null) == jfc.APPROVE_OPTION) {
					file = jfc.getSelectedFile();
					stc.readFile(file);
					tablepanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), file.getName()));
					rows = new String[stc.getData().size()][columnName.size()];

					////// เอาขอมูลในไฟล์ มาลง ตาราง //////////////////////////////////
					for (int i = 0; i < stc.getData().size(); i++) {
						for (int j = 0; j < columnName.size(); j++) {
							if (j == 0) {
								rows[i][j] = stc.getData().get(i).getIndex() + "";

							} else if (j == 1) {
								rows[i][j] = stc.getData().get(i).getId() + "";

							} else if (j == 2) {
								rows[i][j] = stc.getData().get(i).getName();

							}
						}
					}
					//////////////////////////////////////////////////////
					addBtn.setEnabled(true);

					studentInfoTable.setModel(new DefaultTableModel(rows, columnName.toArray()));

				}

			}
		});
		/////// เพิ่ม column ////////////////////
		addBtn = new JButton("Add Exam");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				newColumnName = JOptionPane.showInputDialog(null, "Input your column name");
				if (newColumnName != null) {
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					columnName.add(newColumnName);
					studentInfoTable.setModel(new DefaultTableModel(rows, columnName.toArray()));
				}
			}
		});

		/////// ลบ column ////////////////////
		deleteBtn = new JButton("Delete Exam");
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (columnName.size() > 3) {
					columnName.remove(columnName.size() - 1);
					studentInfoTable.setModel(new DefaultTableModel(rows, columnName.toArray()));

					if (stc.getData().size() > 0) {

						scores.clear();

					}
				} else {
					JOptionPane.showMessageDialog(null, "Can not delete main column");
				}

			}
		});

		updateBtn = new JButton("Update Score");
		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calculateBtn.setEnabled(true);
				try {
					for (int i = 0; i < stc.getData().size(); i++) {
						for (int j = 3; j < columnName.size(); j++) {
							if (studentInfoTable.getValueAt(i, j) != null) {
								scores.add(new Score(newColumnName,
										Double.parseDouble(studentInfoTable.getValueAt(i, j) + "")));
							} else {
								scores.add(new Score(newColumnName, 0.0));
							}
						}
					}
					JOptionPane.showMessageDialog(null, "Update complete");
				} catch (IndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "Value has problem");
				}
			}
		});

		calculateBtn = new JButton("Calculate");
		calculateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveBtn.setEnabled(true);
				columnName.add("Net score");
				rows = new String[stc.getData().size()][columnName.size()];
                Calculate cal = new Calculate();
				try {

					for (int i = 0; i < stc.getData().size(); i++) {
						if(cal.setScore(scores.get(i).getScore())){
							NetScore.add(cal.calculateScore());
						}else{
							JOptionPane.showMessageDialog(null, "This version max score is 50,min score is 0");
						}
					

					}

					////// เอาขอมูลในไฟล์ มาลง ตาราง //////////////////////////////////
					for (int i = 0; i < stc.getData().size(); i++) {
						for (int j = 0; j < columnName.size(); j++) {
							if (j == 0) {
								rows[i][j] = stc.getData().get(i).getIndex() + "";

							} else if (j == 1) {
								rows[i][j] = stc.getData().get(i).getId() + "";

							} else if (j == 2) {
								rows[i][j] = stc.getData().get(i).getName();

							} else if (j == columnName.size() - 1) {
								rows[i][j] = NetScore.get(i) + "";
							} else if (j == columnName.size() - 2) {
								rows[i][j] = scores.get(i).getScore() + "";
							}
						}

					}
					//////////////////////////////////////////////////////
					studentInfoTable.setModel(new DefaultTableModel(rows, columnName.toArray()));

					JOptionPane.showMessageDialog(null, "Calculate complete");

				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "Please Update score");
				}
			}
		});
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileOutputStream fw;
				String line = "";
				try {
					if (jfc.showSaveDialog(null) == jfc.APPROVE_OPTION) {

						BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jfc.getSelectedFile()), "UTF-8"));

						for (int i = 0; i < stc.getData().size(); i++) {
							for (int j = 0; j < columnName.size(); j++) {
								if (j == 0) {
									line = line + " " + studentInfoTable.getValueAt(i, j);

								} else if (j == 1) {
									line = line + " " + studentInfoTable.getValueAt(i, j);

								} else if (j == 2) {
									line = line + " " + studentInfoTable.getValueAt(i, j);

								}
								
							}
							line = line + "     คะแนนดิบ: " + scores.get(i).getScore() + " คะแนนสุทธิ:"+ NetScore.get(i)  ;
							
							
						}
						bf.write(line);
						bf.newLine();
					
					
						JOptionPane.showMessageDialog(null, "Save complete");
						bf.close();
					}

				} catch (IndexOutOfBoundsException e3) {
					JOptionPane.showMessageDialog(null, "please update the data ");
				} catch (FileNotFoundException e2) {
					JOptionPane.showMessageDialog(null, "File not Found");
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		});

		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		addBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		updateBtn.setEnabled(false);
		calculateBtn.setEnabled(false);
		saveBtn.setEnabled(false);

		///////////////// panel ใส่ ปุ่ม //////////////////////
		GridLayout g = new GridLayout(7, 0);
		g.setVgap(5);
		btnPanel.setLayout(g);
		btnPanel.add(uploadBtn);
		btnPanel.add(addBtn);
		btnPanel.add(deleteBtn);
		btnPanel.add(updateBtn);
		btnPanel.add(calculateBtn);
		btnPanel.add(saveBtn);
		btnPanel.add(exitBtn);

		controlPanel.add(btnPanel);
		controlPanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1), "Control"));
		/////////////////////////////////////////

		this.setLayout(new BorderLayout());
		this.add(tablepanel);
		this.add(controlPanel, BorderLayout.EAST);

	}

}
