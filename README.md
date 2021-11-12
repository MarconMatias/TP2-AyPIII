# TP2-AyPIII
Repositorio del TP2 para Algoritmos y Programación III - 2do cuatrimestre 2021

## Estructura del repositorio
```
    .
    ├── informe/                # Archivos fuente y compilados para el informe
    │   ├── img/                #     Imágenes "tal cual" (externas, capturas de pantalla)
    │   ├── out/                #     Archivos generados desde ../src
    │   │   └── uml/            #         Diagramas UML generados desde fuente (.tex, .png)
    │   └── src/                #     Código fuente de latex (.tex) y diagramas
    │       └── uml/            #         Fuentes de diagramas UML (.plantuml)
    └── README.md               # Este archivo
```

## Punteo rápido de LaTeX (usado en informe)
* General:
    * El guion bajo tiene significado especial, anteponer invertida: `snake\_case`.
    * Para fórmulas o texto matemático, poner entre un signo de pesos (en la misma línea) o entre dos (fuerza otra línea).
    * Un enter es ignorado, para hacer un párrafo se usan dos (es decir, una línea en blanco) o `\par`.
    * Además, `\newbreak` fuerza salto de página y `\filbreak` lo hace opcional.
* Formato:
    * `\textbf{texto en negrita}`, `\underline{subrayado}`, `\textit{bastardilla}`, `\texttt{monoespaciado, por ejemplo código}`.
* Bloques: `\begin{tipoDeBloque}` (si hay opciones `\begin{tipoDeBloque}[lasOpciones]`) para empezar y `\end{tipoDeBloque}` para finalizar; donde `tipoDeBloque` puede ser:
    * `enumerate` (lista numerada), `itemize` (lista no numerada) `description` (tipo diccionario).
        * Adentro se usa `\item` o `\item[elNumeroOLoQueSeDefine]`.
        * Para más información, véase https://es.overleaf.com/learn/latex/Lists.
    * `figure` Una figura, que puede tener un ancho, una etiqueta y un epígrafe.
    * `verbatim` (código fuente), `alternate` (colores alternados entre líneas). Algunas opciones son:
        * `breaklines=true` Genera automáticamente saltos de línea indicándolos.
        * `numbers=left` Pone el número de línea a la izquierda.
        * `xleftmargin=5mm` Configura margen para números de línea.
    * `table` y `tabular` Tablas. Véase https://es.overleaf.com/learn/latex/Tables.

### Insertar una imagen escalar como figura

```
\begin{figure}[H]
    \centering
    \includegraphics[width=0.8\textwidth]{img/nombre_de_archivo.png}
    \caption{\label{etiquetaDeFigura} Epígrafe de la figura.}
\end{figure}
```

### Insertar un latex como figura

```
\begin{figure}[H]
    \centering
    \includestandalone[mode=tex,width=0.9\textwidth]{out/nombre_de_archivo}
    \caption{\label{etiquetaDeFigura} Epígrafe de la figura.}
\end{figure}

```

## Punteo rápido de PlantUML (usado en informe)
* General:
    * En Visual Studio Code, la extensión [`jebbs.plantuml`](https://marketplace.visualstudio.com/items?itemName=jebbs.plantuml) funciona de forma aceptable.
    * En un mismo archivo puede haber varios diagramas, deben comenzar con `@startuml nombreDeDiagrama` y terminar con `@enduml`.
        * Cada uno es exportado a un archivo separado en base a la ruta del archivo y nombre del diagrama. Por ejemplo, el diagrama `general` en [`informe/src/uml/DC.plantuml`](informe/src/uml/DC.plantuml) se exporta como [`informe/out/uml/DC/general.latex`](informe/out/uml/DC/general.latex) con la extensión nombrada.
        * Para poder incorporarlos a LaTeX deben tener extensión `.tex`, es importante verificarlo o renombrarlos. También se pueden exportar a `.png`, pero al ser imagen escalar en algún punto se pixela, puede ocupar más tamaño y no puede seleccionarse el texto interno.
    * Se puede agregar un título o un epígrafe con `title Título` o `caption Epígrafe` respectivamente, pero es más prolijo incluirlo en el latex.
    * Empezar una línea con una comilla simple (`'`) la convierte en un comentario.
* Diagrama de clase (más info: https://plantuml.com/es/class-diagram):
    * `hide empty members` oculta las secciones que no tienen miembros, útil para el diagrama general que no se muestran atributos y métodos.
    * `skinparam minClassWidth 100` permite configurar un tamaño mínimo de cajita de clases.
    * `package TP3 {…}` muestra todo lo que esté entre llaves dentro de una caja con solapa que representa a un paquete.
    * `-->` (asociación), `o-->` agregación, `*-->` composición, `..>` uso, pueden usarse con modificadores:
        * Para forzar posición: `r` derecha, `l` izquierda, `u` arriba, `d` abajo, ejemplo: `EstoQuedaAbajo .u.> EstoQuedaArriba`.
        * Para ocultarlo (fuerza posición pero no hay flecha): `EstoQuedaAbajo .[hidden]u.> EstoQuedaArriba`.
        * La multiplicidad se indica antes y después de la flecha, entre comillas dobles, ejemplo: `Persona "1" *--> "0..2" Brazo`.
    * `interface IAlgo {…}` crea una interfaz.
    * `ClaseHijo extends ClaseMadre {…}` se usa para herencia y `ClaseHijo implements IAlgo {…}` para implementar una interfaz.
        * También puede usarse `--^` para herencia, y `..|>` para interfaz, útil para forzar una posición.
    * `together {…}` fuerza, si es posible, que las clases o interaces dentro de las llaves estén juntas.
    * `abstract class` hace que una clase sea abstracta (tiene un círculo con una A en vez de una C).
    * Los miembros dentro de una clase o interfaz siguen la secuencia: visibilidad, modificadores, nombre, parámetros o `()` si es función, `:` y tipo.
        * Visibilidad puede ser `+` público, `-` privado, `#` protegido, `~` de paquete.
        * Modificadores puede ser `{static}` si es estático (de clase), `{abstract}` si es un método abstracto.
        * Si lleva parámetros o paréntesis es función, si no es atributo. Los parámetros siguen el orden `nombre:tipo`.
* Diagrama de secuencia (más info: https://plantuml.com/es/sequence-diagram):
    * `hide footbox` omite repetir los nombres de las clases abajo de la línea de vida (sólo las muestra arriba). Recomendado.
    * `!pragma teoz true` activa un nuevo motor de renderizado, muy recomendado.
    * `skinparam maxMessageSize 200` permite cortar los nombres de los menajes (aunque a veces hay que poner un espacio o algo para forzarlo).
    * `actor JUnit` convierte a `JUnit` en un actor (se muestra como una persona de palitos).
    * `participant "unaInstancia:UnaClase" as A` muestra `unaInstancia:UnaClase` en un cuadro pero permite usar `A` para referenciarlo.
    * `A -> B : unMensaje()`: A envía a B el mensaje `unMensaje()`
    * `activate B` (generalmente después de que B recibe un mensaje) activa la instancia.
    * `return unValor` desactiva la última instancia activada y envía `unValor` como mensaje de retorno.
    * `A -> B ++ : unMensaje()` equivale a enviar el mensaje y realizar un `activate` (no olvidar hacer un `return`).
    * `create B`: indica que el siguiente mensaje crea la instancia B.
    * `A -> B ** : unMensaje()` indica que el mensaje `unMensaje()` crea la instancia de B (equivalente a `create B` y `A -> B : unMensaje()`).
    * `loop unaCondicion` inicia un bucle con la condición indicada y `end` lo termina.
