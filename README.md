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
