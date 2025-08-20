## Spring Framework: Konfiguration und Dependency Injection ohne Spring Boot
- Um Objekte vom Spring Framework zu erhalten, muss eine Konfiguration verwendet werden, typischerweise über eine `spring.xml`-Datei.
- Im XML werden **Bean-Tags** (`<bean>`) verwendet, um Objekte zu definieren, wobei `id` und `class` als Attribute dienen.
- Spring erstellt die in der Bean-Konfiguration definierten Objekte und verwaltet sie im **IOC-Container** (Inversion of Control Container) oder Spring Container.
- Eine Referenzvariable, der kein Objekt zugewiesen wurde, führt beim Zugriff zu einer `NullPointerException`.
- Für den Zugriff auf private Variablen von außerhalb der Klasse sind **Getter- und Setter-Methoden** erforderlich.

### Setter-Injektion
- Bei der Setter-Injektion werden Werte oder Referenzen über Setter-Methoden in ein Objekt injiziert.
- Für **primitive Variablen** (z.B. `int age`) wird der `<property>`-Tag innerhalb des `<bean>`-Tags verwendet.
    - Das `name`-Attribut des `<property>`-Tags gibt den Namen der Eigenschaft an, und `value` den zuzuweisenden Wert.
    - Spring ruft die entsprechende Setter-Methode der Eigenschaft auf, um den Wert zu setzen.
    - Diese Injektion ist spezifisch für die Bean-Definition, in der sie konfiguriert ist.
- Für **Referenzvariablen** (z.B. ein `Laptop`-Objekt) wird der `<property>`-Tag mit dem `ref`-Attribut verwendet, anstatt `value`.
    - Das `ref`-Attribut verweist auf die `id` einer anderen Bean, die bereits im Container existiert.
    - Eine Setter-Methode für die Referenzvariable muss in der Klasse vorhanden sein.
    - Spring "verdrahtet" (wires) das referenzierte Objekt in das aktuelle Objekt.

### Konstruktor-Injektion
- Bei der Konstruktor-Injektion werden Werte oder Referenzen über einen parametrisierten Konstruktor in ein Objekt injiziert.
- Für **primitive Variablen** wird der `<constructor-arg>`-Tag innerhalb des `<bean>`-Tags verwendet.
    - Das `value`-Attribut gibt den zuzuweisenden Wert an.
    - Spring verwendet einen parametrisierten Konstruktor, um den Wert beim Erstellen des Objekts zu übergeben.
    - Optional können `name` oder `index` verwendet werden, um Parameter in Konstruktoren mit mehreren Argumenten zu spezifizieren (z.B. `index="0"` für den ersten Parameter).
- Für **Referenzvariablen** wird der `<constructor-arg>`-Tag mit dem `ref`-Attribut verwendet.
    - Das `ref`-Attribut verweist auf die `id` einer anderen Bean im Container.
    - Spring übergibt das referenzierte Objekt über den Konstruktor.

### Vergleich und Best Practices
- Die Wahl zwischen Setter- und Konstruktor-Injektion hängt von der Natur der Abhängigkeit ab.
- **Konstruktor-Injektion** ist besser geeignet, wenn eine Variable beim Erstellen des Objekts **zwingend erforderlich** (obligatorisch) ist, da sie die Objektintegrität sicherstellt.
- **Setter-Injektion** ist geeignet, wenn eine Variable **optional** ist und auch nach der Objekterstellung gesetzt werden kann.

Hier ist ein Flussdiagramm, das den allgemeinen Prozess der Spring Dependency Injection visualisiert:



Hier ist eine Tabelle, die die verschiedenen Injektionstypen zusammenfasst:

| Injektionstyp | Variablen-Typ | XML-Tag | Attribut für Wert/Referenz | Erforderliche Methode in Klasse | Wann zu verwenden |
|:------------ |:------------ |:------ |:------------------------- |:------------------------------ |:---------------- |
| **Setter**    | Primitiv      | `<property>` | `value`                    | Setter-Methode                  | Optional          |
| **Konstruktor** | Primitiv      | `<constructor-arg>` | `value`                    | Parametrisierter Konstruktor    | Obligatorisch     |
| **Setter**    | Referenz      | `<property>` | `ref`                      | Setter-Methode                  | Optional          |
| **Konstruktor** | Referenz      | `<constructor-arg>` | `ref`                      | Parametrisierter Konstruktor    | Obligatorisch     |