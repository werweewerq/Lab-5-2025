package functions;
import java.io.*;

public class TabulatedFunctions {
    private static final double E = 1e-10;
    public TabulatedFunctions() {}

    public static TabulatedFunction tabulate(Function function, double leftX, double rightX, int pointsCount) {
        if (leftX >= rightX - E)
            throw new IllegalArgumentException("Лквая граница юолбше или равна правой границе");
        if (pointsCount < 2)
            throw new IllegalArgumentException("Точек меньше двух");
        if (leftX < function.getLeftDomainBorder() - E || rightX > function.getRightDomainBorder() + E)
            throw new IllegalArgumentException("Границы выходят за область отределения функции");
        FunctionPoint[] points = new FunctionPoint[pointsCount];
        double step = (rightX - leftX) / (pointsCount - 1);
        for (int i = 0; i < pointsCount; ++ i, leftX += step) {
            double x = leftX + i * step;
            if (Math.abs(x) < E)
                x = 0;
            points[i] = new FunctionPoint(leftX, function.getFunctionValue(leftX));
        }
        return new LinkedListTabulatedFunction(points);
    }

    public static void outputTabulatedFunction(TabulatedFunction function, OutputStream out) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(out);
        dataOut.writeInt(function.getPointsCount());
        for (int i = 0; i < function.getPointsCount(); ++i) {
            dataOut.writeDouble(function.getPointX(i));
            dataOut.writeDouble(function.getPointY(i));
        }
        dataOut.flush();
    }

    public static TabulatedFunction inputTabulatedFunction(InputStream in) throws IOException {
        DataInputStream dataIn = new DataInputStream(in);
        int pointsCount = dataIn.readInt();
        FunctionPoint[] points = new FunctionPoint[pointsCount];
        for (int i = 0; i < pointsCount; ++i)
            points[i] = new FunctionPoint(dataIn.readDouble(), dataIn.readDouble());
        return new LinkedListTabulatedFunction(points);
    }

    public static void writeTabulatedFunction(TabulatedFunction function, Writer out) throws IOException {
        PrintWriter writer = new PrintWriter(out);
        writer.print(function.getPointsCount());
        for (int i = 0; i < function.getPointsCount(); ++i) {
            writer.print(" " + function.getPointX(i) + " " + function.getPointY(i));
        }
        writer.flush();
    }

    public static TabulatedFunction readTabulatedFunction(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        if (tokenizer.nextToken() != StreamTokenizer.TT_NUMBER)
            throw new IOException();
        int pointsCount = (int) tokenizer.nval;
        FunctionPoint[] points = new FunctionPoint[pointsCount];
        for (int i = 0; i < pointsCount; ++i) {
            if (tokenizer.nextToken() != StreamTokenizer.TT_NUMBER)
                throw new IOException();
            double x = tokenizer.nval;
            if (tokenizer.nextToken() != StreamTokenizer.TT_NUMBER)
                throw new IOException();
            double y = tokenizer.nval;
            points[i] = new FunctionPoint(x, y);
        }
        return new LinkedListTabulatedFunction(points);
    }
}