package act06;

import static act06.AuxiliaryMethods.DATOS_EMPLEADOS;
import static act06.AuxiliaryMethods.isEmpty;
import static act06.AuxiliaryMethods.leerArchivo;
import static act06.AuxiliaryMethods.titleCase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Claro, la clase VentanaBienvenida es una clase de Java que representa la
 * ventana de bienvenida de una aplicación de login. En ella se definen las
 * características de la ventana y se añade una funcionalidad de login para los
 * empleados.
 * 
 * En la ventana se solicita al usuario que introduzca su nombre y contraseña
 * para acceder a la aplicación. Si el usuario introduce un nombre de empleado
 * que está registrado en la aplicación y la contraseña correcta, se le da la
 * bienvenida a la aplicación. En caso contrario, se muestra un mensaje de
 * error.
 * 
 * La clase también incluye algunos métodos auxiliares que se encargan de leer
 * un archivo donde se encuentran los datos de los empleados registrados y de
 * mostrar mensajes de error en caso de que ocurra algún problema durante el
 * proceso de login.
 * 
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 *
 */
public class VentanaBienvenida extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaBienvenida() {

		try {
			basicConfiguration();
			leerArchivo();
		} catch (ErrorLeerArchivo e) {
			ERROR_MessageDialog(e.getMessage(), "LEER ARCHIVO");
		} finally {
			loginActionActivate();
		}

	}

	/**
	 * El método basicConfiguration() es un método privado de la clase
	 * VentanaBienvenida que se utiliza para configurar la ventana de bienvenida con
	 * los componentes necesarios como etiquetas de texto, campos de texto y un
	 * botón.
	 * 
	 * En primer lugar, se establece un layout con un objeto BoxLayout que organiza
	 * los componentes de la ventana de forma vertical, uno debajo del otro. Luego,
	 * se establece el tamaño y título de la ventana.
	 * 
	 * A continuación, se crean dos paneles, uno para el campo de texto del nombre y
	 * otro para el campo de texto del password. En cada panel se añade una etiqueta
	 * de texto y un campo de texto. Estos paneles se agregan a la ventana.
	 * 
	 * Por último, se crea un botón de login, se añade a un nuevo panel y se agrega
	 * a la ventana también.
	 * 
	 * En resumen, el método basicConfiguation() se encarga de configurar la ventana
	 * de bienvenida con los componentes necesarios para que el usuario pueda
	 * ingresar su nombre y contraseña y presionar un botón de login.
	 */
	private void basicConfiguration() {

		BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
		setLayout(boxLayout);
		setSize(300, 150);
		setTitle("Actividad 06 - LOGIN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		nombre = new JTextField(10);
		JPanel panelNombre = new JPanel();
		panelNombre.add(new JLabel("Nombre: "));
		panelNombre.add(nombre);
		add(panelNombre);

		password = new JPasswordField(10);
		JPanel panelPassword = new JPanel();
		panelPassword.add(new JLabel("Password: "));
		panelPassword.add(password);
		add(panelPassword);

		login = new JButton("Login");
		JPanel panelBttLogin = new JPanel();
		panelBttLogin.add(login);
		add(panelBttLogin);
	}

	/**
	 * El método loginActionActivate() es llamado desde el constructor de la clase
	 * VentanaBienvenida y se encarga de activar el listener del botón de login que
	 * se encuentra en la ventana. En otras palabras, este método le da una
	 * funcionalidad al botón de login.
	 * 
	 * Este método utiliza el método addActionListener() del botón de login para
	 * agregar un objeto ActionListener al mismo. El objeto ActionListener es
	 * implementado en la clase interna loginButton y se encarga de escuchar los
	 * eventos que se produzcan en el botón de login.
	 * 
	 * @see #actionPerformed
	 */
	private void loginActionActivate() {
		login.addActionListener(new loginButton());
	}

	/**
	 * El método ERROR_MessageDialog es una función auxiliar de la clase
	 * VentanaBienvenida que muestra una ventana de diálogo emergente con un mensaje
	 * de error personalizado y un título específico. Esta ventana de diálogo se
	 * utiliza para mostrar errores que ocurren en el programa.
	 * 
	 * El método acepta dos parámetros de entrada: un mensaje y un título de error.
	 * El mensaje es el texto que se muestra en la ventana emergente y el título de
	 * error es el texto que se muestra en la barra de título de la ventana. Además,
	 * el método establece el color del mensaje de la ventana emergente en rojo para
	 * que el mensaje de error sea más visible.
	 * 
	 * El método utiliza la clase JOptionPane para crear la ventana emergente. La
	 * ventana emergente muestra el mensaje de error y un botón de "OK" para cerrar
	 * la ventana. En general, este método se utiliza para mostrar errores al
	 * usuario y ayudar a depurar el programa.
	 * 
	 * @param msg
	 * @param errorType
	 */
	private void ERROR_MessageDialog(String msg, String errorType) {
		UIManager.put("OptionPane.messageForeground", Color.RED);
		JOptionPane.showMessageDialog(this, msg, "ERROR " + errorType, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * El método buscarEmpleado es un método privado que recibe como parámetros el
	 * nombre y la contraseña de un empleado. Su función es buscar en una estructura
	 * de datos llamada DATOS_EMPLEADOS el empleado que corresponde al nombre
	 * proporcionado y verificar si la contraseña ingresada coincide con la que está
	 * registrada en la estructura.
	 * 
	 * Primero, el método verifica si el nombre proporcionado se encuentra en la
	 * estructura DATOS_EMPLEADOS. Si el nombre no se encuentra, entonces muestra un
	 * mensaje de error indicando que el empleado no ha sido encontrado.
	 * 
	 * En caso contrario, el método recupera el objeto Empleado asociado al nombre
	 * proporcionado y lo almacena en la variable empleado. Luego, el método
	 * verifica si empleado no es nulo y si la contraseña proporcionada no coincide
	 * con la que está registrada en la estructura. Si la contraseña no coincide,
	 * muestra un mensaje de error indicando que las credenciales son incorrectas.
	 * 
	 * Por otro lado, si la contraseña coincide, el método muestra un mensaje de
	 * bienvenida con el nombre del empleado.
	 * 
	 * @param nombre
	 * @param password
	 */
	private void buscarEmpleado(String nombre, String password) {

		if (DATOS_EMPLEADOS.containsKey(nombre)) {

			Empleado empleado = DATOS_EMPLEADOS.get(nombre);

			if (empleado != null && !empleado.getApellido().equals(password))
				ERROR_MessageDialog("CREDENCIALES INCORRECTAS", "CREDENCIALES");
			else
				JOptionPane.showMessageDialog(this, "¡¡¡ BIENVENIDO " + empleado.getNombre() + " !!!");

		} else
			ERROR_MessageDialog(nombre + " NO CONSTA COMO EMPLEADO", "Empleado no Encotrado");

	}

	private JTextField nombre;
	private JPasswordField password;
	private JButton login;

	/**
	 * La clase loginButton es una clase interna que implementa la interfaz
	 * ActionListener. Esta clase es responsable de definir el comportamiento del
	 * botón "Login" al ser presionado.
	 * 
	 * Al implementar la interfaz ActionListener, se debe implementar el método
	 * actionPerformed(ActionEvent e). Este método se ejecuta automáticamente cuando
	 * el botón "Login" es presionado.
	 * 
	 * En el método actionPerformed(ActionEvent e), se recupera el texto ingresado
	 * en los campos de texto "Nombre" y "Password" y se valida que ambos campos
	 * hayan sido completados. Si alguno de los campos está vacío, se muestra un
	 * mensaje de error correspondiente.
	 * 
	 * Si ambos campos tienen un valor, se llama al método buscarEmpleado() de la
	 * clase VentanaBienvenida para buscar el empleado en la lista de empleados. Si
	 * el empleado es encontrado y su contraseña coincide con la ingresada en el
	 * campo de "Password", se muestra un mensaje de bienvenida. Si el empleado no
	 * es encontrado o la contraseña no coincide, se muestra un mensaje de error
	 * correspondiente.
	 * 
	 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
	 *
	 */
	private class loginButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String nombreColectado = titleCase(nombre.getText());
			String passwordColectado = new String(password.getPassword());

			if (isEmpty(nombreColectado))
				ERROR_MessageDialog("¡¡¡Hay que rellenar el NOMBRE!!!", "NOMBRE");
			else if (isEmpty(passwordColectado))
				ERROR_MessageDialog("¡¡¡Hay que rellenar el PASSWORD!!!", "PASSWORD");
			else
				buscarEmpleado(nombreColectado, passwordColectado);

		}

	}
}
