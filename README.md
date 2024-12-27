# Bank Service

Este proyecto implementa un sistema bancario simulado en Java. Modela conceptos clave como cuentas bancarias, clientes, transacciones y tipos de cuentas. Es ideal para aprender y experimentar con principios de programación orientada a objetos.

---

## 🚀 Características

- **Gestor de Cuentas Bancarias:** Incluye clases para cuentas de ahorro y cuentas corrientes.
- **Clientes:** Modelo de cliente bancario con interacción con cuentas.
- **Transacciones:** Permite gestionar operaciones financieras básicas.
- **POO:** Diseño modular y extensible utilizando principios de Programación Orientada a Objetos.

---

## 📋 Requisitos

- **Java JDK** 8 o superior.
- **Maven** (opcional para la gestión de dependencias).

---

## 🛠️ Instalación

1. Clona este repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Accede al directorio del proyecto:
   ```bash
   cd BankService-master
   ```

3. Compila el proyecto utilizando Maven:
   ```bash
   mvn clean install
   ```
   O compila manualmente con el compilador de Java:
   ```bash
   javac -d bin src/main/java/Corfo/exercise/*.java
   ```

---

## ▶️ Uso

1. Ejecuta la clase principal:
   ```bash
   java -cp bin Corfo.exercise.Main
   ```

2. Observa el comportamiento del sistema, que actualmente incluye demostraciones básicas y plantillas para expandir.

---

## 📂 Estructura del Proyecto

```
├── src
│   ├── main
│       ├── java
│           ├── Corfo
│               ├── exercise
│                   ├── Bank.java
│                   ├── BankAccount.java
│                   ├── CurrentAccount.java
│                   ├── Customer.java
│                   ├── Main.java
│                   ├── SavingsAccount.java
│                   ├── Transaction.java
├── pom.xml
```

---

## ✨ Contribuciones

Si deseas contribuir a este proyecto:

1. Haz un fork del repositorio.
2. Crea una nueva rama para tus cambios.
3. Realiza un pull request con una descripción detallada de los cambios.

---

## 📝 Licencia

Este proyecto se distribuye bajo la Licencia MIT.

