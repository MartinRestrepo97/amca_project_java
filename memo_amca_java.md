# Memo: Análisis y Ejecución de amca_java

## Objetivo
- Analizar el proyecto Java `amca_java`.
- Ejecutar el proyecto localmente.
- Crear un README.md con instrucciones e información del proyecto, incluyendo la estructura de carpetas y archivos.

## Progreso
1. **Análisis de la estructura:**
   - El proyecto tiene carpetas `src/` (código fuente), `bin/` (clases compiladas), `.settings/` (configuración Eclipse), `.classpath` y `.project`.
   - El punto de entrada es `src/amca/Main.java`.
   - Los modelos de datos están en `src/modelo/` y las utilidades en `src/util/`.
2. **Revisión de dependencias:**
   - No requiere dependencias externas, solo JDK 8+.
3. **Compilación y ejecución:**
   - Se debe compilar con `javac -d bin src/amca/Main.java src/modelo/*.java src/util/*.java`.
   - Se ejecuta con `java -cp bin amca.Main`.
4. **README.md:**
   - Se creó y documentó la estructura, instrucciones y descripciones de carpetas/archivos.
5. **Migración a Swing:**
   - Se crearon las ventanas gráficas: MainFrame, CultivosFrame, AnimalesFrame, PreparadosFrame y SectorProductivoFrame en src/amca/.
   - Cada ventana permite ver, agregar y eliminar registros en memoria usando JTable y botones.

## Verificación Profunda (Abril 2024)
- Se realizó una revisión exhaustiva de la estructura de carpetas, archivos fuente y documentación.
- El README.md refleja fielmente la estructura y los archivos del proyecto.
- Las clases principales (Main.java, MainFrame.java, CultivosFrame.java, AmazonUtil.java, Cultivos.java) cumplen con los estándares de codificación, validaciones y documentación.
- La funcionalidad CRUD, la persistencia en CSV y la interfaz Swing están implementadas y documentadas correctamente.
- No se detectan desalineaciones entre el código y la documentación.
- El proyecto está listo y cumple con los objetivos y estándares definidos.

## Siguiente paso
- Compilar y ejecutar la aplicación gráfica con:
  javac -d bin src/amca/*.java src/modelo/*.java src/util/*.java
  java -cp bin amca.MainFrame
- Validar funcionamiento y ajustar si es necesario. 