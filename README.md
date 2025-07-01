# Apoyo al Mercado Campesino Agrícola (AMCA)

Este proyecto es una aplicación de consola en Java que simula un sistema de apoyo al mercado campesino agrícola. Permite gestionar y visualizar información sobre cultivos, animales, productos preparados y sectores productivos.

## Requisitos
- Java JDK 8 o superior

## Estructura de Carpetas y Archivos

```
amca_java/
│
├── src/                  # Código fuente Java
│   ├── amca/             # Contiene la clase principal Main.java (punto de entrada) y las ventanas Swing (MainFrame.java, CultivosFrame.java, AnimalesFrame.java, PreparadosFrame.java, SectorProductivoFrame.java)
│   ├── modelo/           # Clases de modelo de datos: Cultivos, Animales, Preparados, SectorProductivo
│   └── util/             # Utilidades, como AmazonUtil.java para validación de entrada
│
├── bin/                  # Archivos .class compilados (salida de compilación)
│   ├── amca/
│   ├── modelo/
│   └── util/
│
├── .settings/            # Configuración de Eclipse IDE
│
├── .classpath            # Configuración de rutas de clases para Eclipse
├── .project              # Configuración del proyecto Eclipse
├── README.md             # Este archivo
├── memo_evidencia_ga7.md # Memo del progreso de la evidencia
└── Evidencia_GA7-220501096-AA3-EV01.md # Documento de evidencia de desempeño
```

### Descripción de Archivos y Carpetas
- **src/amca/Main.java**: Clase principal de consola (menú en terminal) con interfaz mejorada y comentarios Javadoc.
- **src/amca/MainFrame.java**: Ventana principal Swing con acceso a las secciones, interfaz mejorada con colores y efectos hover.
- **src/amca/CultivosFrame.java**: Ventana Swing para gestionar cultivos con operaciones CRUD completas y persistencia CSV.
- **src/amca/AnimalesFrame.java**: Ventana Swing para gestionar animales.
- **src/amca/PreparadosFrame.java**: Ventana Swing para gestionar preparados.
- **src/amca/SectorProductivoFrame.java**: Ventana Swing para gestionar sectores productivos.
- **src/modelo/**: Clases de datos para Cultivos, Animales, Preparados y SectorProductivo, cada una con métodos para obtener listas de ejemplo, validaciones y métodos adicionales.
- **src/util/AmazonUtil.java**: Utilidad para validar la entrada del usuario en el menú, con métodos adicionales de validación y limpieza de texto.
- **bin/**: Carpeta de salida de compilación, contiene los archivos .class generados.
- **.settings/**, **.classpath**, **.project**: Archivos de configuración para Eclipse IDE.

### Documentación de la Evidencia

El documento completo de la evidencia se encuentra en:
- **Evidencia_GA7-220501096-AA3-EV01.md**: Análisis detallado del código, mejoras aplicadas, estándares de codificación y conclusiones.

## Instrucciones para Compilar y Ejecutar

1. **Compilar el proyecto:**

   Desde la raíz del proyecto, ejecuta:
   ```
   javac -d bin src/amca/*.java src/modelo/*.java src/util/*.java
   ```

2. **Ejecutar la aplicación gráfica:**

   Desde la raíz del proyecto, ejecuta:
   ```
   java -cp bin amca.MainFrame
   ```

3. **Ejecutar la aplicación de consola:**

   Desde la raíz del proyecto, ejecuta:
   ```
   java -cp bin amca.Main
   ```

4. **Uso de la Aplicación Gráfica:**

   - La aplicación se abrirá con una ventana principal que contiene botones para acceder a las diferentes secciones (Cultivos, Animales, Preparados, Sector Productivo).
   - Cada sección mostrará una tabla con los datos existentes.
   - Puedes usar los botones "Agregar", "Editar" y "Eliminar" para gestionar los registros.
   - La edición se realiza a través de un pequeño formulario emergente.
   - Las validaciones aseguran que los campos obligatorios no estén vacíos y que los valores numéricos sean positivos.

## Persistencia de Datos

La aplicación utiliza archivos CSV simples para la persistencia de datos. Cada sección tiene su propio archivo CSV en la raíz del proyecto (`cultivos.csv`, `animales.csv`, `preparados.csv`, `sectorproductivo.csv`). Los datos se cargan al abrir la ventana correspondiente y se guardan automáticamente después de cada operación (agregar, editar, eliminar).

## cómo se ve la ventana principal

```java
public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("AMCA - Apoyo al Mercado Campesino Agrícola");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton cultivosBtn = new JButton("Cultivos");
        JButton animalesBtn = new JButton("Animales");
        JButton preparadosBtn = new JButton("Preparados");
        JButton sectorBtn = new JButton("Sector Productivo");

        cultivosBtn.addActionListener(e -> new CultivosFrame().setVisible(true));
        animalesBtn.addActionListener(e -> new AnimalesFrame().setVisible(true));
        preparadosBtn.addActionListener(e -> new PreparadosFrame().setVisible(true));
        sectorBtn.addActionListener(e -> new SectorProductivoFrame().setVisible(true));

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(cultivosBtn);
        panel.add(animalesBtn);
        panel.add(preparadosBtn);
        panel.add(sectorBtn);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
```
