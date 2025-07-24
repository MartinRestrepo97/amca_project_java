# 🏢 Proyecto AMCA: Apoyo al Mercado Campesino Agrícola

---

## 📑 Tabla de Contenido
1. [Descripción General](#descripción-general)
2. [Requisitos del Sistema](#requisitos-del-sistema)
3. [Estructura del Proyecto](#estructura-del-proyecto)
4. [Instalación y Preparación](#instalación-y-preparación)
5. [Compilación y Ejecución](#compilación-y-ejecución)
6. [Uso del Software](#uso-del-software)
7. [Persistencia de Datos (CSV)](#persistencia-de-datos-csv)
8. [Arquitectura y Diseño](#arquitectura-y-diseño)
9. [Pruebas Funcionales y Validación](#pruebas-funcionales-y-validación)
10. [Soporte y Contacto](#soporte-y-contacto)

---

## 📋 Descripción General

**AMCA** es una aplicación de escritorio desarrollada en **Java** que simula un sistema de apoyo al mercado campesino agrícola. Permite gestionar y visualizar información sobre cultivos, animales, productos preparados y sectores productivos de manera eficiente y organizada, facilitando la toma de decisiones y la administración de recursos.

---

## 🛠️ Requisitos del Sistema

- **Java JDK:** 8 o superior
- **Sistemas Operativos Compatibles:** Windows, macOS, Linux
- **Memoria RAM:** 512 MB mínimo
- **Espacio en Disco:** 50 MB disponibles

---

## 📁 Estructura del Proyecto

```text
amca_project_java/
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

## Evidencia de Desempeño: GA7-220501096-AA3-EV01

Este proyecto incluye la implementación completa de la evidencia de desempeño **GA7-220501096-AA3-EV01: "Codificación de módulos del software Stand-alone, web y móvil"**.

### Características Implementadas

#### 1. Estándares de Codificación Java
- ✅ **Convenciones de Nomenclatura**: camelCase para métodos y variables, PascalCase para clases
- ✅ **Comentarios Javadoc**: Documentación completa de todas las clases y métodos públicos
- ✅ **Estructura de Código**: Separación de responsabilidades siguiendo el patrón MVC
- ✅ **Validaciones**: Verificación de entrada de datos y manejo de errores robusto
- complete

#### 2. Frameworks y Tecnologías Aplicadas
- **Java Swing**: Framework de interfaz gráfica para aplicaciones de escritorio
- **Patrón MVC**: Modelo-Vista-Controlador para separación de responsabilidades
- **Persistencia CSV**: Almacenamiento de datos en archivos CSV
- **Validación de Entrada**: Clase AmazonUtil con métodos de validación avanzados

#### 3. Funcionalidades CRUD Completas
- **Create**: Agregar nuevos registros con validación de datos
- **Read**: Mostrar listas en tablas con formato mejorado
- **Update**: Editar registros existentes con confirmación
- **Delete**: Eliminar registros con confirmación de seguridad

#### 4. Mejoras de Interfaz de Usuario
- Look and feel Nimbus para mejor apariencia
- Colores consistentes y efectos hover en botones
- Mensajes informativos y confirmaciones de usuario
- Tablas con formato mejorado y validación de selección

#### 5. Validaciones y Seguridad
- Validación de campos obligatorios
- Verificación de números enteros positivos
- Limpieza de texto y caracteres especiales
- Manejo robusto de excepciones

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

---

## 🖥️ Uso del Software

- Navega entre los módulos usando la barra lateral (en la interfaz gráfica).
- Ingresa, consulta y edita datos de cultivos, animales, preparados y sectores productivos.
- Los datos se guardan automáticamente en archivos CSV.
- Utiliza la versión de consola para ambientes sin entorno gráfico.

---

## 📄 Persistencia de Datos (CSV)

La aplicación utiliza archivos CSV simples para la persistencia de datos. Cada sección tiene su propio archivo CSV en la raíz del proyecto (`cultivos.csv`, `animales.csv`, `preparados.csv`, `sectorproductivo.csv`). Los datos se cargan al abrir la ventana correspondiente y se guardan automáticamente después de cada operación (agregar, editar, eliminar).

## Mejoras Aplicadas en la Evidencia

### Clase Cultivos.java
- ✅ Agregados comentarios Javadoc completos
- ✅ Implementados métodos `toString()`, `equals()` y `hashCode()`
- ✅ Agregado método de validación `esValido()`
- ✅ Mejorado constructor con validación de parámetros
- ✅ Renombrado método `listaCultivos()` a `obtenerListaCultivos()`

### Clase AmazonUtil.java
- ✅ Agregados comentarios Javadoc completos
- ✅ Implementados métodos adicionales de validación
- ✅ Mejorado manejo de errores y mensajes
- ✅ Agregado método de limpieza de texto
- ✅ Mantenido método original para compatibilidad

### Clase Main.java
- ✅ Agregados comentarios Javadoc completos
- ✅ Mejorada presentación del menú con formato
- ✅ Implementado uso de nuevos métodos de validación
- ✅ Mejorada estructura del código

### Clase MainFrame.java
- ✅ Agregados comentarios Javadoc completos
- ✅ Mejorada interfaz de usuario con colores y efectos
- ✅ Implementado look and feel Nimbus
- ✅ Agregados efectos hover en botones

### Clase CultivosFrame.java
- ✅ Corregido método de carga de datos
- ✅ Mejorado manejo de errores
- ✅ Implementadas validaciones de entrada
- ✅ Mejorada interfaz de usuario

## Plan para la migración a Swing

1. **Crear una ventana principal (`MainFrame`)**  
   - Menú o botones para acceder a cada sección: Cultivos, Animales, Preparados, SectorProductivo.

2. **Crear un JFrame para cada entidad**  
   - Cada ventana mostrará una tabla con los datos (usando `JTable`).
   - Botones para agregar, editar y eliminar (CRUD básico, aunque los datos son mock, puedes replicar el patrón del ejemplo).
   - Opcional: Diálogos para ver detalles o editar/agregar registros.

3. **Adaptar los modelos de datos**  
   - Usar los métodos `listaCultivos()`, `listaAnimales()`, etc., para poblar las tablas.

4. **No usar base de datos ni persistencia, solo listas en memoria (como el ejemplo).**

## Estructura sugerida de clases Swing

- `amca/MainFrame.java` — Ventana principal con botones para cada sección.
- `amca/CultivosFrame.java` — Ventana para gestionar cultivos.
- `amca/AnimalesFrame.java` — Ventana para gestionar animales.
- `amca/PreparadosFrame.java` — Ventana para gestionar preparados.
- `amca/SectorProductivoFrame.java` — Ventana para gestionar sectores productivos.

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

## Cambios visuales (Dashboard tipo cPanel)

- **Sidebar solo texto:** El menú lateral ahora muestra únicamente el nombre de cada módulo (Cultivos, Animales, Preparados, Sector Productivo) en fuente grande y clara, sin emojis ni iconos decorativos.
- **Barra de acento:** El botón seleccionado en el sidebar se resalta con una barra vertical de color azul a la izquierda, facilitando la identificación de la sección activa.
- **Diseño profesional y minimalista:** Se eliminaron los emojis y se mejoró la paleta de colores para lograr un aspecto más limpio y corporativo.
- **Fuente moderna:** Se utiliza una fuente grande y moderna para los textos del sidebar y los títulos de cada módulo.
- **Experiencia tipo dashboard:** Todo el contenido se muestra en un solo frame, con navegación fluida entre módulos y sin ventanas emergentes adicionales.
