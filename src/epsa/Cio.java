package epsa;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Esta clase permite acceder a la consola de forma sencilla.
 * Tiene como objetivo facilitar a los alumnos la realización de
 * las prácticas. 'Cio' es una abreviatura de "console input/output".
 * <p>
 * En los terminales de Linux y Mac OS X se utiliza la codificación
 * UTF-8, y en los terminales de Windows (CMD) se utiliza cp850.
 * <p>
 * Se ha utilizado la localización de Estados Unidos para
 * simplificar el manejo de tipos de datos como 'double'.
 * Esto se ha hecho así porque con la localización por defecto
 * (España) la clase Scanner lee los 'doubles' utilizando la
 * coma decimal, mientras que la función 'Double.parseDouble'
 * utiliza el punto. Con la localización de Estados Unidos se
 * se consigue utilizar el punto en los dos casos.
 */
public class Cio
{
private static final Scanner scanner;
private static final PrintStream output;

static
{
    String osName   = System.getProperty("os.name").toLowerCase(),
           encoding = "UTF-8";

    if(osName.startsWith("windows") &&
        !encoding.equals(System.getProperty("file.encoding")))
    {
        // Si la codificación es UTF-8 estaremos ejecutando el programa
        // desde Eclipse. Si no, desde un terminal de Windows.
        encoding = "cp850";
    }

    scanner = new Scanner(System.in, encoding);
    scanner.useLocale(Locale.US);
    PrintStream out = System.out;

    try
    {
        out = new PrintStream(System.out, true, encoding);
    }
    catch(UnsupportedEncodingException ex)
    {
        System.out.println(ex.toString());
    }

    output = out;
}

/**
 * Imprime un booleano.
 * @param b valor a imprimir
 */
public static void print(boolean b)
{
    output.print(b);
}

/**
 * Imprime un carácter.
 * @param c valor a imprimir
 */
public static void print(char c)
{
    output.print(c);
}

/**
 * Imprime un entero.
 * @param i valor a imprimir
 */
public static void print(int i)
{
    output.print(i);
}

/**
 * Imprime un entero de 64 bits.
 * @param l valor a imprimir
 */
public static void print(long l)
{
    output.print(l);
}

/**
 * Imprime un número en coma flotante.
 * @param f valor a imprimir
 */
public static void print(float f)
{
    output.print(f);
}

/**
 * Imprime un numero de 64 bits en coma flotante.
 * @param d valor a imprimir
 */
public static void print(double d)
{
    output.print(d);
}

/**
 * Imprime un array de caracteres.
 * @param s array a imprimir
 */
public static void print(char[] s)
{
    output.print(s);
}

/**
 * Imprime una cadena de caracteres.
 * @param s cadena a imprimir
 */
public static void print(String s)
{
    output.print(s);
}

/**
 * Imprime la representación de un objeto como cadena.
 * @param obj objeto a imprimir
 */
public static void print(Object obj)
{
    output.print(obj);
}

/**
 * Imprime un salto de línea.
 */
public static void println()
{
    output.println();
}

/**
 * Imprime un booleano seguido de un salto de línea.
 * @param b valor a imprimir
 */
public static void println(boolean b)
{
    output.println(b);
}

/**
 * Imprime un carácter seguido de un salto de línea.
 * @param c carácter a imprimir
 */
public static void println(char c)
{
    output.println(c);
}

/**
 * Imprime un entero seguido de un salto de línea.
 * @param i valor a imprimir
 */
public static void println(int i)
{
    output.println(i);
}

/**
 * Imprime un entero de 64 bits y un salto de línea.
 * @param l valor a imprimir
 */
public static void println(long l)
{
    output.println(l);
}

/**
 * Imprime un número en coma flotante y un salto de línea.
 * @param f valor a imprimir
 */
public static void println(float f)
{
    output.println(f);
}

/**
 * Imprime un número de 64 bits en coma flotante y un salto de línea.
 * @param d valor a imprimir
 */
public static void println(double d)
{
    output.println(d);
}

/**
 * Imprime un array de caracteres y un salto de línea.
 * @param s array a imprimir
 */
public static void println(char[] s)
{
    output.println(s);
}

/**
 * Imprime una cadena de caracteres y un salto de línea.
 * @param s cadena a imprimir
 */
public static void println(String s)
{
    output.println(s);
}

/**
 * Imprime la representación de un objeto como cadena y un salto de línea.
 * @param obj objeto a imprimir
 */
public static void println(Object obj)
{
    output.println(obj);
}

/**
 * Imprime con formato una lista de argumentos según la
 * localización de Estados Unidos.
 * <p>
 * La definición de los formatos se puede consultar en
 * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax" target=new>
 * este enlace</a>
 * @param format formato de impresión
 * @param args   valores a imprimir
 */
public static void printf(String format, Object... args)
{
    output.printf(Locale.US, format, args);
}

/**
 * Imprime con formato una lista de argumentos según la
 * localización indicada.
 * <p>
 * La definición de los formatos se puede consultar en
 * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax" target=new>
 * este enlace</a>
 * @param locale localización
 * @param format formato de impresión
 * @param args   valores a imprimir
 */
public static void printf(Locale locale, String format, Object... args)
{
    output.printf(locale, format, args);
}

/**
 * Lee una cadena hasta el fin de línea.
 * @return cadena leída
 */
public static String readString()
{
    return scanner.nextLine();
}

/**
 * Lee un entero a partir de {@link #readString readString}.
 * <p>
 * En caso de introducir un número erróneo, muestra un error
 * y vuelve a leerlo.
 * @return entero leído
 */
public static int readInt()
{
    for(;;)
    {
        try
        {
            return Integer.parseInt(readString());
        }
        catch(NumberFormatException ex)
        {
            println("Número erróneo. Por favor, introduzca un número.");
        }
    }
}

/**
 * Lee un entero de 64 bits a partir de {@link #readString readString}.
 * <p>
 * En caso de introducir un número erróneo, muestra un error
 * y vuelve a leerlo.
 * @return valor leído
 */
public static long readLong()
{
    for(;;)
    {
        try
        {
            return Long.parseLong(readString());
        }
        catch(NumberFormatException ex)
        {
            println("Número erróneo. Por favor, introduzca un número.");
        }
    }
}

/**
 * Lee un número en coma flotante a partir de
 * {@link #readString readString}.
 * <p>
 * En caso de introducir un número erróneo, muestra un error
 * y vuelve a leerlo.
 * @return valor leído
 */
public static float readFloat()
{
    for(;;)
    {
        try
        {
            return Float.parseFloat(readString());
        }
        catch(NumberFormatException ex)
        {
            println("Número erróneo. Por favor, introduzca un número.");
        }
    }
}

/**
 * Lee un número de 64 bits en coma flotante a partir de
 * {@link #readString readString}.
 * <p>
 * En caso de introducir un número erróneo, muestra un error
 * y vuelve a leerlo.
 * @return valor leído
 */
public static double readDouble()
{
    for(;;)
    {
        try
        {
            return Double.parseDouble(readString());
        }
        catch(NumberFormatException ex)
        {
            println("Número erróneo. Por favor, introduzca un número.");
        }
    }
}

/**
 * Lee un BigInteger a partir de {@link #readString readString}.
 * <p>
 * En caso de introducir un número erróneo, muestra un error
 * y vuelve a leerlo.
 * @return valor leído
 */
public static BigInteger readBigInteger()
{
    for(;;)
    {
        try
        {
            return new BigInteger(readString());
        }
        catch(NumberFormatException ex)
        {
            println("Número erróneo. Por favor, introduzca un número.");
        }
    }
}

/**
 * Lee un BigDecimal a partir de {@link #readString readString}.
 * <p>
 * En caso de introducir un número erróneo, muestra un error
 * y vuelve a leerlo.
 * @return valor leído
 */
public static BigDecimal readBigDecimal()
{
    for(;;)
    {
        try
        {
            return new BigDecimal(readString());
        }
        catch(NumberFormatException ex)
        {
            println("Número erróneo. Por favor, introduzca un número.");
        }
    }
}

/**
 * Lee un booleano a partir de {@link #readString readString}.
 * <p>
 * En caso de introducir un booleano erróneo, muestra un error
 * y vuelve a leerlo.
 * <p>Los valores para 'true' son: 1, s, si, sí, cierto, true.
 * <p>Los valores para 'false' son: 0, n, no, falso, false.
 * @return valor leído
 */
public static boolean readBoolean()
{
    for(;;)
    {
        String s = readString();

        if("1".equalsIgnoreCase(s) || "s".equalsIgnoreCase(s) ||
            "si".equalsIgnoreCase(s) || "sí".equalsIgnoreCase(s) ||
            "cierto".equalsIgnoreCase(s) || "true".equalsIgnoreCase(s))
        {
            return true;
        }
        else if("0".equalsIgnoreCase(s) ||
            "n".equalsIgnoreCase(s) || "no".equalsIgnoreCase(s) ||
            "falso".equalsIgnoreCase(s) || "false".equalsIgnoreCase(s))
        {
            return false;
        }
        else
        {
            println("Booleano erróneo. Por favor introduzca un booleano.");
        }
    }
}

/**
 * Lee de un fichero de texto con la codificación
 * UTF-8 mediante la clase 'Scanner'.
 * <p>
 * Al finalizar la lectura hay que llamar a la función
 * 'close' para no dejar el fichero abierto.
 * @param  name nombre del fichero
 * @return objeto para realizar la lectura
 */
public static Scanner fileRead(String name)
{
    try
    {
        Scanner s = new Scanner(new FileInputStream(name), "UTF-8");
        s.useLocale(Locale.US); // Para que se lean bien los números.
        return s;
    }
    catch(IOException ex)
    {
        // Ocultamos la IOException para "simplificar" las cosas.
        RuntimeException rex = new RuntimeException(ex.getMessage());
        rex.setStackTrace(ex.getStackTrace());
        throw rex;
    }
}

/**
 * Escribe en un fichero de texto con la codificación
 * UTF-8 mediante la clase 'PrintStream'.
 * Si el fichero existe, se truncará a tamaño 0, y si no
 * existe, se creará uno nuevo.
 * <p>
 * Al finalizar la escritura hay que llamar a la función
 * 'close' para no dejar el fichero abierto.
 * @param name nombre del fichero
 * @return objeto para realizar la escritura
 */
public static PrintStream fileWrite(String name)
{
    try
    {
        return new PrintStream(name, "UTF-8");
    }
    catch(IOException ex)
    {
        // Ocultamos la IOException para "simplificar" las cosas.
        RuntimeException rex = new RuntimeException(ex.getMessage());
        rex.setStackTrace(ex.getStackTrace());
        throw rex;
    }
}

/**
 * Escribe en un fichero de texto con la codificación
 * UTF-8 mediante la clase 'PrintStream'.
 * <p>
 * Al finalizar la escritura hay que llamar a la función
 * 'close' para no dejar el fichero abierto.
 * @param name Nombre del fichero de texto.
 * @param append Si es true se abrirá el fichero sin truncarlo para
 * añadir al final. 
 * @return objeto para realizar la escritura
 */
public static PrintStream fileWrite(String name, boolean append)
{
    try
    {
        OutputStream os = new FileOutputStream(name, append);
        return new PrintStream(os, false, "UTF-8");
    }
    catch(IOException ex)
    {
        // Ocultamos la IOException para "simplificar" las cosas.
        RuntimeException rex = new RuntimeException(ex.getMessage());
        rex.setStackTrace(ex.getStackTrace());
        throw rex;
    }
}

// Para generar la ayuda:
//
//    javadoc -encoding UTF-8 -charset UTF-8 -classpath ../java epsa
//
// Si no se indica la opción '-charset' no aparece en los html
// generados el charset que hay que utilizar.
//
// Para generar la librería:
// cd ~/asignaturas/iip/lib
// javac -sourcepath ../java ../java/epsa/Cio.java -d .
// jar cvf epsa.jar *

} // Console
