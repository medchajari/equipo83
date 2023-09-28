/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MeD Servicios Inf
 */
public class CargarNotas extends javax.swing.JFrame {

	private AlumnoData aluData;
		private List<Alumno> listaAlumnos;
		private DefaultTableModel modelo;
		private List<Materia> listaMaterias;
		private List<Inscripcion> listaInscripciones;
		
		
		private InscripcionData insData;
		private MateriaData materiaData;
	public CargarNotas() {
		initComponents();
		aluData=new AlumnoData();
		materiaData = new MateriaData();
		modelo = new DefaultTableModel();
		listaAlumnos = (List<Alumno>) aluData.listarAlumnos();
		listaMaterias = (List<Materia>) materiaData.listarMaterias();
		
		insData = new InscripcionData();
		
		cargarAlumnos();
		armarCabecera();
		cargaDatosdeNota();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jSeparator1 = new javax.swing.JSeparator();
                jLabel2 = new javax.swing.JLabel();
                cbxAlumno = new javax.swing.JComboBox<>();
                jScrollPane1 = new javax.swing.JScrollPane();
                tablaNotas = new javax.swing.JTable();
                btnGuardar = new javax.swing.JButton();
                btnSalir = new javax.swing.JButton();
                jLabel3 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(51, 51, 51));
                jLabel1.setText("Cargar Notas");

                jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
                jLabel2.setText("Seleccione un Alumno:");

                cbxAlumno.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cbxAlumnoActionPerformed(evt);
                        }
                });

                tablaNotas.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Title 1", "Title 2", "Title 3", "Title 4"
                        }
                ));
                jScrollPane1.setViewportView(tablaNotas);

                btnGuardar.setText("Guardar");
                btnGuardar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnGuardarActionPerformed(evt);
                        }
                });

                btnSalir.setText("Salir");

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.png"))); // NOI18N

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(139, 139, 139)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(cbxAlumno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                                .addContainerGap(43, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void cbxAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumnoActionPerformed
                // TODO add your handling code here:
				borrarFilas();
				cargaDatosdeNota();
        }//GEN-LAST:event_cbxAlumnoActionPerformed

        private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
                // TODO add your handling code here:
		int filaSeleccionada = tablaNotas.getSelectedRow();
    double nuevaNota = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese la nueva nota:"));
    
    if (filaSeleccionada != -1) {
        int idMateria = (int) modelo.getValueAt(filaSeleccionada, 0);
        int idAlumno = ((Alumno) cbxAlumno.getSelectedItem()).getIdAlumno();

        InscripcionData inscripcionData = new InscripcionData();
        inscripcionData.actualizarNota(idAlumno, idMateria, nuevaNota);

        // Vuelve a cargar los datos después de la actualización
        cargaDatosdeNota();
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una materia de la tabla.");
    }
        }//GEN-LAST:event_btnGuardarActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CargarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CargarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CargarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CargarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CargarNotas().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnGuardar;
        private javax.swing.JButton btnSalir;
        private javax.swing.JComboBox<Alumno> cbxAlumno;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JSeparator jSeparator1;
        public javax.swing.JTable tablaNotas;
        // End of variables declaration//GEN-END:variables

private void  cargarAlumnos(){
		
		for(Alumno lista:listaAlumnos){
		cbxAlumno.addItem(lista);
		}
	}

	private  void armarCabecera(){
		ArrayList<Object> columnas = new ArrayList<>();
		columnas.add("idMateria");
		columnas.add("nombre");
		columnas.add("Año");
		columnas.add("Nota");
		
		//recorrer arreglo y uso eso de titulo
		
		for(Object it : columnas){
			modelo.addColumn(it);
		}
		//cargo a tabla
		
		tablaNotas.setModel(modelo);
	}
	
	private void borrarFilas(){
		if(modelo != null){
		int a = modelo.getRowCount() -1;
		
		for(int i = a; i>= 0; i--){
		modelo.removeRow(i);
		}
		}
	}
	
	public void cargaDatosdeNota(){
	 borrarFilas();
   
 
        //Llenar filas
        InscripcionData cd =new InscripcionData();
        Alumno seleccionado=(Alumno)cbxAlumno.getSelectedItem();
        listaMaterias = (ArrayList)cd.obtenerMateriasInscriptas(seleccionado.getIdAlumno());
        for(Materia m:listaMaterias){
        
            modelo.addRow(new Object[]{m.getIdMateria(),m.getNombre(), m.getAnio(), insData.cargarNotas(WIDTH) });
		}
  

}
}
	
//	
//	public void cargaDatosInscriptas(){
//        borrarFilas();
//        //Llenar filas
//        InscripcionData cd =new InscripcionData();
//        Alumno seleccionado=(Alumno)cbxAlumnos.getSelectedItem();
//        listaMaterias = (ArrayList)cd.obtenerMateriasInscriptas(seleccionado.getIdAlumno());
//        
//        for(Materia m:listaMaterias){
//        
//            modelo.addRow(new Object[]{m.getIdMateria(),m.getNombre(), m.getAnio()});
//		}
//	}
//	
//
	
	
	
	

