# AHrefLabel

AHrefLabel ist ein klickbares JLabel. Es soll einen `<a href`-Link aus der HTML-Welt darstellen.
Deswegen auch dieser komische Name. Bei Klick auf das `AHrefLabel` öffnet sich die entsprechende Website.
Es wird der Standardwebbrowser genutzt.
Diese Bibliothek wurde mit Java 17 getestet.

## Screenshots

![](screenshots/banner.png)

## Installation

**Das muss in die pom.xml:**

```xml
<dependency>
    <groupId>de.schipplock.gui.swing</groupId>
    <artifactId>ahreflabel</artifactId>
    <version>0.0.1</version>
</dependency>
```

## Wie verwende ich diese Bibliothek?

**Es wird folgender Import benötigt:**

```java
import de.schipplock.gui.swing.ahreflabel.AhrefLabel;
```

**Und so benutzt man es:**

```java
// einfach nur ein Link
var urlLabel = new AhrefLabel("https://schipplock.de");

// ein Link mit alternativen Linktext
var urlLabel = new AhrefLabel("https://schipplock.de", "schipplock.de");

// mit Tooltiptext
var urlLabel = new AhrefLabel("https://schipplock.de", "schipplock.de", "mein TooltipText");

// mit anderer Linkfarbe
var urlLabel = new AhrefLabel("https://schipplock.de", "schipplock.de", "mein TooltipText", "#1c59ba");
```

## License
[Apache License 2.0](https://choosealicense.com/licenses/apache-2.0/)