package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.processo;
import dto.dto;

public class trabalho extends JFrame {

	dto dto = new dto();
	private String oi;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trabalho frame = new trabalho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public trabalho() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 448);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menu = new JMenuBar();
		menu.setBackground(Color.WHITE);
		setJMenuBar(menu);
		
		JMenu exportJMenu= new JMenu("Import/Export");
		exportJMenu.setForeground(Color.BLACK);
		exportJMenu.setBackground(Color.WHITE);
		JMenu importJMenu= new JMenu("Importar Dados Para o Mongo");
		menu.add(exportJMenu);
		exportJMenu.add(importJMenu);
		JMenuItem test = new JMenuItem("Exportar Dados");
		exportJMenu.add(test);
		test.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String oi;
				processo p1 = new processo();
				oi= p1.ExportBaseDados();
				Thread thread = new Thread(oi);
				thread.start();		
			}
		});
		
	
		JMenuItem cepaberto1 = new JMenuItem("sp.cepaberto_parte_1");
		importJMenu.add(cepaberto1);
		cepaberto1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dto.setArquivo("sp.cepaberto_parte_1.csv");
				processo p3 = new processo();
				oi= p3.cadastraEndereco(dto);
				Thread thread2 = new Thread(oi);
				thread2.start();	
			}
		});
		
		JMenuItem cepaberto2 = new JMenuItem("sp.cepaberto_parte_2");
		importJMenu.add(cepaberto2);
		cepaberto2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dto.setArquivo("sp.cepaberto_parte_2.csv");
				processo p3 = new processo();
				oi= p3.cadastraEndereco(dto);
				Thread thread2 = new Thread(oi);
				thread2.start();	
			}
		});
	
		
		JMenuItem cepaberto3 = new JMenuItem("sp.cepaberto_parte_3");
		importJMenu.add(cepaberto3);
		cepaberto3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dto.setArquivo("sp.cepaberto_parte_3.csv");
				processo p3 = new processo();
				oi= p3.cadastraEndereco(dto);
				Thread thread2 = new Thread(oi);
				thread2.start();	
			}
		});
	
		JMenuItem cepaberto4 = new JMenuItem("sp.cepaberto_parte_4");
		importJMenu.add(cepaberto4);
		cepaberto4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dto.setArquivo("sp.cepaberto_parte_4.csv");
				processo p3 = new processo();
				oi= p3.cadastraEndereco(dto);
				Thread thread2 = new Thread(oi);
				thread2.start();	
			}
		});
	
		JMenuItem cepaberto5 = new JMenuItem("sp.cepaberto_parte_5");
		importJMenu.add(cepaberto5);
		cepaberto5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dto.setArquivo("sp.cepaberto_parte_5.csv");
				processo p3 = new processo();
				oi= p3.cadastraEndereco(dto);
				Thread thread2 = new Thread(oi);
				thread2.start();	
			}
		});
	
		JButton btnLimpar = new JButton("Buscar MySql");
		btnLimpar.setBounds(237, 230, 172, 23);
		contentPane.add(btnLimpar);
		
		JButton Pesquisar = new JButton("Buscar Mongo");
		
		Pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
	
				dto.setCep(textField.getText());
				
				processo p2 = new processo();
				oi= p2.BuscarEnderoMongoDB(dto);
				Thread thread1 = new Thread(oi);
				thread1.start();
				
							
			}
		});
		Pesquisar.setBounds(25, 230, 163, 23);
		contentPane.add(Pesquisar);
		
		JLabel CEP = new JLabel("CEP");
		CEP.setForeground(Color.WHITE);
		CEP.setBounds(41, 62, 99, 14);
		contentPane.add(CEP);
		
		JLabel Endereco = new JLabel("Endereco");
		Endereco.setForeground(Color.WHITE);
		Endereco.setBounds(41, 105, 99, 14);
		contentPane.add(Endereco);
		
		JLabel Bairro = new JLabel("Bairro");
		Bairro.setForeground(Color.WHITE);
		Bairro.setBounds(41, 152, 46, 14);
		contentPane.add(Bairro);
					
		JLabel lblPesquisa = new JLabel("Sistema de Pesquisa - Endere\u00E7o");
		lblPesquisa.setForeground(Color.ORANGE);
		lblPesquisa.setBounds(112, 13, 185, 14);
		contentPane.add(lblPesquisa);
		
		textField = new JTextField();
		textField.setBounds(178, 59, 201, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 102, 201, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 149, 204, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}