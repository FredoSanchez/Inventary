/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.ProductoDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame {

    public JLabel lblCodigo, lblNombre, lblTipo, lblCantidad, lblPrecio, lblDisponibilidad;

    public JTextField codigo, nombre,descripcion, cantidad, precio;
    public JComboBox tipo;

    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;

    public JPanel table;
    public JButton buscar, eliminar, insertar, limpiar, actualizar;

    private static final int ANCHOC = 130, ALTOC = 30;

    DefaultTableModel tm;

    public Consulta() {
        super("Inventary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblCodigo);
        container.add(lblNombre);
        container.add(lblCantidad);
        container.add(lblDisponibilidad);
        container.add(codigo);
        container.add(tipo);
        container.add(cantidad);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        container.add(precio);
        container.add(lblPrecio);
        setSize(600, 600);
        eventos();
    }

    private final void agregarLabels() {
        lblCodigo = new JLabel("Codigo");
        lblNombre = new JLabel("Nombre");        
        lblCantidad = new JLabel("Cantidad");
        lblDisponibilidad = new JLabel("Disponibilidad");
        lblPrecio =new JLabel("Precio");
        lblCodigo.setBounds(10, 10, ANCHOC, ALTOC);
        lblNombre.setBounds(10, 60, ANCHOC, ALTOC);
        lblCantidad.setBounds(10, 100, ANCHOC, ALTOC);
        lblPrecio.setBounds(300, 60, ANCHOC, ALTOC);
        lblDisponibilidad.setBounds(10, 140, ANCHOC, ALTOC);
    }

    private final void formulario() {
        codigo = new JTextField();
        tipo = new JComboBox();
        cantidad = new JTextField();
        precio = new JTextField();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");

        table = new JPanel();

        tipo.addItem("Fruta");
        tipo.addItem("Verdura");
        tipo.addItem("Bebida");
        tipo.addItem("Dulce");

        existencia = new ButtonGroup();
        existencia.add(si);
        existencia.add(no);

        codigo.setBounds(140, 10, ANCHOC, ALTOC);
        tipo.setBounds(140, 60, ANCHOC, ALTOC);
        cantidad.setBounds(140, 100, ANCHOC, ALTOC);
        precio.setBounds(350, 60, ANCHOC, ALTOC);
        si.setBounds(140, 140, 50, ALTOC);
        no.setBounds(210, 140, 50, ALTOC);

        buscar.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 210, ANCHOC, ALTOC);
        actualizar.setBounds(150, 210, ANCHOC, ALTOC);
        eliminar.setBounds(300, 210, ANCHOC, ALTOC);
        limpiar.setBounds(450, 210, ANCHOC, ALTOC);
        resultados = new JTable();
        table.setBounds(10, 250, 500, 200);
        table.add(new JScrollPane(resultados));
    }

    private void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5: 
                        return Float.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        tm.addColumn("Codigo");
        tm.addColumn("Nombre");
        tm.addColumn("Tipo");
        tm.addColumn("Cantidad");
        tm.addColumn("Precio");
        tm.addColumn("Disponibilidad");

        ProductoDao fd = new ProductoDao();
        ArrayList<Producto> productos = fd.readAll();

        for (Producto fi : productos) {
            tm.addRow(new Object[]{fi.getCodigo(), fi.getNombre(), fi.getTipo(), fi.getCantidad(),fi.getPrecio(), fi.isDisponibilidad()});
        }

        resultados.setModel(tm);
    }

    private void eventos() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = new Producto(codigo.getText(), tipo.getSelectedItem().toString(), Integer.parseInt(cantidad.getText()), true);

                if (no.isSelected()) {
                    f.setDisponibilidad(false);
                }

                if (fd.create(f)) {
                    JOptionPane.showMessageDialog(null, "Producto registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de crear el producto");
                }
            }
        });

        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = new Producto(codigo.getText(), tipo.getSelectedItem().toString(), Integer.parseInt(cantidad.getText()), true);

                if (no.isSelected()) {
                    f.setDisponibilidad(false);
                }

                if (fd.update(f)) {
                    JOptionPane.showMessageDialog(null, "Producto modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de modificar el producto");
                }
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                if (fd.delete(codigo.getText())) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de eliminar el producto");
                }

            }
        });

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = fd.read(codigo.getText());
                if (f == null) {
                    JOptionPane.showMessageDialog(null, "El Producto buscado no se ha encontrado");
                } else {
                    codigo.setText(f.getCodigo());
                    tipo.setSelectedItem(f.getNombre());
                    cantidad.setText(Integer.toString(f.getCantidad()));

                    if (f.isDisponibilidad()) {
                        si.setSelected(true);
                    } else {
                        no.setSelected(true);
                    }
                }
            }
        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

    }

    public void limpiarCampos() {
        codigo.setText("");
        tipo.setSelectedItem("Fruta");
        cantidad.setText("");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Consulta().setVisible(true);
            }
        });

    }
}
